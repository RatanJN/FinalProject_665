
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Ratan Jagath Naik          |
| Date         | 04/23/2024                 |
| Course       | Spring 2024                |
| Final Project (Chat Room Manager)         |

# Assignment Overview

The chat application project integrates a suite of design patterns to construct a sophisticated messaging system. The Singleton pattern centralizes control in the ChatManager class, guaranteeing a single global instance that manages chat rooms. The Observer pattern is pivotal for real-time interaction, allowing chat room participants to receive instant message updates. For additional functionality not addressed in class, the Callback pattern is employed to invoke specific functions when messages arrive, and the Delegation pattern delegates tasks like message formatting or command execution to auxiliary objects, thereby enhancing modularity and separation of concerns.

In practical use, the application facilitates the creation of chat rooms, user registration, and live messaging between clients. It exemplifies a robust software design, effectively addressing the needs of a real-time communication platform. Users can seamlessly join chat rooms, send messages, and get notified of new messages through a user-friendly interface. The combination of these design patterns not only fulfills the technical requirements but also demonstrates a strategic approach to software architecture, resulting in a flexible and maintainable system.

# GitHub Repository Link:
https://github.com/RatanJN/FinalProject_665.git

# Implementation Description 


For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.

The chat application is designed with flexibility in mind, leveraging the Delegation and Strategy patterns which allow for easy expansion or modification. New object types, such as different message formats or handling strategies, can be introduced without altering the core application logic. This is achieved by abstracting functionalities into interfaces and using concrete implementations that can be interchanged as needed. For example, adding a new message type is as simple as creating a new class that implements the MessageHandler interface. This design enables future enhancements and integrations with minimal changes to the existing codebase.

- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.

The implementation is kept straightforward and intuitive by adhering to the Single Responsibility Principle, ensuring that each class has a clear purpose. Clear naming conventions and a consistent coding style contribute to the code's readability. The use of well-known design patterns provides a familiar structure that other developers can quickly grasp. Each class and method is accompanied by concise comments that explain their functionality, which facilitates ease of maintenance and encourages best practices for software development.

- Describe how you have avoided duplicated code and why it is important.

Duplicated code is minimized through the use of abstract classes and interfaces which promote code reuse. For instance, common behaviors are encapsulated within base classes or through shared interfaces, allowing different parts of the application to utilize the same underlying logic without redundancy. Avoiding duplicate code is crucial as it reduces the potential for bugs and decreases the maintenance overhead. When a change is necessary, it can be made in a single location, ensuring consistency and reliability across the application.

- If applicable, mention any design patterns you have used and explain why they were
chosen.

Several design patterns were strategically chosen for this project. The Singleton pattern ensures a single instance of the ChatManager, centralizing the management of chat rooms. The Observer pattern facilitates the notification process to users when messages are broadcasted, promoting loose coupling between the subject and observers. The Callback pattern provides a flexible way to handle incoming messages, allowing for different responses. Lastly, the Delegation pattern is used to offload responsibilities to specialized handlers, making the system more adaptable to change. These patterns were selected based on their ability to provide a clean, modular structure while addressing specific challenges in the chat application's design.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




