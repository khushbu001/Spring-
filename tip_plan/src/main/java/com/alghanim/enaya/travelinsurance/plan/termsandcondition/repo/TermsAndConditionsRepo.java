package com.alghanim.enaya.travelinsurance.plan.termsandcondition.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;

/**
 * @author Khushbu
 * @Description This is a repository class which interacts with the database.
 */
@Repository
public interface TermsAndConditionsRepo extends JpaRepository<TermsAndConditions, Long> {

	@Query(value = "select p.terms from Plan p where p.terms=:termsId")
	List<TermsAndConditions> deleteByTermId(@Param("termsId") TermsAndConditions termsId);

}