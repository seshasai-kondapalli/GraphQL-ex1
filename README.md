# GraphQL-ex1
Very begining basic level GraphQL with spring boot 

# Introducing GraphQL Spring Boot Starter <br/>

<b>The Spring Boot GraphQL Starter offers a fantastic way to get a GraphQL server running in a very short time. Combined with the GraphQL Java Tools library, we need only write the code necessary for our service.</b>

# prereqisites 
spring boot : v2.x <br/>
Postgresql: latest <br/>
java : 8 <br/>
maven : latest version <br/>
IDE : STS4 <br/>

# End point registration by spring for handling GraphQL querys and mutations

By default, this will expose the GraphQL Service on the /graphql endpoint of our application and will accept POST requests containing the GraphQL Payload. 
This endpoint can be customised in our application.properties file if necessary

# Writing the Schema

<b>The GraphQL Tools library works by processing GraphQL Schema files to build the correct structure and then wires special beans to this structure</b>. The Spring Boot GraphQL starter automatically finds these schema files.<br/>

Here I define a class with @configuration where I wire all the query resolvers and mutation in schema to spring context via @Bean

<b>These files need to be saved with the extension “.graphqls” and can be present anywhere on the classpath</b>. We can also have as many of these files as desired, so we can split the scheme up into modules as desired.

# Using Beans to Represent Types

Every complex type in the GraphQL server is represented by a Java bean 

# GraphiQL

GraphQL also has a companion tool called GraphiQL. This is a UI that is able to communicate with any GraphQL Server and execute queries and mutations against it
