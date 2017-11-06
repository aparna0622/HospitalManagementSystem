    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Patients List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Patient Id</th><th>First Name</th><th>LastName</th><th>age</th><th>email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="patient" items="${list}"> 
    <tr>
    <td>${patient.patientId}</td>
    <td>${patient.patientFirstName}</td>
    <td>${patient.patientLastName}</td>
    <td>${patient.age}</td>
    <td>${patient.eMail}</td>
    
    
    <td><a href="editpatient/${patient.patientId}">Edit</a></td>
    <td><a href="deletepatient/${patient.patientId}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="patientform">Add New Patient</a>