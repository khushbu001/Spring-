package com.alghanim.enaya.travelinsurance.plan.template.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alghanim.enaya.travelinsurance.plan.template.model.Template;

/**
 * @Description This is a repository class for Template.
 */
@Repository
public interface TemplateRepo extends JpaRepository<Template, Long> {

	@Query(value = "select p.template from Plan p where p.template=:templateId")
	List<Template> deleteByTemplateId(@Param("templateId") Template templateId);

}
