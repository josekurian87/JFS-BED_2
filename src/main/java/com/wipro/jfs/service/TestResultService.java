package com.wipro.jfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.jfs.dao.TestResultRepo;
import com.wipro.jfs.entity.TestResult;

@Service
public class TestResultService {

	@Autowired
	TestResultRepo testResultRepo;
	
	public List<TestResult> getAllTestResult() {
		return testResultRepo.findByOrderByTestDateAsc();
	}

	public TestResult findByEmailAndTopic(String email, String topic) {
		return testResultRepo.findByEmailAndTopic(email, topic);
	}

	public void saveTestResult(TestResult testResult) {
		testResultRepo.save(testResult);
	}
}
