package com.github.phillipkruger.javaeeserversparent.example;

import javax.ejb.Stateless;
import lombok.Getter;

/**
 * Testing CDI
 * @author Phillip
 */
@Stateless
public class PingEJB {
        
    @Getter
    private final String ping = "pong";
}
