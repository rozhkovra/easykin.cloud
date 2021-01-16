package ru.rrozhkov.easykin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDao {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<TaskEntity> search(TasksRequest request) {
        return taskRepository.findAll((Specification<TaskEntity>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getStatusId() != null) {
                predicates.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("status"), request.getStatusId())));
            }
            if(request.getCategoryId() != null) {
                predicates.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("category"), request.getCategoryId())));
            }
            if(request.getPriorityId() != null) {
                predicates.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("priority"), request.getPriorityId())));
            }
            if(request.getFromDate() != null && request.getToDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    predicates.add(
                        criteriaBuilder.and(criteriaBuilder.between(root.get("planDate"),
                                sdf.parse(request.getFromDate()),
                                sdf.parse(request.getToDate()))));
                } catch (ParseException e) {

                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}

