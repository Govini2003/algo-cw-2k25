# Maximum Flow Solver using Ford-Fulkerson (Edmonds-Karp Variant)

### 📘 Informatics Institute of Technology  
**Module:** 5SENG003C.2 Algorithms: Theory, Design and Implementation  
**Student Name:** Govini Vimaya Rajapakse  
**UoW Number:** w2053511  
**IIT Number:** 20232420  
**Group:** SE-14  

---

## 1. 📌 Introduction

This project implements the **Ford-Fulkerson algorithm** using **Breadth-First Search (BFS)** as applied in the **Edmonds-Karp method** to solve the **maximum flow problem**. The program models a flow network as a graph and computes the maximum possible flow from a given **source** node to a **sink**, ensuring:

- Edge capacity constraints are respected  
- Flow conservation is maintained at each intermediate node  

---

## 2. 🧮 Data Structures & Algorithm

### 🧩 Edge Representation
Each edge is represented using an `Edge` class with:
- `from` node  
- `to` node  
- `capacity`  
- `flow`

The **residual capacity** is calculated dynamically to determine additional flow potential.

### 🌐 Graph Representation
The flow network is stored using an **adjacency list** within a `FlowNetwork` class, allowing efficient edge traversal.

### 📂 Input Parsing
A `NetworkParser` class reads input files with the following format:

```
# Example:
4
0 1 10
0 2 5
1 2 15
1 3 10
2 3 10
```

### ⚙️ Ford-Fulkerson Algorithm
- Uses **BFS** to find augmenting paths
- Augments flow until no more paths are available
- Displays each step and final flow clearly

---

## 3. 🎛️ Features & Interaction

### 🖥️ Main Console Interface
- Prompts user to **input file name**
- Displays **source and sink** nodes
- Shows each **augmenting path and flow added**
- Prints the **final maximum flow**
- Asks if the user wants to process another file

### 📤 Example Output
```
Source: 0  
Sink: 3  
Augmenting path found: 0 → 1 → 3 | Flow added: 10  
Augmenting path found: 0 → 2 → 3 | Flow added: 5  
Maximum flow: 15
```

---

## 4. ⚡ Performance Analysis

### ⏱️ Time Complexity
- **Edmonds-Karp Algorithm:** `O(V × E²)`
  - `V` = number of vertices  
  - `E` = number of edges  

### 🔍 Practical Observations
- Efficient for **small to medium** networks (up to a few thousand nodes)
- **Slow on large graphs** (e.g., `ladder_19.txt` with 1M+ nodes)
- For large datasets, consider:
  - **Dinic’s Algorithm**
  - **Push-Relabel Algorithm**

---

## 5. ✅ Conclusion

This implementation:

- Accurately computes **maximum flow**  
- Offers an **interactive, console-based** experience  
- Allows testing with **custom input files**  
- Clearly displays the path and flow calculations  

While Ford-Fulkerson with BFS (Edmonds-Karp) is excellent for educational and mid-scale purposes, **alternative algorithms** are better suited for very large graphs due to performance constraints.

---

## 📎 Sample Files

You may include benchmark files such as:
- `sample1.txt`
- `ladder_19.txt`
- `dense_network.txt`

> 📁 Place them in a folder like `input/` or prompt the user for a path.

---

## 🛠️ To Run the Project

```bash
javac Main.java
java Main
```

Ensure all related classes (`Edge`, `FlowNetwork`, `NetworkParser`, etc.) are in the same directory or properly referenced.

![image](https://github.com/user-attachments/assets/8da7ec92-0d67-487f-a484-99bc5e7ac819)
![image](https://github.com/user-attachments/assets/39ee9f4e-6e33-4711-beff-6f0ef42e737a)

---

## 🧠 Keywords

`Ford-Fulkerson` · `Edmonds-Karp` · `Maximum Flow` · `Graph Theory` · `BFS` · `Network Flow Algorithms` · `Java`
