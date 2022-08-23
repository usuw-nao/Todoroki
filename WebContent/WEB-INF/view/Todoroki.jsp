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
			日付を選択してください。 <input type="text" name="rdate" id="datepicker">
		</p>
		<input type="submit" value="決定">
	</form>

	<hr color="blue">

	<h2>ToDoRoKiサッカー教室イベント日程</h2>
	<table border="1">
		<tr>
			<th>教室名</th>
			<th>日にち</th>
		</tr>
		<c:forEach items="${masterList}" var="mL">
			<tr>
				<td><c:out value="${mL.name}" /></td>
				<td><c:out value="${mL.rdate}" /></td>
			</tr>
		</c:forEach>
	</table>

	<hr color="blue">
	<h2>ToDoRoKiサッカー教室イベント</h2>
	<form action="" method="post">
		<p>
			<c:out value="${master.id }" />
		</p>
		<table border="1">
			<tr>
				<th>教室名</th>
				<th>8時〜9時</th>
				<th>9時〜10時</th>
				<th>10時〜11時</th>
				<th>11時〜12時</th>
				<th>12時〜13時</th>
				<th>13時〜14時</th>
				<th>14時〜15時</th>
				<th>15時〜16時</th>
				<th>16時〜17時</th>
				<th>17時~18時</th>

			</tr>

			<c:forEach items="${planList}" var="master">


				<tr>
					<td><c:out value="${master.name }" /></td>
					<td><c:out value="${master.r08}" /><p><a href="Form">予約する</a></p></td>
					<td><c:out value="${master.r09}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r10}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r11}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r12}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r13}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r14}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r15}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r16}" /><p><a href="">予約する</a></p></td>
					<td><c:out value="${master.r17}" /><p><a href="">予約する</a></p></td>

				</tr>


			</c:forEach>
		</table>
	</form>


	<hr color="blue">



	<hr color="blue">
	<p>
		<a href="">マイページに戻る</a>
	</p>

</body>
</html>