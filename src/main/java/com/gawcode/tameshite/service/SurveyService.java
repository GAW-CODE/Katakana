package com.gawcode.tameshite.service;

import com.gawcode.tameshite.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyService extends MongoRepository<Survey, Long> {
    public Survey findSurveyById(long surveyId);
}
