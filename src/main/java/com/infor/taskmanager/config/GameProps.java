package com.infor.taskmanager.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "marie.lo")
@Setter
@Getter
public class GameProps {
    String a;
    String b;
}
