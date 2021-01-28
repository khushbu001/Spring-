package com.alghanim.enaya.travelinsurance.plan.template.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.template.DTO.TemplateDTO;
import com.alghanim.enaya.travelinsurance.plan.template.DTO.TemplateMapper;
import com.alghanim.enaya.travelinsurance.plan.template.exceptions.TemplateNotFoundException;
import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import com.alghanim.enaya.travelinsurance.plan.template.repo.TemplateRepo;

/**
 * @Description This is the class which is use to implement the services of the
 *              template
 * @author Khushbu
 */
@Service
public class TemplateImpl {

	private static final Logger LOG = LoggerFactory.getLogger(TemplateImpl.class);

	@Autowired
	private TemplateRepo templateRepo;

	@Autowired
	private TemplateMapper templateMapper;

	@Autowired
	private TemplateNotFoundException templteNotFoundException;

	/**
	 * @throws CustomExceptions
	 * @Description This method is use to create a template and store it in database
	 */
	public TemplateDTO createTemplate(TemplateDTO templateDTO) throws CustomExceptions {

		LOG.info("TemplateImpl::createTemplate::Start");

		Template template = templateMapper.toTemplate(templateDTO);
		
		LOG.debug("templateDTO: {},templateDTO: {} ", templateDTO, template);
//		templteNotFoundException.validateTemplate(template);
		Template templateData = templateRepo.save(template);

		TemplateDTO templateInfo = templateMapper.toTemplateDTO(templateData);

		LOG.info("TemplateImpl::createTemplate::End");
		return templateInfo;
	}

	/**
	 * @throws CustomExceptions
	 * @Description This method will use to update a template
	 */
	public TemplateDTO updateTempate(Long templateId, TemplateDTO templateDTO) throws CustomExceptions {
		LOG.info("TemplateImpl::updateTempate::Start");

		Template template = templateMapper.toTemplate(templateDTO);
		LOG.debug("templateId: {},templateDTO: {} ", templateId, template);
		template.setTemplateId(templateId);
		Template updateTemplate = templateRepo.getOne(template.getTemplateId());
		templteNotFoundException.validateTemplate(updateTemplate);
		updateTemplate.setTemplateName(template.getTemplateName());
		updateTemplate.setFormat(template.getFormat());

		Template templateUpdateData = templateRepo.save(updateTemplate);
		TemplateDTO templateData = templateMapper.toTemplateDTO(templateUpdateData);
		LOG.info("TemplateImpl::updateTempate::End");

		return templateData;
	}

	/**
	 * @throws CustomExceptions
	 * @description This method is use to delete a template
	 */
	public void deleteOneTemplate(Long templateId) throws CustomExceptions {

		LOG.info("TemplateImpl::deleteOneTemplate::Start");
		LOG.debug("templateId: {} ", templateId);
		templteNotFoundException.validateId(templateId);
		
		Template tId = new Template();
		tId.setTemplateId(templateId);
		
		if (templateRepo.deleteByTemplateId(tId).isEmpty()) {
			templateRepo.deleteById(templateId);
		} else {
			LOG.info("This term id cannot be deleted it is maped with a plan");
		}
		LOG.info("TemplateImpl::deleteOneTemplate::End");
	}

	/**
	 * @Description This method is used to get a single template
	 * @param templateId
	 * @throws CustomExceptions
	 */
	public TemplateDTO getOneTemplate(Long templateId) throws CustomExceptions {

		LOG.info("TemplateImpl::getOneTemplate::Start");
		LOG.debug("templateId: {} ", templateId);

		templteNotFoundException.validateId(templateId);
		Optional<Template> template = templateRepo.findById(templateId);
		TemplateDTO templateDTO = templateMapper.toTemplateDTO(template.get());
		
		LOG.debug("template: {} , templateDTO: {}", template, templateDTO);
		LOG.info("TemplateImpl::getOneTemplate::End");

		return templateDTO;
	}

	/**
	 * @Description This method will use to display all template
	 *
	 */
	public List<TemplateDTO> getAllTemplate() {
		LOG.info("TemplateImpl::getAllTemplate::Start");

		List<Template> allTemplate = new ArrayList<Template>();
		templateRepo.findAll().forEach(s -> allTemplate.add(s));
		List<TemplateDTO> templateDTO = templateMapper.toTemplateDTOs(allTemplate);
		LOG.info("TemplateImpl::getAllTemplate::End");

		return templateDTO;

	}
}