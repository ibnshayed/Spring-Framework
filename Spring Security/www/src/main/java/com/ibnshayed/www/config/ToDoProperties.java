package com.ibnshayed.www.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "todo.authentication")
public class ToDoProperties {

    private String findByEmailUri;
    private String userName;
    private String password;
}
