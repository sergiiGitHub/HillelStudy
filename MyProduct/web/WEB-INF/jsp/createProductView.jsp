<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Create Product</title>
 </head>
 <body>

    <h3>Create Product</h3>

    <p style="color: red;">${errorString}</p>

    <form method="POST" action="insertProduct">
       <table border="0">
          <tr>
             <td>Name</td>
             <td><input type="text" name="name" value="${product.name}" /></td>
          </tr>
          <tr>
             <td>Price</td>
             <td><input type="text" name="price" value="${product.price}" /></td>
          </tr>
          <tr>
             <td colspan="2">
                 <input type="submit" value="Submit" />
                 <a href="productList">Cancel</a>
             </td>
          </tr>
       </table>
    </form>

 </body>
</html>