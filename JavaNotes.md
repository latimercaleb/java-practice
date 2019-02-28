# Java w/ Spring & Hibernate
Spring is a popular framework for building enterprise apps.

Spring was supposed to be the lightweight iteration of J2EE.

J2EE introduced a feature called EJB (_Enterprise Java Beans_) which was notorious for being slow.

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

Pojo &  packages are important concepts to understand for Spring development.

`Pojo` is  a plain old java object and it's an object that is not dependant on framework extensions or interfaces.
A pojo should not:
- Extend another Class
- Implement interfaces
- contain anotations

 A pojo in theory should directly wrap business logic and not contain any functions besides getters, setters & constructors.

 `Beans` are a subtype of pojo, not all Pojos are beans. But all beans are Pojos. A bean must:
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

The id is used to retrieve or work with a bean

## Spring Container
Also known as `ApplicationContext` has two parts, first declare it's instance and pass in the config xml. Then extract beans by id and interface or class name
Finish app 1 understand definitions used, learn dependancy injection 
