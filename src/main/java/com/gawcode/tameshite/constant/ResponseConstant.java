package com.gawcode.tameshite.constant;

import com.google.gson.JsonObject;
import org.jglue.fluentjson.JsonBuilderFactory;

public class ResponseConstant {
    public static final JsonObject SURVEY_NOT_FOUND = JsonBuilderFactory
            .buildObject()
            .add("code", 404)
            .add("message", "Survey not found")
            .getJson();

    public static final JsonObject SURVEY_MODIFIED = JsonBuilderFactory
            .buildObject()
            .add("code", 404)
            .add("message", "Survey not found")
            .getJson();
}
