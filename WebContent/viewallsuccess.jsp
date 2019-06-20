<%@include file="header.html"%>
<html>
<head>
<title>View All Contact Success page</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>View All Contacts</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<!--Body: view contact information-->
	<center>

		<%@page import="java.util.ArrayList"%>
		<%--Importing all the dependent classes--%>
		<%@page import="assign.dbaccess.EMailAddressVOO"%>
		<%@page import="java.util.Iterator"%>

		<%
		ArrayList<EMailAddressVOO> eMailList = (ArrayList<EMailAddressVOO>)request.getAttribute("emaillist");
		%>
		<%--Assigning ArrayList object containing Email address data  to the local object --%>

		<table >

			<tr>
				<th>EmailID</th>
				<th>FirstName</th>
				<th>Middlename</th>
				<th>Lastname</th>
				<th>Homephone</th>
				<th>WorkPhone</th>
				<th>Mobileno</th>
				<th>Groupid</th>
			</tr>
			
			<%
				// Iterating through subjectList

				if (request.getAttribute("emaillist") != null) // Null check for the object
				{
					for(EMailAddressVOO emaildetails:eMailList){ %>
						<tr>
						<td><%=emaildetails.geteMailID()%></td>
						<td><%=emaildetails.getfName()%></td>
						<td><%=emaildetails.getmName()%></td>
						<td><%=emaildetails.getlName()%></td>
						<td><%=emaildetails.gethPhone()%></td>
						<td><%=emaildetails.getwPhone()%></td>
						<td><%=emaildetails.getmPhone()%></td>
						<td><%=emaildetails.getgroupID()%></td>
					</tr>
					<% 
					}
					
			
			
 }

%>
		</table>


	</center>
</body>



</html>
<%@include file="footer.html"%>