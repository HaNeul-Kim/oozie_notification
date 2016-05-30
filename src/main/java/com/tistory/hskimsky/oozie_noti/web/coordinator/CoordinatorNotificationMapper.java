package com.tistory.hskimsky.oozie_noti.web.coordinator;

import com.tistory.hskimsky.oozie_noti.annotation.Mapper;

import java.util.Map;

@Mapper
public interface CoordinatorNotificationMapper {

    int insertCoordinatorActionStatus(Map<String, String> params);
}