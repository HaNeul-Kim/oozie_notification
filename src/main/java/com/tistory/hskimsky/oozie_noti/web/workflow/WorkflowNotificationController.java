package com.tistory.hskimsky.oozie_noti.web.workflow;

import org.apache.oozie.client.OozieClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/workflow")
public class WorkflowNotificationController {

    private Logger logger = LoggerFactory.getLogger(WorkflowNotificationController.class);

    @Autowired
    private WorkflowNotificationService service;

    @RequestMapping(value = "/{jobId}/{status}", method = RequestMethod.GET)
    public String workflowJobStatusNotification(@PathVariable String jobId,
                                                @PathVariable String status) {
        // oozie.wf.workflow.notification.url=http://hdm3.hdp.local:8080/workflow/@jobId/@status
        logger.info("jobId = {}", jobId);
        logger.info("status = {}", status);

        int result = service.workflowJobStatusNotification(jobId, status);
        logger.info("result = {}", result);

        return "blank";
    }

    @RequestMapping(value = "/{jobId}/{nodeName}/{status}", method = RequestMethod.GET)
    public String nodeStartEndNotifications(@PathVariable String jobId,
                                            @PathVariable String nodeName,
                                            @PathVariable String status) {
        // oozie.wf.action.notification.url=http://hdm3.hdp.local:8080/workflow/@jobId/@nodeName/@status
        logger.info("jobId = {}", jobId);
        logger.info("nodeName = {}", nodeName);
        logger.info("status = {}", status);

        int result = service.nodeStartEndNotifications(jobId, nodeName, status);
        logger.info("result = {}", result);

        return "blank";
    }
}