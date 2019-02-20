#Build Eureka Container
cd WarnIt-Eureka/
mvn clean install
sudo docker build -t warnit-eureka-app .
sudo docker run -p 8761:8761 warnit-eureka-app --network warnitnetwork --name eureka-service
#sudo docker service create --replicas 1 --name eureka-service --reserve-memory=100Mb --publish 8761:8761 --update-delay 10s -e spring_application_name=eureka-service --constraint 'node.role == manager' warnit-eureka-app --network warnitnetwork
