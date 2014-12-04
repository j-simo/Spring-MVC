<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"
        language="java"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="customers" type="java.util.List<com.capco.spring.entity.Customer>" scope="request"/>
             
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>MVC Customers</title>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css"
          href="${cssLink}"/>
</head>
<body>

    <h1>Customer list</h1>

    <h3>
        <a href="${newCustomerLink}">
            Add Customer
        </a>
    </h3>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Last name</th>
            <th>Address</th>
            <th>Action</th>
        </tr>

        <jstl:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.address}</td>
                <td>
                    <jstl:url value="/edit-customer.html" var="editLink">
                        <jstl:param name="id" value="${customer.id}"/>
                    </jstl:url>
                    <jstl:url value="/delete-customer.html" var="deleteLink">
                        <jstl:param name="id" value="${customer.id}"/>
                    </jstl:url>
                    <a href="${editLink}">Edit</a>
                    <a href="${deleteLink}">Delete</a>
                </td>
            </tr>
        </jstl:forEach>
    </table>

</body>
</html>