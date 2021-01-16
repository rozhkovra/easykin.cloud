package ru.rrozhkov.easykin.task;

import lombok.Data;

@Data
public class TasksRequest {
  private Long statusId;
  private Long categoryId;
  private Long priorityId;
  private String fromDate;
  private String toDate;
}
