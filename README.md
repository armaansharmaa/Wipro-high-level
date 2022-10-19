# Project
This is a demo application for person


API 

use case 1 : http://localhost:8080/api/person/ared

Response : 

{
"statusCode": 404,
"timestamp": "2022-07-14T08:12:33.584+00:00",
"message": "Pass the valid person id. Should contains only numeric.",
"description": "uri=/api/person/ared"
}

usecase 2 :
http://localhost:8080/api/person/1
Response :
{
"id": 1,
"firstName": "Wipro",
"lastName": "Bangalore",
"middleName": "Electronic City",
"email": "wiprobgl@wipro.com",
"street": "street",
"city": "city",
"state": "state",
"country": "country",
"pincode": "560123",
"employerName": "Employer",
"employerId": "EMP123",
"employerStreet": "EMPStreet",
"employerCity": "EMPCity",
"employerState": "EMPSTate",
"employerCountry": "EMPCountry",
"employerPincode": "147852"
}