package org.launchcode.semesterassignmentflow.models.data;

import org.launchcode.semesterassignmentflow.models.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersDao extends BaseCrudRepository<User, Integer> {
}