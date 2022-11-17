# Introduction
(50-100 words)
What does this app do? What technoglies you have used? (e.g. Twitter REST API, HTTP client, mvn, Java libs, docker etc..)

This Twitter Crud application makes calls to the official Twitter API to post, find and delete tweets. Technologies used are the Twitter REST API to make api calls, HTTP client, maven, Java and docker. Implemented Data Access Object (DAO) pattern. The Twitter DAO and HttpHelper is seperated from the business logic of the app, and is where the API calls and API URL strings are formed with the help of the OAuthConsumer and HttpHelper libraries. 

# Quick Start
- how to package your app using mvn?
  -- mvn clean package
- how to run your app with docker?
   - created dockerfile, build image from docker file and finally run the app on docker:
   - docker pull carlagcasta/twitter
   - docker run --rm \
 ${docker_user}/twitter post|show|delete [options]

# Design
## UML diagram
![image](../assets/SpringBoot.JPG)
spring dependencies diagram

## explain each component(app/main, controller, service, DAO) (30-50 words each)
- App/main
  - created a class called TwitterCLIAppSpringBoot that has the annotation @SpringBootApplication on top of it and in the constructor the TwitterCLIApp is passed to the constructor as the app which is then run in the main function.
  
- Controller
  - the controller layer handles the user input and checks that the correct input is passed when the service layer is called.
  
- Service
  - The service layer handles the business logic to check the user input has the correct number of argument and that if a tweet is being posted it doesnt not exceeed 140 characters. Once all requirements are met, DAO layer is called to interect directly with the Twitter REST API, with the help of the httpHelper.

- DAO
  - The twitter DAO layer handles data from an extrernal storage in this case the twitter REST API, and does not have to worry about the business logic whcih is handled by the Service layer which called the DAO. the TwitterHtpHelper is responsible for executing the HTTP with a given URL and authorizes the HTTP requests with twitter secrets.

## Models
Talk about tweet model
* the tweet model includes different classes which encapsulate Tweet data such as Coordinates, Entities, Hashtag, UserMention and lastly the Tweet model itself which contains all these models. these models are classes with private vairables and public getters and setters which are then used to be displayed in JSON format.

## Spring
- How you managed the dependencies using Spring?
  - using the 
  
# Test
How did you test you app using Junit and mockito?

## Deployment
How did you dockerize your app.

# Improvements
- improvements
