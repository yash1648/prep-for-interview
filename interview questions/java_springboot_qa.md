
# 📚 Java & Spring Boot Interview Questions and Answers

## 🧱 Core Java

### OOPS Concepts

**Q: What is the difference between abstraction and encapsulation?**  
**A:**  
- **Abstraction** hides implementation details and exposes only functionality.
- **Encapsulation** binds data and methods together and restricts access.

---

**Q: Explain polymorphism with examples.**  
**A:**  
- **Polymorphism** allows objects to be treated as instances of their parent class.
- **Compile-time** (method overloading) and **Runtime** (method overriding) are two types.

---

**Q: What are the four pillars of OOP?**  
**A:**  
- **Abstraction**, **Encapsulation**, **Inheritance**, and **Polymorphism**.

---

**Q: Difference between Interface and Abstract class.**  
**A:**  
- **Interface**: Only abstract methods (Java 7); from Java 8, default/static methods allowed.
- **Abstract Class**: Can have method bodies, constructor, and instance variables.

---

**Q: Can an Interface have constructors?**  
**A:**  
- **No**, interfaces cannot have constructors because they cannot be instantiated directly.

---

### Exception Handling

**Q: Difference between checked and unchecked exceptions?**  
**A:**  
- **Checked exceptions** must be caught or declared (IOException).
- **Unchecked exceptions** are not checked at compile-time (NullPointerException).

---

**Q: What is the importance of finally block?**  
**A:**  
- Executes **always**, regardless of exception occurrence.

---

**Q: Can we have try block without catch and finally?**  
**A:**  
- **No**, must have either **catch** or **finally** block.

---

**Q: What is the difference between throw and throws?**  
**A:**  
- **throw**: Used to **explicitly** throw an exception.
- **throws**: Used in method signature to **declare** exceptions.

---

### Collections Framework

**Q: Difference between List, Set, and Map?**  
**A:**  
- **List**: Ordered, allows duplicates.
- **Set**: Unordered, no duplicates.
- **Map**: Key-value pairs.

---

**Q: Difference between HashMap and Hashtable?**  
**A:**  
- **HashMap**: Not synchronized, faster.
- **Hashtable**: Synchronized, slower.

---

**Q: How does HashSet ensure uniqueness?**  
**A:**  
- Uses **hashCode()** and **equals()** methods.

---

**Q: Difference between ArrayList and LinkedList?**  
**A:**  
- **ArrayList**: Fast random access.
- **LinkedList**: Fast insertions/deletions.

---

**Q: Explain fail-fast and fail-safe iterators.**  
**A:**  
- **Fail-fast**: Throws **ConcurrentModificationException**.
- **Fail-safe**: Iterates over a **copy**.

---

### Multithreading and Concurrency

**Q: Difference between process and thread?**  
**A:**  
- **Process**: Independent program execution.
- **Thread**: Subset of process, shares memory.

---

**Q: What is the purpose of the volatile keyword?**  
**A:**  
- Guarantees visibility of changes across threads.

---

**Q: What are synchronized blocks in Java?**  
**A:**  
- Ensures that only **one thread** executes a block at a time.

---

**Q: Explain thread lifecycle.**  
**A:**  
- **New → Runnable → Running → Waiting/Blocked → Dead**.

---

**Q: Difference between Runnable and Callable?**  
**A:**  
- **Runnable**: No return value, can't throw checked exceptions.
- **Callable**: Returns value, can throw exceptions.

---

### Java 8 Features

**Q: What are functional interfaces?**  
**A:**  
- Interfaces with **one abstract method**. (e.g., Runnable, Comparator)

---

**Q: Explain lambda expressions.**  
**A:**  
- Shorter syntax for implementing functional interfaces.

---

**Q: What is the Stream API?**  
**A:**  
- Processes collections **functionally** (e.g., filter, map, reduce).

---

**Q: Difference between map and flatMap in Stream API?**  
**A:**  
- **map**: Transforms each element.
- **flatMap**: Flattens streams of collections.

---

**Q: What are default methods in interfaces?**  
**A:**  
- Methods with a **body** inside interfaces using **default** keyword.

---

# (Similarly, continue for Advanced Java, Spring, Microservices...)
