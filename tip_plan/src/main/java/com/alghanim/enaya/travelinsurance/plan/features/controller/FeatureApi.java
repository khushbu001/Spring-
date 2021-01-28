package com.alghanim.enaya.travelinsurance.plan.features.controller;

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

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.features.DTO.FeatureDTO;
import com.alghanim.enaya.travelinsurance.plan.features.services.FeatureImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description This class is mainly use to implement the API for the Feature.
 * @author khushbu
 */
@EnableSwagger2
@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class FeatureApi {

	Logger LOG = LoggerFactory.getLogger(FeatureApi.class);

	@Autowired
	private FeatureImpl featureImpl;

	/**
	 * @Description This API will use to create a feature.
	 * @param featureDTO
	 * @return feature
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to create a feature data ")
	@ApiParam(value = "featureDTO")
	@PostMapping(value = "/features")
	public ResponseEntity<Object> createFeature(@RequestBody FeatureDTO featureDTO) throws CustomExceptions {
		LOG.info("FeatureApi::createFeature::Start");
		if (featureDTO.getName() == null || featureDTO.getDescription() == null || featureDTO.getPlan() == null) {
			return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
					.body("All fields are mandatory, Please fill all the fields.");
		}
		FeatureDTO feature = featureImpl.createFeature(featureDTO);
		LOG.info("FeatureApi::createFeature::End");

		return ResponseEntity.status(HttpStatus.CREATED).body(feature);
	}

	/**
	 * @Description This API will use to update the feature API .
	 * @param featureId, featureDTO
	 * @return updateFeature
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to update the feature data.")
	@ApiParam(value = "")
	@PutMapping(value = "/features/{featureId}")
	public ResponseEntity<Object> updateFeature(@PathVariable Long featureId, @RequestBody FeatureDTO featureDTO)
			throws CustomExceptions {

		LOG.debug("FeatureApi::updateFeature::Start");
		FeatureDTO updateFeature = featureImpl.updateFeature(featureId, featureDTO);
		LOG.debug("FeatureApi::updateFeature::End");

		return ResponseEntity.status(HttpStatus.OK).body(updateFeature);
	}

	/**
	 * @Description This API will use to delete the feature.
	 * @param featureId
	 * @throws CustomExceptions 
	 */
	@ApiOperation("This api will use to delete a feature data ")
	@DeleteMapping(value = "/features/{featureId}")
	public ResponseEntity<Object> deleteFeatureById(@PathVariable Long featureId) throws CustomExceptions {

		LOG.debug("FeatureApi::deleteFeature::Start");
		featureImpl.deleteFeatureById(featureId);
		LOG.debug("FeatureApi::deleteFeature::End");

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	/**
	 * @Description This API will use to get one record with the given id.
	 * @param featureId
	 * @return featureDTO
	 * @throws CustomExceptions 
	 */
	@ApiOperation("This api will use to get one record with the given id.")
	@ApiParam(value = "")
	@GetMapping(value = "/features/{featureId}")
	public ResponseEntity<FeatureDTO> getOneFeature(@PathVariable Long featureId) throws CustomExceptions {

		LOG.debug("FeatureApi::getOneFeature::Start");
		FeatureDTO featureDTO = featureImpl.getOneFeature(featureId);
		LOG.debug("FeatureApi::getOneFeature::End");

		return ResponseEntity.status(HttpStatus.OK).body(featureDTO);
	}

	/**
	 * @Description This API will use to get all the records.
	 * @return featureDTO
	 */
	@ApiOperation("This api will use to get all the records.")
	@ApiParam(value = "")
	@GetMapping(value = "/features")
	public ResponseEntity<List<FeatureDTO>> getAllFeatures() {

		LOG.debug("FeatureApi::getAllFeatures::Start");
		List<FeatureDTO> feature = featureImpl.getAllFeature();
		LOG.debug("FeatureApi::getAllFeature::End");
		return ResponseEntity.status(HttpStatus.OK).body(feature);
	}
}