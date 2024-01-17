<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<div align="center">
   <form action="insertProduct" method="post">
   		<input type="text" name="pid" id="pid" placeholder="Product_Id"><br>
       	<input type="text" name="pname" id="pname" placeholder="Product Name"><br>
        <input type="text" name="price" id="price" placeholder="Product Price"><br>
        <input type="text" name="qty" id="qty" placeholder="Product Qty."><br><br>
        <button type="submit" name="btn" id="btn">Add</button>
   </form>
</div>
</body>
</html>