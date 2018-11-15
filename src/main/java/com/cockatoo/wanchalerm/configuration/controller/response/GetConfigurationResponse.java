package com.cockatoo.wanchalerm.configuration.controller.response;


import lombok.Data;

import java.util.List;

@Data
public class GetConfigurationResponse {
    private String name;
    private List<String> profiles;
    private List<PropertySourceResponse> propertySources;
}
