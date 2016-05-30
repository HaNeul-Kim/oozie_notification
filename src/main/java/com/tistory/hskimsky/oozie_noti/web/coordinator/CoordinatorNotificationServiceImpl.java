package com.tistory.hskimsky.oozie_noti.web.coordinator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoordinatorNotificationServiceImpl implements CoordinatorNotificationService {

    private Logger logger = LoggerFactory.getLogger(CoordinatorNotificationService.class);

    @Autowired
    private CoordinatorNotificationMapper mapper;

    @Override
    public int coordinatorActionStatusNotification(String actionId, String status) {
        logger.info("actionId = {}", actionId);
        logger.info("status = {}", status);

        Map<String, String> params = new HashMap<>();
        params.put("actionId", actionId);
        params.put("status", status);

        return mapper.insertCoordinatorActionStatus(params);
    }
}