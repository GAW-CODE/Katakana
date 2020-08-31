package com.gawcode.toraiautsu.repository;

import com.gawcode.toraiautsu.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey, Long> {
    public Survey findSurveyById(long surveyId);
}
