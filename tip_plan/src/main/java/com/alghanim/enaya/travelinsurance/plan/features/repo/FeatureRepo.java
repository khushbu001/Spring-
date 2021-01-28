package com.alghanim.enaya.travelinsurance.plan.features.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;

/**
 * @author khushbu
 * @Description This is a feature repository class.
 */
@Repository
public interface FeatureRepo extends JpaRepository<Feature, Long> {

	@Query(value = "select p.feature from Plan p where p.feature=:featureId")
	List<Feature> deleteByFeatureId(@Param("featureId") Set<Feature> featureId);

}