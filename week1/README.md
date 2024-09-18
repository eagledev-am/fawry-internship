# Week1

## OOP 
> OOP stands for Object-Oriented Programming, which is a programming paradigm that uses objects – instances of classes – for designing and organizing code. The main principles of OOP include
<details close>
  <summary><h3>Principles</h3></summary>
1- **Encapsulation**: This involves bundling the data (attributes) and the methods (functions) that operate on the data into a single unit known as a class. It helps in hiding the internal details of an object and exposing only what is necessary.

2- **Inheritance**: This allows a class (subclass or derived class) to inherit properties and behaviors from another class (superclass or base class). It promotes code reuse and the creation of a hierarchy of classes.

3- **Polymorphism**: This concept allows objects of different classes to be treated as objects of a common base class. It enables a single interface to represent different types of objects, providing flexibility and extensibility.

4- **Abstraction**: Abstraction involves simplifying complex systems by modeling classes based on the essential properties and behaviors. It allows programmers to focus on relevant details while ignoring unnecessary complexities.
</details>

<br>

| Resource | instructor |
| ---------| ---------|
| [Programming 2 - Object Oriented Programming With Java](https://www.youtube.com/watch?v=M3Na5luSx50&list=PL1DUmTEdeA6Icttz-O9C3RPRF8R8Px5vk) | DR. Mohamed Eldesoky |
| [Object-Oriented Programming JAVA in Arabic](https://www.youtube.com/watch?v=FaaM6uVbuJM&list=PLCInYL3l2AagY7fFlhCrjpLiIFybW3yQv)  | Eng. Adel Nessim |

<br>

## Git 
> Git is a distributed version control system (DVCS) that is widely used for tracking changes in source code during software development. It allows multiple developers to collaborate on a project, keeping track of changes, merging modifications, and maintaining a complete history of the codebase.

<br>

| Resource | instructor |
| ---------| ---------|
| [Git and GitHub Tutorial For Beginners](https://www.youtube.com/watch?v=3fUbBnN_H2c&pp=ygUDZ2l0)| AmigosCode |
| [Git and GitHub](https://youtu.be/Q6G-J54vgKc?si=ICIrjHBdx7Wu41QY)| AmigosCode |

<br>

## Design Principle 
> Code design principles are guidelines and best practices that help software developers create well-organized, maintainable, and efficient code. These principles contribute to the overall quality, readability, and scalability of a software system. Here are some important code design principles.

<details close>
  <summary><h3>Some Principles<h3></summary>

1- **DRY (Don't Repeat Yourself)**:
        Avoid duplicating code. Instead, use abstractions, functions, or classes to encapsulate common functionality. This reduces redundancy, improves maintainability, and makes code easier to understand.

2- **SOLID Principles**:
        These are a set of five principles for object-oriented design:
            S - Single Responsibility Principle (SRP): A class should have only one reason to change, meaning it should have only one responsibility.
            O - Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
            L - Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types without altering the correctness of the program.
            I - Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
            D - Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions.

3- **KISS (Keep It Simple, Stupid)**:
        Favor simplicity over complexity. Strive for the simplest solution that meets the requirements. Simple code is easier to understand, maintain, and less prone to bugs.

4- **YAGNI (You Ain't Gonna Need It)**:
        Only implement features that are necessary for the current requirements. Avoid adding functionality based on speculation about future needs, as it can lead to unnecessary complexity.

5- **Composition Over Inheritance**:
        Prefer composition and aggregation over inheritance when building relationships between classes. This promotes flexibility and reduces coupling.

6- **Separation of Concerns (SoC)**:
        Divide your program into distinct sections, each addressing a separate concern. This makes the code more modular, easier to understand, and facilitates changes in one area without affecting others.

7- **Single Responsibility Principle (SRP)**:
        A class or module should have only one reason to change, meaning it should have only one responsibility. This principle is part of the SOLID principles.

8- **Dependency Injection**:
        Instead of hardcoding dependencies within a class, pass them as parameters or inject them through constructors. This promotes loose coupling and easier testing.
9- **Law of Demeter (LoD) or Principle of Least Knowledge**:
        A module should not have knowledge of the inner workings of the objects it manipulates. It promotes encapsulation and reduces the ripple effect of changes.

10- **Consistency**:
        Follow consistent naming conventions, coding styles, and patterns throughout your codebase. This makes it easier for developers to read and contribute to the code.
</details>

<br>

| Resource | instructor |
| ---------| ---------|
| [Design principles video](https://drive.google.com/file/d/1SdVK56v9G_stsRaoIi1mN16Y5RNTAp4T/view?usp=sharing) | Eng. Hany Ahmed |
| [Design principles tutorial](https://github.com/Ahmed-Mohmed-Sakr/Fawry-Intern/blob/main/src/main/java/org/tasks/week1/Design_Principles) | Eng. Ahmed Sakr |

<br>


## Solid Principles 
> The SOLID principles are a set of five design principles that, when followed, can lead to the creation of more maintainable, flexible, and scalable software systems. The SOLID principles were introduced by Robert C. Martin and are widely used in object-oriented design. Here's a brief overview of each SOLID principle.

<details close>
  <summary><h3>Principles</h3></summary>
1- **Single Responsibility Principle (SRP)**:
        A class should have only one reason to change, meaning it should have only one responsibility. This principle encourages a class to have a single, well-defined purpose. It helps in keeping classes focused and makes them easier to understand, modify, and maintain.

2- **Open/Closed Principle (OCP)**:
        Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This principle promotes the idea that existing code should not be altered when new functionality is added. Instead, the code should be extended without modifying its existing behavior. This is often achieved through the use of abstraction and interfaces.

3- **Liskov Substitution Principle (LSP)**:
        Subtypes must be substitutable for their base types without altering the correctness of the program. In other words, objects of a base class should be replaceable with objects of a derived class without affecting the correctness of the program. This ensures that derived classes adhere to the contract established by the base class.
4- **Interface Segregation Principle (ISP)**:
        Clients should not be forced to depend on interfaces they do not use. This principle suggests that a class should not be forced to implement interfaces it does not use. Instead of having a large, monolithic interface, it is better to have smaller, more specific interfaces that are tailored to the needs of the implementing classes.

5- **Dependency Inversion Principle (DIP)**:
        High-level modules should not depend on low-level modules. Both should depend on abstractions. This principle emphasizes the importance of relying on abstractions (interfaces or abstract classes) rather than concrete implementations. It promotes the idea that the high-level modules and low-level modules should depend on the same abstractions, reducing coupling.
</details>
<br>

| Resource | instructor |
| ---------| ---------|
| [SOLID principles](https://www.youtube.com/watch?v=-hbWDYRSjqk&list=PLnqAlQ9hFYdflFSS4NigVB7aSoYPNwHTL) | Eng. Mohammed Reda |
| [Learn solid principles](https://youtu.be/MrDYsFbtFZM) | Eng. Mahmoud Yousef |
| ||

#### You can find an implementaion for solid [here](https://github.com/eagledev-am/solid-principles)
