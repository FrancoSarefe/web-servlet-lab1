<%@ page language="java" %>
<%@ page import="com.webshoppe.ecommerce.entity.Book"%>
<%@ page import="java.util.List"%>

<%
List<Book> catalog = (List<Book>)request.getAttribute("bookCatalog");
%>
<html>
    <head>
        <title>Webshoppe::Book Catalog</title>
        <style type="text/css">
            body {
                margin: 50px;
            }
        </style>
    </head>
    <body>
        <h2>Book Catalog</h2>
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
	                <td>Book ID</td>
	                <td>Title</td>
	                <td>Description</td>
	                <td>Price</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(Book book: catalog) {
                %>
                    <tr>
	                    <td><%= book.getBookId() %></td>
	                    <td><%= book.getTitle() %></td>
	                    <td><%= book.getBookDescription() %></td>
	                    <td><%= book.getBookPrice() %></td>
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