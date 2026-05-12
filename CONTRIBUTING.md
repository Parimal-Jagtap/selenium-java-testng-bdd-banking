# Contributing Guidelines

## Framework Structure Rules

### Where to add things:
New page?         → src/test/java/pages/
New step defs?    → src/test/java/stepDefinitions/
New feature?      → src/test/resources/features/
New test data?    → test-data/test-data.json
New utility?      → src/test/java/utils/

## Commit Message Format
feat: add TransferPage POM for RTGS module
fix: resolve StaleElementException in TransferSteps
test: add negative test for insufficient balance
docs: update README with Jenkins setup steps
refactor: extract duplicate wait logic to BaseTest
ci: update GitHub Actions to Java 17

## BDD Feature File Rules

- One feature file per module
- Scenario names must be clear business language
- No technical terms in feature files
- Use Background for repeated Given steps
- Use Scenario Outline for data-driven cases
- Tag every scenario with @smoke or @regression

## Page Object Rules

- All locators defined as private final By
- No Thread.sleep() — use WebDriverWait only
- Every public method has a JavaDoc comment
- Constructor always initializes WebDriverWait
