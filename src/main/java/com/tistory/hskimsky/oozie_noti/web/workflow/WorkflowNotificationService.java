package com.tistory.hskimsky.oozie_noti.web.workflow;

public interface WorkflowNotificationService {

    int workflowJobStatusNotification(String jobId, String status);

    int nodeStartEndNotifications(String jobId, String nodeName, String status);
}
