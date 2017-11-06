<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datePicker").datepicker();
  } );
  </script>

		<h1>Add Appointment Record</h1>
       <form:form method = "POST" action="/appointmentcreated">  
      	<table >  
      		<tr>
          <td>Doctor Id : </td> 
          <td><input type="text" name = "doctorId"/></td>
         </tr>
         
         <tr>
          <td>Patient Id : </td> 
          <td><input type="text" name = "patientId"/></td>
         </tr>
         
      	  <tr>
          <td>Appointment Date : </td> 
          <td><input type="text" name = "apptDate" id="datePicker"/></td>
         </tr>  
         <tr>  
         <tr>  
          <td>Visit Notes </td> 
          <td><input type="text" name = "visitNotes"/></td>
         </tr>  
         
                
                  
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
