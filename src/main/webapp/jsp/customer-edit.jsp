<%@page contentType="text/html;charset=UTF-8"
        language="java"%>
<%@taglib prefix="jstl"
          uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="customer" 
             type="com.capco.spring.entity.Customer"
             scope="request"/>
<jstl:url var="actionLink" value="/customers">
    <jstl:param name="id" value="${customer.id}"/>
</jstl:url>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Customers</title>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" 
          type="text/css"
          href="${cssLink}"/>
</head>
<body>

    <h1>Edit</h1>

    <form action="${actionLink}" method="post">
        <table>
            <tr>
                <th>Id</th>
                <td>
                    ${customer.id}
                </td>
            </tr>
            <tr>
                <th><label for="firstName">Name</label></th>
                <td>
                    <input id="firstName"
                           name="firstName"
                           value="${customer.firstName}"/>
                </td>
            </tr>
            <tr>
                <th><label for="lastName">Last name</label></th>
                <td>
                    <input id="lastName"
                           name="lastName"
                           value="${customer.lastName}"/>
                </td>
            </tr>
            <tr>
                <th><label for="address">Address</label></th>
                <td>
                    <input id="address"
                           name="address"
                           value="${customer.address}"/>
                </td>
            </tr>
            <tr>
                <th>&nbsp;</th>
                <td>
                    <input type="submit" value="Save"/>
                    <input type="submit" name="cancel" value="Cancel" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>