package com.github.phillipkruger.javaeeserversparent.example;

import javax.ejb.Stateless;
import javax.inject.Inject;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * Testing CDI and MicroProfile Config
 * @author Phillip
 */
@Stateless
public class PingEJB {
    
    @Getter
    @Inject
    @ConfigProperty(name = "ping", defaultValue = "pong")
    private String ping;
}
