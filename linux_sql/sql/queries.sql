SELECT
        cpu_number,host_id,total_mem
FROM
        host_usage
JOIN
        host_info ON host_usage.host_id=host_info.id
ORDER BY total_mem DESC;

--query 2

