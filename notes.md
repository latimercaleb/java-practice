# Java notes
- Classes have 4 member access level specifiers:
      -  Public: Any class can call
      -  Private: Called only in class declared
      - Protected: Any class in same package or subclasses anywhere
      - Default: Absence of a modifier, any class or subclass in same package but only accessible in that package
- Java can **only extend one other class**, inheritance defines an **is-a** type of relationship, inheritance brings in public & protected methods of its parent and allows method overwriting
- *super* gives a reference to the parent, the same way *this* reference returns itself, *super*  can be used to call `super.foo()` or any method that exists in the super class
- *static* defines shared members across all classes can be used without instancing first
- *final* makes something immutable
- *abstract* is an incomplete method, and can only be extended and not instantiated
- If a class has an abstract method it is a **virtual class and cannot be instantiated**
- Objects go in memory and their addresses are stored in reference vars
- *instanceof* checks to see if an object is from a specific class
- *Strings* in Java are immutable & recycled by the string pool via garbage collection, if two strings are given the same value they point to the same variable in memory if not used with the `new string()` constructor
- Is-A (polymorphic relationship)
-  Downcasting & upcasting deal with casting an object as a type of its sub or super class, upcasting is always allowed but downcasting can typically throw a `classcastexception` if not checked
- Interfaces are used as **method collections for classes**, all methods in an interface should be public abstract while members should be **public static final**
- To use an interface in a class it must be included with implements, if you have inheritance it comes after like:
```
class alpha extends origin implements lib {
      // Code here
}
```
- Implementing an interface means that you **MUST** define every method in the interface since a concrete class cannot lack full definition of its methods, since all interface members are abstract
- Can implement multiple interfaces, and interfaces should be named after adjectives
- Exceptions in Java are checked or unchecked, doing handling of these follows:
```
try {

}
catch {

      }
finally {

            }
```

- Throwing an exception simply throws the exception back to the calling code where it can then be handled
- Ignoring exceptions is a great way to conserve cpu time at the loss of code integrity
- The object class is the god-class of everything in java
- Collections in java deal strictly with objects and has it's own package in java.util
- Several different types of collections distinguished by **ordering** (how an element is stored) and **sorting** (how an element is positioned based on its value)
- Collections have 3 main types:
      -  Set(collections that do not allow duplicate elements)
      -  List(ordered and unsorted)
      - Queue(a set of elements for processing)
- Maps are an interface that are collections, but not part of the collection hierarchy, this has it's own interface and is used in hashtable, hashmap and  hashcode
- Bounded types, introed in java 5 as a means of allowing generics. Enforcing type safety, for your files. Used via `<>` to instantiate different patterns
- Generics can make generic classes which work with ideally any type, but the type is declared at the point of instantiation, inheritance can be used on Generics
- Annotations are like decorators in Angular, start with @ and provide metadata about how things should work.
- Most Annotations come from libs, @Override is a really common one meaning that the methods should override a super method, most IDEs have support for annotations and provide debugging support
- Anotations can have properties in itself, as defined by their respective api
- Anotations can be applied to types in the checker framework to add more expected properties on types to improve programming practice
- Marshalling transforms an object instance into a data format that describes it, useful for instance transmission, instances have state which must be defined at a byte level so that those bytes can be sent to wherever and reconstruct the object with a similar state.
- Marshalling has quite a few bits of terminology around it but most notably XML and JSON are the popular formats used to accomplish the goals of Marshalling
- JAX-B is the most formal form of doing so in java architecture
