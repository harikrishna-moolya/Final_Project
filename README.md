# FINAL PROJECT - E2E TEST FRAMEWORK

FINAL PROJECT - E2E TEST FRAMEWORK is a hybrid **UI + API + Integration + E2E automation framework** built using:

- **Java**
- **Selenium WebDriver**
- **Rest-Assured**
- **Cucumber BDD**
- **TestNG**
- **Maven**

It supports complete end-to-end validation of e-commerce workflows including API validation, UI flows, and cross-layer integration tests.

The framework follows industry-standard best practices such as:

✔ Cucumber BDD  
✔ Page Object Model (POM)  
✔ API action layer  
✔ Clean separation of concerns  
✔ Reusable hooks and utilities  
✔ Modular multi-runner architecture  

---

#  1. Overview

This project automates:

### **UI Scenarios**
- Login flow  
- Product listing  
- Add to cart  
- Checkout  
- End-to-end purchase  

### **API Scenarios**
- User API  
- Products API  
- Brands API  
- Account API  

### **Integration Scenarios**
- API + UI combined flows  
- Data validation across layers  
- Search and user verification flows  

### **End-to-End Scenarios**
- Multi-product checkout  
- Guest checkout  
- Failed login blocking checkout  

The framework is **modular, scalable, and CI/CD-ready**.

---

#  2. Technology Stack

| Category | Technology |
|---------|------------|
| Programming Language | Java |
| UI Automation | Selenium WebDriver |
| API Automation | Rest-Assured |
| BDD Framework | Cucumber |
| Test Runner | TestNG |
| Build Tool | Maven |
| Logging | Log4j2 |
| Design Pattern | Page Object Model |
| Test Data | Feature files + Config properties |
| IDE | IntelliJ IDEA / Eclipse |

---

# 📁 3. Project Structure

```
FINAL_PROJECT
│
├── .idea
├── .mvn
├── logs
├── pom.xml
├── testng.xml
├── log4j2.xml
├── .gitignore
│
├── src
│   ├── main
│   │   └── java
│   │       └── (reserved for future expansion)
│   │
│   └── resources
│       ├── features
│       │   ├── api
│       │   │   ├── Account.feature
│       │   │   ├── Brands.feature
│       │   │   ├── Products.feature
│       │   │   └── User.feature
│       │
│       │   ├── e2e
│       │   │   ├── e2e.feature
│       │   │   ├── E2E_02_Guest_Checkout_Requires_Login.feature
│       │   │   ├── E2E_03_Login_Failure_Blocks_Checkout.feature
│       │   │   ├── E2E_05_MultiProduct_Checkout_LoginRequired.feature
│       │   │   └── E2E_Login_Checkout.feature
│       │
│       │   ├── integration
│       │   │   ├── Integration_Login_API_UI.feature
│       │   │   ├── Integration_Search.feature
│       │   │   ├── Integration_UI_API_1.feature
│       │   │   ├── Integration_UserDeletion.feature
│       │   │   └── Integration_UserValidation.feature
│       │
│       │   └── ui
│       │       ├── CartUI.feature
│       │       ├── CheckoutUI.feature
│       │       ├── EndToEndUI.feature
│       │       ├── LoginUI.feature
│       │       └── ProductsUI.feature
│       │
│       ├── config.properties
│       └── log4j2.xml
│
└── src
    └── test
        └── java
            ├── api_actions
            │   ├── AccountAPI
            │   ├── ProductAPI
            │   └── UserAPI
            │
            ├── base
            │   ├── BaseTest
            │   ├── ConfigReader
            │   └── RequestSpec
            │
            ├── hooks
            │   ├── ApiSetup
            │   └── Hooks
            │
            ├── utils
            │   └── LoggerClass
            │
            ├── runner
            │   ├── E2ETestRunner
            │   ├── IntegrationTestRunner
            │   ├── TestRunner
            │   └── UiRunner
            │
            ├── steps
            │   ├── api
            │   │   ├── AccountSteps
            │   │   ├── CommonSteps
            │   │   ├── ProductsSteps
            │   │   └── UserSteps
            │   │
            │   └── ui
            │       ├── CartUISteps
            │       ├── CartVerificationSteps
            │       ├── CheckoutUISteps
            │       ├── LoginUISteps
            │       └── ProductsUISteps
            │
            └── ui
                ├── driver
                │   └── DriverFactory
                │
                ├── hooks
                │   └── UIHooks
                │
                └── pages
                    ├── CartPage
                    ├── CheckoutPage
                    ├── LoginPage
                    └── ProductsPage
```

---

# 🔧 4. Prerequisites

- Java JDK 17+  
- Maven 3.8+  
- Chrome (latest)  
- IntelliJ IDEA or Eclipse  
- Stable internet  

Verify:

```bash
java -version
mvn -version
```

---

# ⚙️ 5. Setup Instructions

### Clone Repo
```bash
git clone https://github.com/harikrishna-moolya/SDET-Training-Hari_Krishna.git
cd "FINAL PROJECT - E2E TEST FRAMEWORK"
```

### Install Dependencies
```bash
mvn clean install
```

### Import into IDE
File → Open → Select project folder  

---

#  6. Running Tests

### Run All Tests
```bash
mvn test
```

### Run Only UI Tests
```bash
mvn test -Dcucumber.filter.tags="@ui"
```

### Run Only API Tests
```bash
mvn test -Dcucumber.filter.tags="@api"
```

### Run E2E Tests
```bash
mvn test -Dcucumber.filter.tags="@e2e"
```

### Use Specific Runner
```bash
mvn test -Dtest=UiRunner
```

---

#  7. Framework Highlights

- Hybrid UI + API design  
- Cucumber BDD  
- Page Object Model  
- Modular api_actions layer  
- Reusable hooks  
- Multiple runners  
- Log4j2 logging  
- Central config management  

---

#  8. Future Enhancements

- Cucumber Reporting  
- Parallel Execution  
- CI/CD with GitHub Actions  
- API Schema Validation  
 

---

