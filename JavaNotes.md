# Java w/ Spring & Hibernate
Spring is a popular framework for building enterprise apps that was supposed to be the lightweight iteration of J2EE. J2EE introduced a feature called EJB (_Enterprise Java Beans_) which was notorious for being slow.

Spring first came out in 2004. And is viewed as a popular alternative to J2EE.

Spring 5 came out in 2017 and is dependant on Java 8.

A goal of spring is to make development easy with Java POJOs and use dependency injection. It also makes use of Aspect Oriented Programming.

Spring has Spring MVC for web development as well as several Spring-like projects for core Spring Framework modules

## Java 7 & Java 8
There are higher versions of the java language but 7 & 8 are the most popular. I'll be working on 8 primarily.
8 has some core features to be aware of:

- Functional Interfaces: In short interfaces with a single method:
```java
interface baz{
      void doThing(int foo, String bar){...}
}
```
- Lambda expressions: Annoymous single line functions to return values, similar to the arrow function in ES6
```java
(foo,bar) -> foo - bar;
```
Multiple lines can be wrapped in `{...}`
- :: for method refferences to methods that already have a name

## Setup
Need Java App Server (Tomcat) & Java IDE(eclipse)
- Spring needs Java 8 or higher
- Only JEE perspective has server window for tomcat integration
Download Apache Tomcat and check it at localhost 8080, Tomcat runs as a windows service so it can be checked and handled via service manager

With Eclipse, download it we want 64-bit `Eclipse IDE for Enterprise Java Developers `, main thing to look for is Java EE support, this is important because Eclipse has alot of distros and this one has native web app support.

Next connect tomcat (webserver) to eclipse(IDE) by adding it to `Servers` and pointing it to where you installed tomcat. This will make running and deploying to tomcat

## Spring Jar files
Spring has two popular build systems Gradle (also used in android) and Maven. A Jar file is similar to a zip but it usually contains compiled java code (*.class) or .java source code.

Spring has several (roughly 64) jar files that you should import into a lib folder added to the project. Importing files this way will require them to be added to the build path for eclipse do this by accessing `properties` on the root of the project then `Java Build Path` then `Add JARs` and add all the spring jars to the `ClassPath`.

When importing JARs this is the standard.

## Spring IoC
IoC means `Inversion of Control`. Basically Spring uses an object factory to outsource the construction and management of objects.
Can be found in app 1.

Pojo & packages are important concepts to understand for Spring development.

`Pojo` is  a plain old java object and it's an object that is not dependant on framework extensions or interfaces.
A pojo should not:
- Extend another Class
- Implement interfaces
- contain anotations

 A pojo in theory should directly wrap business logic and not contain any functions besides getters, setters & constructors.

 `Beans` are a subtype of pojo, not all Pojos are beans.
 But all beans are Pojos.
 A bean must:
 - Be serializable eg implement serializable interface
 - Have private fields
 - Each field should have getters and setters
 - The constructor should have no arguments
 - Fields should be accessed only by the constructor

`Packages` in java work like namespaces and contain sets of related classes and interfaces. They prevent name conflicts and make indexing better and are a first layer of data-abstraction. Packages can have subpackages and all packages are either user-defined or built in

## App 1 notes
In Eclipse always make package first then classes go in package
Spring has two main parts to it's container `Inversion of control` & `dependency injection`
The setup for this is done via configuration in xml, java annotations or java source
In a typical spring pipeline you make spring beans => generate a spring container => retrieve beans from container

## Beans
``` xml
<beans>
      <bean id="foo" class= "pkg"></bean>
</beans>
```
A bean is declared in a beans xml list with 2 properties:
- id: alias of bean
- class : full name of package + class

The id is used to retrieve or work with a bean, beans can have properties one of which is `singleton` which can be false or true to enable multiple instances or a single instance of said bean. By default a bean is a singleton. Only one instance in the container at a time. Can specify scope by, `scope="singleton"`, some other scopes are:
- prototype: New bean per every request
- request: scope to an http web request(web app only)
- session: scope to an http web session (web app only)
- global-session:  scope to global http web session (web app only)


## Spring Container
Also known as `ApplicationContext` has two parts, first declare it's instance and pass in the config xml. Then extract beans by id and interface or class name.

You instantiate a container by `ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");`

In order to configure a spring container there are 3 ways:
- Configuration via xml
- Configuration via component scan + Annotations
- Java Configuration class

## Dependency Injection
`Dependency Inversion Principal` client delegates calls to another object and that object is responsible for getting the client it's dependencies.

Dependencies can be thought of as `helper methods or values` that a bean needs to function.

App 1- Extension, Fortune Service

There are three types of injection: `Constructor`, `Setter` and `Direct` injection, these can be auto-wired via annotations.
To implement Constructor Injection do the following:
- Define Interface and class of dependency
- Generate constructor that consumes the dependency within class that is using dependency
- Define dependency in app-context then use constructor injection to beans that use dependency: `<constructor-arg ref="id name of bean"/>`

For Setter Injection do the following:
- Simply add some setter methods for the dependency in the class
- Inject via setter injection in applicationContext with `<property name ="name of set method" ref="service bean id"/>`

The `name...` property will be fetched by IoC and changed to `setName...` prefixing set and uppercasing the first letter, an error will be thrown if it cannot find a set method that matches.

 For Literal Injection do the following:
 - Create a setter method for your injection for private fields
 - Add configuration in context with `<property name ="name of set method" value="literal value to have in code"/>`

 Note `val="..."` must be a literal and `ref="..."` must be a bean ID.

 Values can also be added via an `external property file` which would need to be loaded into the spring config file.

 File must be `.properties` and follow the pattern of `var.propName=value` var can be anything but the `propName` must be consistent with the spring file.

 To load the prop file into spring you'll need to add:
 `<context:property-placeholder location="classpath:fileName.properties" />`

 And in the context to access the values use: `val="${var.propName}"`

