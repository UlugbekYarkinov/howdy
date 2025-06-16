# 🤠 HowdyLang

HowdyLang is a custom, string-based programming language with a Texas twist, designed and implemented using **JavaCC** and **JJTree**. This language is a university project focused on the concepts of syntax definition, AST construction, and source code interpretation.

## 💡 Project Idea

The goal of HowdyLang is to define a **fully working programming language** that:

- Uses strings as its only data type
- Supports a readable, playful syntax inspired by cowboy slang
- Is interpreted via an AST built using JJTree
- Can later be translated into Java source code

This project demonstrates how to:
- Define a custom grammar
- Build an AST using JavaCC + JJTree
- Write an interpreter to execute language constructs

## ✅ Features Implemented

- ✅ Variable declaration and assignment
- ✅ String equality condition
- ✅ `if-then-else` statements
- ✅ `while` loop
- ✅ `do N times` loop
- ✅ `HOLLER` (print) statement
- ✅ AST interpreter in Java
- ✅ Grammar defined using `.jjt` (JavaCC + JJTree)

## 🧩 Constraints

- Only **string type** values are supported
- No arithmetic or boolean logic
- Variables must be declared by assignment (e.g., `name = "John";`)
- No function support (future extension)
- Limited to print, comparison, loops, and conditionals for now

---

## 📦 How to Build & Run

### 🔧 Prerequisites

- Java 21+
- Maven

### 🛠️ Build Steps

1. **Compile the project**
   ```bash
   mvn clean compile
   ```
2. **Package the project**
   ```bash
   mvn package
   ```
3. Run a HowdyLang Program 
Replace `src/test/test0.hl` with your input file path:
   ```bash
   java -jar target/howdy-1.0-SNAPSHOT.jar src/test/presentation.hl
   ```

#### If you want to run the code in Codespaces:
To make sure you run it on the same Java version
   ```bash
   sudo apt update
   sudo apt install openjdk-21-jdk
   export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
   export PATH=$JAVA_HOME/bin:$PATH
   ```

### 📁 Example Code (test0.hl)

   ```bash
   MAKE_PROGRAMMING

   greeting = "Howdy";
   name = "Partner";
   HOLLER greeting name;

   IF_YALL (greeting == "Howdy") {
      HOLLER "Yeehaw!";
   }

   WHILE_YALL (name == "Partner") {
      HOLLER "Still riding'...";
      name = "Cowboy";
   }

   GREAT_AGAIN
   ```

### 📚 Technologies Used

- JavaCC – Parser generator
- JJTree – AST builder
- Java 21+
- Maven
