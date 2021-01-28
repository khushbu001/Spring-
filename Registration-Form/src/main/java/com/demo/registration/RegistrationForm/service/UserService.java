package com.demo.registration.RegistrationForm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.registration.RegistrationForm.exception.InsufficientBalanceException;
import com.demo.registration.RegistrationForm.exception.InvalidAccountException;
import com.demo.registration.RegistrationForm.exception.LimitTransactionException;
import com.demo.registration.RegistrationForm.model.User;
import com.demo.registration.RegistrationForm.repository.UserRepo;
import com.demo.registration.RegistrationForm.validation.Validation;

@Service
public class UserService {

	Logger LOG = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private Validation validation;

	/**
	 * 
	 * @return
	 */
	public List<User> getUser() {
		List<User> allUser = new ArrayList<User>();
		userRepo.findAll().forEach(s -> allUser.add(s));
		return allUser;
	}

	@Transactional
	public String transaction(Integer fromAccountId, Integer toAccountId, Double amount)
			throws InvalidAccountException, InsufficientBalanceException, LimitTransactionException {
		Optional<User> fromUserOpt = userRepo.findById(fromAccountId);
		Optional<User> toUserOpt = userRepo.findById(toAccountId);
		
		User fromUser = fromUserOpt.get();
		User toUser = toUserOpt.get();
		
		validation.limitTransaction();
		validation.checkPresence(fromUser.getUserId(),toUser.getUserId());

		try {
			Double currentBalance = fromUser.getAmount();
			if (currentBalance < amount) {
				throw new InsufficientBalanceException(fromAccountId);
			}

			toUser.setAmount(toUser.getAmount() + amount);
			fromUser.setAmount(fromUser.getAmount() - amount);

			userRepo.save(fromUser);
			Thread.sleep(2000);
			userRepo.save(toUser);

		} catch (Exception e) {
//			throw new RuntimeException(HttpStatus.FORBIDDEN);
			LOG.debug("invalid transaction");
			
		}
		return "Transaction Successful";
	}

	public Double getBalance(Integer userId) throws InvalidAccountException {
		Optional<User> userOpt = userRepo.findById(userId);
		User user = userOpt.get();
		validation.validateUser(user.getUserId());
		Double balance = user.getAmount();
		LOG.debug("User id: {}, amount: {}", user.getUserId(), user.getAmount());
		return balance;
	}

	
}