<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../style/header.css">
    <link rel="stylesheet" href="../../style/profile.css">
    <title>Profile</title>
</head>
<body>
    <div class="wrapper">
        <#include "_header.ftl">
        <main class="main">
            <div class="main__container container">
                <form id="form" action="/profile" class="form" method="post">
                    <p class="form__text">Имя</p>
                    <input name="firstName" type="text" class="form__firstName input" value="<#if firstName??>${firstName}</#if> ">
                    <p class="form__text">Фамилия</p>
                    <input name="lastName" type="text" class="form__lastName input" value="<#if lastName??>${lastName}</#if>">
                    <button class="form__button">Изменить</button>
                </form>
            </div>
        </main>
    </div>
</body>
</html>