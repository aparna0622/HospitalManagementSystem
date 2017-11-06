    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Doctors List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Doctor Id</th><th>PatientId</th><th>Appointment Date</th><th>VisitNotes</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="appt" items="${list}"> 
    <tr>
    <td>${appt.doctorId}</td>
    <td>${appt.doctorName}</td>
    <td>${doc.speciality}</td>
    <td>
    	<a href="viewdoctorappointment/${doc.doctorId}">Click here</a>
    </td>
    <td><a href="editdoctor/${doc.doctorId}">Edit</a></td>
    <td><a href="deletedoc/${doc.doctorId}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="docform">Add New Doctor</a>