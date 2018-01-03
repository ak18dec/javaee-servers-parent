# Java EE parent project

Build status: [![build_status](https://travis-ci.org/phillip-kruger/javaee-servers-parent.svg?branch=master)](https://travis-ci.org/phillip-kruger/javaee-servers-parent)

Make this you parent project to get Java EE Application server build options in maven profiles.

    <parent>
        <groupId>com.github.phillip-kruger</groupId>
        <artifactId>javaee-servers-parent</artifactId>
        <version>javaee-7-v2</version>
    </parent>

You can change some properties, example:

    <properties>    
        <http.port>8081</http.port>
        <https.port>8444</https.port>
    </properties>

## OpenLiberty

### Config

You can add the server config file in `src/main/openliberty/config/server.xml`

#### Example config

    <?xml version="1.0" encoding="UTF-8"?>
    <server description="${project.build.finalName}">

        <!-- Enable features -->
        <featureManager>
            <feature>javaee-7.0</feature>
            <feature>microProfile-1.2</feature>
        </featureManager>

        <!-- To access this server from a remote client add a host attribute to the following element, e.g. host="*" -->

        <httpEndpoint id="defaultHttpEndpoint"
            httpPort="${httpPort}"
            httpsPort="${httpsPort}"/>

        <!-- Automatically expand WAR files and EAR files -->
        <applicationManager autoExpand="true" />

        <application location="${project.build.directory}/${project.build.finalName}.war"/>

        <logging traceSpecification="${log.name}.*=${log.level}"/>

    </server>

### Log file

If you use the `start` rather than `run` the logfile is available at:

`/tmp/${project.artifactId}/openliberty/wlp/usr/servers/defaultServer/logs/trace.log`

### Options

*       `mvn clean install -P openliberty-run`
*       `mvn clean install -P openliberty-start`
*       `mvn clean install -P openliberty-deploy`
*       `mvn clean install -P openliberty-stop`
*       `mvn clean install -P openliberty-package`
*       `mvn clean install -P openliberty-log`

## Wildfly swarm

### Config

You can add the server config file in `src/main/wildfly-swarm/config/standalone.xml`

#### Example config

    <?xml version="1.0" encoding="UTF-8"?>
    <server xmlns="urn:jboss:domain:4.0">
        <profile>
            <subsystem xmlns="urn:jboss:domain:logging:3.0">
                <periodic-rotating-file-handler name="FILE" autoflush="true">
                    <file path="${wildfly-swarm.logfile}"/>
                    <suffix value=".yyyy-MM-dd"/>
                    <append value="true"/>
                </periodic-rotating-file-handler>
                <root-logger>
                    <level name="INFO"/>
                    <handlers>
                        <handler name="FILE"/>
                    </handlers>
                </root-logger>
                <logger category="${log.name}">
                    <level name="${log.level}"/>
                </logger>
            </subsystem>
        </profile>
    </server>

### Log file

If you use the `start` rather than `run` the logfile is available at:

`/tmp/${project.artifactId}/wildfly-swarm/logs/server.log`

### Options

*       `mvn clean install -P wildflyswarm-run`
*       `mvn clean install -P wildflyswarm-start`
*       `mvn clean install -P wildflyswarm-deploy`
*       `mvn clean install -P wildflyswarm-stop`
*       `mvn clean install -P wildflyswarm-package`
*       `mvn clean install -P wildflyswarm-log`