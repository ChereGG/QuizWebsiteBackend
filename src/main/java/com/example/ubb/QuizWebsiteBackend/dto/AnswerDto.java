package com.example.ubb.QuizWebsiteBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "statement")
    private String statement;

    @JsonProperty(value = "displayOrder")
    private Integer displayOrder;

    @JsonProperty(value = "isCorrect")
    private Boolean isCorrect;

    @JsonProperty(value = "questionId")
    private Long questionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
