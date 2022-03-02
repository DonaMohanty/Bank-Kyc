<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype Html>
<Html>
<Head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<Title>HOME</Title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>  
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />  
           <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type=text/css>
body {
	height: 125vh;
	margin-top: 80px;
	padding: 30px;
	background-size: cover;
	font-family: sans-serif;
}
header {
	background-color: #13afed;
	position: fixed;
	left: 0;
	right: 0;
	top: 5px;
	height: 30px;
	display: flex;
	align-items: center;
	padding:25px;
	box-shadow: 0 0 25px 0 black;
}

header * {
	display: inline;
}

header li {
	margin: 20px;
}

header strong {
	margin: 500px;
	color: white;
}

header p {
	margin: 30px;
	color: black;
}
header li a {
	color: black;
	text-decoration: none;
}
</style>
</Head>
<Body>
	 <%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("./login");
	}
	response.setHeader("cache-control", "no-cache ,no-store,must-revalidate");
	%>
	<header>
		<nav>
			<ul>
				<li><a href="./home"> Home </a></li>
				<h1>|</h1>
				<li><a href="logout"> Logout </a></li>
				<strong> ABC BANK</strong>
				<p>Welcome ${username}</p>
			</ul>
		</nav>
	</header>
	<div style="color: red">${msg}</div>
	<button style="background-color: #13afed;color: white;padding: 15px;margin-left: 1100px;" type="button"><a href="./add"> Create New Customer </a>  </button><br><br>
<!-- 	<div class="form-group">
    <div class="row">
     <div class="col-md-10">
      <input type="text" id="tags" class="form-control" data-role="tagsinput" />
     </div>
     <div class="col-md-2">
      <button type="button" name="search" class="btn btn-primary" id="search">Search</button>
     </div>
    </div>
   </div> -->  
   <br /><br /> 
	<table id="mytable" class="table" style="width:100%">
	<thead>
  <tr>
    <th>Customer Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Address</th>
    <th>City</th>
    <th>State</th>
    <th>Country</th>
    <th>KYC Status</th>
    <th></th>
  </tr>
  </thead>
  
                <c:forEach var="customer" items="${listCustomer}">
<tbody>                
  <tr>
    <td>${customer.customerid}</td>
    <td>${customer.firstname}</td>
    <td>${customer.lastname}</td>
    <td>${customer.address}</td>
    <td>${customer.city}</td>
    <td>${customer.state}</td>
    <td>${customer.country}</td>
    <td>${customer.kycstatus}</td>
    <td><button style="background-color: #13afed;color: white;padding: 10px" type="button" ><a href="update/<c:out value='${customer.customerid}'/>">Edit</a></button></td>
  </tr>
 </tbody> 
  <h4 class="error message" style="width: 900px">${errMsg}</h4>
  </c:forEach> 
</table>
</Body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript">
  $(document).ready( function () {
    $('#mytable').DataTable();
} );
</script> 
</Html>