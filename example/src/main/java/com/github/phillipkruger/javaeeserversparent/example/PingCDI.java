package com.github.phillipkruger.javaeeserversparent.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * Testing CDI and MicroProfile Config 
 * @author Phillip
 */
@RequestScoped
public class PingCDI {
    
    @Getter
    @Inject
    @ConfigProperty(name = "ping", defaultValue = "pong")
    private String ping;
    
}
