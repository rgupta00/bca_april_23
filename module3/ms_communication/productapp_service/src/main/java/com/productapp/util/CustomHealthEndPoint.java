package com.productapp.util;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Endpoint(id="custom-health")
public class CustomHealthEndPoint {

    @ReadOperation
    public CustomHealth health() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("CustomHealthStatus", "Everything looks good");
        CustomHealth health = new CustomHealth();
        health.setHealthDetails(details);
        return health;
    }
}