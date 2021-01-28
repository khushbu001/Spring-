package com.demo.registration.RegistrationForm.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.registration.RegistrationForm.model.User;
import com.demo.registration.RegistrationForm.repository.UserRepo;
//import com.demo.registration.RegistrationForm.config.LanguageConfiguration;
import com.demo.registration.RegistrationForm.service.UserService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author khushii
 *
 */
@EnableSwagger2
@RestController
@ControllerAdvice
@RequestMapping
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	/**
	 * Creates a {@link User}
	 * 
	 * @param userdata the user you want to create
	 * @return the user with ID populated
	 */
	// create a user
	@ApiOperation(value = "This api is mainly use to create and save users data.")
	@PostMapping(value = "/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@Valid @RequestBody User userdata) {
		return userRepo.save(userdata);
	}

	/**
	 * Retrive all users from repo
	 */
	@GetMapping(value = "/users", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers() {
		return userService.getUser();
	}

	// update a user detail
	/**
	 * 
	 * @param id
	 * @param user
	 * @return
	 */

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody User user) {
		User updateUser;
		if (userRepo.findById(id) == null) {
			return new ResponseEntity<>("Data does not exist", HttpStatus.NOT_FOUND);

		} else {
			user.setUserId(id);
			updateUser = userRepo.getOne(user.getUserId());
			System.out.println(updateUser.toString());
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			userRepo.save(updateUser);
			return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
		if (userRepo.findById(id) == null) {
			return new ResponseEntity<>("Data does not exist", HttpStatus.NOT_FOUND);

		} else {
			userRepo.deleteById(id);
			return new ResponseEntity<>("user deleted successfully", HttpStatus.FORBIDDEN);
		}
	}
}