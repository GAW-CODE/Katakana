package com.gawcode.tameshite.service;

import com.gawcode.tameshite.model.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Optional<Application> find(long applicationId);

    Optional<List<Application>> findBySurveyId(long surveyId);
}
