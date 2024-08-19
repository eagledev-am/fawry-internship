# Week 5
## Java 8
> Java 8, released in March 2014, is a major update to the Java programming language. It introduced several new features and enhancements that greatly improved the language and its ecosystem. Key features of Java 8 include

<br>

<details close>
  <summary><h3>Some Features</h3></summary>
  
#### Lambda Expressions
  * **Syntax**: (parameters) -> expression or (parameters) -> { statements; }
  * Lambda expressions enable you to treat functionality as a method argument, or pass a block of code that can be executed later.

```
List<String> names = Arrays.asList("John", "Jane", "Max");
names.forEach(name -> System.out.println(name));
```
#### Functional Interfaces
* An interface with a single abstract method (SAM) is known as a functional interface. Java 8 provides several built-in functional interfaces like Predicate, Function, Consumer, and Supplier
```
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}
```
####  Streams API
* A new abstraction that lets you process sequences of elements (e.g., collections) in a functional style.
```
List<String> names = Arrays.asList("John", "Jane", "Max");
names.stream()
     .filter(name -> name.startsWith("J"))
     .forEach(System.out::println);
```

#### Optional Class
* A container object that may or may not contain a non-null value. This helps avoid NullPointerException.
```
Optional<String> optionalName = Optional.ofNullable(null);
System.out.println(optionalName.orElse("Default Name"));
```

#### New Date and Time API (java.time)
* A new, more robust and flexible API for working with dates and times, replacing the old java.util.Date and java.util.Calendar.
```
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1);
Period age = Period.between(birthday, today);
System.out.println("Age: " + age.getYears());
```
</details>

<br>

| Resource | instructor |
| ---------| ---------|
|[Java8(part 1)](https://drive.google.com/file/d/1tJ-Y-unioZZrnXB57dMuH-11o33IW4Wh/view?usp=sharing) | Eng. Adel Zaid |
|[Java8(part 2)](https://drive.google.com/file/d/15Sl5KnhQalhsbyZxR6PsFIhdUNYKhb1J/view?usp=sharing)|Eng. Adel Zaid |

<br>

## Design Pattern
> Design patterns are general reusable solutions to common problems encountered in software design and development. They are not code or libraries but rather guidelines on how to structure code to solve specific problems efficiently. Design patterns help developers create software that is more flexible, maintainable, and scalable by providing proven solutions to recurring design challenges.

### Behavioral Design Patterns
Behavioral design patterns are concerned with how objects interact and collaborate to achieve specific objectives. They focus on improving communication and responsibility between objects.
- Observer Pattern
- Template Pattern
- Strategy Pattern

| Resource | instructor | impl.|
| ---------| ---------|-----------|
|[Design pattern (part 3)](https://drive.google.com/file/d/1rXxhMd9HpD6ltyruTG7K49VHkWzy5fe4/view?usp=sharing) | Eng. Ahemd Ali |[Behavioral pattern](https://github.com/eagledev-am/Design-Pattern/tree/main/behavioral) |
