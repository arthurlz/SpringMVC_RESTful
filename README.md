### A tiny small show case to demonstrate how to develop a restful api using springmvc.
---
### Run this project
1. Clone the source.
```
git clone https://github.com/loveppears/SpringMVC_RESTful.git
```

2. Enter source code, run ```mvn tomcat7:run``` tomcat maven plugin to start the project.
```
mvn tomcat7:run
```

3.Visit [http://localhost:8080/Restful/employee](http://localhost:8080/Restful/employee) to retrieve the data.
#### Get a specific data. 
[http://localhost:8080/Restful/employee/1](http://localhost:8080/Restful/employee/1) It will return ```{"id":1,"name":"Beckett","age":38,"salary":150000.0,"gender":"Male"}```

#### Update an employee.
Using the http verb ```PUT``` to update by ID [http://localhost:8080/Restful/employee/1](http://localhost:8080/Restful/employee/1)

#### Delete an employee.
Using the http verb ```DELETE``` to delete by ID [http://localhost:8080/Restful/employee/1](http://localhost:8080/Restful/employee/1) 

#### Create an new employee
Using the http ver ```POST``` to create a new one, I strongly recommend you to test restful requests on [Postman](https://www.getpostman.com/) .SO you can set the http header ```Content-Type = application/json```to create.


---
I'll soon update the source with populating those data into database by JPA.
To be continued...