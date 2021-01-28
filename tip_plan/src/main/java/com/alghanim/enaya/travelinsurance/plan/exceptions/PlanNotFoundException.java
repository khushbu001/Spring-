package com.alghanim.enaya.travelinsurance.plan.exceptions;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alghanim.enaya.travelinsurance.plan.model.Plan;
import com.alghanim.enaya.travelinsurance.plan.repo.PlanRepo;

@ControllerAdvice
public class PlanNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PlanRepo planRepo;

	public void validatePlan(Plan plan) throws CustomExceptions {

		if (plan.getPlanName() == null || plan.getPlanName() == "" || plan.getPlanName() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Plan Name can not be kept as null.Please fill a unique valid value !", "Invalid input", 422);
		}

		String regex = "(.)*(\\d)(.)*";
		Pattern pattern = Pattern.compile(regex);
		boolean containsNumber = pattern.matcher(plan.getPlanName()).matches();

		if (Character.isDigit(plan.getPlanName().charAt(0)) || containsNumber) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Plan Name should not contain any digit.Please fill a unique valid value !", "Invalid input", 422);

		}

		if (!(Character.isDigit(plan.getPlanVersion().charAt(plan.getPlanVersion().length() - 1)))) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Plan Version must ends with digit. Please fill a uniqu valid value !", "Invalid input", 422);

		}

		if (plan.getPlanVersion() == null || plan.getPlanVersion() == "" || plan.getPlanVersion() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Plan Version can not be kept as null.Please fill a unique valid value !", "Invalid input", 422);
		}

		if (plan.getPlanDescription() == null || plan.getPlanDescription() == "" || plan.getPlanDescription() == " ") {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Plan description can not be kept as null.Please fill a unique valid value !", "Invalid input",
					422);

		}

		if (plan.getPlanStatus() == null) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity",
					"Plan description can not be kept as null.Please fill a unique valid value !", "Invalid input",
					422);

		}

		if ((plan.getPlanName().length() > 40 || plan.getPlanName().length() < 5)
				|| (plan.getPlanVersion().length() > 10 || plan.getPlanVersion().length() < 2)
				|| (plan.getPlanDescription().length() > 500 || plan.getPlanDescription().length() < 10)) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", " Input length is invalid", "Invalid input",
					422);

		}

	}

	public void validateId(Long planId) throws CustomExceptions {
		if (planRepo.findById(planId) == null) {
			throw new CustomExceptions(new Date(), "Unprocessable Entity", "Id not found", "Invalid Input", 422);
		}

	}

}