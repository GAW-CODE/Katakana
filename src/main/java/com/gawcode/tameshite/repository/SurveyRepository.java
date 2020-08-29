package com.gawcode.tameshite.repository;

import com.gawcode.tameshite.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey, Long> {
    public Survey findSurveyById(long surveyId);
}
