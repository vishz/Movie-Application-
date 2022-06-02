package com.example.crudApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailDto {
    private Long id;
    private String movieName;
    private String description;
    private String producer;
}
