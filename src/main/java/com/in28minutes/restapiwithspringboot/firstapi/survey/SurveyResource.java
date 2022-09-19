package com.in28minutes.restapiwithspringboot.firstapi.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyResource {
	
	private SurveyService  surveyService;
	
	public SurveyResource(SurveyService survetService) {
		super();
		this.surveyService = survetService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retriveAllSurvey(){		
		return surveyService.retriveAllSurveys();
		
	}
	
	@RequestMapping("/surveys/{surveyId}")
	public Survey retriveSurveyById(@PathVariable String surveyId){		
				
		Survey survey = surveyService.retriveSurveyById(surveyId);
		if(survey==null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		return survey;
		
	}
	
	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveAllSurveyQuestions(@PathVariable String surveyId){		
		List<Question> questions = 	surveyService.retriveAllSurveyQuestions(surveyId);	
		
		if(questions == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;
	}
	
	
	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retriveSpecificSurveyQuestion (@PathVariable String surveyId,
			@PathVariable String questionId){		
		Question question = surveyService.retriveSpecificSurveyQuestion(surveyId,questionId);	
		
		if(question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;
	}
	
	
	@RequestMapping(value="/surveys/{surveyId}/questions", method=RequestMethod.POST)
	public void addNewSurveyQuestion(@PathVariable String surveyId,
			@RequestBody Question question){		
		surveyService.addNewSurveyQuestion(surveyId,question);	
		
		
		 
	}

}
