<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../style/header.css">
    <link rel="stylesheet" href="../../style/index.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Энциклопедия</title>
</head>
<body>
    <div class="wrapper">
        <#include "_header.ftl">
        <main class="page">
            <section class="page__main-top main-top">
                <div class="main-top__container container">
                    <div class="main-top__content">
                        <div class="main-top__left">
                            <h2 class="main-top__title">Добро пожаловать</h2>
                        </div>
                        <div class="main-top__right">
                            <a href="/create" class="main-top__create">Создать статью</a>
                        </div>
                    </div>
                    <div class="main-top__find">
                        <form>
                            <div class="form__container">
                                <select form="find" name="select" id="select" class="form__select">
                                    <option form="find" name="option" value="all" class="form__option">По всем категориям</option>
                                    <option form="find" name="option" value="War" class="form__option">Война</option>
                                    <option form="find" name="option" value="20 century" class="form__option">20 век</option>
                                    <option form="find" name="option" value="ancient history" class="form__option">Древняя история</option>
                                </select>
                                <input name="search" form="find" type="text" class="form__input" placeholder="Поиск">
                                <button form="find" class="form__button" id="form__button">Поиск</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
            <section class="page__main-block main-block">
                <div class="main-block__container container">
                    <div class="main-block__content">
                        <#if contributions??>
                            <#if contributions?has_content>
                                <#list contributions as c>
                                    <div class="main-block__item">
                                        <a href="/contribution/${c.id}" class="main-block__link">${c.title}</a>
                                    </div>
                                </#list>
                            </#if>
                        </#if>
                    </div>
                </div>
            </section>
        </main>
    </div>
    <script src="../../js/filter.js"></script>
</body>
</html>