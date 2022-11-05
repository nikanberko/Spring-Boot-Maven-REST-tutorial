package com.springboot_maven_tutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

@Data
public class UpdateUserDto {

    @JsonProperty("first_Name")
    private Optional<String> optionalFirstName = Optional.empty();

    @JsonProperty("last_Name")
    private Optional<String> optionalLastName = Optional.empty();

    @JsonProperty("email")
    private Optional<String> optionalEmail = Optional.empty();

    @JsonProperty("phone")
    private Optional<String> optionalPhone = Optional.empty();


}
