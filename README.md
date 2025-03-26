# 🚀 Project Name GEN AI Integrated Platform Support Environment(IPE)

## 📌 Table of Contents
- [Introduction](#introduction)
- [Demo](#demo)
- [Inspiration](#inspiration)
- [What It Does](#what-it-does)
- [How We Built It](#how-we-built-it)
- [Challenges We Faced](#challenges-we-faced)
- [How to Run](#how-to-run)
- [Tech Stack](#tech-stack)
- [Team](#team)

---

## 🎯 Introduction
This solution provides a Contextual recommendations with related incidents and provides proactive recommendation engine mapping to related incidents.

## 🎥 Demo
🔗 [Live Demo](#) (if applicable)   
🖼️ Screenshots:
![GEN-AI-APP](https://github.com/user-attachments/assets/d0db18bb-fea2-4428-8b41-400c892ec07b)


## 💡 Inspiration
Managing IT incidents efficiently is a challenge for many organizations. Often, teams spend valuable time diagnosing recurring issues and manually finding resolutions. We wanted to leverage AI to make this process smarter and faster.
•	Frequent IT Incidents: Many organizations struggle with resolving repeated issues, leading to downtime and inefficiencies.
•	AI-Powered Automation: We saw the potential of AI-driven recommendations to predict incidents and suggest resolutions proactively.
•	Enhancing Incident Management: Traditional incident management systems focus on logging and tracking. We aimed to add predictive intelligence to improve resolution times.
•	Bridging the Gap Between Monitoring & Action: By integrating AI predictions with real-time incident reports, we help teams make informed decisions quickly.
This project is a step towards proactive incident management, reducing MTTR (Mean Time to Resolve) and improving system reliability.

## ⚙️ What It Does
Our AI-powered Incident Management System helps organizations track, analyze, and resolve IT incidents efficiently. It’s a prototype built with Hugging Face API (Mistral-7B) which helps to provide smart recommendations and proactive issue resolution.

## 🛠️ How We Built It
We developed an AI-Powered Incident Management System using a Spring Boot backend, a React frontend, and a MySQL database, integrating AI-based incident prediction.
Our system enables faster issue resolution by providing AI-driven recommendations, making IT operations more efficient & proactive.

## 🚧 Challenges We Faced
During the development of our AI-Powered Incident Management System, we encountered several challenges related to backend performance, AI integration, frontend rendering, database optimization. 
Optimized the input prompt sent to the AI model to ensure context clarity. Experimented with different models (OpenAI Llama, Hugging Face, Mistral-7B) to find the best one for IT incident prediction. Implemented preprocessing to filter unnecessary text before displaying recommendations.

## 🏃 How to Run
1. Clone the repository  
   ```sh
   git clone https://github.com/ewfx/gaipl-innovators-pe
   ```
2. Install dependencies  
   ```sh
      Ensure Java 17+ and Maven are installed.
      Update application.properties with your database credentials
      For running the backend service use below mvn command.

   mvn spring-boot:run
   ```
3. Run the frontend project using below commands  
   ```sh
   cd frontend
   npm install 
   ```
   
4. Start the React app
   npm start

5. Open in Browser
   Visit http://localhost:3000 to access the Incident Dashboard

## 🏗️ Tech Stack
- 🔹 Frontend: React 
- 🔹 Backend: Spring boot
- 🔹 Database: My SQL
- 🔹 Hugging Face API (Mistral-7B) – Used NLP models to predict incident causes & recommend resolutions.

## 👥 Team
- Shriraam M
- Kalpana J
- Aarthi K
- Saiprasad A
- Bhagyalakshmi J
