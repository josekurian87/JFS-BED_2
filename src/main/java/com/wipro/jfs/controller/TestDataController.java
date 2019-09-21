package com.wipro.jfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.jfs.entity.TestData;
import com.wipro.jfs.service.TestDataService;

@Controller
public class TestDataController {
	
	@Autowired
	private TestDataService testDataService;

	@RequestMapping(value = {"/{topic}/do", "{topic}Assessment.html"}, method = RequestMethod.GET)
	public String getHibernateQuestions(@PathVariable("topic") String topic, Model model) {
		String topicTxt = "spring".equals(topic)?"Spring":"Hibernate";
		List<TestData> questionList = testDataService.getQuestions(topicTxt);
		model.addAttribute("title", topicTxt+" Assessment");
		model.addAttribute("questionList", questionList);
		model.addAttribute("topic", topic);
		return "assessment";
	}

//	@RequestMapping(value = {"/{topic}/do", "springAssessment.html"}, method = RequestMethod.GET)
//	public String getSpringQuestions(@PathVariable("topic") String topic, Model model) {
//		List<TestData> questionList = testDataService.getQuestions("Spring");
//		model.addAttribute("title", "Spring Assessment");
//		model.addAttribute("questionList", questionList);
//		model.addAttribute("topic", topic);
//		return "assessment";
//	}

}
