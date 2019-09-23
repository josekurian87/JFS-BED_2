package com.wipro.jfs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.jfs.entity.TestData;

public interface TestDataRepo extends JpaRepository<TestData, Long> {
	List<TestData> findByTopicOrderByNoAsc(String topic);
}
