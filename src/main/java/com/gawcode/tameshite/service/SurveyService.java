package com.gawcode.tameshite.service;

import com.gawcode.tameshite.model.Survey;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface SurveyService {
    Optional<Survey> find(long surveyId);

    void save(Survey survey);

    CompletableFuture<Survey> saveAsync(Survey survey);
}
