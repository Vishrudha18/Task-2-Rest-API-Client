# Task-2-Rest-API-Client

# Java REST API Client – Weather Application

## 📌 Project Overview
This project is a **Java-based REST API Client** that consumes a **public REST API** to fetch **real-time weather data** and displays it in a **structured, readable format**.

The application takes the **city name as user input**, sends an HTTP request to the OpenWeatherMap API, parses the JSON response, and prints weather details such as temperature, humidity, and condition.

---

## 🎯 Objectives
- Consume a public REST API using Java
- Handle HTTP GET requests
- Parse JSON responses
- Display data in a structured format
- Accept dynamic input from the user

---

## 🛠 Technologies Used
- Java (JDK 11 or higher)
- OpenWeatherMap REST API
- `HttpURLConnection`
- `org.json` library for JSON parsing
- VS Code / Any Java IDE

---

## 📂 Project Structure
CODTECH-IT-INTERNSHIP-TASK-2/
│
├── .vscode/
│   └── settings.json
├── bin/
│   ├── Task2_Weather.class
├── lib/
│   └── json-20251224.jar
├── src/
│   ├── Task2_Weather.java
├── sample.txt
└── README.md

---

## 🌐 Public API Used
**OpenWeatherMap API**

Endpoint:
https://api.openweathermap.org/data/2.5/weather

---

## 🔑 API Key Setup
1. Create an account at https://openweathermap.org/
2. Generate an API key from **My API Keys**
3. Replace the placeholder in the code:
String apiKey = "YOUR_API_KEY";

---

## 🧪 Sample Input
Enter city name: Chennai

## 📤 Sample Output
----- Weather Report -----
City        : Chennai
Temperature : 27.8 °C
Humidity    : 63 %
Condition   : haze

## ⚙️Project Overflow

1.	User enters the city name
2.	Application constructs the API URL
3.	Sends an HTTP GET request
4.	Receives the JSON response
5.	Parses JSON using the org.json library
6.	Displays weather data in a structured format

## 📝Conclusion

This project demonstrates the use of REST APIs in Java, including HTTP request handling, JSON parsing, and user input processing, fulfilling the requirements of TASK 2: REST API Client.

