package com.gawcode.tameshite.repository;

import com.gawcode.tameshite.model.Application;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
    Application findApplicationById(long applicationId);

    List<Application> findApplicationsBySurveyId(long surveyId);
}
