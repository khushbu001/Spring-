package com.alghanim.enaya.travelinsurance.plan.termsandcondition.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.DTO.TermsAndConditionsDTO;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.service.TermsAndConditionsImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Khushbu
 * @Description This class will use to create all the end points and it will
 *              communicate with the service class for the further operation
 */
@EnableSwagger2
@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class TermsAndConditionsApi {

	Logger LOG = LoggerFactory.getLogger(TermsAndConditionsApi.class);

	@Autowired
	private TermsAndConditionsImpl termsImpl;

	/**
	 * @Description This API is use to create a term and condition
	 * @param termsAndConditionsDTO
	 * @return terms
	 * @throws Exception
	 */
	@ApiOperation("This api is use to create a term and condition")
	@ApiParam()
	@PostMapping(value = "/terms")
	public ResponseEntity<Object> createTerms(@Valid @RequestBody TermsAndConditionsDTO termsAndConditionsDTO)
			throws Exception {

		LOG.info("TermsAndConditionsApi::createTerms::Start" + termsAndConditionsDTO);

		TermsAndConditionsDTO terms = termsImpl.createTerms(termsAndConditionsDTO);
		LOG.debug("termsAndConditionsDTO: {}", "terms: {}", termsAndConditionsDTO, terms);

		LOG.info("TermsAndConditionsApi::createTerms::End" + terms);

		return ResponseEntity.status(HttpStatus.CREATED).body(terms);
	}

	/**
	 * @Description This API is use to create a term and condition
	 * @param termId
	 * @return updateTerms
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api is use to update a term and condition.")
	@ApiParam
	@PutMapping(value = "/terms/{termId}")
	public ResponseEntity<TermsAndConditionsDTO> updateTerms(@PathVariable Long termId,
			@RequestBody TermsAndConditionsDTO termsAndConditionsDTO) throws CustomExceptions {

		LOG.info("TermsAndConditionsApi::updateTerms::Start");
		LOG.debug("termId: {}", "termsAndConditionsDTO: {}", termId, termsAndConditionsDTO);

		TermsAndConditionsDTO updateTerms = termsImpl.updateTerms(termId, termsAndConditionsDTO);

		LOG.debug("updateTerms: {}", updateTerms);
		LOG.info("TermsAndConditionsApi::updateTerms::End");

		return ResponseEntity.status(HttpStatus.OK).body(updateTerms);
	}

	/**
	 * @Description This API is use to create a term and condition
	 * @param termId
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api is use to create a term and condition.")
	@ApiParam(value = "")
	@DeleteMapping(value = "/terms/{termId}")
	public ResponseEntity<Object> deleteTerm(@PathVariable Long termId) throws CustomExceptions {

		LOG.info("TermsAndConditionsApi::deleteTerm::Start");
		LOG.debug("termId: {}", termId);

		termsImpl.deleteTermsById(termId);
		LOG.info("TermsAndConditionsApi::deleteTerm::End");

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	/**
	 * @Description This API will use to get a single Terms and conditions.
	 * @param termId
	 * @return termsAndConditions
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api is use to get a single Terms and conditions detail")
	@ApiParam
	@GetMapping(value = "/terms/{termId}")
	public ResponseEntity<TermsAndConditionsDTO> getOneTerm(@PathVariable Long termId) throws CustomExceptions {

		LOG.info("TermsAndConditionsApi::getOneTerm::Start");

		TermsAndConditionsDTO termsAndConditions = termsImpl.getOneTerm(termId);

		LOG.debug("termId: {}", termId);
		LOG.info("TermsAndConditionsApi::getOneTerm::End");
		return ResponseEntity.status(HttpStatus.OK).body(termsAndConditions);
	}

	/**
	 * @Description This API will use to get all the terms.
	 * @return termsAndConditions
	 */
	@ApiOperation("This api is use to get all the Terms and conditions")
	@ApiParam
	@GetMapping(value = "/terms")
	public ResponseEntity<List<TermsAndConditionsDTO>> getAllTerms() {

		LOG.info("TermsAndConditionsApi::getAllTerms::Start");
		List<TermsAndConditionsDTO> termsAndConditions = termsImpl.getAllTerms();
		LOG.info("TermsAndConditionsApi::getAllTerms::End");

		return ResponseEntity.status(HttpStatus.OK).body(termsAndConditions);
	}
}