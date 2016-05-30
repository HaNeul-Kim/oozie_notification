package com.tistory.hskimsky.oozie_noti.web.workflow;

import com.tistory.hskimsky.oozie_noti.annotation.Mapper;

import java.util.Map;

@Mapper
public interface WorkflowNotificationMapper {

    int insertWorkflowJobStatus(Map<String, String> params);

    int insertNodeStartEnd(Map<String, String> params);
}
