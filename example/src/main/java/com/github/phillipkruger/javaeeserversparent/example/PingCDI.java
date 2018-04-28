package com.github.phillipkruger.javaeeserversparent.example;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * Testing CDI and MicroProfile Config 
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Dependent
public class PingCDI {
    
    @Getter
    @Inject
    @ConfigProperty(name = "ping", defaultValue = "pong")
    private String ping;
    
}
