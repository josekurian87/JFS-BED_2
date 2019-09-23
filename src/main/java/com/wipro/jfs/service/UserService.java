package com.wipro.jfs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.jfs.dao.UserDao;
import com.wipro.jfs.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	List<User> userList = null;
	
	public String validateLogin(User user) {
		User dbUser = userDao.findByEmail(user.getEmail());
		if(dbUser == null) {
			return "I";
		} else if(user!=null && encoder.matches(user.getPassword(), dbUser.getPassword())) {
			return ("A".equals(dbUser.getType()))?"SA":"SC";
		} else 
		return "I";
	}

	public String registerUser(User user) {
		User dbUser = userDao.findByEmail(user.getEmail());
		if(dbUser!=null) {
			return "D";
		} else {
			user.setPassword(encoder.encode(user.getPassword()));
			userDao.save(user);
		}
		return "S";
	}

	public List<User> getUsers() {
		List<User> result = (List<User>) userDao.findByOrderByFirstNameAsc();
		return result;
	}
	
	public void saveUserSession(HttpSession session, User user) {
		session.setAttribute("usr_auth", user);
	}

	public void removeUserSession(HttpSession session) {
		session.removeAttribute("usr_auth");
		session.invalidate();
	}
	
	public User getUserFromSession(HttpSession session) {
		return (User)session.getAttribute("usr_auth");
	}

}
