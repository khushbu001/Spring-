package com.demo.registration.RegistrationForm.user.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.registration.RegistrationForm.exception.InsufficientBalanceException;
import com.demo.registration.RegistrationForm.exception.InvalidAccountException;
import com.demo.registration.RegistrationForm.exception.LimitTransactionException;
import com.demo.registration.RegistrationForm.model.SendMoneyFrom;
import com.demo.registration.RegistrationForm.service.UserService;

@RestController
public class UserTransactionController {
	@Autowired
	private UserService userService;

	Logger LOG = org.slf4j.LoggerFactory.getLogger(UserTransactionController.class);

	@Transactional
	@PutMapping(value = "/transfer")
	@ResponseBody
	public String fundTransfer(@RequestBody SendMoneyFrom sendMoneyFrom) throws InvalidAccountException, InsufficientBalanceException, LimitTransactionException {
		LOG.debug("Get From Account id {}", sendMoneyFrom.getFromAccountId());
		LOG.debug("Get To Account id {}", sendMoneyFrom.getToAccountId());
		LOG.debug("Amount{}", sendMoneyFrom.getAmount());

		return userService.transaction(sendMoneyFrom.getFromAccountId(), sendMoneyFrom.getToAccountId(),
				sendMoneyFrom.getAmount());
	}

	@GetMapping(value = "/balance/{userId}")
	@ResponseBody
	public Double balance(@PathVariable Integer userId) throws InvalidAccountException {
		LOG.debug("Getting balance: {} ", userId);
		return userService.getBalance(userId);
	}
}