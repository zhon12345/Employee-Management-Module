
# Employee Management Module

This project is a part of **AACS2204 Object-Oritented Programming Technique** assignment. The goal is to create an Employee Management Module for our [Inventory Management System](https://github.com/YapSJin/Inventory-Management-System) using Java with an emphasis on Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, and encapsulation.
## Features

- 🛠️ Admin Panel
    - The admin account have access to create, read, update, and delete (CRUD) both full-time and part-time staff members.
- 👥 Full-time and Part-time Staff Management
  - Full-time staff have additional attributes such as bonuses, fines, and a base salary.
  - Part-time staff have their work hours tracked to calculate their salary.
- 🏷️ Polymorphism and Inheritance
  - The module utilizes abstraction by defining an abstract `Staff` class, which is inherited by `FulltimeStaff` and `ParttimeStaff` classes.
  - Methods such as `getSalary()` and `updateDetails()` are overwritten to handle specific behaviors for full-time and part-time staff.
- 🔒 Encapsulation
    - All employee attributes, which includes name, IC number, and salary details, are encapsulated within their respective classes. This ensures data security and gives control over how attributes are accessed or modified.
- 💾 Persistent Storage
    - Staff information is loaded from and saved to text files, ensuring data persists across sessions. This provides reliable data management even after system restarts.


## Account Credentials

- Admin Credentials
   - **Email:** `admin`
   - **Password:** `admin1234`

- Staff Credentials
    - Full-time Staff
        - **Email:** `ali@hotmail.com`
        - **Password:** `okok`

    - Part-time Staff
        - **Email:** `akao@gmail.com`
        - **Password:** `123`
## Run Locally

Clone the project

```bash
  git clone https://github.com/zhon12345/Employee-Management-Module.git
```

Go to the project directory

```bash
  cd Employee-Management-Module/src
```

Compile `main.java`

```bash
  javac Main.java
```

Start the program

```bash
  java Main
```
## Appendix

- **Setting up a Java Development Kit (JDK):**

  1. Download and install [Eclipse Temurin](https://adoptium.net/temurin/releases/?package=jdk/).

  2. **Verify Installation:**
  Open a terminal and run the following command:
  ```bash
    java -version
  ```

- **Online compilers or an IDEs:**

  - Online compilers: [Replit](https://replit.com/), [OnlineGDB](https://www.onlinegdb.com/)

  - IDEs: [NetBeans](https://netbeans.apache.org/front/main/download/), [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
