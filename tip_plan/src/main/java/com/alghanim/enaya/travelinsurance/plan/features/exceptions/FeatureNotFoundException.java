package com.alghanim.enaya.travelinsurance.plan.features.exceptions;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;
import com.alghanim.enaya.travelinsurance.plan.features.repo.FeatureRepo;

@ControllerAdvice
public class FeatureNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private FeatureRepo featureRepo;

	public void validateFeature(Feature feature) throws CustomExceptions {

		if ((feature.getName() == null || feature.getName() == "" || feature.getName() == " ")) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Feature Name can not be kept as null.Please fill a unique" + " valid value !", "Invalid input",
					422);
		}

		String regex = "(.)*(\\d)(.)*";
		Pattern pattern = Pattern.compile(regex);
		boolean containsNumber = pattern.matcher(feature.getName()).matches();

		if (Character.isDigit(feature.getName().charAt(0)) || containsNumber) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Feature Name should not contain any digit.Please fill a unique valid value !", "Invalid input",
					422);

		}

		if (feature.getDescription() == null || feature.getDescription() == "" || feature.getDescription() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Feature description can not be kept as null.Please fill a unique valid value !", "Invalid input",
					422);

		}

		if ((feature.getName().length() > 25 || feature.getName().length() < 5)
				|| (feature.getDescription().length() > 200 || feature.getDescription().length() < 20)) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", " Input length is invalid", "Invalid input",
					422);

		}
	}

	public void validateId(Long featureId) throws CustomExceptions {
		if (featureRepo.findById(featureId).isEmpty()) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", "Id not found", "Invalid Input", 422);
		}
	}

}