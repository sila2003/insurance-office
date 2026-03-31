Insurance Office

Simple Java console application for managing vehicle insurance policies.

Description
This project simulates a small insurance office system.  
It allows storing policies, calculating premiums, and generating reports based on business rules.

The goal of the project is to demonstrate object-oriented programming concepts in Java.


Project Structure
Policy
Represents a single insurance policy.

Main fields:**
- policy number
- client name
- base premium
- risk level
- vehicle value
- alarm information
- claim-free status

Main methods:
- `calculateFinalPremium()`
- `calculateRenewalPremium()`
- `getRiskSummary()`
- overridden `equals()` and `toString()`


InsuranceOffice
Manages a list of policies using `ArrayList<Policy>`.

Main methods:
- `addPolicy()`
- `printReport()`
- `calculateTotalPremium()`
- `calculateTotalRenewalForecast()`
- `countHighRiskPolicies()`
- `findByNumber()`
- `printCheaperThan()`

 Features
- Object-oriented design
- Business logic inside class methods
- Use of `ArrayList`
- Premium calculation based on multiple conditions
- Renewal premium forecast
- Static field and static method
- Object comparison using `equals()`
- Readable output using `toString()`


 Business Logic Overview
The premium is calculated based on several conditions:
- base premium + administrative fee
- additional cost depending on risk level
- extra charge for expensive vehicles
- discount for alarm system
- discount for claim-free clients
- minimum threshold applied

Renewal premium includes:
- risk-based increase
- additional charges
- discounts
- minimum and maximum limits


 How to Run
1. Open the project in IntelliJ IDEA
2. Run the `Main` class
3. The program will display:
   - policy report
   - total premium
   - renewal forecast
   - additional statistics


## 👤 Author
sila2003
