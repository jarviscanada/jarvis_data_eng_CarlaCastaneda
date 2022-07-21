SELECT
        cpu_number,host_id,total_mem
FROM
        host_usage
JOIN
        host_info ON host_usage.host_id=host_info.id
ORDER BY total_mem DESC;

--query 2


CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
    $$
BEGIN
RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
LANGUAGE PLPGSQL;

SELECT
    host_id, hostname, round5(hu.timestamp) as tt, (AVG(total_mem-memory_free)/MAX(total_mem )*100 ) as avg

FROM
    host_usage as hu
    JOIN
    host_info ON hu.host_id=host_info.id
GROUP BY tt,host_id,hostname
ORDER BY tt ASC;


--query 3