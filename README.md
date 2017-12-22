# Java EE parent project

Make this you parent project to get Java EE Application server build options in maven profiles.

    <parent>
        <groupId>com.github.phillip-kruger</groupId>
        <artifactId>javaee-servers-parent</artifactId>
        <version>javaee-7-v1</version>
    </parent>

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

### Options

*  `mvn clean install -P openliberty-fatjar`
*  `mvn clean install -P openliberty-start`
*  `mvn clean install -P openliberty-deploy`
*  `mvn clean install -P openliberty-stop`
*  `mvn clean install -P openliberty-package`

## Wildfly swarm

### Config

You can add the server config file in `src/main/wildfly-swarm/config/standalone.xml`

#### Example config

    <?xml version="1.0" encoding="UTF-8"?>
    <server xmlns="urn:jboss:domain:4.0">
        <profile>
            <subsystem xmlns="urn:jboss:domain:logging:3.0">
                <logger category="${log.name}">
                    <level name="${log.level}"/>
                </logger>
            </subsystem>
        </profile>
    </server>

### Options

*  `mvn clean install -P wildflyswarm-fatjar`
*  `mvn clean install -P wildflyswarm-start`
*  `mvn clean install -P wildflyswarm-deploy`
*  `mvn clean install -P wildflyswarm-stop`
*  `mvn clean install -P wildflyswarm-package`