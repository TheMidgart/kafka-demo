## Kafka application
Simple demo for exchange data via kafka uses stack Kotlin/Spring boot

Contains 3 applications : sender, receiver and model (source library for them) 

### To run applications neeed execute 4 steps
#### Step 1 Clone Repository and up docker-container

```
https://github.com/TheMidgart/kafka-demo.git
cd kafka-demo
docker-compose up
```
#### Step 2 Install models 

```
cd kafka-model
mvn clean install
```
#### Step 3 Run sender

```
cd ../kafka-sender
mvn spring-boot:run
```
#### Step 4 Run receiver
```
cd ../kafka-receiver
mvn spring-boot:run
```
#### Notices
To try application use Swagger on http://localhost:8083/swagger-ui/index.html

To monitor kafka use http://localhost:8080

To monitor database use http://localhost:5050 and credenttials for pg-admin in docker-compose.yml
