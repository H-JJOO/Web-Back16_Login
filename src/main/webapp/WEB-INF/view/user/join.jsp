<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        html {height: 100%;}
        .position {height: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;}
    </style>
</head>
<body class="position">
    <h1>회원가입</h1>
    <form action="/user/join" method="post">
    <div><input type="text" name="uid" placeholder="아이디"></div>
    <div><input type="password" name="upw" placeholder="비밀번호"></div>
    <div><input type="text" name="nm" placeholder="성명"></div>
    <div>
        Gender :
        <label><input type="radio" name="gender" value="0">여자</label>
        <label><input type="radio" name="gender" value="1">남자</label>
    </div>
    <div>
        <input type="submit" value="회원가입">
        <input type="reset" value="초기화">
    </div>
    <div><a href="/board/list"><input type="button" value="리스트로 이동"></a></div>
    </form>

</body>
</html>
