<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../style/header.css">
    <link rel="stylesheet" href="../../style/register.css">
    <title>Register</title>
</head>
<body>
<div class="wrapper">

    <#include "_header.ftl">
    <form action="/register" class="form" method="post">
        <div class="login">
            <label for="login" class="login__label">Логин</label>
            <input name="login" type="text" class="login__input input" id="login">
            <label for="login" class="login__label">Пароль</label>
            <input name="password" type="password" class="password__input input" id="password">
            <div class="validation-text"></div>
            <div class="login__checkbox-wrapper">
                <input name="checkbox" type="checkbox" class="login__checkbox" id="checkbox">
                <label for="checkbox" class="login__label">Запомнить меня</label>
            </div>
            <input type="submit" class="login__submit input" value="Зарегистрироваться">
        </div>
    </form>
</div>
<script type="text/javascript" src="../../js/validation.js"></script>
</body>
</html>