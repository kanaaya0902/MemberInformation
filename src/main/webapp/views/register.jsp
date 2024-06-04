<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>会員情報登録</title>
    <!-- CSSファイルをリンク -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>会員情報登録</h2>
        <!-- フォーム開始 -->
        <form action="${pageContext.request.contextPath}/register" method="post">
            <!-- ユーザーID入力 -->
            <label for="userId">ユーザーID</label>
            <input type="text" id="userId" name="userId" required>

            <!-- パスワード入力 -->
            <label for="password">パスワード</label>
            <input type="password" id="password" name="password" minlength="8" maxlength="30" required>

            <!-- パスワード確認入力 -->
            <label for="confirmPassword">パスワード確認</label>
            <input type="password" id="confirmPassword" name="confirmPassword" minlength="8" maxlength="30" required>

            <!-- 姓入力 -->
            <label for="lastName">姓</label>
            <input type="text" id="lastName" name="lastName" required>

            <!-- 名入力 -->
            <label for="firstName">名</label>
            <input type="text" id="firstName" name="firstName" required>

            <!-- 性別選択 -->
            <label>性別</label>
            <div>
                <input type="radio" id="male" name="gender" value="male" required>
                <label for="male">男性</label>
                <input type="radio" id="female" name="gender" value="female" required>
                <label for="female">女性</label>
            </div>

            <!-- 生年月日選択 -->
            <label for="birthYear">生年月日</label>
            <div>
                <!-- 年選択 -->
                <select id="birthYear" name="birthYear" required>
                    <c:forEach var="year" begin="1920" end="2020">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
                年
                <!-- 月選択 -->
                <select id="birthMonth" name="birthMonth" required>
                    <c:forEach var="month" begin="1" end="12">
                        <option value="${month}">${month}</option>
                    </c:forEach>
                </select>
                月
                <!-- 日選択 -->
                <select id="birthDay" name="birthDay" required>
                    <c:forEach var="day" begin="1" end="31">
                        <option value="${day}">${day}</option>
                    </c:forEach>
                </select>
                日
            </div>

            <!-- 電話番号入力 -->
            <label for="phoneNumber">電話番号</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" required>

            <!-- メールアドレス入力 -->
            <label for="email">メールアドレス</label>
            <input type="email" id="email" name="email" required>

            <!-- 職業選択 -->
            <label for="occupation">職業</label>
            <select id="occupation" name="occupation" onchange="checkOccupation(this)" required>
                <option value="経営者・役員">経営者・役員</option>
                <option value="会社員（総合職）">会社員（総合職）</option>
                <option value="会社員（一般職）">会社員（一般職）</option>
                <option value="契約社員・派遣社員">契約社員・派遣社員</option>
                <option value="パート・アルバイト">パート・アルバイト</option>
                <option value="公務員（教職員除く）">公務員（教職員除く）</option>
                <option value="教職員">教職員</option>
                <option value="医療関係者">医療関係者</option>
                <option value="自営業・自由業">自営業・自由業</option>
                <option value="専業主婦・主夫">専業主婦・主夫</option>
                <option value="大学生・大学院生">大学生・大学院生</option>
                <option value="専門学校生・短大生">専門学校生・短大生</option>
                <option value="高校生">高校生</option>
                <option value="士業（公認会計士・弁護士・税理士・司法書士）">士業（公認会計士・弁護士・税理士・司法書士）</option>
                <option value="無職">無職</option>
                <option value="定年退職">定年退職</option>
                <option value="other">その他</option>
            </select>

            <!-- その他職業入力（デフォルトで非表示） -->
            <input type="text" id="otherOccupation" name="otherOccupation" placeholder="職業を入力" style="display:none;">

            <!-- ボタン群 -->
            <div class="button-group">
                <button type="submit">登録</button>
                <button type="reset">リセット</button>
                <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/views/index.jsp';">戻る</button>
            </div>
        </form>
        <!-- エラーメッセージの表示 -->
        <c:if test="${not empty errorMessage}">
            <p class="error">${errorMessage}</p>
        </c:if>
    </div>
    <!-- JavaScriptファイルをリンク -->
    <script src="${pageContext.request.contextPath}/js/register.js"></script>
</body>
</html>
