package com.gawcode.toraiautsu.service;

import com.gawcode.toraiautsu.model.Application;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ApplicationService {
    Optional<Application> find(long applicationId);

    Optional<List<Application>> findBySurveyId(long surveyId);

    void save(Application application);

    CompletableFuture<Application> saveAsync(Application application);
}
