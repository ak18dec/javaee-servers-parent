package com.github.phillipkruger.javaeeserversparent.example;

import javax.enterprise.context.RequestScoped;
import lombok.Getter;

/**
 * Testing CDI
 * @author Phillip
 */
@RequestScoped
public class PingCDI {
        
    @Getter
    private final String ping = "pong";
}
