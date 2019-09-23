package com.wipro.jfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.jfs.dao.TestDataRepo;
import com.wipro.jfs.entity.TestData;

@Service
public class TestDataService {

	@Autowired
	private TestDataRepo testDataRepo;
	
	public List<TestData> getQuestions(String topic) {
		return testDataRepo.findByTopicOrderByNoAsc(topic);
	}
	
}
