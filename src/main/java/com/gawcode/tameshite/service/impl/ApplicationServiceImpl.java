package com.gawcode.tameshite.service.impl;

import com.gawcode.tameshite.model.Application;
import com.gawcode.tameshite.repository.ApplicationRepository;
import com.gawcode.tameshite.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Optional<Application> find(long applicationId) {
        return Optional.ofNullable(this.applicationRepository.findApplicationById(applicationId));
    }

    @Override
    public Optional<List<Application>> findBySurveyId(long surveyId) {
        return Optional.ofNullable(this.applicationRepository.findApplicationsBySurveyId(surveyId));
    }
}
