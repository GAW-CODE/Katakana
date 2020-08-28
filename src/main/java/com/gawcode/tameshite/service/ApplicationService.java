package com.gawcode.tameshite.service;

import com.gawcode.tameshite.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationService extends MongoRepository<Application, Long> {
    public Application findApplicationById(long applicationId);

    public List<Application> findApplicationsBySurveyId(long surveyId);
}
