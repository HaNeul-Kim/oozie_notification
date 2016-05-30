package com.tistory.hskimsky.oozie_noti.web.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workflow")
public class WorkflowNotificationController {

    private Logger logger = LoggerFactory.getLogger(WorkflowNotificationController.class);

    @Autowired
    private WorkflowNotificationService service;

    @RequestMapping("/{jobId}/{status}")
    public String workflowJobStatusNotification(@PathVariable String jobId,
                                                @PathVariable String status) {
        logger.info("jobId = {}", jobId);
        logger.info("status = {}", status);

        int result = service.workflowJobStatusNotification(jobId, status);
        logger.info("result = {}", result);

        return "blank";
    }

    @RequestMapping("/{jobId}/{nodeName}/{status}")
    public String nodeStartEndNotifications(@PathVariable String jobId,
                                            @PathVariable String nodeName,
                                            @PathVariable String status) {
        logger.info("jobId = {}", jobId);
        logger.info("nodeName = {}", nodeName);
        logger.info("status = {}", status);

        int result = service.nodeStartEndNotifications(jobId, nodeName, status);
        logger.info("result = {}", result);

        return "blank";
    }
}