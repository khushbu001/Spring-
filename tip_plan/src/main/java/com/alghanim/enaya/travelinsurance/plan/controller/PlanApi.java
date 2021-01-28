package com.alghanim.enaya.travelinsurance.plan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alghanim.enaya.travelinsurance.plan.DTO.PlanDTO;
import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.service.PlanImpl;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description This class is use to define a plan with its feature template and
 *              terms.
 * @author khushbu
 */
@EnableSwagger2
@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class PlanApi {

	Logger logger = LoggerFactory.getLogger(PlanApi.class);

	@Autowired(required = true)
	private PlanImpl planImpl;

	/**
	 * @Description ThisAPI will use to create a plan.
	 * @param planDTO
	 * @return plan
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to create the plan")
	@PostMapping(value = "/plans")
	public ResponseEntity<Object> createPlan(@RequestBody PlanDTO planDTO) throws CustomExceptions {

		logger.info("PlanApi::createPlan::Start");

		PlanDTO plan = planImpl.createPlan(planDTO);
		logger.info("PlanApi::createPlan::End");

		return ResponseEntity.status(HttpStatus.CREATED).body(plan);
	}

	/**
	 * @Description This API will use to update the plan.
	 * @param planId, PlanDTO
	 * @return updatePlan
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to update the plan.")
	@PutMapping(value = "/plans/{planId}")
	public ResponseEntity<PlanDTO> updatePlan(@PathVariable Long planId, @RequestBody PlanDTO planDTO)
			throws CustomExceptions {

		logger.info("PlanApi::updatePlan::Start");
		logger.debug("planId: {}, planDTO: {}", planId, planDTO);

		PlanDTO updatedPlan = planImpl.updatePlan(planId, planDTO);

		logger.debug(" updatedPlan: {}", updatedPlan);
		logger.info("PlanApi::updatePlan::End");

		return ResponseEntity.status(HttpStatus.OK).body(updatedPlan);
	}

	/**
	 * @Description This API will use to delete a plan.
	 * @param planId
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to delete a plan data ")
	@DeleteMapping(value = "/plans/{planId}")
	public ResponseEntity<Object> deletePlan(@PathVariable Long planId) throws CustomExceptions {

		logger.info("PlanApi::deletePlan::Start");
		planImpl.deletePlanById(planId);
		
		logger.debug("planId:{} ", planId);
		logger.info("PlanApi::deletePlan::End");

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	/**
	 * @Description This API will use to get one plan.
	 * @param planId
	 * @return plan
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to get one plan.")
	@GetMapping(value = "/plans/{planId}")
	public ResponseEntity<PlanDTO> getOnePlan(@PathVariable Long planId) throws CustomExceptions {

		logger.info("PlanApi::getOnePlan::Start");

		PlanDTO plan = planImpl.getOnePlan(planId);

		logger.debug("planId:{} , plan:{} ", planId, plan);
		logger.info("PlanApi::getOnePlan::End");

		return ResponseEntity.status(HttpStatus.OK).body(plan);

	}

	/**
	 * @Description This API will use to get all the plan.
	 * @return allPlan
	 */
	@ApiOperation("This api will use to get all the plan.")
	@GetMapping(value = "/plans")
	public ResponseEntity<List<PlanDTO>> getAllPlan() {

		logger.debug("PlanApi::getAllPlan::Start");
		List<PlanDTO> allPlan = planImpl.getAllPlan();
		logger.debug("PlanApi::getAllPlan::End");
		
		return ResponseEntity.status(HttpStatus.OK).body(allPlan);

	}
}