package org.launchcode.semesterassignmentflow.models.data;

import org.launchcode.semesterassignmentflow.models.Classes;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClassesDao extends BaseCrudRepository<Classes, Integer> {
}
