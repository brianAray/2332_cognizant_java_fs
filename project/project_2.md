# Project 2

This is a continuation of project 1, where you will be converting your monolith application into microservices and deploying it to the cloud. This will be your final presentation and will need to be presented to the client.

- Due date: 2/20/26

- Technology Requirements:
	- Version Control: Git
	- Frontend: Angular or React
	- Backend: Spring Boot
	- Authentication: JWT
	- Database: PostgreSQL or MongoDB
	- Testing:
		- API: Postman
        - Load: Jmeter
		- Unit: JUnit5 and Mockito
		- Frontend: Jasmine and Karma / React Testing Library and Jest
    - Microservices:
        - Spring Cloud Project
        - API Gateway
        - Discovery Client
        - Optional
            - Load balanced EC2 for scalability
    - DevOps:
        - Jenkins
        - EC2
        - S3
        - Docker
    - Optional
        - ELK monitoring
        - AI Features
- Project Requirements:
    - Application must be converted to microservices based on features
    - Each microservice must have their own database
    - Each microservice must be deployed to their own EC2 instance as a dockerized container
    - Automated Deployment to the cloud must be done through Jenkins
    - The frontend must be served as a static application on an S3 bucket