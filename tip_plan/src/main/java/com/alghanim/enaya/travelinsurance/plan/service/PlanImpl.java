package com.alghanim.enaya.travelinsurance.plan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alghanim.enaya.travelinsurance.plan.DTO.PlanDTO;
import com.alghanim.enaya.travelinsurance.plan.DTO.PlanMapper;
import com.alghanim.enaya.travelinsurance.plan.controller.PlanApi;
import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.exceptions.PlanNotFoundException;
import com.alghanim.enaya.travelinsurance.plan.model.Plan;
import com.alghanim.enaya.travelinsurance.plan.repo.PlanRepo;
import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import com.alghanim.enaya.travelinsurance.plan.template.repo.TemplateRepo;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.repo.TermsAndConditionsRepo;

/**
 * @author khushbu
 *
 */
@Service
public class PlanImpl {

	Logger LOG = LoggerFactory.getLogger(PlanImpl.class);

	@Autowired
	private PlanRepo planRepo;

	@Autowired(required=true)
	private PlanMapper planMapper;

	@Autowired
	private TermsAndConditionsRepo termRepo;

	@Autowired
	private TemplateRepo templateRepo;

	@Autowired
	private PlanNotFoundException planNotFoundException;

	/**
	 * @Description createPlan will create a plan and will store it in repository
	 * @param plan
	 * @return
	 * @throws CustomExceptions
	 */
	public PlanDTO createPlan(PlanDTO planDTO) throws CustomExceptions {

		LOG.info("PlanImpl::createPlan::Start");

		Plan plan = planMapper.toPlan(planDTO);
		planNotFoundException.validatePlan(plan);
		LOG.debug("planDTO: {}, plan: {}", planDTO, plan);

		Optional<TermsAndConditions> term = termRepo.findById(plan.getTerms().getTermsId());
		TermsAndConditions termData = term.get();
		plan.setTerms(termData);

		LOG.debug("termData: {}, term: {}", termData, term);

		Optional<Template> template = templateRepo.findById(plan.getTemplate().getTemplateId());
		Template templateData = template.get();
		plan.setTemplate(templateData);

		LOG.debug("templateData: {}, template: {}", templateData, template);

		Plan planData = planRepo.save(plan);
		PlanDTO plans = planMapper.toPlanDTO(planData);

		LOG.debug("planData: {}, plans: {}", planData, plans);
		LOG.info("PlanImpl::createPlan::End");
		return plans;
	}

	/**
	 * @Description update plan will update a plan using plan id and store it in
	 *              database
	 * @param planId
	 * @param plan
	 * @throws CustomExceptions
	 */
	public PlanDTO updatePlan(Long planId, PlanDTO planDTO) throws CustomExceptions {

		LOG.info("PlanImpl::updatePlan::Start");
		LOG.debug("planId: {}, planDTO: {}", planId, planDTO);

		Plan plan = planMapper.toPlan(planDTO);
		planNotFoundException.validatePlan(plan);

		LOG.debug("plan: {}, planDTO: {}", plan, planDTO);

		plan.setPlanId(planId);
		Plan updatePlan = planRepo.getOne(plan.getPlanId());
		updatePlan.setPlanName(plan.getPlanName());
		updatePlan.setPlanStartDate(plan.getPlanStartDate());
		updatePlan.setPlanEndDate(plan.getPlanEndDate());
		updatePlan.setPlanDescription(plan.getPlanDescription());
		updatePlan.setPlanVersion(plan.getPlanVersion());
		updatePlan.setPlanStatus(plan.getPlanStatus());
		
		updatePlan.setTemplate(plan.getTemplate());
		updatePlan.setTerms(plan.getTerms());
		updatePlan.setFeature(plan.getFeature());

		LOG.debug("updatePlan: {}", updatePlan);
		Plan planUpdateData = planRepo.save(updatePlan);
		PlanDTO plans = planMapper.toPlanDTO(planUpdateData);

		LOG.debug("Plans: {}, planUpdateData: {}", plans, planUpdateData);

		LOG.info("PlanImpl::updatePlan::End");
		return plans;
	}

	/**
	 * @Description DeletePlan will delete a plan.
	 * @param planId
	 * @throws CustomExceptions
	 */
	public void deletePlanById(Long planId) throws CustomExceptions {
		LOG.info("PlanImpl::deletePlanById::Start");

		planNotFoundException.validateId(planId);
		LOG.debug("planId: {}", planId);

		planRepo.deleteById(planId);
		LOG.info("PlanImpl::deletePlanById::End");
	}

	/**
	 * @Description getOnPlan is use to get a single plan from database using planId
	 * @param planId
	 * @throws CustomExceptions
	 */
	public PlanDTO getOnePlan(Long planId) throws CustomExceptions {

		LOG.info("PlanImpl::getOnePlan::Start");

		planNotFoundException.validateId(planId);

		LOG.debug("planId: {}", planId);
		Optional<Plan> plan = planRepo.findById(planId);
		PlanDTO planDTO = planMapper.toPlanDTO(plan.get());
		LOG.info("PlanImpl::getOnePlan::End");

		return planDTO;
	}

	/**
	 * @Description getAllPlan is used to get all the records from the database
	 * @param planId
	 */
	public List<PlanDTO> getAllPlan() {

		LOG.debug("PlanImpl::getAllPlan::Start");

		List<Plan> allPlans = new ArrayList<Plan>();
		planRepo.findAll().forEach(s -> allPlans.add(s));
		List<PlanDTO> planDTO = planMapper.toPlanDTOs(allPlans);

		LOG.debug("PlanImpl::getAllPlan::End");

		return planDTO;
	}
}
