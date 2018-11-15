package com.cockatoo.wanchalerm.configuration.controller;

import com.cockatoo.wanchalerm.configuration.controller.response.GetConfigurationResponse;
import com.cockatoo.wanchalerm.configuration.controller.response.PropertySourceResponse;
import com.cockatoo.wanchalerm.configuration.model.PropertiesEntity;
import com.cockatoo.wanchalerm.configuration.service.ConfigurationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/{application}/{profile}")
    public ResponseEntity getConfiguration(@PathVariable("application") String application,
                                           @PathVariable("profile") String profile) {

        log.info("========== Start get configuration ==========");
        List<String> profiles = new ArrayList<>();
        profiles.add(profile);


        GetConfigurationResponse getConfigurationResponse = new GetConfigurationResponse();
        getConfigurationResponse.setName(application);
        getConfigurationResponse.setProfiles(profiles);

        Map<String, String> configurationMap = new HashMap<String, String>();

        List<PropertySourceResponse> propertySourceResponseList = new ArrayList<>();
        List<PropertiesEntity> propertiesEntityList = configurationService.getProperties(application, profile);
        propertiesEntityList.stream().forEach(propertiesEntity -> {
            configurationMap.put(propertiesEntity.getKey(), propertiesEntity.getValue());
        });

        PropertySourceResponse scopePropertySourceResponse = new PropertySourceResponse();
        scopePropertySourceResponse.setName(application + ".properties");
        scopePropertySourceResponse.setSource(configurationMap);
        propertySourceResponseList.add(scopePropertySourceResponse);
        getConfigurationResponse.setPropertySources(propertySourceResponseList);
        log.info("========== End get configuration ==========");
        return ResponseEntity.ok(getConfigurationResponse);
    }
}
