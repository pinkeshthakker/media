<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-us">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<title>Product Sales Report</title>
	<link rel="stylesheet" href="css/jq.css" type="text/css" media="print, projection, screen" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/jquery.tablesorter/themes/blue/style.css" type="text/css" media="print, projection, screen" />
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery.tablesorter/jquery-latest.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery.tablesorter/jquery.tablesorter.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery.tablesorter/addons/pager/jquery.tablesorter.pager.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery.tablesorter/docs/js/chili/chili-1.8b.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/jquery.tablesorter/docs/js/docs.js"></script>
	<script type="text/javascript">
	$(function() {
		$("table")
			.tablesorter({widthFixed: true, widgets: ['zebra']})
			.tablesorterPager({container: $("#pager")});
	});
	</script>
</head>
<body>
<div id="main">
<h1>Product Sales Report</h1>
<table cellspacing="1" class="tablesorter">
	<thead>
		<tr>
			<th>Product Name</th>
			<th>Count</th>
			<th>SUM</th>

		</tr>
	</thead>
	<tfoot>
		<tr>
			<th>Product Name</th>
			<th>Count</th>
			<th>SUM</th>
		</tr>
	</tfoot>
	<tbody>
	<c:forEach var="productDTO" items="${products}">
		<tr>
			<td>${productDTO.product.productName}</td>
			<td>${productDTO.productCount}</td>
			<td>${productDTO.sumOfProduct}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div id="pager" class="pager">
	<form>
		<select class="pagesize">
			<option selected="selected"  value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option  value="40">40</option>
		</select>
	</form>
</div>

</div>
</body>
</html>

