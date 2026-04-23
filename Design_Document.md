## Test Framework Design

### Framework Type
Page Object Model (POM)

---

## Features

- Config-driven execution using `config.properties`
- Data-driven testing using TestNG `@DataProvider`
- Reusable Page classes for all modules (POM design)
- FluentWait/WebDriverWait for handling dynamic elements
- Screenshot capture on failure using TestNG Listener
- ExtentReports for HTML reporting
- WebDriverManager for automatic driver setup
- Clean separation of Page, Test, and Utility layers

---

# Project Structure
```
NinjaShop
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   ├── com.srm.pages
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── DriverFactory.java
│   │   ├── WaitUtil.java
│   │   ├── ScreenshotUtil.java
│   │   └── ExtentManager.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   └── com.srm.tests
│       ├── LoginTest.java
│       ├── RegisterTest.java
│       ├── ProductTest.java
│       ├── CartTest.java
│       ├── CheckoutTest.java
│       └── ValidationTest.java
│
├── screenshots
├── reports
├── testng.xml
├── pom.xml

```

## Test Coverage

- User Authentication (Login, Logout, Registration)
- Product Search and Category Navigation
- Product Detail Verification (name, price)
- Shopping Cart Operations (Add, Update, Remove)
- Cart Count Validation (increase/decrease)
- Checkout Flow (basic validation)
- Form Validations (empty fields, invalid inputs)

---

## Tools & Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- ExtentReports
