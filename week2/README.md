# Collections
Java collections are a set of classes and interfaces that provide a framework for storing and manipulating groups of objects. They allow you to perform common operations on data structures, such as searching, sorting, adding, removing, and iterating over elements. Java collections are part of the java.util package and include the following main components:
*  **Collection interface**
*  **List interface**
*  **Set interface**
*  **Queue interface**
*  **Deque interface**
*  **Map interface**
  
![Collections-in-Java-768](https://github.com/eagledev-am/fawry-intern/assets/84116267/e67426ac-94d7-4ce6-9f18-ac62cb2b1ef1)
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

##
## Set 
Set implements **Collection**. Set is a collection of objects ts that does not allow duplicate elements. It is based on the mathematical concept of a set, which is a group of distinct values.

### HashSet
* A HashSet uses a **HashMap** to store data.
* A HashSet is implemented using a hash table, which is a data structure that stores elements using their hash codes. A hash code is a unique value that identifies an object.
* A HashSet provides constant time performance for basic operations such as add, remove, contains, and size, assuming the hash function distributes the elements evenly across the buckets.
* A HashSet does not guarantee any specific order of the elements. The order may change over time as the HashSet grows or shrinks.
```
 Set<String> hs = new HashSet<String>();
 hs.add("B");
 hs.add("B");
 hs.add("C");
 hs.add("A");
 System.out.println(hs);// [A , B , C]
```
### LinkedHashSet
* A HashSet uses a **HashMap** to store data.
* A HashSet is implemented using a hash table, which is a data structure that stores elements using their hash codes. A hash code is a unique value that identifies an object.
* A HashSet provides constant time performance for basic operations such as add, remove, contains, and size, assuming the hash function distributes the elements evenly across the buckets.
* A LinkedHashSet maintains a doubly-linked list of the elements in the order of their insertion. This means it preserves the insertion order of the elements, unlike HashSet, which does not guarantee any specific order.

```
 Set<String> hs = new LinkedHashSet<String>();
 hs.add("B");
 hs.add("B");
 hs.add("C");
 hs.add("A");
 System.out.println(hs);[ B , C , A ]
```
### TreeSet 
* TreeSet uses **TreeMap** to store data.
* TreeSet Stores data in natural order or according to specific Comparator.
* A TreeSet provides logarithmic time performance for basic operations such as add, remove, contains, and size, assuming the elements are comparable or a valid comparator is provided.
```
Set<Integer> numbers = new TreeSet<>();
numbers.add(10);
numbers.add(15);
numbers.add(20); 
numbers.add(10); 
System.out.println(numbers); // [ 10 , 15 , 20 ]
```
