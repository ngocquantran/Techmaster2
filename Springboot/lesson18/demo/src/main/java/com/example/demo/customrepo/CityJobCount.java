package com.example.demo.customrepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityJobCount {
    private String city;
    private String job;
    private long count;
}
