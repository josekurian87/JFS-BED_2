package com.wipro.jfs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jfs.entity.User;

public interface UserDao extends JpaRepository<User, String> {
	List<User> findByEmail(String email);
	List<User> findByOrderByFirstNameAsc();
	List<User> findByEmailAndPassword(String email, String password);
}
