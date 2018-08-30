# Java notes
- Classes have 4 levels, public(any class), private(only in the class declared), protected(any class in same package or subclasses anywhere), default(absence of a modifier, any class or subclass in same package but only accessible in that package)
- Java can only extend one other class, inheritance defines an is-a type of relationship, inheritance brings in public & protected methods of its parent and allows method overwriting
- super gives a reference to the parent, the same way this reference returns itself, can be used to call super.foo() or any method that exists in the super class
- static defines shared members across all classes can be used without instancing first
- final makes something immutable
- abstract is an incomplete method, and can only be extended and not instantiated
- Objects go in memory and their addresses are stored in reference vars

Post fix operators exist and follow similar prefix/postfix conventions to C++
instanceof checks to see if an object is from a specific class
bitwise and or and xor do function in java as in C++

break exits loop, continue stops iteration and stays in the loop

strings in java are immutable and recycled by the string pool via garbage collection, if two strings are given the same value they point to the same variable in memory if not used with the new string() constructor

Strings in Java are common interview questions
- Is-A (polymorphic relationship)
-  Downcasting and upcasting deal with casting an object as a type of its sub or super class, upcasting is always allowed but downcasting can typically throw a classcastexception if not checked
- Interfaces are used as method collections for classes, all methods in an interface should be public abastract while members should be public static final
- To use an interface in a class it must be included with implements, if you have inheritance it comes after like: class alpha extends origin implements lib {}
- Implementing an interface means that you MUST define every method in the interface since a concrete class cannot lack full definition of its methods, since all interface members are abstract
- Can implement multiple interfaces, and interfaces should be named after adjectives
- Exceptions in Java are checked on unchecked, doing handling of these follows try {} catch {} finally {} to determine what needs to happen
- Throwing an exception simply throws the exception back to the calling code where it can then be handled
- Ignoring exceptions is a great way to conserve cpu time at the loss of code integrity
- The object class is the god-class of everything in java
- Collections in java deal strictly with objects and has it's own package in java.util
- Several different types of collections distinguished by ordering(how an element is stored) and sorting(how an element is positioned based on its value)
- Collections have 3 main types, set(collections that do not allow duplicate elements), list(ordered and unsorted) and queue(a set of elements for processing).
- Maps are an interface that are collections, but not part of the collection hierarchy, this has it's own interface and is used in hashtable, hashmap and  hashcode
- Bounded types
