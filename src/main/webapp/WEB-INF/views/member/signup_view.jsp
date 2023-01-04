<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">

        //아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
        var idck = 0;
        $(function() {
            //idCheck 버튼을 클릭했을 때
            $("#idCheck").click(function() {

                //input_id 를 param.
                var userid =  $("#input_id").val();

                $.ajax({
                    async: true,
                    type : 'POST',
                    data : userid,
                    url : "member/id_confirm",
                    dataType : "json",
                    contentType: "application/json; charset=UTF-8",
                    success : function(data) {
                        if (data.cnt > 0) {

                            alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                            //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                            $("#divInputId").addClass("has-error")
                            $("#divInputId").removeClass("has-success")
                            $("#userid").focus();


                        } else {
                            alert("사용가능한 아이디입니다.");
                            //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                            $("#divInputId").addClass("has-success")
                            $("#divInputId").removeClass("has-error")
                            $("#userpwd").focus();
                            //아이디가 중복하지 않으면  idck = 1
                            idck = 1;

                        }
                    },
                    error : function(error) {

                        alert("error : " + error);
                    }
                });
            });
        });

        $(document).ready(function () {

            $("#signInForm").submit(function (event) {

                event.preventDefault();

                let id = $("#input_id").val();
                let pw = $("#input_pw").val();
                let name = $("#input_name").val();
                let tel = $("#input_tel").val();
                let email = $("#input_email").val();
                let nickname = $("#input_nickname").val();


                let form = {
                    id: id,
                    pw : pw,
                    name : name,
                    tel : tel,
                    email : email,
                    nickname : nickname
                };

                console.log(JSON.stringify(form))

                $.ajax({
                    type : "POST",
                    url : "/tomato/member/signup",
                    cache : false,
                    contentType : 'application/json; charset=utf-8',
                    data : JSON.stringify(form),
                    success : function (result) {
                        console.log(result);
                        $(location).attr('href', '/');
                    },
                    error : function (e) {
                        console.log(e);
                    }
                });
            });
        });

    </script>
</head>
<body>
<table width="600" cellpadding="0" cellspacing="0" border="1">
    <form id="signInForm" action="join" method="post">
        <tr>
            <td>아이디</td>
            <td><input id="input_id" type="text" name="id" size="50">
                <button id="idCheck">아이디 중복 확인</button>
            </td>
        </tr>
        <tr>
            <td>도로명코드(api?)</td>
            <td><input id="input_code" type="text" name="code" size="50"></td>
        </tr>
        <tr>
            <td>읍연동일련번호(api?)</td>
            <td><input id="input_dong_id" type="text" name="dong_id" size="50"></td>
        </tr>
        <tr>
            <td>패스워드</td>
            <td><input id="input_pw" type="text" name="pw" size="50"></td>
        </tr>
        <tr>
            <td>패스워드 확인</td>
            <td><input id="input_pwCheck" type="text" name="pwCheck" size="50"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input id="input_name" type="text" name="name" size="50"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input id="input_tel" type="text" name="tel" size="50"></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input id="input_email" type="text" name="email" size="50"></td>

        </tr>
        <tr>
            <td>닉네임</td>
            <td><input id="input_nickname" type="text" name="nickname" size="50"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="가입"></td>
        </tr>
    </form>
</table>
</body>
</html>