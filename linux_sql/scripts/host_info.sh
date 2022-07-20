#! /bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

if [ $# -ne 5 ]; then
  exit 1
fi

vmstat_mb=$(vmstat --unit M)

hostname=$(hostname -f)
cpu_number= $(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture= $(echo "$lscpu_out"  | egrep "^(Architecture)\:" | awk '{print $2}' | xargs)
cpu_model= $(echo "$lscpu_out"  | egrep "^Model\sname:" | awk '{$1=$2="";print $0}' | xargs)
cpu_mhz= $(echo "$lscpu_out"  | awk 'NR==15{print $3}' |xargs)
l2_cache= $(echo "$lscpu_out"  | egrep "^L2\scache:" | awk '{$1=$2="";print $0}' |sed 's/.$//'| xargs) #remove the k
total_mem=$(cat '/proc/meminfo'  | egrep "^MemTotal:" | awk '{$3="";print $2}' | xargs)
timestamp= $(vmstat -t  |  awk 'NR==3 {print$(NF-1);print $(NF)}' | xargs)



insert_stmt="INSERT INTO
               host_info (
                 hostname,
                 cpu_number,
                 cpu_architecture,
                 cpu_model,
                 cpu_mhz,
                 l2_cache,
                 total_mem,
                 timestamp
               )
             VALUES
               (
                 '$hostname',
                 '$cpu_number',
                 '$cpu_architecture',
                 '$cpu_model',
                 '$cpu_mhz',
                 '$l2_cache',
                 '$total_mem',
                 '$timestamp'
               )
"
export PGPASSWORD=$psql_password

#Insert date into a database
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?
exit 0
