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
                    <li class="menu__item">
                        <a href="/chat" class="menu__link">Чат</a>
                    </li>
                    <li class="menu__item">
                        <a href="/" class="menu__link">На главную</a>
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
                        <li class="menu__item">
                            <a href="/chat" class="menu__link">Чат</a>
                        </li>
                        <li class="menu__item">
                            <a href="/" class="menu__link">На главную</a>
                        </li>
                </#if>
            </ul>
        </nav>
    </div>
</header>