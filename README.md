# PatchPilot

PatchPilot is an autonomous software maintenance platform that detects breaking changes, analyzes affected codebases, generates tested migrations, and opens production-ready pull requests.

## High-Level Architecture

```text
                    External APIs
             (Stripe, OpenAI, AWS...)

                         │
                         ▼

                 API Monitoring Service
                    (Spring Boot)

                         │
                  Kafka Events
                         │

 ┌─────────────────────────────────────────────────────┐
 │                                                     │
 ▼                                                     ▼

Repository Scanner                           Breaking Change Detector

 │                                                     │

 └───────────────► Dependency Graph ◄──────────────────┘

                         │

                  AI Planning Service
                       (Python)

                         │

                  AI Code Generator

                         │

                 Test Execution Service

                         │

                Pull Request Generator

                         │

                Monitoring & Analytics
```

## Tech Stack

### Backend (Java / Spring Boot)

- Spring Boot
- Spring Security
- Spring Data JPA
- Spring WebFlux
- Spring AI (optional)

**Purpose**
- Orchestrating workflows
- APIs
- Authentication
- Event processing

### AI Services (Python)

- FastAPI
- LangGraph
- Pydantic
- Tree-sitter
- OpenAI-compatible models
- sentence-transformers

**Purpose**
- Code understanding
- Migration planning
- Code generation
- Embeddings

### Infrastructure

- Docker
- Kubernetes
- Helm
- GitHub Actions
- Terraform (later)

### Messaging

- Kafka

**Topics**
- `api.detected`
- `api.changed`
- `repo.scanned`
- `migration.created`
- `migration.completed`
- `test.failed`
- `pr.created`

### Databases

**PostgreSQL stores**
- Repositories
- Migrations
- API versions
- Users
- Pull requests

**Redis stores**
- Cache
- Queues
- Distributed locks
- Session state

### Frontend

- Next.js
- TypeScript
- Tailwind
- React Query
- Monaco Editor

### Observability

- Prometheus
- Grafana
- OpenTelemetry
- Loki

## Features

### 1) API Registry
Users register APIs they depend on, such as:
- OpenAI
- Stripe
- Twilio
- AWS
- GitHub

PatchPilot continuously monitors registered APIs.

### 2) API Change Monitor
Detects:
- Endpoint additions
- Endpoint removals
- Renamed fields
- Authentication changes
- SDK releases
- Version upgrades

Produces events into Kafka.

### 3) Repository Management
Users connect repositories from:
- GitHub
- GitLab

The platform indexes repositories and shows:
- Repository
- Languages
- Frameworks
- Dependencies

### 4) Dependency Graph
Visual graph of:
- Repository
- Module
- Class
- Function
- External API

This allows the AI system to identify exactly where APIs are used.

### 5) Static Code Analysis
Parses Java, Python, and TypeScript using Tree-sitter to identify:
- API calls
- Imports
- Models
- Authentication flows

### 6) AI Migration Planner
Produces:
- Summary
- Affected files
- Required changes
- Risk level
- Estimated success

### 7) AI Code Generator
Applies file edits automatically for:
- Java
- Python
- TypeScript

### 8) Test Runner
Runs:
- Maven
- Gradle
- npm
- pytest

Collects:
- Logs
- Failures
- Coverage

### 9) Retry Agent
If tests fail, the AI agent:
- Analyzes failures
- Patches code
- Reruns tests

Repeats until success or retry limit.

### 10) Pull Request Generator
Creates:
- Branch
- Commit
- Pull request
- Migration summary

### 11) Approval Workflow
Developers can:
- Approve
- Reject
- Ask AI questions
- Edit migration

### 12) Monitoring Dashboard
Shows:
- Monitored APIs
- Active migrations
- Completed migrations
- Failed migrations
- Test status
- Open PRs

## Stages of Development

### Stage 1: Foundation
**Goal**: Create the platform.

Implement:
- Monorepo
- Docker
- PostgreSQL
- Redis
- Kafka
- Kubernetes local setup
- Authentication
- Frontend shell
- Spring Boot gateway

**Deliverable**: Users can log in and register repositories.

### Stage 2: Repository Intelligence
Implement:
- GitHub OAuth
- Repository cloning
- Language detection
- Dependency detection
- Repository dashboard

**Deliverable**: Platform understands connected repositories.

### Stage 3: API Monitoring
Implement:
- OpenAPI parsing
- Swagger ingestion
- API version history
- Breaking change detection

**Deliverable**: Platform detects API updates automatically.

### Stage 4: Code Intelligence
Implement:
- Tree-sitter parsing
- AST generation
- Dependency graph
- API usage mapping

**Deliverable**: Platform knows exactly which code is affected by a breaking change.

### Stage 5: AI Planning
Implement:
- Embeddings
- Retrieval
- Migration planning
- Structured reasoning
- Risk analysis

**Deliverable**: Generate a detailed migration plan before changing code.

### Stage 6: AI Code Generation
Implement:
- File editing
- Code rewriting
- Import updates
- Model updates
- API call replacement

**Deliverable**: Generate candidate patches automatically.

### Stage 7: Validation Pipeline
Implement:
- Test execution
- Linting
- Formatting
- Retry agent
- Failure analysis

**Deliverable**: Only propose changes that pass validation.

### Stage 8: Pull Request Automation
Implement:
- GitHub branch creation
- Commits
- PR creation
- Changelog generation
- Migration summaries

**Deliverable**: A complete pull request is created without manual intervention.

### Stage 9: Observability & Operations
Implement:
- Prometheus metrics
- Grafana dashboards
- Distributed tracing
- WebSocket live updates
- Migration analytics

**Deliverable**: Users can monitor the entire migration lifecycle in real time.

### Stage 10: Autonomous Maintenance Platform
Expand beyond API migrations into broader software maintenance, including:
- Library and dependency upgrades
- Deprecated language feature detection
- Configuration file migrations
- Infrastructure-as-Code updates (Terraform, Kubernetes manifests)
- Security patch recommendations
- Automated documentation updates based on code changes

At this stage, PatchPilot evolves into an autonomous engineering assistant that continuously monitors software systems, proposes safe maintenance changes, validates them through testing, and delivers production-ready pull requests.

## Final Architecture Outcomes

By the end of development, PatchPilot demonstrates:

- Event-driven microservices using Spring Boot and Kafka
- AI orchestration through Python services for planning and code generation
- Static code analysis with AST parsing instead of simple text search
- Cloud-native deployment with Docker, Kubernetes, and Helm
- CI/CD automation through GitHub Actions
- Distributed caching and coordination with Redis
- Persistent metadata and audit history in PostgreSQL
- Real-time monitoring and tracing with Prometheus, Grafana, OpenTelemetry, and WebSockets
