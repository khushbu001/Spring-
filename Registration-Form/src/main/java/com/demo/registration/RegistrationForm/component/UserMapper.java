package com.demo.registration.RegistrationForm.component;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.demo.registration.RegistrationForm.model.User;

@Component
public class UserMapper implements RowMapper<User> {

	public static final String BASE_SQL //
			= "Select user_id, firstname, lastname, email, password,"
					+ " contact, amount From users_data";

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer userId = rs.getInt("userId");
		String firstName = rs.getString("FirstName");
		String lastName = rs.getString("lastName");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String contact = rs.getString("contact");
		Double amount = rs.getDouble("amount");

		return new User(userId, firstName, lastName, email, password, contact, amount);
	}

}