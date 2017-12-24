<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>J Album</title>
	</head>
	
	<body>
		<div style="text-align: center !important;">
			<table align="center">
				<tr>
					<td colspan="2">
						<img alt="J Album Gallery" src="<%= request.getContextPath() %>/downloads?image_id=${image_id}" width="600" height="375">
					</td>
				</tr>
				<tr>
					<td align="left"><a href="<%= request.getContextPath() %>/gallery?action=prev&image_id=${image_id}">PREV</a></td>
					<td align="right"><a href="<%= request.getContextPath() %>/gallery?action=next&image_id=${image_id}">NEXT</a></td>
				</tr>
			</table>
		</div>
	</body>
	
</html>