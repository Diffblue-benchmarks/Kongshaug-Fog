<%-- 
    Document   : placeorder
    Created on : 01-05-2019, 12:30:45
    Author     : aamandajuhl
--%>

<%@page import="FunctionLayer.HelpingClasses.Order"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file = "header.jsp" %>
<form action="Fog" method="POST">
    <center id="index" class="index">
        <div>
            <img src="images/logo.png" width="30%"><br>
            <%                
                String message = (String) request.getAttribute("message");
                out.println(message);
            %>
            <br><br>
            <button name="command" value="back">G� til shop</button>
            </form>
        </div>
    </center>
</body>
</html>
