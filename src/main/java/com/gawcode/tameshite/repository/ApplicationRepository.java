package com.gawcode.tameshite.repository;

import com.gawcode.tameshite.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, Long> {
    Application findApplicationById(long applicationId);

    List<Application> findApplicationsBySurveyId(long surveyId);
}
