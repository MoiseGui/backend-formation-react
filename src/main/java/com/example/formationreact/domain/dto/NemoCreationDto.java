package com.example.formationreact.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NemoCreationDto {
    private String firstName;
    private String lastName;
    private String email;
}

