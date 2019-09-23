package com.wipro.jfs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jfs.entity.TestResult;

public interface TestResultRepo extends JpaRepository<TestResult, Long> {
	TestResult findByEmailAndTopic(String email, String topic);
	List<TestResult> findByOrderByTestDateAsc();
}
