<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Patient Record</h1>
       <form:form method="POST" action="/editsavepatient">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="patientId" /></td>
         </tr> 
         <tr>  
          <td>Patient First Name : </td> 
          <td><form:input path="patientFirstName"  /></td>
         </tr>  
         <tr>  
         <tr>  
          <td>Patient Last Name : </td> 
          <td><form:input path="patientLastName"  /></td>
         </tr>  
         <tr>  
          <td>Age :</td>  
          <td><form:input path="age" /></td>
         </tr> 
         <tr>  
          <td>EMail :</td>  
          <td><form:input path="eMail" /></td>
         </tr> 
                
                  
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
