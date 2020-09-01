#!/bin/bash
mvn clean install
docker build -t mobile-online-store .
docker run -p 8080:8080 mobile-online-store
