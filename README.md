# SmartCity Backend

A Spring Boot backend system for reporting and managing city infrastructure issues using AI-based classification and institutional assignment.

---

## 🚀 Tech Stack

- Java 23
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- WebClient (AI communication)
- Maven

---

## 🧱 Project Modules

- **AI Module** → Handles classification via external AI service
- **Report Module** → Core system for creating and managing reports
- **Institution Module** → Assigns reports to responsible institutions (mock system)
- **Client Layer** → External service communication (AI, Institution)
- **Config Layer** → CORS, WebClient, and application configuration
- **Exception Layer** → Global exception handling
- **Util Layer** → Helper utilities

---

## 📦 Features

- Create city issue reports
- AI-based categorization (water, electricity, road, etc.)
- Automatic institution assignment
- Mock institution integration
- REST API architecture
- Clean modular backend design

---

## ⚙️ Requirements

Before running the project:

- Java 23
- Maven
- PostgreSQL installed and running

---

## 🏗️ Start Instructions
1. run with dev profile for hot reload and development features:
   ```bash
   mvn spring-boot:run -Dspring-boot.run.profiles=dev 
   ```

## 🐘 Database Setup

### 1. Create database

```sql
CREATE DATABASE smartcity;
