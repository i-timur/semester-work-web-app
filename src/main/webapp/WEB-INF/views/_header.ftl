<header class="header">
    <div class="header__container container">
        <nav class="header__menu menu">
            <ul class="menu__list">
                <#if username??>
                    <li class="menu__item">
                        <a href="/profile" class="menu__link">
                            <#if username?has_content>${username}</#if>
                        </a>
                    </li>
                    <li class="menu__item">
                        <a href="/logout" class="menu__link">Выйти</a>
                    </li>
                    <#else>
                        <li class="menu__item">
                            <a href="/register" class="menu__link">
                                Создать учётную запись
                            </a>
                        </li>
                        <li class="menu__item">
                            <a href="/login" class="menu__link">
                                Войти
                            </a>
                        </li>
                </#if>
            </ul>
        </nav>
    </div>
</header>