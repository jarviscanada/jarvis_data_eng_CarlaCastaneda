
-- sample values
-- all fields are required (NOT NULL)


-- DDL
-- CONNECT TO host_agent AS postgres;

CREATE TABLE IF NOT EXISTS PUBLIC.host_info
(
    id                  SERIAL Primary Key NOT NULL,
    hostname            VARCHAR NOT NULL UNIQUE ,
    cpu_number          INT NOT NULL,
    cpu_architecture    VARCHAR NOT NULL,
    cpu_model           VARCHAR NOT NULL,
    cpu_mhz             INT NOT NULL,
    L2_cache            INT NOT NULL,
    total_mem           INT NOT NULL,
    "timestamp"         TIMESTAMP NOT NULL

    -- primary key constraint
    -- unique hostname constraint
);




-- DDL
CREATE TABLE  IF NOT EXISTS PUBLIC.host_usage
(
    "timestamp"     TIMESTAMP NOT NULL,
    host_id         SERIAL NOT NULL,
    memory_free     INT NOT NULL,
    cpu_idle        INT NOT NULL,
    cpu_kernel      INT NOT NULL,
    disk_io         INT NOT NULL,
    disk_available  INT NOT NULL
    -- add more columns
    -- add foreign key constraint
);
