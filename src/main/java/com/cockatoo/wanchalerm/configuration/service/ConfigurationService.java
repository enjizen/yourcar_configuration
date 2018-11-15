package com.cockatoo.wanchalerm.configuration.service;

import com.cockatoo.wanchalerm.configuration.model.PropertiesEntity;
import com.cockatoo.wanchalerm.configuration.repository.PropertiesRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ConfigurationService {

    @Autowired
    private PropertiesRepository propertiesRepository;

    public List<PropertiesEntity> getProperties(String application, String profile){
        log.info("Get properties by [{}] application and [{}] profile", application, profile);
        List<PropertiesEntity> propertiesEntityList = propertiesRepository.findByApplicationAndProfile(application, profile);
        log.info("End get properties");
        return propertiesEntityList;
    }

}
