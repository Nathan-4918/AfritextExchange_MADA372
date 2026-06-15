# AfriText Exchange 

A student peer-to-peer textbook marketplace for Android, built to help South African higher education students buy and sell second-hand textbooks affordably.


## About the App

AfriText Exchange connects students within the same institution, allowing them to list textbooks they no longer need and browse listings from other students. The app replaces informal methods like WhatsApp groups and notice boards with a dedicated, structured mobile platform that is easy to use and built with the South African student in mind.

This project was developed as part of the **MADA372 – Mobile Application Development A** module at **STADIO School of Information Technology**.


## Screenshots

*(Add your screenshots here after taking them from the final app)*

| Home Screen | Book Detail | Search | Add Listing |



## Features

- 📖 **Textbook Browsing** — Featured and latest listings displayed on the home screen using RecyclerView
- 🔍 **Search & Filter** — Live keyword search with subject chip filters
- 📄 **Book Detail View** — Full listing information including seller, condition, edition and price
- ✉️ **Send Enquiry** — Message the seller directly from the book detail screen
- ➕ **Add Listing** — Students can list their own textbooks with full input validation
- 🧭 **Bottom Navigation** — Structured navigation between Home, Search, and Add Listing screens


## Project Structure

AfritextExchange_MADA372/
├── app/
│   └── src/main/
│       ├── java/com/nathan/afritextexchange/
│       │   ├── activities/
│       │   │   ├── SplashActivity.kt
│       │   │   ├── RegisterActivity.kt
│       │   │   ├── HomeActivity.kt
│       │   │   ├── SearchActivity.kt
│       │   │   ├── BookDetailActivity.kt
│       │   │   ├── EnquiryActivity.kt
│       │   │   └── AddListingActivity.kt
│       │   ├── adapters/
│       │   │   └── BookAdapter.kt
│       │   ├── models/
│       │   │   └── Book.kt
│       │   ├── utils/
│       │   │   └── ValidationUtils.kt
│       │   └── BookRepository.kt
│       └── res/
│           ├── layout/
│           ├── values/
│           └── menu/


## How to Run

1. Open the project in **Android Studio**

2. Let Gradle sync complete

3. Run on an emulator or physical Android device (API 24+)

> No external dependencies or API keys are required. All data is managed in-memory.


## User Journey

Splash Screen → Register → Home Screen → Search / Browse
                                       → Book Detail → Send Enquiry
                                       → Add Listing


## Deployment

- **Module:** MADA372 – Mobile Application Development A
- **Institution:** STADIO School of Information Technology
- **Student:** Nathan Van Huyssteen
- **Assessment:** SS4 – Final Submission


## Design

AfriText Exchange uses a **Pan-African inspired colour palette** throughout the interface, incorporating cultural identity into the visual design as required by the project brief.

Colour - Hex - Usage 

AfriText Gold - `#F5A623` - Toolbar title, accents 
AfriText Green - `#2E7D32` - Prices, CTAs 
AfriText Red - `#C62828` - Errors, highlights 
AfriText Earth - `#6D4C41` - Secondary elements 
AfriText Dark - `#1A1A1A` - Primary text 
