//package com.demo.registration.RegistrationForm.dao;
//
//import java.util.List;
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.demo.registration.RegistrationForm.component.UserMapper;
//import com.demo.registration.RegistrationForm.exception.LimitTransactionException;
//import com.demo.registration.RegistrationForm.model.User;
//
//@Repository
//@Transactional
//public class UserDAO extends JdbcDaoSupport {
//
//	@Autowired
//	public UserDAO(DataSource dataSource) {
//		this.setDataSource(dataSource);
//	}
//
//	public List<User> getUser() {
//		/*
//		 * Select ud.userId, ud.FirstName, ud.lastName, ud.email, ba.password," + "
//		 * ud.contact, ba.amount From Users_data ud
//		 */
//		String sql = UserMapper.BASE_SQL;
//
//		Object[] params = new Object[] {};
//		UserMapper mapper = new UserMapper();
//		List<User> list = this.getJdbcTemplate().query(sql, params, mapper);
//		return list;
//	}
//
//	public User findUser(Integer toAccountId) {
//		/*
//		 * Select ud.userId, ud.FirstName, ud.lastName, ud.email, ba.password," + "
//		 * ud.contact, ba.amount From Users_data ud
//		 */
//		String sql = UserMapper.BASE_SQL + " where ud.user_id = ? ";
//		Object[] params = new Object[] { toAccountId };
//		UserMapper mapper = new UserMapper();
//		try {
//			User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
//			return userInfo;
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	// MANDATORY: Transaction must be created before.
//	@Transactional(propagation = Propagation.MANDATORY)
//	public void addAmount(Integer toAccountId, double amount) throws UserTransactionException {
//		User accountInfo = this.findUser(toAccountId);
//		if (accountInfo == null) {
//			throw new UserTransactionException("User not found " + toAccountId);
//		}
//
//		double newBalance = accountInfo.getAmount() + amount;
//		if (accountInfo.getAmount() + amount < 0) {
//			throw new UserTransactionException(
//					"The money in the account '" + toAccountId + "' is not enough (" + accountInfo.getAmount() + ")");
//		}
//		accountInfo.setAmount(newBalance);
//		// Update to DB
//		String sqlUpdate = "Update Users_data set Balance = ? where ud.user_id = ?";
//		this.getJdbcTemplate().update(sqlUpdate, accountInfo.getAmount(), accountInfo.getUserId());
//	}
//
//	// Do not catch UserTransactionException in this method.
//	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = UserTransactionException.class)
//	public String sendMoney(Integer fromAccountId, Integer toAccountId, double amount) throws UserTransactionException {
//
//		addAmount(toAccountId, amount);
//		addAmount(fromAccountId, -amount);
//		return " ";
//	}
//}