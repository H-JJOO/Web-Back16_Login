<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
    <style>
        .err {color: red;}
    </style>
</head>
<body>
    <h1>글쓰기</h1>
    <div class="err">${requestScope.err}</div>
    <form action="/board/write" method="post">
    <div>
        <input type="text" name="title" placeholder="제목" value="${requestScope.data.title}">
    </div>
    <div>
        <textarea name="ctnt" placeholder="내용" rows="20">${requestScope.data.ctnt}</textarea>
    </div>
    <div>
        <input type="submit" value="글등록">
        <input type="reset" value="초기화">
        <a href="/board/list"><input type="button" value="리스트로 이동"></a>
    </div>
    </form>

</body>
</html>
