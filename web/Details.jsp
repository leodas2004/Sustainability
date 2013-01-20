<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
	<head>
		<title>Savings</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' />
		<link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css' />
		<link href="default.css" rel="stylesheet" type="text/css" media="all" />	
	</head>
	<body>
        <center><h3> welcome <%=session.getAttribute("user")%><br/>
            Logged in as <%=session.getAttribute("role")%><br/></h3>
        </center><div id="menu1">
		<ul>
			<li ><a href="Savings.html" accesskey="1" title="">Savings</a></li>
			<li><a href="Revenue.html" accesskey="2" title="">Revenue</a></li>
			<li><a href="Reports.html" accesskey="3" title="">Reports</a></li>
			<li><a href="Admin.html" accesskey="4" title="">Administrator</a></li>
			<li><a href="Logout.jsp" accesskey="5" title="">Logout</a></li>
		</ul>
		</div>
		
	</body>
</html>
