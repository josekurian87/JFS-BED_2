package com.wipro.jfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_DATA")
public class TestData {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "TOPIC", nullable = false, length = 40)
	private String topic;

	@Column(name = "NO", nullable = false)
	private int no;

	@Column(name = "QUESTION", nullable = false, length = 200)
	private String question;

	@Column(name = "OPTION_1", nullable = false, length = 200)
	private String option1;

	@Column(name = "OPTION_2", nullable = false, length = 200)
	private String option2;

	@Column(name = "OPTION_3", nullable = false, length = 200)
	private String option3;

	@Column(name = "OPTION_4", nullable = false, length = 200)
	private String option4;

	@Column(name = "ANSWER", nullable = false, length = 200)
	private String answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public TestData(Long id, String topic, int no, String question, String option1, String option2, String option3,
			String option4, String answer) {
		super();
		this.id = id;
		this.topic = topic;
		this.no = no;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}

	public TestData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
