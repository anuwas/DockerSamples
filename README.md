# DockerSamples

#Build the image with image tag versionone

sudo docker build -t springboot-docker-demo:versionone .

#Run the image in container. 
#Image is running in docker container in 8080 port, but we want to map 8080 port with docker host 8081 port, this is why port mapping has been done

sudo docker run -p 8081:8080 springboot-docker-demo:versionone
