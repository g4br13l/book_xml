package com.gabriel.bookxml.models;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModel() {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setPreferNestedProperties(false);

        return mapper;
    }




}
