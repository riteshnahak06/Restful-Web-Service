package com.pralashgroup.restfulwebservicespart1.withOutJPA.socialmedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    @Size(min = 2,message = "Size should be at least 2 character")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birthdate should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;


}
