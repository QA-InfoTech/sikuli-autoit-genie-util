## Cross-Platform Utility for AutoIt, Genie, Sikuli
 
The objective of developing this project is to handle windows native events, flash components using client-server request and response over http protocol. The project is divided into two parts:

(1) AutoITExecutor--It is client java application for handling native windows events as well as flash automation. I reside in com.jetty.autoit.client package of AutoITClientServer project.It is a public concrete class. In its constructor, the dll path is get set depends on the OS architecture (32 or 64 bit) type.

(2) JettyRunServer--It is server java application for handling native windows events as well as flash automation through http request and response.


#### Supported Platforms
* Windows
* Linux
* Mac OS

#### Requirements
Your environment needs to be setup for the particular platforms that you want to run tests on. See below for particular platform requirements.

###### Quick Start utility as server - Windows, Linux & Mac OS

* Install jdk 1.7 or greater
* Set JAVA_HOME environement variable
* Kick up sikuli-autoit-genie-util server, and then run a test written in your favorite language! 
```javascript
java -jar sikuli-autoit-genie-util.jar
```
in cmd server started successfully at 8080 message appear.

To run server on different port, type this command
```javascript
java -jar sikuli-autoit-genie-util.jar localhost <port number>
```

###### Quick Start utility as client (for java only) - Windows, Linux & Mac OS

* Install jdk 1.7 or greater
* Set JAVA_HOME environement variable
* Add sikuli-autoit-genie-util.jar to build path of your eclipse/maven projects, and then run a test written in java! 


#### How to write tests
###### Example to initialize utility class (Server):
* Java
```javascript
AutoITServer server=AutoITServer.getJettyServerInstance("127.0.0.1","port");
server.autoItExecutor.sendKeys("native window title", "native window text", "native window controlID","abc"); //send keys to native window element
```

###### Example to initialize utility class (Client):
* Java
```javascript
AutoITClient client=new AutoITClient();
client.sendKeys("native window title", "native window text", "native window controlID","abc"); //send keys to native window element
```

This repository contains many [examples of tests in a variety of different languages](https://github.com/QA-InfoTech/sikuli-autoit-genie-util/tree/master/sample-code)

#### Implemented Methods

###### public Class AutoITClient

     Description: It is a client class that handles native element actions.

     Field Summary:
           autoItX : variable declaration of AutoITX class

     Constructor:
           AutoITClient : initialize the suitable(based on Architecture of OS(x64/x86)) DLL for windows machine and intialize autoItX

     Methods:
           sendKeys : send characters/string to native element.
           Paramaters :
               title : String --> title of native element
               text : String --> text of native element
               controlID : String --> controlID of native element
               value : String --> value/text you want to send to native element

           click  : click on native element
           Parameters :
               title : String --> title of native element
               text : String --> text of native element
               controlID : String --> controlID of native element

           isDisplayed : checks the visibility of native element
           Parameters :
               title : String --> title of native element
               text : String --> text of native element

           implicitWait : implicitly wait for native element to exist for defined time.
           Parameters :
               title : String --> title of native element
               text : String --> text of native element
               timeOut : int --> timeOut of native element

           setKeyDelay : delay the input of keys into native element
           Parameters :
               timeOut : long --> timeOut of native element

           explicitWait : explicitly wait for native element to defined time.
           Parameters :
               timeOut : int --> timeOut of instruction
##### public class AutoITServer

     Description: It is a server class that handles the HTTP GET request and on the bases of request call the functions.

     Parent Class: AbstractHandler


     Field Summary:
           jettyServer: variable declaration of AutoITX class
           autoITExecutor : variable declaration of AutoITClient class 

     Constructor:
           AutoITServer: initialize autoITExecutor & initialize jetty server on the basis of below arguments and start the jetty server.
           Parameters :
             vars : String[] --> takes command line arguments like host address & port number.   

     Methods:
           getJettyServerInstance: return the singleton instance of JettyServer.
           Paramaters :
           Parameters :
             vars : String[] --> takes command line arguments like host address & port number.   


           handle : handle the http request and response and call functions on the basis of http quesry String. 
           Parameters :
               title : String --> The target of the request - either a URI or a name
               request : Request--> The original unwrapped request object
               httpRequest : HttpServletRequest--> The HttpRequest either as the object or a wrapper of that request.
               httpResponse : HttpServletResponse --> The response object which will return response user need.