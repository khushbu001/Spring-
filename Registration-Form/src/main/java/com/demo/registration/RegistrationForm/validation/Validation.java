package com.demo.registration.RegistrationForm.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.registration.RegistrationForm.exception.InvalidAccountException;
import com.demo.registration.RegistrationForm.exception.LimitTransactionException;
import com.demo.registration.RegistrationForm.model.User;
import com.demo.registration.RegistrationForm.repository.UserRepo;

@Component
@ValidateOnExecution
public class Validation {

	@Autowired
	private UserRepo userRepo;

	public void validateUser(Integer userId) throws InvalidAccountException {
		Optional<User> userOpt = userRepo.findById(userId);
		if (!(userOpt.isPresent())) {
			throw new InvalidAccountException(userId);
		}

	}

	int countTransaction = 1;

	public String limitTransaction() throws LimitTransactionException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();

		if (dateFormat.format(dateobj).equals(dateobj)) {
			countTransaction += 1;
			if (countTransaction > 3) {
				throw new LimitTransactionException();
			}
		}
		return "";
	}

	public void checkPresence(Integer fromAccountId, Integer toAccountId) throws InvalidAccountException {
		Optional<User> fromUserOpt = userRepo.findById(fromAccountId);
		Optional<User> toUserOpt = userRepo.findById(toAccountId);

		if (!fromUserOpt.isPresent()) {
			throw new InvalidAccountException(fromAccountId);
		}

		if (!toUserOpt.isPresent()) {
			throw new InvalidAccountException(toAccountId);
		}

	}

}
