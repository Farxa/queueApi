# Spring Boot Application with PostgreSQL and Docker

This project demonstrates a simple CRUD API using Spring Boot, PostgreSQL, and Docker.

## Project Structure

- **src/**: Source code for the Spring Boot application.
- **Dockerfile**: Instructions for building the Docker image for the application.
- **docker-compose.yml**: Configuration to run the Spring Boot application and PostgreSQL database as Docker services.
- **pom.xml**: Maven build file with project dependencies.

## Getting Started

### 1. Clone the Repository

### 2. Build the Docker Images

docker-compose build

### 3. Start the Services

docker-compose up

To run in detached mode:

docker-compose up -d

### 4. Running the Application

Once the services are up, your Spring Boot application is accessible at `http://localhost:8080`.

You can interact with the API using tools like Postman or curl. Here are some examples of operations you can perform:

- **Create Queue**: Sends a POST request to create a new queue.
- **Get All Queues**: Sends a GET request to retrieve all queues.
- **Get Queue by ID**: Sends a GET request to retrieve a queue by its ID.
- **Update Queue**: Sends a PUT request to update an existing queue.
- **Delete Queue**: Sends a DELETE request to remove a queue.

Example using curl to create a new queue:

curl -X POST http://localhost:8080/api/queues -H 'Content-Type: application/json' -d '{"name": "New Queue", "owner": "Owner Name"}'

### 5. Testing the API

For detailed API endpoints and examples, refer to the [API Documentation](#).

### 6. Stopping the Services

To stop and remove the containers, networks, and volumes:

docker-compose down

## License

This project is licensed under the MIT License - see the LICENSE file for details.
