package com.tuempresa.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    // No necesita más código, Payara lo detectará automáticamente.
}
