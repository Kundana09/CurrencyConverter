# CurrencyConverter


A Spring Boot application for real-time currency conversion.

## How to Run

1. Clone the repository:
2. Set up an API key in application.properties.
3. Run the application:
4. API Endpoints:
- *Fetch Rates:* GET /api/rates?base=USD
- *Convert Currency:* POST /api/convert
  json
  {
    "from": "USD",
    "to": "EUR",
    "amount": 100
  }
  
