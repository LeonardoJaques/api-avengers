#!/bin/bash

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev -Dspring-boot.run.jvmArguments="-Xmx256m -Xms128m" -Dspring-boot.run.arguments="'--DB_USER=leo.avenger' '--DB_PASSWORD=leo.avenger' '--DB_NAME=avengers'"