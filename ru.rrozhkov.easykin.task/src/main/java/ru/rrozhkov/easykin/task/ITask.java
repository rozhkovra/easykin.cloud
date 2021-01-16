package ru.rrozhkov.easykin.task;

import java.util.Date;

public interface ITask {
    Long getId();
    String getName();
    Date getCreateDate();
    Date getPlanDate();
    Date getCloseDate();
    Integer getStatus();
    Integer getPriority();
    Integer getCategory();
}
