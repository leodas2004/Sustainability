<%@page import="DAO.CategoryDAO"%>
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
        <script>
            function load()
            {
                if(document.getElementById("rad1").checked)
                {
                    document.saving.amount.disabled=true;
                    alert("Saving amount disabled");
                }
                else
                {
                    document.saving.amount.disabled=false;
                    document.getElementById("amount").value="";
                    alert("Saving amount enabled")
                }
				
            }
            function init()
            {
                document.saving.amount.disabled=true;
            }
            
            function change()
            {
                var sav=document.getElementById("quantity");
                document.getElementById("amount").value=sav.value*52.5;
                
            }
			
        </script>
    </head>
    <body onload="init()">
        <form action="Savings.html" id="saving" name="saving">
            <div id="menu1">
                <ul>
                    <li class="current_page_item"><a href="Savings.jsp" accesskey="1" title="">Savings</a></li>
                    <li><a href="Revenue.jsp" accesskey="2" title="">Revenue</a></li>
                    <li><a href="Reports.jsp" accesskey="3" title="">Reports</a></li>
                    <li><a href="Admin.jsp" accesskey="4" title="">Administrator</a></li>
                    <li><a href="Logout.jsp" accesskey="5" title="">Logout</a></li>
                </ul>
            </div>
            <div id="context">
                <div id="legend">
                    <fieldset>
                        <legend>Select Type of Saving</legend>
                        <input type="radio" name="saving" id="rad1" value="saving" checked="checked" onclick="load()"/>Diversion 
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="saving" id="rad2" value="" onclick="load()"/>Production
                    </fieldset>
                    <br/>
                    <fieldset>
                        <legend>Record the Values</legend>
                        <table border="0" cellspacing="15">
                            <tbody>
                                <tr>
                                    <td>Select Category</td>
                                    <td>Enter Quantity</td>
                                    <td></td>
                                    <td></td>
                                    <td>Saving Amount</td>
                                </tr>
                                <tr>
                                    <td><select name="category">
       <!-- Loading the data into the drop down list from the database--> 
                                            <%
                                                CategoryDAO category = new CategoryDAO();
                                                for (int i = 0; i < category.getCategoryList().size(); i++)
                                                  {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                        <td><input type="text" id="quantity" value="" onkeyup="change()"/></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" id="amount" value="" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>

                    <br/>
                    <table border="0" class="button" cellspacing="20">
                        <tbody>
                            <tr>
                                <td><input type="submit" value="Submit" name="submit" class="button-style"/></td>
                                <td><input type="reset" value="Clear" name="clear" class="button-style"/></td>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>
