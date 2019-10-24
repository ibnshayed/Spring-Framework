package com.ibnshayed.www.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "todo.jms")
public class ToDoProperties {

    private String destination;

}