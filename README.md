# Job Desk Full Stack Application

Job Desk is a full stack job post management application. It provides a React frontend for creating, viewing, searching, editing, and deleting job posts, backed by a Spring Boot REST API and MySQL database.

The project is organized as a Docker-ready full stack application with separate backend and frontend services.

## Features

- View all job posts
- Search job posts by keyword
- Create new job posts
- Edit existing job posts
- Delete job posts
- Persist job data in MySQL
- Run the full application with Docker Compose

## Tech Stack

| Layer | Technology |
| --- | --- |
| Frontend | React 18, React Router, Material UI, Axios |
| Backend | Java 21, Spring Boot 3.5.3, Spring Web, Spring Data JPA |
| Database | MySQL |
| Build Tools | Maven, npm |
| Deployment | Docker, Docker Compose |

## Project Structure

```text
job-desk-full-stack/
  backend/                 Spring Boot REST API
  frontend/                React user interface
  docker-compose.yml       Docker Compose services
  .env                     Local Docker environment values
  .env.example             Safe environment template

job-desk-full-stack/backend/src/main/java/com/MG/Spring_Boot_REST/
  controller/              REST API controllers
  model/                   JPA/domain models
  repository/              Spring Data repositories
  service/                 Business logic services

job-desk-full-stack/frontend/src/components/
  JobPostsList.jsx         Job post listing, search, edit/delete actions
  CreateJobPost.jsx        Create job post form
  EditJobPost.jsx          Edit job post form
  Navbar.jsx               Application navigation
```

## Backend API

The backend runs on port `8080` by default.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/jobPosts` | Get all job posts |
| `GET` | `/jobPost/{JobId}` | Get a single job post |
| `POST` | `/jobPost` | Create a job post |
| `PUT` | `/jobPost` | Update a job post |
| `DELETE` | `/jobPost/{PostId}` | Delete a job post |
| `GET` | `/load` | Load sample job posts |
| `GET` | `/jobPosts/keyword/{keyword}` | Search job posts |

## Environment Variables

Docker Compose reads local values from `job-desk-full-stack/.env`.

Use `job-desk-full-stack/.env.example` as the template when setting up the project on another machine.

```env
MYSQL_DATABASE=jobdesk
MYSQL_ROOT_PASSWORD=root
MYSQL_USER=jobdesk
MYSQL_PASSWORD=jobdesk

MYSQL_HOST_PORT=3307
MYSQL_CONTAINER_PORT=3306
BACKEND_PORT=8080
FRONTEND_PORT=3000
```

Important note: `.env` is ignored by Git because it can contain local credentials. Commit `.env.example`, not `.env`.

## Docker Services

`docker-compose.yml` starts three services:

| Service | Container | Port |
| --- | --- | --- |
| MySQL | `jobdeskmysql` | `3307:3306` |
| Backend | `jobdesk-backend` | `8080:8080` |
| Frontend | `jobdesk-frontend` | `3000:3000` |

Inside Docker, the backend connects to MySQL using the Compose service name:

```text
jdbc:mysql://jobdeskmysql:3306/jobdesk
```

## Prerequisites

Install these tools before running the project:

- Docker and Docker Compose
- Java 21 for local backend development
- Maven for local backend builds
- Node.js and npm for local frontend development

Docker is the recommended way to run the complete application.

## How To Run With Docker

1. Open the project folder:

```bash
cd job-desk-full-stack
```

2. Check or create the `.env` file:

```bash
cp .env.example .env
```

If `.env` already exists, you can keep it.

3. Start all services:

```bash
docker compose up --build
```

4. Open the application:

```text
Frontend: http://localhost:3000
Backend:  http://localhost:8080
MySQL:    localhost:3307
```

5. Load sample data:

```text
http://localhost:8080/load
```

6. Stop the application:

```bash
docker compose down
```

7. Stop the application and remove the database volume:

```bash
docker compose down -v
```

Use `down -v` only when you want to delete persisted MySQL data.

## How To Run Backend Locally

Start MySQL first, then run:

```bash
cd job-desk-full-stack/backend
mvn spring-boot:run
```

Build the backend JAR:

```bash
mvn clean package
```

Run the generated JAR:

```bash
java -jar target/job-desk-backend-0.0.1-SNAPSHOT.jar
```

If your machine has Java 17 but the project is still configured for Java 21, use Java 21 for the cleanest setup.

## How To Run Frontend Locally

```bash
cd job-desk-full-stack/frontend
npm install
npm start
```

The frontend will run at:

```text
http://localhost:3000
```

Build the frontend:

```bash
npm run build
```

## Useful Commands

Validate Docker Compose configuration:

```bash
cd job-desk-full-stack
docker compose config
```

View running containers:

```bash
docker compose ps
```

View logs:

```bash
docker compose logs -f
```

Rebuild only the backend:

```bash
docker compose build jobdesk-backend
```

Rebuild only the frontend:

```bash
docker compose build jobdesk-frontend
```

## Notes

- The backend uses environment variables from Docker Compose when running in containers.
- Local backend defaults are defined in `backend/src/main/resources/application.properties`.
- MySQL data is stored in the Docker volume named `db_data`.
- Generated folders such as `target/`, `build/`, and `node_modules/` are ignored by Git.
