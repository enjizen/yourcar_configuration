package com.cockatoo.wanchalerm.configuration.repository;

import com.cockatoo.wanchalerm.configuration.model.PropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<PropertiesEntity, Integer> {

    List<PropertiesEntity> findByApplicationAndProfile(String application, String profile);

}
