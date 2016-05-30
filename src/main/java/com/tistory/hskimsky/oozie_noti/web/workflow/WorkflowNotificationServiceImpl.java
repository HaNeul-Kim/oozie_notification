package com.tistory.hskimsky.oozie_noti.web.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WorkflowNotificationServiceImpl implements WorkflowNotificationService {

    private Logger logger = LoggerFactory.getLogger(WorkflowNotificationServiceImpl.class);

    @Autowired
    private WorkflowNotificationMapper mapper;

    @Override
    public int workflowJobStatusNotification(String jobId, String status) {
        logger.info("jobId = {}", jobId);
        logger.info("status = {}", status);

        Map<String, String> params = new HashMap<>();
        params.put("jobId", jobId);
        params.put("status", status);

        return mapper.insertWorkflowJobStatus(params);
    }

    @Override
    public int nodeStartEndNotifications(String jobId, String nodeName, String status) {
        logger.info("jobId = {}", jobId);
        logger.info("nodeName = {}", nodeName);
        logger.info("status = {}", status);

        Map<String, String> params = new HashMap<>();
        params.put("jobId", jobId);
        params.put("nodeName", nodeName);
        params.put("status", status);

        return mapper.insertNodeStartEnd(params);
    }
}
