package com.tistory.hskimsky.oozie_noti.web.coordinator;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.OozieClientException;
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

    public static void main(String[] args) throws OozieClientException {
        OozieClient client = new OozieClient("http://hdm3.hdp.local:11000/oozie");
        String jobId = client.getJobId("0000030-161126055444944-oozie-oozi-W@:start:");
        System.out.println("------------------ CoordinatorNotificationServiceImpl.main.jobId:36 = " + jobId);
    }
}