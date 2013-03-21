<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' />
		<link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css' />
		<link href="default.css" rel="stylesheet" type="text/css" media="all" />
		<script type="text/javascript" src="datepickr.js"></script>
		<style type="text/css">
			
			.calendar {
				font-family: 'Trebuchet MS', Tahoma, Verdana, Arial, sans-serif;
				font-size: 0.9em;
				background-color: #EEE;
				color: #333;
				border: 1px solid #DDD;
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
				padding: 0.2em;
				width: 14em;
			}
			
			.calendar a {
				outline: none;
			}
			
			.calendar .months {
				background-color: #F6AF3A;
				border: 1px solid #E78F08;
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
				color: #FFF;
				padding: 0.2em;
				text-align: center;
			}
			
			.calendar .prev-month,
			.calendar .next-month {
				padding: 0;
			}
			
			.calendar .prev-month {
				float: left;
			}
			
			.calendar .next-month {
				float: right;
			}
			
			.calendar .current-month {
				margin: 0 auto;
			}
			
			.calendar .months a {
				color: #FFF;
				text-decoration: none;
				padding: 0 0.4em;
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
			}
			
			.calendar .months a:hover {
				background-color: #FDF5CE;
				color: #C77405;
			}
			
			.calendar table {
				border-collapse: collapse;
				padding: 0;
				font-size: 0.8em;
				width: 100%;
			}
			
			.calendar th {
				text-align: center;
			}
			
			.calendar td {
				text-align: right;
				padding: 1px;
				width: 14.3%;
			}
			
			.calendar td a {
				display: block;
				color: #1C94C4;
				background-color: #F6F6F6;
				border: 1px solid #CCC;
				text-decoration: none;
				padding: 0.2em;
			}
			
			.calendar td a:hover {
				color: #C77405;
				background-color: #FDF5CE;
				border: 1px solid #FBCB09;
			}
			
			.calendar td.today a {
				background-color: #FFF0A5;
				border: 1px solid #FED22F;
				color: #363636;
			}
			
		</style>
	</head>
	<body>
		<form action="ReportResults.html">
		<div id="menu1">
		<ul>
			<li ><a href="Savings.jsp" accesskey="1" title="">Savings</a></li>
			<li><a href="Revenue.jsp" accesskey="2" title="">Revenue</a></li>
			<li class="current_page_item"><a href="Reports.jsp" accesskey="3" title="">Reports</a></li>
			<li><a href="Admin.jsp" accesskey="4" title="">Administrator</a></li>
			<li><a href="Logout.jsp" accesskey="5" title="">Logout</a></li>
		</ul>
		</div>
		<div id="context">
			<div id="legend">
				<fieldset>
					<legend>Select the Type of Report</legend>
						<input type="radio" name="report" value="" checked="checked" />
						Savings Report
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="report" value="" />
						Revenue Report
				</fieldset>
			<br/><br/>
			
			<fieldset>
				<legend>Date Range</legend>
				
					Initial Date <input id="datepick1" class="date-pick" />
					<script type="text/javascript">
						new datepickr('datepick1', { dateFormat: 'm-d-Y' });
				</script>
					
						Final Date <input id="datepick2" class="date-pick" />
				<script type="text/javascript">
						new datepickr('datepick2', { dateFormat: 'm-d-Y' });
				</script>
				
				<br/>
				<div class="button"><input type="reset" value="Reset" class="button-style"/></div>
			</fieldset>
			<br/>
			<fieldset>
				<legend>Graphical Report</legend>
				<input type="radio" name="charts" value="barChart" />BarChart&nbsp;&nbsp;
				<input type="radio" name="charts" value="pieChart" />PieChart<br/>
				<div class="button">
				<input type="submit" value="GenerateReport" name="generateReport" class="button-style"/>				
				</div>
			</fieldset>
			<br/>
			<fieldset>
				<legend>Tabular Report</legend>
				<div class="button">
				<input type="submit" value="Export to Excel" class="button-style"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="Display in Screen" class="button-style"/>
				</div>
			</fieldset>
			</div>
			<br/><br/><br/>
		</div>
	</form>	
	</body>
</html>
