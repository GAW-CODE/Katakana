package com.gawcode.tameshite.model;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Setter
    private JsonObject content;

    private List<Application> applications;

    public void addApplication(Application application) {
        this.applications.add(application);
    }
}
