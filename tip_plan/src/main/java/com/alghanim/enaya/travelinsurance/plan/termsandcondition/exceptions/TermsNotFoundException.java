package com.alghanim.enaya.travelinsurance.plan.termsandcondition.exceptions;

import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.repo.TermsAndConditionsRepo;

/**
 * 
 * @author khushbu
 * @Description This class defines all the custom exception for a terms and
 *              conditions.
 *
 */
@ControllerAdvice
public class TermsNotFoundException extends Exception {

	Logger LOG = LoggerFactory.getLogger(TermsNotFoundException.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	private TermsAndConditionsRepo termsAndConditionsRepo;

	/**
	 * @Description This method will work on exception based on validation.
	 * @param terms
	 * @throws CustomExceptions
	 */

	public void validateTerms(TermsAndConditions terms) throws CustomExceptions {
		LOG.info("TermsNotFoundException::validateTerms::Start" + terms.toString());

		LOG.debug("terms: {}", terms);

		if (terms.getName() == null || terms.getName() == "" || terms.getName() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Name can not be kept as null.Please fill a unique valid value !", "Invalid input", 422);
		}

		String regex = "(.)*(\\d)(.)*";
		Pattern pattern = Pattern.compile(regex);
		boolean containsNumber = pattern.matcher(terms.getName()).matches();

		if (Character.isDigit(terms.getName().charAt(0)) || containsNumber) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Name should not contain any digit.Please fill a unique valid value !", "Invalid input", 422);

		}

		if (!(Character.isDigit(terms.getVersion().charAt(terms.getVersion().length() - 1)))) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Version must ends with digit.Please fill a unique valid value !", "Invalid input", 422);

		}

		if (terms.getFormat() == null || terms.getFormat() == "" || terms.getFormat() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Format can not be kept as null.Please fill a unique valid value !", "Invalid input", 422);

		}

		if (terms.getVersion() == null || terms.getVersion() == "" || terms.getVersion() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Version can not be kept as null.Please fill a unique valid value !", "Invalid input", 422);
		}

		if (!(terms.getFormat().startsWith("."))) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Terms Format starts with dot " + "." + ".Please fill a unique valid value !", "Invalid input",
					422);

		}

		if ((terms.getName().length() > 40 || terms.getName().length() < 5)
				|| (terms.getFormat().length() > 10 || terms.getFormat().length() < 2)
				|| (terms.getVersion().length() > 10 || terms.getName().length() < 2)) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", " Input length is invalid", "Invalid input",
					422);

		}
		LOG.info("TermsAndConditionsImpl::validateTerms::End");
	}

	/**
	 * @Description This method will work on exception based on validation.
	 * @param terms
	 * @throws CustomExceptions
	 */
	public void validateId(Long termsId) throws CustomExceptions {
		LOG.info("TermsNotFoundException::validateId::Start");

		LOG.debug("termsId: {}", termsId);
		if (termsAndConditionsRepo.findById(termsId).isEmpty()) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", "Id not found", "Invalid Input", 422);

		}
		LOG.info("TermsNotFoundException::validateId::End");
	}

}