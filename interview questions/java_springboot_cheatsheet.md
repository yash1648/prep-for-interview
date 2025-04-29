
# 📄 Java & Spring Boot Interview Cheat Sheet

## 🧱 Core Java

### OOPS Concepts
- **Abstraction**: Hiding internal implementation details, showing only functionalities.
- **Encapsulation**: Binding data and methods together; protecting data.
- **Polymorphism**: Ability to take many forms; method overloading and overriding.
- **Four Pillars**: Abstraction, Encapsulation, Inheritance, Polymorphism.
- **Interface vs Abstract Class**: Interface = contract; Abstract class = partial implementation. No constructors in interfaces.

### Exception Handling
- **Checked vs Unchecked**: Checked = compile-time (IOException), Unchecked = runtime (NullPointerException).
- **Finally block**: Executes always (even after return).
- **Try without Catch/Finally**: Not allowed directly; needs at least finally.
- **Throw vs Throws**: `throw` = manually throw exception, `throws` = declare exception.

### Collections Framework
- **List vs Set vs Map**: List = ordered, Set = unique, Map = key-value.
- **HashMap vs Hashtable**: HashMap = not thread-safe; Hashtable = thread-safe but slower.
- **HashSet Uniqueness**: Uses `hashCode()` and `equals()`.
- **ArrayList vs LinkedList**: ArrayList = dynamic array; LinkedList = doubly-linked nodes.
- **Fail-fast vs Fail-safe**: Fail-fast = throws ConcurrentModificationException; Fail-safe = uses a clone during iteration.

### Multithreading and Concurrency
- **Process vs Thread**: Process = program in execution; Thread = lightweight sub-process.
- **Volatile**: Guarantees visibility of changes across threads.
- **Synchronized Blocks**: Control thread access to critical code.
- **Thread Lifecycle**: New → Runnable → Running → Waiting/Blocked → Dead.
- **Runnable vs Callable**: Runnable = no return result; Callable = returns a result and can throw exceptions.

### Java 8 Features
- **Functional Interface**: Interface with a single abstract method (@FunctionalInterface).
- **Lambda Expressions**: Short form of anonymous class implementation.
- **Stream API**: Functional processing of collections.
- **Map vs FlatMap**: Map = transforms each element; FlatMap = flattens nested structures.
- **Default Methods**: Interfaces with method bodies using `default` keyword.

## 🚀 Advanced Java

### JDBC
- **JDBC Driver**: Java library for database connectivity.
- **Steps**: Load driver → Establish connection → Execute query → Process result → Close connection.
- **Statement vs PreparedStatement**: PreparedStatement is precompiled and safe from SQL injection.
- **Batch Updates**: Execute multiple SQL statements efficiently in a single batch.

### Servlets
- **Servlet Lifecycle**: init() → service() → destroy().
- **GET vs POST**: GET = idempotent, data in URL; POST = safer, data in body.
- **ServletConfig vs ServletContext**: Config = per servlet settings; Context = application-wide settings.
- **Session Creation**: `request.getSession(true)` method.

### JSP
- **JSP Directives**: Instructions to the container (`<%@ page %>`, `<%@ include %>`, etc.).
- **Include Directive vs Action**: Directive = compile-time inclusion; Action = runtime inclusion.
- **Implicit Objects**: request, response, session, application, out, config, page, pageContext, exception.
- **JSTL**: JSP Standard Tag Library for reducing Java code inside JSP.

### Hibernate
- **Hibernate**: ORM tool for Java.
- **Advantages over JDBC**: Simplifies data persistence, provides caching, handles transaction management.
- **Architecture**: SessionFactory, Session, Transaction, Query.
- **Hibernate Session**: Bridge between Java objects and database.
- **get() vs load()**: get() = immediate fetch; load() = lazy fetch (throws ObjectNotFoundException if not found).
- **Object States**: Transient, Persistent, Detached.
- **HQL**: Hibernate Query Language, object-oriented SQL.
- **save() vs persist()**: save() returns ID; persist() does not return ID.
- **Caching**: First-level (Session), Second-level (SessionFactory), Query Cache.
- **Annotations**: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`, etc.

## 🌱 Spring Framework

### Spring Core
- **Dependency Injection**: Injecting dependencies into objects instead of the objects creating them.
- **Types of Injection**: Constructor Injection, Setter Injection.
- **BeanFactory vs ApplicationContext**: ApplicationContext extends BeanFactory and adds more features (AOP, event propagation).
- **Bean Scopes**: Singleton, Prototype, Request, Session, Application, Websocket.
- **Bean Lifecycle**: Methods like `@PostConstruct` and `@PreDestroy`.

### Spring MVC
- **DispatcherServlet**: Front Controller in Spring MVC architecture.
- **Workflow**: Client Request → DispatcherServlet → Controller → Service Layer → DAO Layer → Database.
- **@Controller vs @RestController**: @RestController = @Controller + @ResponseBody.
- **Exception Handling**: Using `@ControllerAdvice`, `@ExceptionHandler`.

### Spring Boot
- **Definition**: Spring with auto-configuration, starter templates, and embedded servers.
- **Advantages**: Simplifies setup, minimizes configuration, production-ready metrics.
- **Starter**: Pre-configured templates like `spring-boot-starter-web`.
- **Auto Configuration**: Automatically configures Spring application based on dependencies.
- **Creating App**: Use Spring Initializer or manually setup `@SpringBootApplication`.

### Spring Data JPA
- **Definition**: Abstraction layer over JPA.
- **Benefits**: Reduces boilerplate code.
- **Repository Pattern**: Interface-based approach to data access.
- **CrudRepository vs JpaRepository**: JpaRepository extends CrudRepository and adds pagination and sorting.
- **Pagination and Sorting**: Using `Pageable` and `Sort`.

## 🧩 Microservices

### Basics
- **Microservices**: Independently deployable small services.
- **Advantages**: Flexibility, scalability, resilience.
- **Monolithic vs Microservices**: Monolithic = single unit; Microservices = multiple independent units.
- **API Gateway**: Single point of entry, handles routing, authentication, and load balancing.

### Spring Cloud
- **Netflix Eureka**: Service discovery.
- **Spring Cloud Config Server**: Centralized external configuration.
- **Circuit Breaker Pattern**: Fault tolerance in microservices (Hystrix/Resilience4j).
- **Feign Client**: Simplified REST client.

## 🎯 Miscellaneous

### Design Patterns
- **Singleton Pattern**: Ensures one instance of a class.
- **Factory Pattern**: Creates objects without specifying exact class.
- **Observer Pattern**: One-to-many dependency; listeners.
- **Dependency Injection Pattern**: Inject objects rather than creating internally.

### Best Practices
- **Immutable Class**: Final class, private final fields, no setters.
- **Program to Interface**: Reduces tight coupling.
- **Coding Standards**: Follow meaningful naming, consistent formatting, exception handling.

# 🛡️ Quick Memory Shortcuts

| Concept | Shortcut |
|:---|:---|
| OOP Pillars | A PIE (Abstraction, Polymorphism, Inheritance, Encapsulation) |
| Java 8 Highlights | Functional + Streams + Default Interfaces |
| Exception Types | Checked (compile), Unchecked (runtime) |
| Collection Key Points | List (order), Set (unique), Map (key-value) |
| Hibernate Object States | TPD (Transient, Persistent, Detached) |
| Spring MVC Workflow | Dispatcher → Controller → Service → DAO |
| Spring Boot Key Features | Auto Configuration + Embedded Servers |
| Microservices Essence | Small, Independent, Deployable |
