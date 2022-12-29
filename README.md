# Electricity Billing System

# Technologies:

1. Spring Boot
2. AWS S3
3. PostgreSQL (AWS)

# Main Controllers
1. Admin
2. Customer
3. Property
4. Bill

# Database
1. Address
2. Meter Reading
3. Bill
4. Customer
5. Property

# Address
1. id
2. state
3. county
4. town

# Meter Reading
1. id
2. meterReading
3. date ["January", "February", "March", "April]

# Bill
1. id
2. reading
3. date  ["January", "February", "March", "April]

# Customer
1. id
2. first_name
3. last_name
4. address_id
5. licence

# Property
1. id
2. customer_id
3. type
4. meterReading_id
5. address_id
