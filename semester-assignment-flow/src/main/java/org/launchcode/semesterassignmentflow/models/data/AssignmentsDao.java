package org.launchcode.semesterassignmentflow.models.data;

import org.launchcode.semesterassignmentflow.models.Assignments;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AssignmentsDao extends BaseCrudRepository<Assignments, Integer> {
}

