# 🏦 Selenium Java TestNG BDD Banking Automation Framework

> ⚠️ **Note:** This is a framework demonstration repository.
> Tests require a live banking application and environment
> configuration to execute. CI pipeline validates build
> structure and compilation only.
> End-to-end test automation framework for Banking domain  
> Built with **Selenium WebDriver (Java) + TestNG + BDD Cucumber** | CI/CD via **GitHub Actions + Jenkins**

---

## 🧱 Framework Architecture
## ⚙️ Tech Stack

| Layer | Tool |
|---|---|
| Language | Java |
| Automation Framework | Selenium WebDriver 4 |
| Test Framework | TestNG |
| BDD Framework | Cucumber |
| Build Tool | Maven |
| Reporting | Allure Reports |
| CI/CD | GitHub Actions + Jenkins |
| Version Control | Git + GitHub |

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 11+
- Maven 3.8+
- Chrome browser installed

### Installation

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/selenium-java-testng-bdd-banking.git

# Navigate to project
cd selenium-java-testng-bdd-banking
```

### Run Tests

```bash
# Run all tests
mvn test

# Run specific tag (smoke tests)
mvn test -Dcucumber.filter.tags="@smoke"

# Run regression suite
mvn test -Dcucumber.filter.tags="@regression"

# Run with specific browser
mvn test -Dbrowser=firefox

# Generate Allure report
mvn allure:serve
```

---

## 🔑 Key Framework Features

- ✅ **Page Object Model (POM)** — maintainable and reusable page classes
- ✅ **BDD Feature Files** — business-readable test scenarios in Gherkin
- ✅ **Data-Driven Testing** — JSON-based test data management
- ✅ **Cross-browser Testing** — Chrome, Firefox, Edge support
- ✅ **Parallel Execution** — TestNG parallel configuration
- ✅ **API Validation** — REST Assured for backend verification
- ✅ **Database Validation** — SQL queries for data integrity
- ✅ **Allure Reporting** — detailed reports with screenshots
- ✅ **GitHub Actions CI/CD** — automated pipeline on every push
- ✅ **Jenkins Integration** — scheduled and triggered builds

---

## 🌐 Test Coverage — Banking Modules

| Module | Coverage |
|---|---|
| Authentication | Login, logout, invalid credentials, session |
| Fund Transfer | Domestic transfer, NEFT, RTGS, IMPS |
| Account Management | View balance, statement, account details |
| Payments | Bill pay, mobile recharge, utility payments |
| API Validation | Transaction API, balance API verification |

---
---

## 👤 Author

**Parimal Jagtap** — SDET | 4+ Years  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-parimaljagtap-0A66C2?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/parimaljagtap)

## 📊 CI/CD Pipeline
