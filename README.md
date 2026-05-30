## Finance Tracker API (Spring Boot + JWT)

A secure backend application built using Spring Boot that provides user authentication and protected APIs using JWT (JSON Web Token).

---

🧠 Features

- 🔐 User Registration & Login
- 🔑 Password Encryption using BCrypt
- 🪪 JWT Token-based Authentication
- 🚫 Secure APIs (only accessible with token)
- ⚡ RESTful API Design

---

🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (jjwt)
- Maven
- MySQL / H2 (based on your setup)

---


## 📁 Project Structure
```text

src/
 ├── config/          # Security Configuration
 ├── controller/      # API Controllers
 ├── service/         # Business Logic
 ├── repository/      # Database Layer
 ├── model/           # Entities
 ├── security/        # JWT Utils & Filter

---

 Authentication Flow

1. User registers
2. User logs in
3. Server returns JWT token
4. Client sends token in headers
5. Backend validates token for each request

---

API Endpoints

🟢 Public APIs

Method| Endpoint| Description
POST| "/api/users/register"| Register new user
POST| "/api/users/login"| Login and get token

---

Protected APIs

Method| Endpoint| Description
GET| "/api/blogs"| Get all blogs
POST| "/api/blogs"| Create blog

👉 Requires Header:

Authorization: Bearer <your_token>

---

Example Login Request

{
  "email": "test@example.com",
  "password": "123456"
}

---

 Example Response

eyJhbGciOiJIUzI1NiJ9...

---

Setup Instructions

1. Clone repository

git clone https://github.com/your-username/your-repo.git

2. Navigate to project

cd your-repo

3. Run application

mvn spring-boot:run

---


---

🚀 Future Improvements

- Role-based authentication (ADMIN / USER)
- Refresh tokens
- Swagger API documentation
- Docker deployment

---

👨‍💻 Author

Amit Mourya
Aspiring Backend Developer 🚀

---

⭐ If you like this project

Give it a ⭐ on GitHub!
