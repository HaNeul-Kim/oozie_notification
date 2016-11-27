package com.tistory.hskimsky.oozie_noti.web.coordinator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/coordinator")
public class CoordinatorNotificationController {

    private Logger logger = LoggerFactory.getLogger(CoordinatorNotificationController.class);

    @Autowired
    private CoordinatorNotificationService service;

    @RequestMapping(value = "/{actionId}/{status}", method = RequestMethod.GET)
    public String coordinatorActionStatusNotification(@PathVariable String actionId,
                                                      @PathVariable String status) {
        // oozie.coord.workflow.notification.url=http://hdm3.hdp.local:8080/coordinator/$actionId/$status
        logger.info("actionId = {}", actionId);
        logger.info("status = {}", status);

        int result = service.coordinatorActionStatusNotification(actionId, status);
        logger.info("result = {}", result);

        return "blank";
    }
}