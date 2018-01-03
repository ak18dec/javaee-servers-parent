package com.github.phillipkruger.javaeeserversparent.example;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.extern.java.Log;

@Log
@Path("/")
@Produces(MediaType.TEXT_PLAIN) @Consumes(MediaType.TEXT_PLAIN)
public class PingApi {
    
    @EJB
    private PingEJB pingEJB;
    
    @Inject
    private PingCDI pingCDI;
    
    @GET
    @Path("/ping")
    @Consumes(MediaType.TEXT_PLAIN)
    public String ping() {
        try(StringWriter sw = new StringWriter()){
            
            sw.write("JAX-RS Ping [pong]\n");
            
            String ejbping = pingEJB.getPing();
            sw.write("EJB Ping [" + ejbping + "]\n");
        
            String cdiping = pingCDI.getPing();
            sw.write("CDI Ping [" + cdiping + "]\n");
            
            String response = sw.toString();
            log.log(Level.SEVERE, ASCII_ART + "{0}", response);
            return response;   
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
 
    
    private static final String ASCII_ART = "\n\n" + 
"     ██╗ █████╗ ██╗   ██╗ █████╗ ███████╗███████╗\n" +
"     ██║██╔══██╗██║   ██║██╔══██╗██╔════╝██╔════╝\n" +
"     ██║███████║██║   ██║███████║█████╗  █████╗  \n" +
"██   ██║██╔══██║╚██╗ ██╔╝██╔══██║██╔══╝  ██╔══╝  \n" +
"╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║███████╗███████╗\n" +
" ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝╚══════╝\n" +
"                                                 \n" +
"\n";
    
}