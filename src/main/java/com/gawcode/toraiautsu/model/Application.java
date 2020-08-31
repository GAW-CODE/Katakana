package com.gawcode.toraiautsu.model;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Document("applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private JsonObject content;

    @DBRef
    private Survey survey;
}
