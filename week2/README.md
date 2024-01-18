# Collections
> collections are a set of classes and interfaces that provide a framework for storing and manipulating groups of objects. They allow you to perform common operations on data structures, such as searching, sorting, adding, removing, and iterating over elements. Java collections are part of the java.util package and include the following main components:
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
##
## Queue
Queue implements **Collection** interface that follows first-in , first-out (FIFO) principle that is inserted first removed first.
### LinkedList
* A LinkedList is a Java class that implements the Queue interface, which means it can be used as a queue data structure.
* To add an element to the end of the queue, you can use the add() method of LinkedList, which appends the specified element to the end of the list. For example: queue.add("Alice");
* To remove an element from the front of the queue, you can use the remove() method of LinkedList, which retrieves and removes the head (first element) of the list. For example: String name = queue.remove();
* To peek at the element at the front of the queue, you can use the peek() method of LinkedList, which returns the head (first element) of the list without removing it. For example: String first = queue.peek();.
* Other methods of LinkedList that are inherited from the Queue interface, such as offer(), poll(), and element(), which have similar functionality to add(), remove(), and peek(), respectively.
```
// import the LinkedList class
import java.util.LinkedList;

// create a LinkedList object
Queue<String> queue = new LinkedList<String>();

// add some elements to the queue
queue.add("Alice");
queue.add("Bob");
queue.add("Charlie");

// print the queue
System.out.println(queue); // [Alice, Bob, Charlie]

// remove the first element from the queue
String name = queue.remove();

// print the removed element
System.out.println(name); // Alice

// print the queue after removal
System.out.println(queue); // [Bob, Charlie]

// peek at the first element of the queue
String first = queue.peek();

// print the first element
System.out.println(first); // Bob

// print the queue after peeking
System.out.println(queue); // [Bob, Charlie]

```
## PriorityQueue
* The elements of a priority queue are ordered either by their natural ordering (such as numerical or alphabetical order) or by a custom comparator that defines the priority rules.
* A priority queue can be created with different constructors that specify the initial capacity, the comparator, or the collection of elements to be added.
```
PriorityQueue<String> pq = new PriorityQueue<String>();

// add some elements to the queue
pq.add("Apple");
pq.add("Banana");
pq.add("Cherry");

// print the queue
System.out.println(pq); // [Apple, Banana, Cherry]

// remove and print the head of the queue
System.out.println(pq.remove()); // Apple

// print the queue after removal
System.out.println(pq); // [Banana, Cherry]

// peek and print the head of the queue
System.out.println(pq.peek()); // Banana

// print the queue after peeking
System.out.println(pq); // [Banana, Cherry]
```
