package com.example.ubb.QuizWebsiteBackend.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "isAdmin")
    private Boolean isAdmin;

    @JsonProperty(value = "maxNumberOfChapters")
    private Integer  maxNumberOfChapters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getMaxNumberOfChapters() {
        return maxNumberOfChapters;
    }

    public void setMaxNumberOfChapters(Integer maxNumberOfChapters) {
        this.maxNumberOfChapters = maxNumberOfChapters;
    }
}
