package com.tistory.hskimsky.oozie_noti;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.OozieClientException;
import org.apache.oozie.client.WorkflowAction;
import org.apache.oozie.client.WorkflowJob;
import org.junit.Test;

import java.util.List;

/**
 * description.
 *
 * @author Haneul, Kim
 */
public class WorkflowInfoTest {

    @Test
    public void main() throws OozieClientException {
        String oozieService = "http://hdm3.hdp.local:11000/oozie";
        OozieClient client = new OozieClient(oozieService);
        String jobId = "0000065-161126055444944-oozie-oozi-W";
        WorkflowAction info = client.getWorkflowActionInfo(jobId);
        System.out.println("------------------ WorkflowNotificationController.main.info = " + info);
        System.out.println("------------------ WorkflowNotificationController.main.info.getConf() = " + info.getConf());
        System.out.println("------------------ WorkflowNotificationController.main.info.getName() = " + info.getName());
        System.out.println("------------------ WorkflowNotificationController.main.info.getConsoleUrl() = " + info.getConsoleUrl());
        System.out.println("------------------ WorkflowNotificationController.main.info.getCred() = " + info.getCred());
        System.out.println("------------------ WorkflowNotificationController.main.info.getData() = " + info.getData());
        System.out.println("------------------ WorkflowNotificationController.main.info.getErrorCode() = " + info.getErrorCode());
        System.out.println("------------------ WorkflowNotificationController.main.info.getErrorMessage() = " + info.getErrorMessage());
        System.out.println("------------------ WorkflowNotificationController.main.info.getExternalChildIDs() = " + info.getExternalChildIDs());
        System.out.println("------------------ WorkflowNotificationController.main.info.getExternalId() = " + info.getExternalId());
        System.out.println("------------------ WorkflowNotificationController.main.info.getExternalStatus() = " + info.getExternalStatus());
        System.out.println("------------------ WorkflowNotificationController.main.info.getId() = " + info.getId());
        System.out.println("------------------ WorkflowNotificationController.main.info.getStats() = " + info.getStats());
        System.out.println("------------------ WorkflowNotificationController.main.info.getTrackerUri() = " + info.getTrackerUri());
        System.out.println("------------------ WorkflowNotificationController.main.info.getTransition() = " + info.getTransition());
        System.out.println("------------------ WorkflowNotificationController.main.info.getStartTime() = " + info.getStartTime());
        System.out.println("------------------ WorkflowNotificationController.main.info.getEndTime() = " + info.getEndTime());
        System.out.println("------------------ WorkflowNotificationController.main.info.getType() = " + info.getType());
        System.out.println("------------------ WorkflowNotificationController.main.info.getRetries() = " + info.getRetries());
        System.out.println("------------------ WorkflowNotificationController.main.info.getUserRetryMax() = " + info.getUserRetryMax());

        WorkflowJob job = client.getJobInfo(jobId);
        System.out.println("------------------ WorkflowNotificationController.main.job = " + job);
        System.out.println("------------------ WorkflowNotificationController.main.job.getConf() = " + job.getConf());
        System.out.println("------------------ WorkflowNotificationController.main.job.getExternalId() = " + job.getExternalId());
        System.out.println("------------------ WorkflowNotificationController.main.job.getAppName() = " + job.getAppName());
        System.out.println("------------------ WorkflowNotificationController.main.job.getAppPath() = " + job.getAppPath());
        System.out.println("------------------ WorkflowNotificationController.main.job.getConsoleUrl() = " + job.getConsoleUrl());
        System.out.println("------------------ WorkflowNotificationController.main.job.getId() = " + job.getId());
        System.out.println("------------------ WorkflowNotificationController.main.job.getParentId() = " + job.getParentId());
        System.out.println("------------------ WorkflowNotificationController.main.job.getUser() = " + job.getUser());
        System.out.println("------------------ WorkflowNotificationController.main.job.getCreatedTime() = " + job.getCreatedTime());
        System.out.println("------------------ WorkflowNotificationController.main.job.getEndTime() = " + job.getEndTime());
        System.out.println("------------------ WorkflowNotificationController.main.job.getLastModifiedTime() = " + job.getLastModifiedTime());
        System.out.println("------------------ WorkflowNotificationController.main.job.getRun() = " + job.getRun());

        List<WorkflowAction> actions = job.getActions();
        for (WorkflowAction action : actions) {
            //            System.out.println("------------------ WorkflowNotificationController.main.action.getConf() = " + action.getConf());
            System.out.println("------------------ WorkflowNotificationController.main.action.getConsoleUrl() = " + action.getConsoleUrl());
            System.out.println("------------------ WorkflowNotificationController.main.action.getExternalChildIDs() = " + action.getExternalChildIDs());
            System.out.println("------------------ WorkflowNotificationController.main.action.getEndTime() = " + action.getEndTime());
            System.out.println("------------------ WorkflowNotificationController.main.action.getId() = " + action.getId());
            System.out.println("------------------ WorkflowNotificationController.main.action.getName() = " + action.getName());
            System.out.println("------------------ WorkflowNotificationController.main.action.getTrackerUri() = " + action.getTrackerUri());
            System.out.println("------------------ WorkflowNotificationController.main.action.getTransition() = " + action.getTransition());
            System.out.println("------------------ WorkflowNotificationController.main.action.getRetries() = " + action.getRetries());
            System.out.println("------------------ WorkflowNotificationController.main.action.getStartTime() = " + action.getStartTime());
            System.out.println("------------------ WorkflowNotificationController.main.action.getType() = " + action.getType());
            System.out.println("------------------ WorkflowNotificationController.main.action.getData() = " + action.getData());
            System.out.println("------------------ WorkflowNotificationController.main.action.getCred() = " + action.getCred());
            System.out.println("------------------ WorkflowNotificationController.main.action.getErrorCode() = " + action.getErrorCode());
            System.out.println("------------------ WorkflowNotificationController.main.action.getErrorMessage() = " + action.getErrorMessage());
            System.out.println("");
        }
    }
}
