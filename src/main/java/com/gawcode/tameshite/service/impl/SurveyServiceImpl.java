package com.gawcode.tameshite.service.impl;

import com.gawcode.tameshite.model.Survey;
import com.gawcode.tameshite.repository.SurveyRepository;
import com.gawcode.tameshite.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@CacheConfig(cacheNames = "surveys")
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    @Cacheable(key = "#surveyId")
    public Optional<Survey> find(long surveyId) {
        return Optional.ofNullable(this.surveyRepository.findSurveyById(surveyId));
    }

    @Override
    @CachePut(key = "#survey.id")
    public void save(Survey survey) {
        this.surveyRepository.save(survey);
    }

    @Override
    @Async
    public CompletableFuture<Survey> saveAsync(Survey survey) {
        this.save(survey);
        return CompletableFuture.completedFuture(survey);
    }
}
