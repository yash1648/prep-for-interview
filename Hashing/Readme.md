# Hashing


## 🚀 Introduction to Hashing

Hashing is a fundamental technique in computer science that allows for efficient data storage and retrieval. At its core, hashing is about converting data of arbitrary size into a fixed-size value, which serves as a "digital fingerprint" of the original data.

**Definition**: Hashing is the process of mapping data of arbitrary size to fixed-size values using a hash function. These fixed-size values, known as hash values or hash codes, are typically used to index a hash table.

The primary purpose of hashing is to enable **O(1)** time complexity for data retrieval operations, making it significantly faster than linear search algorithms.

## 💡 Core Concepts of Hashing

### The Key Ideas Behind Hashing:

1. **Pre-computation**: Calculate and store data properties in advance
2. **Direct Access**: Use the hash value as an index to access data directly
3. **Constant Time**: Achieve O(1) time complexity for lookups
4. **Space-Time Tradeoff**: Use additional memory to reduce computational time

> 💡 **Key Insight**: Hashing essentially trades memory for speed by pre-computing and storing information for rapid access later.

## 🔧 Hash Functions

A hash function is an algorithm that converts input data into a fixed-size string of bytes, typically represented as a hexadecimal number. The ideal hash function has these properties:

1. **Deterministic**: The same input always yields the same output
2. **Fast Computation**: Computing the hash should be quick
3. **Uniform Distribution**: Hash values should be evenly distributed
4. **Minimized Collisions**: Different inputs should rarely produce the same output
5. **Avalanche Effect**: Small changes in input cause significant changes in output

### Common Hash Functions:

- **Division Method**: `h(k) = k mod m`
- **Multiplication Method**: `h(k) = ⌊m * (k * A mod 1)⌋` where A is a constant
- **Universal Hashing**: Using a randomly selected hash function from a family
- **Cryptographic Hash Functions**: MD5, SHA-1, SHA-256, etc.

```java
// Simple hash function for strings
public int simpleStringHash(String s, int tableSize) {
    int hash = 0;
    for (int i = 0; i < s.length(); i++) {
        hash = (hash * 31 + s.charAt(i)) % tableSize;
    }
    return hash;
}
```

## 🧩 Collision Handling

A collision occurs when two different inputs produce the same hash value. Since the input space is typically larger than the output space, collisions are inevitable. There are several strategies to handle collisions:

### 1. Chaining (Open Hashing)

In chaining, each slot of the hash table contains a linked list of elements that hash to the same value.

```java
class HashTableChaining {
    private LinkedList<Entry>[] table;
    
    public HashTableChaining(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    public void insert(String key, int value) {
        int hash = hashFunction(key);
        table[hash].add(new Entry(key, value));
    }
}
```

### 2. Open Addressing

In open addressing, all elements are stored in the hash table itself. When a collision occurs, we probe for the next available slot.

- **Linear Probing**: `h(k, i) = (h(k) + i) mod m`
- **Quadratic Probing**: `h(k, i) = (h(k) + c₁i + c₂i²) mod m`
- **Double Hashing**: `h(k, i) = (h₁(k) + i * h₂(k)) mod m`

```java
class HashTableOpenAddressing {
    private Entry[] table;
    
    public void insert(String key, int value) {
        int hash = hashFunction(key);
        int i = 0;
        
        while (table[(hash + i) % table.length] != null) {
            i++;
        }
        
        table[(hash + i) % table.length] = new Entry(key, value);
    }
}
```

## ⏱️ Time Complexity Analysis

The power of hashing lies in its time complexity:

|Operation|Average Case|Worst Case (With collisions)|
|---|---|---|
|Insert|O(1)|O(n)|
|Search|O(1)|O(n)|
|Delete|O(1)|O(n)|

In a well-designed hash table with a good hash function and appropriate collision resolution, the average case complexity of O(1) is typically achieved in practice.

## 📊 Types of Hashing Techniques

### Character Frequency Hashing

Character frequency hashing pre-computes and stores the count of each character in a string, allowing for O(1) time complexity when retrieving the frequency of any character.

```java
public void charFrequencyHashing(String str) {
    // Pre-computation
    int[] hash = new int[26]; // For lowercase English letters
    
    for (int i = 0; i < str.length(); i++) {
        hash[str.charAt(i) - 'a']++;
    }
    
    // Retrieval
    char ch = 'a';
    System.out.println("Frequency of '" + ch + "': " + hash[ch - 'a']);
}
```

### Number Hashing

Number hashing involves pre-computing some property of numbers in an array to enable fast lookups.

```java
public void numberHashing(int[] arr) {
    // Pre-computation for counting occurrences
    HashMap<Integer, Integer> hash = new HashMap<>();
    
    for (int num : arr) {
        hash.put(num, hash.getOrDefault(num, 0) + 1);
    }
    
    // Retrieval
    int query = 42;
    System.out.println("Frequency of " + query + ": " + hash.getOrDefault(query, 0));
}
```

### String Hashing

String hashing is used for efficient string comparison and substring matching.

```java
public long computeStringHash(String s) {
    long hash = 0;
    long p = 31; // Prime number
    long m = 1_000_000_007; // Modulo to prevent overflow
    long p_pow = 1;
    
    for (char c : s.toCharArray()) {
        hash = (hash + (c - 'a' + 1) * p_pow) % m;
        p_pow = (p_pow * p) % m;
    }
    
    return hash;
}
```

## 🗺️ Hash Maps and Hash Sets

Hash maps (or dictionaries) and hash sets are common implementations of the hashing concept in programming languages.

