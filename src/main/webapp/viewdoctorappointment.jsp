    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Doctors Upcoming Appointment List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>First Name</th><th>Patient Name</th><th>Date Time </th><th>VisitNotes</th></tr>
    <c:forEach var="appt" items="${list}"> 
    
    <tr>
    <td>${appt.PatientFirstName}</td>
    <td>${appt.PatientLastName}</td>
    <td>${appt.appointmentDate}</td>
    <td>${appt.visitNotes}</td>
    
    </c:forEach>
    </table>
    <br/>
    <a href="viewalldoc">Back</a>