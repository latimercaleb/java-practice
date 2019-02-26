# API notes
API is an application programming interface and is a part of a backend-server that sends responses and receives request
Responses are in the form of data most commonly JSON
Numerous types of API most popular are:
- SOAP: Simple Access Protocol - Encoding XML messages so that they can be received and understood by any operating system over any type of network protocol.
- RPC: Remote Procedure Call
- REST: Representational State Transfer

APIs can be public or privately available to handle this data transmission
Services or apps that consume APIs are called `API Integrations`

The goal of an API is to get data to the user `seamlessly` or without being noticed on the UI
A popular way of using API is in microservice architecture

## What are microservices?
Using APIs to scale applications rather than using a monolithic approach. Breaking the backend into serveral network based services that communicate via a restful API. It makes deployments easier due to making things more standalone.

Some difficulties of this are design of these services and their dependancies as well. Microservices are more modern but should not be used in everything. There are plenty of use cases that break the two categories apart.
