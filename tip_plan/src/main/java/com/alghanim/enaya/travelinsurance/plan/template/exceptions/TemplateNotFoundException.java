package com.alghanim.enaya.travelinsurance.plan.template.exceptions;

import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import com.alghanim.enaya.travelinsurance.plan.template.repo.TemplateRepo;

/**
 * 
 * @author khushbu
 * @Description This is template exception class.
 *
 */
@ControllerAdvice
public class TemplateNotFoundException extends Exception {

	Logger LOG = LoggerFactory.getLogger(TemplateNotFoundException.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	private TemplateRepo templateRepo;

	public void validateTemplate(Template template) throws CustomExceptions {

		LOG.info("TemplateNotFoundException::validateTemplate::Start");

		LOG.debug("template: {}", template);
		if (template.getTemplateName() == null || template.getTemplateName() == ""
				|| template.getTemplateName() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Template Name can not be kept as null.Please fill a unique" + " valid value !", "Invalid input",
					422);
		}

		String regex = "(.)*(\\d)(.)*";
		Pattern pattern = Pattern.compile(regex);
		boolean containsNumber = pattern.matcher(template.getTemplateName()).matches();

		if (Character.isDigit(template.getTemplateName().charAt(0)) || containsNumber) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Template Name should not contain any digit.Please fill a unique valid value !", "Invalid input",
					422);

		}

		if (template.getFormat() == null || template.getFormat() == "" || template.getFormat() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Format can not be kept as null.Please fill a unique valid value !", "Invalid input", 422);

		}
		if ((!template.getFormat().startsWith("."))) {

			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Template Format starts with dot " + "." + ".Please fill a unique valid value !", "Invalid input",
					422);

		}

		if ((template.getTemplateName().length() > 40 || template.getTemplateName().length() < 5)
				|| (template.getFormat().length() > 10 || template.getFormat().length() < 4)) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", " Input length is invalid", "Invalid input",
					422);

		}
		LOG.info("TemplateNotFoundException::validateTemplate::End");
	}

	public void validateId(Long templateId) throws CustomExceptions {

		LOG.info("TemplateNotFoundException::validateId::Start");

		LOG.debug("templateId: {}", templateId);
		if (templateRepo.findById(templateId).isEmpty()) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", "Id not found", "Invalid Input", 422);
		}
		LOG.info("TemplateNotFoundException::validateId::End");
	}
}