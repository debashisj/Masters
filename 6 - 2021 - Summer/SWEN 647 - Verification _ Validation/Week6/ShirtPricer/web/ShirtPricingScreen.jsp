<%-- 
    Document   : ShirtPricingScreen
    Created on : Jan 3, 2019, 12:50:28 PM
    Author     : Michael Brown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shirt Pricing Tool</title>
    </head>
    <body>
        <h1>Shirt Pricing Calculator</h1>
        <%-- There are a number of methos to get the values of a request in a jsp.
             The ${} method is easy.
        --%>
        <p>Your price is $${cost} ${currency}</p>
        
        <%-- Put a hyperlink back to the page to enter information for another shirt.
        --%>
        <p>Would you like to price another short?  <a href="index.html">Click here</a></p>
    </body>
</html>
