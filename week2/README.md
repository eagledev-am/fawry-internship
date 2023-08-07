# Collections
Java collections are a set of classes and interfaces that provide a framework for storing and manipulating groups of objects. They allow you to perform common operations on data structures, such as searching, sorting, adding, removing, and iterating over elements. Java collections are part of the java.util package and include the following main components:
*  **Collection interface**
*  **List interface**
*  **Set interface**
*  **Queue interface**
*  **Deque interface**
*  **Map interface**

![collections-hierarchy](https://github.com/eagledev-am/fawry-intern/assets/84116267/b505764a-162e-42d5-a3c7-7061634b2d36)
##
## List 
List implements **Collection** interface that represents an ordered sequence of elements that can be accessed by index
### ArrayList
* It is resizable, meaning it can grow or shrink as needed.
* It supports random access, meaning you can access any element by its index in constant time.
* It is not synchronized, meaning it is not thread-safe and may cause concurrency issues if used by multiple threads.
* It is not efficient for primitive types, meaning it requires wrapper classes such as Integer or Double to store them.
```
List<String> names = new ArrayList<>();
names.add("Ahmed");
names.get(0); // Ahmed
names.remove(0);
```
### LinkedList
* It is dynamic, meaning it can grow or shrink as needed
* It supports sequential access, meaning you can traverse the list from either end in linear time
* It is efficient for frequent insertion or deletion at any position, meaning it does not require shifting of elements or resizing of the array.
* It does not support random access, meaning you cannot access any element by its index in constant time.
```
List<String> names = new LinkedList<>();
names.add("Ahmed");
names.getFirst();
names.removeFirst();
```
<img width="887" alt="list" src="https://github.com/eagledev-am/fawry-intern/assets/84116267/747fcc7a-8d4f-469c-a986-7216547243be">

