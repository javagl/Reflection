# Reflection

Utility methods for reflection.

The classes in this library offer utility methods for certain common (simple)
reflection tasks. For more sophisticated tasks like classpath scanning or
metadata extraction, the [reflections library](`https://github.com/ronmamo/reflections`)
may be used.
 

The main classes in this library are named according to the entities that
they operate on:

- [`Classes`](https://github.com/javagl/Reflection/blob/master/src/main/java/de/javagl/reflection/Classes.java)
- [`Fields`](https://github.com/javagl/Reflection/blob/master/src/main/java/de/javagl/reflection/Fields.java)
- [`Constructors`](https://github.com/javagl/Reflection/blob/master/src/main/java/de/javagl/reflection/Constructors.java)
- [`Methods`](https://github.com/javagl/Reflection/blob/master/src/main/java/de/javagl/reflection/Methods.java)

These classes offer utility methods that are usually just wrappers around the
methods of the corresponding JDK classes (`Class`, `Field`, `Constructor`
and `Method`, respectively).

## `Unchecked` and `Optional`  

The methods in these classes generally come in two flavors:

- An `...Unchecked` version that wraps all checked exceptions and security
  exceptions from the underlying call into an unchecked `ReflectionException`
- An `...Optional` version that tries to silently ignore any errors and
  returns `null`, an empty list, or does nothing at all. (Make sure to use
  this only when you know what you're doing...)


## Filtering with the `Members` class  

The [`Members`](https://github.com/javagl/Reflection/blob/master/src/main/java/de/javagl/reflection/Members.java)
class contains methods that may be used via method references as predicates
for filtering streams. Additionally, the `Fields` and `Methods` class offer
convenience methods that allow passing in multiple predicates at once. For 
example, to obtain all `public` and `static` methods of a class whose 
names start with `get`, the following code may be used: 

    List<Method> publicStaticGetters = 
        Methods.getAllOptional(Example.class,
            Members::isPublic, 
            Members::isStatic,
            f -> f.getName().startsWith("get"));

            
## Parsing constructors and methods

The `Methods` and the `Constructors` class offer utility methods for
parsing strings that have been created from the `Method` or `Constructor`
object, respectively.

For example, there may be a class with the following method: 

    public class ExampleClass
    {
        public <T> void exampleMethod(
            List<? extends T> list, 
            Collection<? super T> collection) 
        { ... }
    }

The method in this class has two different string representations:

- Created with `Method#toString` : `"public void com.example.ExampleClass.exampleMethod(java.util.List,java.util.Collection)"`
- Created with `Method#toGenericString` : `"public <T> com.example.ExampleClass.exampleMethod(java.util.List<? extends T>,java.util.Collection<? super T>)"`

The `Methods#parseMethodUnchecked` method may be used to parse the 
`Method` object from these string representations:

    String string = ...; // See above
    String genericString = ...; // See above
    
    Method methodFromString = Methods.parseMethodUnchecked(string);
    Method methodFromGenericString = Methods.parseMethodUnchecked(genericString);
    
The same applies, analogously, for `Constructor` objects and the 
`Constructors#parseConstructorUnchecked` method.

    



  
            
            