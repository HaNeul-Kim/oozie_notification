CREATE DATABASE oozie_noti CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI;
use oozie_noti;

CREATE TABLE `workflow_job_status` (
  `job_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `workflow_job_node_status` (
  `job_id` varchar(255) DEFAULT NULL,
  `node_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `coordinator_action_status` (
  `action_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
