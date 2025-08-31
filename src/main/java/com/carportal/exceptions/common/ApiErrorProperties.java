package com.carportal.exceptions.common;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Value
@ConfigurationProperties(prefix = "carportal.api.error")
public class ApiErrorProperties {

  String format; // apierror | problemjson

}
