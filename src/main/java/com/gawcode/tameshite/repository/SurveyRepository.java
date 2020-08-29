package com.gawcode.tameshite.repository;

import com.gawcode.tameshite.model.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
    public Survey findSurveyById(long surveyId);
}
