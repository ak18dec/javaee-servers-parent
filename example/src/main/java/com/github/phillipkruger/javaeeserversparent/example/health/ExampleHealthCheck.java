package com.github.phillipkruger.javaeeserversparent.example.health;

import com.github.phillipkruger.javaeeserversparent.example.PingCDI;
import com.github.phillipkruger.javaeeserversparent.example.PingEJB;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class ExampleHealthCheck implements HealthCheck {

    @EJB
    private PingEJB pingEJB;
    
    @Inject
    private PingCDI pingCDI;
    
    @Inject
    @ConfigProperty(name = "ping", defaultValue = "pong")
    private String ping;
    
   @Override
   public HealthCheckResponse call() {
        
        return HealthCheckResponse.named("ping check")
                .withData("ejb",pingEJB.getPing())
                .withData("cdi", pingCDI.getPing())
                .withData("config", ping)
                .up()
                .build();

   }
}
