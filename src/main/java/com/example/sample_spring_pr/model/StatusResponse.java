package com.example.sample_spring_pr.model;

import lombok.Data;

@Data
public class StatusResponse {
    private boolean success = true;
    private String error = "";

}
