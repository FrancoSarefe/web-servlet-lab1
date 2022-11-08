<%@ page language="java" %>
<%@ page import="com.webshoppe.ecommerce.entity.Flower"%>
<%@ page import="java.util.List"%>

<%
List<Flower> catalog = (List<Flower>)request.getAttribute("flowerCatalog");
%>
<html>
    <head>
        <title>Webshoppe::Flower Catalog</title>
        <style type="text/css">
            body {
                margin: 50px;
            }
        </style>
    </head>
    <body>
        <h2>Flower Catalog</h2>
        <hr/>
        <%
        if(catalog.isEmpty()) {
        %>
            <b>Empty Catalog!</b>
        <%
        }
        %>
        
         <%
        if(!catalog.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
	                <td>Flower ID</td>
	                <td>Name</td>
	                <td>Description</td>
	                <td>Price</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(Flower flower: catalog) {
                %>
                    <tr>
	                    <td><%= flower.getFlowerID() %></td>
	                    <td><%= flower.getFlowerName() %></td>
	                    <td><%= flower.getFlowerDescription() %></td>
	                    <td><%= flower.getFlowerPrice() %></td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <%
        }
        %>
    </body>
</html>