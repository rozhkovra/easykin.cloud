package ru.rrozhkov.easykin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TaskDao {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity findById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<TaskEntity> search(Map<String, String> params) {
        return taskRepository.findAll((Specification<TaskEntity>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(params.containsKey("statusId")) {
                predicates.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("status"), params.get("statusId"))));
            }
            if(params.containsKey("categoryId")) {
                predicates.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("category"), params.get("categoryId"))));
            }
            if(params.containsKey("priorityId")) {
                predicates.add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.get("priority"), params.get("priorityId"))));
            }
            if(params.containsKey("fromDate") && params.containsKey("toDate")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    predicates.add(
                        criteriaBuilder.and(criteriaBuilder.between(root.get("planDate"),
                                sdf.parse(params.get("fromDate")),
                                sdf.parse(params.get("toDate")))));
                } catch (ParseException e) {

                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}

