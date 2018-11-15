package com.cockatoo.wanchalerm.configuration.controller.response;

import lombok.Data;

import java.util.Map;

@Data
public class PropertySourceResponse {
    private String name;
    private Map<String, String> source;
}
