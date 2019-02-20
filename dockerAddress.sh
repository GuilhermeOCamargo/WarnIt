#Build User Container
cd WarnIt-Address/
mvn clean install
sudo docker build -t warnit-address-app .
sudo docker run -p 8100:8100 warnit-address-app --network warnitnetwork --name address-service

