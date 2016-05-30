package com.tistory.hskimsky.oozie_noti.web.coordinator;

public interface CoordinatorNotificationService {

    int coordinatorActionStatusNotification(String actionId, String status);
}