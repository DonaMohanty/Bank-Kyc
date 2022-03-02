<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype Html>
<Html>
<Head>
<Title>Edit Customer</Title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	padding: 25px;
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
<style>
.sidenav {
	width: 400px;
	height: 680px;
	position: fixed;
	z-index: 1;
	top: 65px;
	left: 10px;
	background: #7a8282;
	overflow-x: hidden;
	padding: 8px 0;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	text-align: center;
	font-size: 25px;
	color: black;
	display: block;
}

.sidenav strong {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	text-align: center;
	font-size: 25px;
	color: black;
	display: block;
}

.sidenav b {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	text-align: center;
	font-size: 20px;
	color: #2196F3;
	display: block;
}

.sidenav a:hover {
	color: #064579;
}

.main {
	margin-left: 400px;
	/* Same width as the sidebar + left position in px */
	font-size: 20px; /* Increased text to enable scrolling */
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
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
<c:forEach var="customer" items="${listCustomer}">
	<header>
		<nav>
			<ul>
				<li><a href="../home"> Home </a></li>
				<h1>|</h1>
				<li><a href="logout"> Logout </a></li>
				<strong> ABC BANK</strong>
				<p>Welcome ${username}</p>
			</ul>
		</nav>
	</header>
	<div class="sidenav">
		<a href="#about">Customer Profile</a> <br> <a href="../kycinfo">KYC
			INFORMATION</a><br> <br> <br> <br> <br> <br>
		<strong>CUSTOMER ID</strong> <b>${customer.customerid}</b> <strong>KYC STATUS</strong>
		<b>${customer.kycstatus}</b>
	</div>
	<div class="main">
		 <form action="../update" method="post">
			<div class="container">
				<hr>
				<input type="hidden" name="customerid" value ="${customer.customerid}" size="15" required ></input><br><br> 
				<label> Firstname </label> 
				<input type="text" name="firstname"placeholder="Firstname" value ="${customer.firstname}" size="15" required ></input><br><br> 
				
				<label> Lastname: </label> 
				<input type="text" name="lastname" placeholder="Lastname" value ="${customer.lastname}" size="15"  required /> <br><br>
				
				<div>
				<label>Gender</label>
					<input type="radio" name="gender" value="Male" label="Male" />
					<label>Male</label>
					<input type="radio" name="gender" value="Female" label="Female" />
					<label>Female</label>
				</div><br><br> 
				
				<label>Date Of Birth:</label> 
				<input type="date" id="dob" name="dob" value ="${customer.dob}"/><br> 
				
				<label> Address : </label>
				<textarea cols="50" rows="3" name="address" placeholder="Current Address" value ="${customer.address}" required ></textarea>
				<br>
				
				<br> <label><b>City</b></label>
				 <input type="text" placeholder="Enter City" name="city" value ="${customer.city}" required /> <br>
				 
				<br> <label><b>State</b></label> 
				<input type="text" placeholder="Enter State" name="state" value ="${customer.state}" required /> <br>
				
				<br> <label><b>Country</b></label> 
				<input type="text" placeholder="Enter Country" name="country" value ="${customer.country}" required /> <br>
				
				<br> <label ><b>Postal Code</b></label> 
				
				<input type="number" placeholder="Enter Postal Code" name="postalcode" value ="${customer.postalcode}" required />
				<br>
				
				</div>
				<button type="submit" class="registerbtn">Submit</button>
		</form>
	</div>
	</c:forEach>	
</Body>
</Html>