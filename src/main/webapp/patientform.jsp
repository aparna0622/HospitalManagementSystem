<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Patient</h1>
       <form:form method="post" action="/savepatient">  
      	<table >  
         <tr>  
          <td>Patient First Name : </td> 
          <td><form:input path="patientFirstName"/></td>
         </tr>  
         <tr>  
          <td>Patient Last Name : </td> 
          <td><form:input path="patientLastName"  /></td>
         </tr>  
         <tr>  
          <td>Patient Age : </td> 
          <td><form:input path="age"  /></td>
         </tr>
         <tr>  
          <td>Patient email : </td> 
          <td><form:input path="eMail"/></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
