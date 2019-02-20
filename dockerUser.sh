#Build User Container
cd WarnIt-User/
mvn clean install
sudo docker build -t warnit-user-app .
sudo docker run -p 8200:8200 warnit-user-app --network warnitnetwork --name user-service
#docker service create --replicas 1 --name user-service  --reserve-memory=100Mb --publish 8200:8200 --update-delay 10s  --network warnitnetwork warnit-user-app

