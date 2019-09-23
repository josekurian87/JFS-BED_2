package com.wipro.jfs.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.jfs.entity.TestData;
import com.wipro.jfs.entity.TestResult;
import com.wipro.jfs.entity.User;
import com.wipro.jfs.service.TestDataService;
import com.wipro.jfs.service.TestResultService;
import com.wipro.jfs.service.UserService;

@Controller
public class TestResultController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TestDataService testDataService;

	@Autowired
	private TestResultService testResultService;

	@RequestMapping(value = "/evaluate/{topic}/test", method = RequestMethod.POST)
	public String submitTest(@PathVariable("topic") String topic, Model model, HttpServletRequest request) {
		User userData = userService.getUserFromSession(request.getSession());
		int score = 0;
		String topicTxt = "spring".equals(topic)?"Spring":"Hibernate";
		List<TestData> testDataList = testDataService.getQuestions(topicTxt);
		for(TestData data: testDataList) {
			String paramName = "Question"+data.getNo();
			System.out.println(data.getAnswer() +" >> "+request.getParameter(paramName));
			if(!(StringUtils.isEmpty(request.getParameter(paramName))) 
					&& data.getAnswer().equals(request.getParameter(paramName))) {
				score += 10;
			}
		}
		System.out.println("SCORE="+score);
		
		TestResult testResult = testResultService.findByEmailAndTopic(userData.getEmail(), topicTxt);
		if(testResult == null) {
			testResult =  new TestResult();
			testResult.setEmail(userData.getEmail());
			testResult.setTopic(topicTxt);
		}
		testResult.setScore(score);
		testResult.setTestDate(new Date());
		
		testResultService.saveTestResult(testResult);
		
		if(score>=30) {
			model.addAttribute("title", "Success Page");
			model.addAttribute("message", "Congratulations !!! You have passed !!!");
			model.addAttribute("assessmentResult", "P");
			return "result";
		} else {
			model.addAttribute("title", "Failure Page");
			model.addAttribute("message", "Sorry !!! Better Luck Next Time !!!");
			model.addAttribute("assessmentResult", "F");
			return "result";
		}
	}
	
	@RequestMapping(value = "/tests/all", method = RequestMethod.GET)
	public String getTests(Model model) {
		List<TestResult> testResultList = testResultService.getAllTestResult();
		model.addAttribute("title", "All Tests Details");
		model.addAttribute("testResultList", testResultList);
		model.addAttribute("reportType", "TR");
		return "report";
	}

}
