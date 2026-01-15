# Docker Commands

### Run Docker Compose
- `docker-compose up`

### Enter into Kafka Container
- `docker exec -it kafka bash`

### Create Kafka Topic
- `kafka-topics --create --topic example --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1`

### List Kafka Topics
- `kafka-topics --list --bootstrap-server localhost:9092`

### Console Producer
- `kafka-console-producer --topic example --bootstrap-server localhost:9092`

### Console Consumer
- `kafka-console-consumer --topic orders --group order-processors --bootstrap-server localhost:9092`

