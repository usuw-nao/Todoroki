<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約フォーム</title>
</head>
<body>
	<h1>予約フォーム</h1>
	<p>フォーム入力お願いいたします</p>
	<form action="" method="post">
		<p>
			名前:<input type="text" name="name" placeholder="名前">
		</p>
		<p>
			年齢:<input type="number" min="3" max="18" name="age">
		</p>
		<p>
			メールアドレス:<input type="email" name="email" placeholder="email">
		</p>
		<p>
			後援会fno:<input type="text" name="fno">
		</p>
		<p>
			<input type="submit" value="申し込む">
		</p>


	</form>
</body>
</html>