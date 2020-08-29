package com.gawcode.tameshite.model;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@Document("surveys")
public class Survey {
    @Id
    private final long id;

    @Setter
    private JsonObject content;

    private final List<Application> applications;

    public void addApplication(Application application) {
        this.applications.add(application);
    }
}
