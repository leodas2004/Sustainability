<%@page import="DAO.CategoryDAO"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head onload="doInit()"
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
        <script>
            function validate()
            {
                if(document.revenueForm.check.checked)
                {
                    document.revenueForm.transportCost.disabled=false;
                    document.revenueForm.transportCost.value="";
                }

                else
                {
                    document.revenueForm.transportCost.disabled=true;
                    document.revenueForm.transportCost.value="";
                }
            }
			
			
			
            function show(divId,btnId){
                var theDiv = document.getElementById(divId);
                theDiv.style.display="";
                document.getElementById(btnId).style.display="none";    
            }
			
            function res()
            {
                document.getElementById("hide1").style.display="none";
                document.getElementById("hide2").style.display="none";
                document.getElementById("hide3").style.display="none";
                document.getElementById("hide4").style.display="none";
                document.getElementById("hide5").style.display="none";
                document.getElementById("btn").style.display="";
            }
        </script>
    </head>
    <body onload="doInit()"><form action="Revenue.html" name="revenueForm">
            <script>
                function doInit(){
                    document.getElementById("hide1").style.display="none";
                    document.getElementById("hide2").style.display="none";
                    document.getElementById("hide3").style.display="none";
                    document.getElementById("hide4").style.display="none";
                    document.getElementById("hide5").style.display="none";
                }
            </script>

            <div id="menu1">
                <ul>
                    <li ><a href="Savings.jsp" accesskey="1" title="">Savings</a></li>
                    <li class="current_page_item"><a href="Revenue.jsp" accesskey="2" title="">Revenue</a></li>
                    <li><a href="Reports.jsp" accesskey="3" title="">Reports</a></li>
                    <li><a href="Admin.jsp" accesskey="4" title="">Administrator</a></li>
                    <li><a href="Logout.jsp" accesskey="5" title="">Logout</a></li>
                </ul>
            </div>
            <div id="context">
                <div id="legend">
                    <fieldset>
                        <legend>Record the Values</legend>
                        <table border="0" cellspacing="2">
                            <tbody>
                                <tr>
                                    <td>Select Item</td>
                                    <td>Quantity</td>
                                    <td></td>
                                    <td></td>
                                    <td>Enter Dollar Value</td>
                                    <td>Market Rate</td>
                                    <td>Comments(optional)</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><select name="category">
                                            <%
                                                CategoryDAO category = new CategoryDAO();
                                                for (int i = 0; i < category.getCategoryList().size(); i++) {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                    <td><input type="text" name="quantity" value="" /></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" name="rate" value="" /></td>
                                    <td><input type="text" name="marketrate" value="" disabled="true"/></td>
                                    <td><input type="text" name="comment" value="" /></td>
                                    <td><input id="btn" type="button" value="Add" onclick="show('hide1','btn')" /></td>
                                </tr>			

                                <tr id="hide1">
                                    <td><select name="category">
                                            <%

                                                for (int i = 0; i < category.getCategoryList().size(); i++) {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                    <td><input type="text" name="quantity" value="" /></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" name="rate" value="" /></td>
                                    <td><input type="text" name="marketrate" disabled="true" value="" /></td>
                                    <td><input type="text" name="comment" value="" /></td>
                                    <td><input id="btn1" type="button" value="Add" onclick="show('hide2','btn1')"/></td>
                                </tr>

                                <tr id="hide2">
                                    <td><select name="category">
                                            <%
                                                for (int i = 0; i < category.getCategoryList().size(); i++) {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                    <td><input type="text" name="quantity" value="" /></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" name="rate" value="" /></td>
                                    <td><input type="text" name="marketrate" disabled="true" value="" /></td>
                                    <td><input type="text" name="comment" value="" /></td>
                                    <td><input id="btn2" type="button" value="Add" onclick="show('hide3','btn2')"/></td>
                                </tr>


                                <tr id="hide3">
                                    <td><select name="category">
                                            <%
                                                for (int i = 0; i < category.getCategoryList().size(); i++) {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                    <td><input type="text" name="quantity" value="" /></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" name="rate" value="" /></td>
                                    <td><input type="text" name="marketrate" disabled="true" value="" /></td>
                                    <td><input type="text" name="comment" value="" /></td>
                                    <td><input id="btn3" type="button" value="Add" onclick="show('hide4','btn3')"/></td>
                                </tr>

                                <tr id="hide4">
                                    <td><select name="category">
                                            <%
                                                for (int i = 0; i < category.getCategoryList().size(); i++) {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                    <td><input type="text" name="quantity" value="" /></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" name="rate" value="" /></td>
                                    <td><input type="text" name="marketrate" disabled="true" value="" /></td>
                                    <td><input type="text" name="comment" value="" /></td>
                                    <td><input id="btn4" type="button" value="Add" onclick="show('hide5','btn4')"/></td>
                                </tr>

                                <tr id="hide5">
                                    <td><select name="category">
                                            <%
                                                for (int i = 0; i < category.getCategoryList().size(); i++) {
                                            %>

                                            <option><%
                                                out.println(category.getCategoryList().get(i).getCategoryName());
                                                %></option>
                                                <%
                                                    }
                                                %>
                                        </select></td>
                                    <td><input type="text" name="quantity" value="" /></td>
                                    <td><select name="measure">
                                            <option>lbs</option>
                                            <option>tons</option>
                                        </select></td>
                                    <td>$</td>
                                    <td><input type="text" name="rate" value="" /></td>
                                    <td><input type="text" name="marketrate" disabled="true" value="" /></td>
                                    <td><input type="text" name="comment" value="" /></td>
                                    <td><input id="btn5" type="button" value="Add"/></td>
                                </tr>

                            </tbody>
                        </table>
                </div>
                <br/><br/><br/><br/><br/><br/>
                <div id="legend">
                    <fieldset>
                        <legend>Select a Date</legend>
                        Enter Date<br/>
                        <input id="datepick" class="date-pick" />
                        <script type="text/javascript">
                            new datepickr('datepick', { dateFormat: 'm-d-Y' });
                        </script>

                    </fieldset>
                    <br/>
                    <fieldset>
                        <legend>Check the Box to Record Transportation Cost</legend>
                        <input type="checkbox" name="check" value="ON" onclick="validate()"/> Do you want to enter transportation cost?			<br/>

                        <input type="text" name="transportCost" value="" disabled="disabled" />
                    </fieldset>
                    <table border="0" class="button" cellspacing="20">
                        <tbody>
                            <tr>
                                <td><input type="submit" value="Submit" name="submit" class="button-style"/></td>
                                <td><input type="reset" value="Clear" name="clear" onclick="res()" class="button-style"/></td>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>	
    </body>
</html>
