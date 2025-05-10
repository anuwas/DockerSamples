# DockerSamples

# First PG DB docker Image launched in a container with a container name as "docpgdb" with port and db password

sudo docker run -d --name=docpgdb -p 5432:5432 -e POSTGRES_PASSWORD=mypgpass postgres 

# configure db connection properties with the pgdb container name. 

spring.datasource.url=jdbc:postgresql://docpgdb:5432/productdb

#Create DB. Oepn another terminal and execute the following command

psql -h localhost -U postgres 

CREATE DATABASE productdb; 

# Build the image with a tag here tag is versionone

sudo docker build -t spbootpgsql-docker:versionone .

# run the spring boot image with a link with "docpgdb" here "docpgdb" is the name of the pgdb container, so that this image can connect

sudo docker run --link docpgdb:docpgdb -p 8081:8080 spbootpgsql-docker:versionone 
