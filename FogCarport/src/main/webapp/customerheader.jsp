<%-- 
    Document   : customerheader
    Created on : 02-05-2019, 12:42:20
    Author     : sofieamalielandt
--%>

<%@page import="FunctionLayer.HelpingClasses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Fog</title>
        <style>
            .menu ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: rgba(7, 72, 133, 1.0);
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;  
                height: 80px;
                color: whitesmoke;
                font-family: Avenir Next Condensed;  
                z-index: 9999;
            }

            .menu li p {
                float: right;
                display: block;
                color: whitesmoke;
                text-align: center;
                padding: 10px 15px;
                text-decoration: none;
                font-size: 18px;
                height: 80px;
            }

            .menu li button {
                float: right;
                display: inline-block;
                text-align: center;
                background-color: rgba(7, 72, 133, 1.0);
                text-decoration: none;
                padding: 20px 20px;
                position: static; width: 150px; 
                color: whitesmoke;
                border: none;
                font-family: Avenir Next Condensed;
                font-size: 18px;
                height: 80px;
            }
            .menu li a {
                float: left;
                display: block;
                color: whitesmoke;
                text-align: center;
                padding: 0px 16px;
                text-decoration: none;  
                height: 80px;
                display: -webkit-flex;
                -webkit-align-items: center; 
            }
            .menu li a img {
                display: block;
                text-align: center;
                padding: 0px 10px;
                width: 50px;
                height: 50px;
                text-decoration: none;  
                display: -webkit-flex;
                -webkit-align-items: center; 
            }

            .menu li a:hover, li a img:hover, .dropdown:hover {
                opacity: 0.6;
            }

            .menu button:hover {
                font-size: 20px;
                opacity: 0.6;
            }

            #menu img{
                position: fixed;
                left:0;
                top: 11%;
            }

            #index input, select{
                position: relative;  
                display: inline-block;
                align-items: center;
                background-color: transparent;
                border: solid;
                border-color: whitesmoke;
                text-decoration: none;
                font-size: 16px;
                text-align: center;
                padding: 5px 5px;
                border-radius: 10px;
                border-width: thin;
                color: whitesmoke;
                font-family: Avenir Next Condensed;
            }

        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <form action="Fog" method="post">
            <center class="menu">
                <ul>
                    <li> <a href="shop.jsp"><img src="images/logo.png"></a></li>

                    <li><button name="command" value="logout">Log ud</button></li>
                    <li><p>
                            <%
                                out.println(user.getEmail() + "&nbsp;&nbsp");
                            %>
                        </p>
                    </li>
                </ul>
            </center>
        </form>
        <br><br><br><br><br>