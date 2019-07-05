# Test task

## Step-by-step instruction

1. Create images for all projects (use command ```mvn clean install docker:build``` from projects root directories)
2. Run ```docker-compose up``` command to start docker containers
3. To create credit/customer/product you should send request to credit/CreateCredit endpoint ```localhost:8081/credit/CreateCredit```
4. Use following json to create credit:
```
{
  "creditDto":{
    "nameCredit":"Test Credit Name1"
  },
  "customer":{
    "firstNameCustomer":"Test First Name1",
    "lastNameCustomer":"Test Last Name1",
    "peselCustomer":"TestPesel1"
  },
  "product":{
    "productName":"Test Product Name1",
    "value":116
  }
}
```
5. To get all details (credit/customer/product) you should send request to endpoint: ```localhost:8081/credit/GetCredits```
6. You can use postman collection located in root.