### Hash Map (Java)

```java
// Creating a HashMap
HashMap<String, Integer> hashMap = new HashMap<>();

// Insertion
hashMap.put("apple", 5);
hashMap.put("banana", 3);

// Retrieval
int appleCount = hashMap.get("apple"); // O(1) time complexity

// Checking existence
boolean containsOrange = hashMap.containsKey("orange"); // O(1) time complexity
```

### Hash Set (Java)

```java
// Creating a HashSet
HashSet<String> hashSet = new HashSet<>();

// Insertion
hashSet.add("apple");
hashSet.add("banana");

// Checking existence
boolean containsApple = hashSet.contains("apple"); // O(1) time complexity
```

## 🌐 Real-World Applications

Hashing is used in numerous applications:

1. **Database Indexing**: Fast retrieval of records
2. **Caching Systems**: Quickly determine if a value is in cache
3. **Password Storage**: Store hashed passwords instead of plaintext
4. **Data Integrity Checks**: Verify data hasn't been modified
5. **Blockchain Technology**: Secure transaction verification
6. **Load Balancing**: Distribute network traffic across servers
7. **Cryptography**: Digital signatures and encryption
8. **Deduplication**: Identify duplicate data

## 🛠️ Best Practices and Optimization

To maximize the efficiency of hashing:

1. **Choose an appropriate hash function** for your specific use case
2. **Select a suitable initial size** for your hash table
3. **Define a good load factor** (typical values range from 0.5 to 0.75)
4. **Implement rehashing** when the load factor threshold is exceeded
5. **Use a prime number** for the hash table size to minimize collisions
6. **Consider the data distribution** when designing your hash function

```java
class OptimizedHashTable<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private final double LOAD_FACTOR_THRESHOLD = 0.75;
    
    public void put(K key, V value) {
        if ((double) size / table.length >= LOAD_FACTOR_THRESHOLD) {
            rehash();
        }
        // Insert implementation
    }
    
    private void rehash() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[nextPrime(table.length * 2)];
        size = 0;
        
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }
    
    private int nextPrime(int n) {
        // Find the next prime number >= n
        // Implementation details omitted for brevity
        return n;
    }
}
```

## 🔬 Advanced Hashing Techniques

### Perfect Hashing

Perfect hashing guarantees no collisions by using a two-level hash structure, especially useful when the key set is static.

### Consistent Hashing

Consistent hashing minimizes the remapping of keys when a hash table is resized, making it ideal for distributed systems.

```java
public class ConsistentHashing {
    private final TreeMap<Integer, String> ring = new TreeMap<>();
    private final int replicas = 100;
    
    public void addNode(String node) {
        for (int i = 0; i < replicas; i++) {
            int hash = hashFunction(node + i);
            ring.put(hash, node);
        }
    }
    
    public String getNode(String key) {
        if (ring.isEmpty()) return null;
        
        int hash = hashFunction(key);
        if (!ring.containsKey(hash)) {
            // Get the first key greater than or equal to the hash
            Integer nextKey = ring.ceilingKey(hash);
            // If no key found, use the first key (wrap around)
            hash = nextKey != null ? nextKey : ring.firstKey();
        }
        
        return ring.get(hash);
    }
    
    private int hashFunction(String key) {
        // Implementation details omitted
        return 0;
    }
}
```

### Cuckoo Hashing

Cuckoo hashing uses multiple hash functions and guarantees O(1) worst-case lookup time.

### Bloom Filters

Bloom filters are probabilistic data structures that efficiently test whether an element is a member of a set, with possible false positives but no false negatives.

```java
public class BloomFilter {
    private BitSet bitSet;
    private int bitSetSize;
    private int numHashFunctions;
    
    public BloomFilter(int expectedElements, double falsePositiveProbability) {
        // Calculate optimal size and number of hash functions
        // Implementation details omitted
    }
    
    public void add(String element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(element, i);
            bitSet.set(hash);
        }
    }
    
    public boolean mightContain(String element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(element, i);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }
    
    private int hash(String element, int functionIndex) {
        // Implementation details omitted
        return 0;
    }
}
```

## 🎯 Conclusion

Hashing is a powerful technique that enables efficient data storage and retrieval through pre-computation and direct access. By understanding the principles of hashing, choosing appropriate hash functions, and implementing effective collision resolution strategies, developers can significantly improve the performance of their applications.

Key takeaways:

1. Hashing converts data into a fixed-size value for efficient indexing
2. Good hash functions distribute values uniformly and minimize collisions
3. Collision resolution strategies include chaining and open addressing
4. Hash tables offer average-case O(1) time complexity for lookups
5. Real-world applications include databases, caching, and cryptography
6. Advanced techniques like consistent hashing and bloom filters solve specific problems

By mastering hashing, you'll have a valuable tool in your algorithmic toolbox for solving a wide range of computational problems efficiently.

---

## 📝 Practice Exercises

To solidify your understanding of hashing concepts, try these exercises:

1. Implement a hash table with chaining for collision resolution
2. Create a character frequency counter using hashing
3. Solve the "Two Sum" problem using a hash map
4. Implement a simple cache with an LRU (Least Recently Used) policy using hashing
5. Design a hash function for a specific type of data structure

## 📚 Further Reading

- "Introduction to Algorithms" by Cormen, Leiserson, Rivest, and Stein
- "Algorithms" by Robert Sedgewick and Kevin Wayne
- "The Art of Computer Programming, Volume 3: Sorting and Searching" by Donald Knuth