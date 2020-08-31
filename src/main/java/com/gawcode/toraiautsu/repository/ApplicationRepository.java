package com.gawcode.toraiautsu.repository;

import com.gawcode.toraiautsu.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, Long> {
    Application findApplicationById(long applicationId);

    List<Application> findApplicationsBySurveyId(long surveyId);
}
