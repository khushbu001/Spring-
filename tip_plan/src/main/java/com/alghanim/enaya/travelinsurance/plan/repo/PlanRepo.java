package com.alghanim.enaya.travelinsurance.plan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alghanim.enaya.travelinsurance.plan.model.Plan;
/**
 *@Description This is a repository class. 
 * @author khushbu
 *
 */
@Repository
public interface PlanRepo extends JpaRepository<Plan, Long> {
}
