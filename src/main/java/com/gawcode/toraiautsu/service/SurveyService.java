package com.gawcode.toraiautsu.service;

import com.gawcode.toraiautsu.model.Survey;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface SurveyService {
    Optional<Survey> find(long surveyId);

    void save(Survey survey);

    CompletableFuture<Survey> saveAsync(Survey survey);
}
