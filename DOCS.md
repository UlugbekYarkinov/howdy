# 🤠 HowdyLang Syntax Guide

Howdy, partner! Welcome to **HowdyLang** — a string-based, down-home programming language inspired by the heart of Texas. This here guide will walk you through the language's grammar, its cowboy-lingo-flavored syntax, and how to wrangle your logic with it.

Whether you're `HOLLER`in' or loopin' `WHILE_YALL`, we've got you covered.

---

## 📜 Program Structure

Every HowdyLang program is a **script** made up of one or more **statements**, executed in order from top to bottom.

```howdy
// Example:
username = "Cowboy";
HOLLER "Howdy, " username;
```

---

## 🟡 Statements

Here’s what you can do with HowdyLang:

### 📝 Variable Assignment

Use plain English (with a Texan twang) to assign values to variables.

```howdy
name = "Buck";
hat <- "Stetson";
boots is "snakeskin";
```

All these mean the same thing — the following **assignment operators** are allowed:

- `=`
- `<-`
- `is`
- `are`
- `contains`
- `contain`

Only string values or identifiers are allowed.

---

### 📣 Print Something

Use `HOLLER` to print messages or variables.

```howdy
HOLLER "Howdy partner!";
HOLLER "Name: " name;
```

Multiple values can be printed in one go.

---

### 🔀 Conditional Logic

Use `IF_YALL` to branch your logic — with optional `ELSE_YALL`.

```howdy
IF_YALL (name == "Buck") {
    HOLLER "That's Buck!";
} ELSE_YALL {
    HOLLER "Who’re you?";
}
```

You can also use friendly equality expressions:

```howdy
IF_YALL (role equals "rancher")
```

Allowed equality operators:

- `==`
- `equals`
- `equal`

---

### 🔁 Loops

#### 1. `WHILE_YALL` — Keep goin’ till the cows come home:

```howdy
count = "start";

WHILE_YALL (count == "start") {
    HOLLER "Still startin’...";
    count = "done";
}
```

Executes the block as long as the condition holds.

#### 2. `DO_YALL ("N") TIMES` — Do it N times, no more, no less:

```howdy
DO_YALL ("3") TIMES {
    HOLLER "This here’s a loop!";
}
```

The number must be provided as a quoted string (e.g. `"5"`).

---

### 📦 Block Statements

Use `{ }` to group multiple statements:

```howdy
IF_YALL (mode == "debug") {
    HOLLER "Debuggin’";
    HOLLER "Watch out!";
}
```

You can also use a single statement without braces.

---

## 🔍 Conditions

Conditions compare a variable to a value using:

```howdy
<IDENTIFIER> <EQ> Value()
```

Where `<EQ>` can be:

- `==`
- `equals`
- `equal`

Example:

```howdy
IF_YALL (status == "ready")
```

---

## 💬 Values

Values can be either:

- A **string literal** (e.g. `"Howdy"`)
- A **variable name** (e.g. `username`)

---

## 🧪 Sample Program

```howdy
name = "Tex";
count = "1";

IF_YALL (name == "Tex") HOLLER "Howdy Tex!";

DO_YALL ("3") TIMES {
    HOLLER "Runnin' the rodeo!";
}

WHILE_YALL (count == "1") {
    HOLLER "Loopin': " iteration_YALL;
    IF_YALL (iteration_YALL == "3") count = "done";
}

HOLLER "All done!";
```

---

## 🪪 Summary

| Syntax                 | Purpose                          |
|------------------------|----------------------------------|
| `HOLLER`               | Print to console                 |
| `IF_YALL`, `ELSE_YALL` | Conditional logic                |
| `WHILE_YALL`           | Loop while condition is true     |
| `DO_YALL ("N") TIMES`  | Loop N times (N as string)       |
| `{}`                   | Block scope                      |
| `==`, `equals`, `equal`| String comparison                |
| `=`, `is`, `<-`        | Assignment operators             |

---

## 🤠 Final Word

HowdyLang is a friendly, string-only language with a Texas soul. Use it to learn how programming logic works with a smile on your face and a twang in your code. Yeehaw!
