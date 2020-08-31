package com.gawcode.toraiautsu.service.impl;

import com.gawcode.toraiautsu.model.Application;
import com.gawcode.toraiautsu.repository.ApplicationRepository;
import com.gawcode.toraiautsu.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@CacheConfig(cacheNames = "applications")
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    @Cacheable(key = "#applicationId")
    public Optional<Application> find(long applicationId) {
        return Optional.ofNullable(this.applicationRepository.findApplicationById(applicationId));
    }

    @Override
    public Optional<List<Application>> findBySurveyId(long surveyId) {
        return Optional.ofNullable(this.applicationRepository.findApplicationsBySurveyId(surveyId));
    }

    @Override
    @CachePut(key = "#application.id")
    public void save(Application application) {
        this.applicationRepository.save(application);
    }

    @Override
    @Async
    public CompletableFuture<Application> saveAsync(Application application) {
        this.save(application);
        return CompletableFuture.completedFuture(application);
    }
}
