package com.wipro.jfs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "TEST_RESULT")
public class TestResult {

	@Id
	@Column(name = "EMAIL", nullable = false, length = 40)
	private String email;
	
	@Column(name = "TOPIC", nullable = false, length = 40)
	private String topic;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TEST_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date testDate;
	
	@Column(name = "SCORE", nullable = false)
	private int score;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public TestResult(String email, String topic, Date testDate, int score) {
		super();
		this.email = email;
		this.topic = topic;
		this.testDate = testDate;
		this.score = score;
	}

	public TestResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
