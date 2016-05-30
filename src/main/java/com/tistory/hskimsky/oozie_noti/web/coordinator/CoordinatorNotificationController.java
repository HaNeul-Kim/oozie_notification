package com.tistory.hskimsky.oozie_noti.web.coordinator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coordinator")
public class CoordinatorNotificationController {

    private Logger logger = LoggerFactory.getLogger(CoordinatorNotificationController.class);

    @Autowired
    private CoordinatorNotificationService service;

    @RequestMapping("/{actionId}/{status}")
    public String coordinatorActionStatusNotification(@PathVariable String actionId,
                                                      @PathVariable String status) {
        logger.info("actionId = {}", actionId);
        logger.info("status = {}", status);

        int result = service.coordinatorActionStatusNotification(actionId, status);
        logger.info("result = {}", result);

        return "blank";
    }
}