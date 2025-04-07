🎟️ TicketBooking App

This is a real-time Ticket Booking System built with Spring Boot and Angular, demonstrating the classical Producer-Consumer problem using multithreading. The system simulates a ticketing platform where vendors (producers) release tickets, and customers (consumers) book them concurrently.

🔧 Tech Stack
Backend: Spring Boot
Frontend: Angular, HTML, CSS, Bootstrap
Real-time Communication: WebSockets
Concurrency: Java Multithreading (Producer-Consumer pattern)


🖥️ Features
Two distinct user interfaces:
Vendor Page: For ticket release
Customer Page: For ticket booking
Real-time updates using WebSockets
Thread-safe operations to maintain data consistency
Demonstrates concurrency control and synchronization
Minimal UI using Bootstrap for simplicity and responsiveness



🧠 Core Concept
The application models the Producer-Consumer problem:

Vendors act as producers by releasing tickets
Customers act as consumers by booking available tickets
Ensures synchronization to avoid race conditions and data corruption
