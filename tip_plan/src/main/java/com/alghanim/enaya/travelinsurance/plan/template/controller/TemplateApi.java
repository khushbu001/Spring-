package com.alghanim.enaya.travelinsurance.plan.template.controller;

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
import com.alghanim.enaya.travelinsurance.plan.template.DTO.TemplateDTO;
import com.alghanim.enaya.travelinsurance.plan.template.service.TemplateImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description This class is mainly use to implement the API for the Template.
 * @author Khushbu
 */
@EnableSwagger2
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ControllerAdvice
@RequestMapping("/api/v1")
public class TemplateApi {

	Logger LOG = LoggerFactory.getLogger(TemplateApi.class);

	@Autowired
	private TemplateImpl tempImpl;

	/**
	 * @Description This API will use to create a template
	 * @param templateId templateDTO
	 * @return template
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to create a template.")
	@ApiParam(value = "templateDTO")
	@PostMapping(value = "/templates")
	public ResponseEntity<Object> createTemplate(@RequestBody TemplateDTO templateDTO) throws CustomExceptions {

		LOG.info("TemplateApi::createTemplate::Start" + templateDTO);
		TemplateDTO template = tempImpl.createTemplate(templateDTO);
		LOG.debug("templateDTO: {}", "template: {}", templateDTO, template);

		LOG.info("TemplateApi::createTemplate::End");

		return ResponseEntity.status(HttpStatus.CREATED).body(template);
	}

	/**
	 * @Description This API will use to update a template based on id.
	 * @param templateId templateDTO
	 * @return template
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to update a template based on id.")
	@ApiParam(value = "templateId, templateDTO")
	@PutMapping(value = "/templates/{templateId}")
	public ResponseEntity<TemplateDTO> updateTemplate(@PathVariable Long templateId,
			@RequestBody TemplateDTO templateDTO) throws CustomExceptions {

		LOG.info("TemplateApi::updateTemplate::Start");

		TemplateDTO template = tempImpl.updateTempate(templateId, templateDTO);

		LOG.debug("templateDTO: {}", "templateId: {}", templateDTO, templateId);
		LOG.debug("TemplateApi::updateTemplate::End" + template);

		return ResponseEntity.status(HttpStatus.OK).body(template);
	}

	/**
	 * @Description This API will use to delete the template.
	 * @param templateId
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to delete the template.")
	@ApiParam(value = "templateId")
	@DeleteMapping(value = "/templates/{templateId}")
	public ResponseEntity<Object> deleteTemplateById(@PathVariable Long templateId) throws CustomExceptions {

		LOG.info("TemplateApi::deleteTemplateById::Start");
		tempImpl.deleteOneTemplate(templateId);
		LOG.debug("templateId: {}", templateId);
		LOG.info("TemplateApi::updateTemplate::End");

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	/**
	 * @Description This API will use to get a single template.
	 * @param templateId
	 * @return template
	 * @throws CustomExceptions
	 */
	@ApiOperation("This api will use to get a single template")
	@ApiParam(value = "templateId")
	@GetMapping(value = "/templates/{templateId}")
	public ResponseEntity<TemplateDTO> getoneTemplate(@PathVariable Long templateId) throws CustomExceptions {

		LOG.info("TemplateApi::getoneTemplate::Start" + templateId);
		TemplateDTO template = tempImpl.getOneTemplate(templateId);

		LOG.debug("templateId: {}", templateId);
		LOG.info("TemplateApi::getoneTemplate::End" + template);

		return ResponseEntity.status(HttpStatus.OK).body(template);
	}

	/**
	 * @Description This API will use to list out all the template.
	 * @return template
	 */
	@ApiOperation("This API will use to list out all the template.")
	@ApiParam(value = "No parameter")
	@GetMapping(value = "/templates")
	public ResponseEntity<List<TemplateDTO>> getAllTemplate() {

		LOG.debug("TemplateApi::getAllTemplate::Start");
		List<TemplateDTO> template = tempImpl.getAllTemplate();
		LOG.debug("TemplateApi::getAllTemplate::End" + template);

		return ResponseEntity.status(HttpStatus.OK).body(template);
	}
}
