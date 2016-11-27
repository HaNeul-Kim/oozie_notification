CREATE DATABASE oozie_noti ENCODING 'UTF-8';
-- createdb --encoding=UTF-8 --owner=oozie oozie_noti

DROP TABLE IF EXISTS workflow_job_status;
DROP TABLE IF EXISTS workflow_job_node_status;
DROP TABLE IF EXISTS coordinator_action_status;

CREATE TABLE IF NOT EXISTS workflow_job_status (
  "job_id"      CHARACTER VARYING(255) NOT NULL,
  "status"      CHARACTER VARYING(255) NOT NULL,
  "insert_time" CHARACTER VARYING(255) NOT NULL
);

COMMENT ON COLUMN workflow_job_status."job_id" IS 'JobID';
COMMENT ON COLUMN workflow_job_status."status" IS '상태';
COMMENT ON COLUMN workflow_job_status."insert_time" IS '시간';

CREATE TABLE IF NOT EXISTS workflow_job_node_status (
  "job_id"      CHARACTER VARYING(255)      NOT NULL,
  "node_name"   CHARACTER VARYING(255)      NOT NULL,
  "status"      CHARACTER VARYING(255)      NOT NULL,
  "insert_time" TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

COMMENT ON COLUMN workflow_job_node_status."job_id" IS 'JobID';
COMMENT ON COLUMN workflow_job_node_status."node_name" IS '노드이름';
COMMENT ON COLUMN workflow_job_node_status."status" IS '상태';
COMMENT ON COLUMN workflow_job_node_status."insert_time" IS '시간';

CREATE TABLE IF NOT EXISTS coordinator_action_status (
  "action_id"   CHARACTER VARYING(255)      NOT NULL,
  "status"      CHARACTER VARYING(255)      NOT NULL,
  "insert_time" TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

COMMENT ON COLUMN coordinator_action_status."action_id" IS 'ActionID';
COMMENT ON COLUMN coordinator_action_status."status" IS '상태';
COMMENT ON COLUMN coordinator_action_status."insert_time" IS '시간';
