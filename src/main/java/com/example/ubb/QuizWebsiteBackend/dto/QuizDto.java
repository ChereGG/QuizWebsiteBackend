package com.example.ubb.QuizWebsiteBackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "theory")
    private String theory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }
}
