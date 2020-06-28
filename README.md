# Eagle Messaging

This is a Spring Boot REST API written in Kotlin using Cassandra for persistence. 
The intended goal is to create a lightweight messaging application that will scale up as traffic increases, 
and scale out as deployment across multiple regions becomes a necessity.  

### Local running:
Cassandra will need to be up-and-running to start the application. A docker-compose file has been added to the project 
for ease of development. Simply run `docker-compose up -d cassandra` to start the cassandra container. Then run the 
MessagingApplication either from within your IDE or by manually compiling and running the JARs. 

#### Interacting with the Application
Once you have the application up and running, a message can be sent by invoking the POST endpoint at `/messages/send` with 
a message payload. An example of such a payload would be: 
```json
{
	"messageKey": {
		"senderId": 1,
		"recipientId": 42
	},
	"body": "i can haz cheezburger?"
}
```

To get the full conversation between two users, simply call the GET endpoint at `/messages/{userId1}/{userId2}` with 
two userIds. 


![EAGLEEEEEE!](https://media.tenor.com/images/3bc23e16364048e0447efcc261b2709e/tenor.gif)