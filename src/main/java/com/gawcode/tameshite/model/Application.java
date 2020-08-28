package com.gawcode.tameshite.model;

import com.google.gson.JsonObject;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private JsonObject content;
}
