package com.gawcode.tameshite.model;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@Document("surveys")
public class Survey {
    @Id
    private final long id;

    private String name;

    public Survey(long id, String name, JsonObject content) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.applications = new ArrayList<>();
    }

    @CreatedDate
    private Date createDate;

    private Date endDate;

    @Setter
    private JsonObject content;

    @DBRef
    private final List<Application> applications;

    public void addApplication(Application application) {
        this.applications.add(application);
    }
}
