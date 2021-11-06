<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../style/header.css">
    <link rel="stylesheet" href="../../style/create.css">
    <title>Create</title>
</head>
<body>
    <div class="wrapper">
        <#include "_header.ftl">
        <form id="form" action="/create" class="form" method="post">
            <div class="create">
                <h2 class="title">Название статьи</h2>
                <input name="title" type="text" class="create__input">
                <h2 class="title">Содержание статьи</h2>
                <textarea form="form" name="text" id="" class="create__textarea" placeholder="Впишите сюда ваш текст">

                </textarea>
                <select form="form" name="select" id="select" class="form__select">
                    <option disabled class="form__option">Категории</option>
                    <option form="form" name="option" value="none" class="form__option">Без категории</option>
                    <option form="form" name="option" value="War" class="form__option">Война</option>
                    <option form="form" name="option" value="20 century" class="form__option">20 век</option>
                    <option form="form" name="option" value="ancient history" class="form__option">Древняя история</option>
                </select>
                <input type="submit" class="create__submit" value="Создать">
            </div>
        </form>
    </div>
</body>
</html>