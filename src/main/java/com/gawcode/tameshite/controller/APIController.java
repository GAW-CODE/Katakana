package com.gawcode.tameshite.controller;

import com.gawcode.tameshite.constant.ResponseConstant;
import com.gawcode.tameshite.model.Application;
import com.gawcode.tameshite.model.Survey;
import com.gawcode.tameshite.service.ApplicationService;
import com.gawcode.tameshite.service.SurveyService;
import com.gawcode.tameshite.util.Snowflake;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/")
@Validated
public class APIController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/survey/{id}")
    public ResponseEntity<JsonObject> getSurvey(@Validated @PathVariable("id") long surveyId) {
        Survey survey = this.surveyService.find(surveyId).orElse(null);

        if (survey == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseConstant.SURVEY_NOT_FOUND);

        return ResponseEntity.ok(survey.getContent());
    }

    @PatchMapping("/survey/{id}")
    public ResponseEntity<JsonObject> patchSurvey(@Validated @PathVariable("id") long surveyId, @Validated @RequestBody JsonObject patchObject) {
        Survey survey = this.surveyService.find(surveyId).orElse(null);

        if (survey == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseConstant.SURVEY_NOT_FOUND);

        survey.setContent(patchObject);
        return ResponseEntity.ok(ResponseConstant.SURVEY_MODIFIED);
    }

    @PostMapping("/action/survey/create")
    public ResponseEntity<JsonObject> createSurvey(@RequestParam("name") @Validated String name, @Validated @RequestBody JsonObject surveyContent) {
        long surveyId = Snowflake.INSTANCE.nextId();

        Survey survey = this.surveyService.find(surveyId).orElse(null);

        while (survey != null) {
            surveyId = Snowflake.INSTANCE.nextId();
            survey = this.surveyService.find(surveyId).orElse(null);
        }

        this.surveyService
                .saveAsync(new Survey(surveyId, name, surveyContent))
                .join();

        return ResponseEntity.ok(ResponseConstant.SURVEY_CREATED);
    }

    @PostMapping("/action/application/submit/{id}")
    public ResponseEntity<JsonObject> submitApplication(@PathVariable("id") @Validated long surveyId, @Validated @RequestBody JsonObject applicationContent) {
        long applicationId = Snowflake.INSTANCE.nextId();

        Survey survey = this.surveyService.find(surveyId).orElse(null);

        if (survey == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseConstant.SURVEY_NOT_FOUND);

        Application application = this.applicationService.find(applicationId).orElse(null);
        while (application != null) {
            applicationId = Snowflake.INSTANCE.nextId();
            application = this.applicationService.find(applicationId).orElse(null);
        }

        this.applicationService
                .saveAsync(new Application(applicationId, applicationContent, survey))
                .join();

        return ResponseEntity.ok(ResponseConstant.APPLICATION_SUBMITTED);
    }
}
