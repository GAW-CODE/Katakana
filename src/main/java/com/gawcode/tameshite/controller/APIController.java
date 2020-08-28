package com.gawcode.tameshite.controller;

import com.gawcode.tameshite.constant.ResponseConstant;
import com.gawcode.tameshite.model.Survey;
import com.gawcode.tameshite.service.SurveyService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class APIController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/survey/{id}")
    public ResponseEntity<JsonObject> getSurvey(@Validated @PathVariable("id") long surveyId) {
        Survey survey = this.surveyService.findSurveyById(surveyId);

        if (survey == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseConstant.SURVEY_NOT_FOUND);

        return ResponseEntity.ok(survey.getContent());
    }

    @PatchMapping("/survey/{id}")
    public ResponseEntity<JsonObject> patchSurvey(@Validated @PathVariable("id") long surveyId, @RequestBody JsonObject patchObject) {
        Survey survey = this.surveyService.findSurveyById(surveyId);

        if (survey == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseConstant.SURVEY_NOT_FOUND);

        survey.setContent(patchObject);
        return ResponseEntity.ok(ResponseConstant.SURVEY_MODIFIED);
    }
}
