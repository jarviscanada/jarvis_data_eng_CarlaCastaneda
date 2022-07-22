#!/bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

if [ $# -ne 5 ]; then
  exit 1
fi

hostname=$(hostname -f)
vmstat_mb=$(vmstat --unit M)

#CLI commands to get usage CPU and Memory data
timestamp=$(vmstat -t  |  awk 'NR==3 {print$(NF-1);print $(NF)}' | xargs)
memory_free=$(echo "$vmstat_mb" | awk '{print $4}'| tail -n1 | xargs)
cpu_idle=$(echo "$vmstat_mb"|awk 'NR==3 {print $(NF-2)} ' |xargs)
cpu_kernel=$(echo "$vmstat_mb"|awk 'NR==3 {print $(NF-3)} ' |xargs)
disk_io=$(vmstat -d|awk 'NR==3 {print $(NF-1)} ' |xargs)
disk_available=$(df -BM / |awk 'NR==2 {print $(NF-2)} ' |sed 's/.$//'|xargs)
host_id="(SELECT id FROM host_info WHERE hostname='$hostname')";

#
insert_stmt="INSERT INTO
            host_usage(
              timestamp,
              memory_free,
              cpu_idle,
              cpu_kernel,
              disk_io,
              disk_available,
              host_id
              )
            VALUES
              (
              '$timestamp',
              $memory_free,
              $cpu_idle,
              $cpu_kernel,
              $disk_io,
              $disk_available,
              $host_id
              )
"
export PGPASSWORD=$psql_password

psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?

exit 0