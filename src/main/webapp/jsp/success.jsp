<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>登録成功</title>
     <!-- CSSファイルをリンク -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    
</head>
<body>
    <div class="container">
        <h2>登録が成功しました</h2>
        <p>登録が完了しました。ありがとうございます。</p>
        <button onclick="window.location.href='${pageContext.request.contextPath}/jsp/register.jsp';">戻る</button>
    </div>
</body>
</html>