## Bean LifeCycle & Scope
If `scope="prototype"` is not used then different instantiations of an object are just refferences to the same object. Polymorphic in a sense.
If it is used each instantiation is it's own with it's own memory.

Bean LifeCycle:
``` javascript
Container Built =>Bean instance generated =>Depenencies are injected => Spring processes internally =>Your custom init method gets called =>Bean is ready for use => Container is closed (custom destroy method can be invoked) and bean is destroyed
```

Custom code can occur during bean initialization and destruction by using lifecycle hooks

For custom initialization it's done via app context with : `init-method="someMethodName"`

For custom destruction it's done via app context with : `destroy-method="someMethodName"`

To use these:
- Define method in spring class
- Configure those in the xml

**Note** These methods cannot have any arguments and can be any access level and have any return type, beans of type prototype do not call `destroy` method. You have to handle via client side

Add bean scope to coach app

## Annotations & IoC
An `annotation` is a special label added to Java classes that provide meta-data about that class. (Very similar to decorators in Angular)

These labels are processed either run time or compile time to enable certain things.

`@Override` is an example of an annotation, this tells the compiler to override the interface method.

XML configuration can get really verbose so it's better to use annotations in this case to minimize the XML use.

Spring scans classes for Annotations and if they are detected it will add them to the container.

To identify a class as a bean:
- Enable component scanning in XML: `<context: component-scan base-package="com.pkgName.fullName"/>`
- Use @Component to annotate Beans: `@Component("beanId") public class foo implements bar {...}`
- Retrieve beans in app

Spring can generate a default bean id for your component if you don't specify, it will be `by default the className with the first letter lowercase`, this only works if only the first letter is Upper-case, if both are upper case it will not be changed.

Explicit bean id: @Component("SomeName")

Default bean id: @Component

## Annotations & Dependency Injection
`Auto wiring` is a process that spring uses to wire classes together spring will look for a class that matches the property by it's class or interface. If a match is determined it's auto injected.

Autowiring has 3 types of injection like with standard DI:
- Constructor Injection: Declare var and add @Autowired to the constructor to consume and assign var
- Setter Injection: Add var and add @Autowired to setter method that consumes and assigns var
  - This can be done via **ANY** method, but it needs to have @Autowired the method name is insignificant this is called `method injection` and is only possible since we are using the annotations.
- Field Injection: Inject by setting fields directly in class with @Autowired. No need for setters, handled via Java Reflection

In using each injection type. Pick a single style and stay consistent through the project. All 3 give the same functionality.

## Autowiring + Qualifiers
In autowiring spring scans the components and looks for any bean that implements a select interface.

But what about multiple implementations? Autowiring can't do it alone it will throw exception. Spring needs a unique bean to reference.

This is done via `@Qualifier(...)` so after @Autowired, you have to provide the beanId of the component you want to reference.

Qualifier can be used on all injection types with the exception of `Constructor Injection`.

For Constructors the qualifier must be passed in with the constructor argument.

``` java
// Constructor based autowire
@Autowired
public KickBoxingCoach(@Qualifier("randomFortune")FortuneService newService) {
		this.kickFortune = newService;
}
```
Another type of qualifier `@Value("${...}")` is required to inject literals. This follows the same process as previous but using the files previously save for injecting them directly into the class that has the dependency rather than injecting via the spring container configuration.

## Bean scope in Annotations
Everything about bean scope still applies but scope can be declared via an annotation.

Use: `@Scope("...")` on your bean components to do so.

Like in using the config it's possible to use custom hooks via annotations to add some custom behavior into the bean scope.

For initialization annotation use: `@PostConstruct`
For destruction annotation use: `@PreDestroy`

In Java 9 and up there is one more spring jar `javax.annotation-api-1.2.jar` that is needed to use these annotations

The method itself can have any name, access modifier, or return type. Public & void are the most common.

These methods like their config level counter parts do not accept arguments.

Recall: PostConstruct hook runs after both the constructor and dependancies are injected. PreDestroy runs before the bean is destroyed, predestroy doesn't get called on prototype scope

## Spring Configuration w/ Java code
If using Java source code to configure spring, there is no XML required.

Process:
- Make a java class and annotate it as `@Configuration`
- If needed enable component scanning with `@ComponentScan("...")`
- Read Java config class with `AnnotationConfigApplicationContext`
- Retrieve bean from Spring container


In the class file marked for configuration you can extract and manipulate beans at the code level, dependency injection must be done manually.

Process:
- Make method to expose bean using `@Bean` method name must be the bean name and must return a new instance of the bean
- Inject Dependencies: Inject dependencies by calling a bean constructor in a constructor that calls itself: `return new SwimCoach(badFortuneService());`
- Read spring config class: As per usual
- Retrieve bean: As per usual

In additon to that there is injection of beans via a property file:
- Create file like before, remember add it to the source dir not the package dir
- Read from spring config via a new annotation `@PropertySource("classpath:strength.properties")` `classpath:fileName` is the location and name of the properties file
- Refference values from properties file, do this with another new annotation `@Value("${...}")` over a field name that gets that value in the class itself


## Spring MVC
Spring MVC is a spring framework for web apps which endorses the MVC design pattern but with Spring core features like DI and IoC.
Spring allows UI components, state management, form validation and conversion and a flexible configuration for the view layer.

Spring makes use of a `front controller` which is called `DispatchServlet` which routes requests to other controllers
Controllers wrap business logic and route requests as usual
Models wrap data
And view templates wrap the UI
