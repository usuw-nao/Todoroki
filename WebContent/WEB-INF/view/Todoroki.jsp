<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- jQuery UI -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					/*初期値*/
					defaultDate : '{month}/01/{year}',
					/*月の表示を日本語に*/
					monthNames : [ "1月", "2月", "3月", "4月", "5月", "6月", "7月",
							"8月", "9月", "10月", "11月", "12月" ],
					iventDay : [ "2022-09-10", "2022-08-31", "2022-08-10",
							"2022-08-23" ]
				});
		option = {
			beforeShowDay : function(date) {
				current = $.datepicker.formatDate(dateFormat, date);
				return [ (hilidays.indexOf(current) == -1), "", "" ];
			}
		}
		$("#datepicker").datepicker(option);
	});
</script>
</head>
<body>
	<form action="">

		<p>
			日付を選択してください。 <input type="text" name="day" id="datepicker">
		</p>
		<input type="submit" value="決定">
	</form>

	<hr color="blue">

	<h1>イベント情報</h1>
	<h2>お知らせ</h2>
	<p>～現在はありません～</p>
	<br>
	<h2>開催予定イベント</h2>
	<table border="1">
		<tr>
			<th>NO.</th>
			<th>イベント名</th>
			<th>日にち</th>
			<th>場所</th>
			<th>詳細</th>
		</tr>
		<c:forEach items="${iventList}" var="ivent">

			<tr>
				<td><c:out value="${ivent.id }" /></td>
				<td><c:out value="${ivent.name }" /></td>
				<td><c:out value="${ivent.day }" /></td>
				<td><c:out value="${ivent.place}" /></td>
				<td><a href="IventDo?id=<c:out value="${ivent.id }" />">詳細</a></td>

			</tr>
		</c:forEach>
	</table>



	<hr color="blue">

	<h2>参加予定イベント</h2>
	<table border="1">
		<tr>
			<th>NO.</th>
			<th>イベント名</th>
			<th>日にち</th>
			<th>場所</th>
			<th>詳細</th>
		</tr>
		<c:forEach items="${masterList}" var="ivent">

			<tr>
				<td><c:out value="${master.id }" /></td>
				<td><c:out value="${master.rdate }" /></td>
				<td><c:out value="${master.r08 }" /></td>
				<td><c:out value="${master.r09}" /></td>
				<td><c:out value="${master.r10}" /></td>
				<td><c:out value="${master.r11}" /></td>
				<td><c:out value="${master.r12}" /></td>
				<td><c:out value="${master.r13}" /></td>
				<td><c:out value="${master.r14}" /></td>
				<td><c:out value="${master.r15}" /></td>
				<td><c:out value="${master.r16}" /></td>
				<td><c:out value="${master.r17}" /></td>

				<td><a href="MasterDo?id=<c:out value="${master.id }" />">詳細</a></td>

			</tr>
		</c:forEach>
	</table>

	<hr color="blue">
	<p>
		<a href="">マイページに戻る</a>
	</p>

</body>
</html>