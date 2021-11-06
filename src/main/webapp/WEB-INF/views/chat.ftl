<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../style/header.css">
    <link rel="stylesheet" href="../../style/chat.css">
    <title>Chat</title>
</head>
<body>
    <div class="wrapper">
        <#include "_header.ftl">
        <div class="chat">
            <div class="chat__container container">
                <div class="chat__messages">
                    <#if messages??>
                        <#if messages?has_content>
                            <#list messages as m>
                                <div class="chat__message message">
                                    <div class="message__author">
                                        ${m.messageAuthor}
                                    </div>
                                    <div class="message__text">
                                        ${m.text}
                                    </div>
                                    <div class="message__date">
                                        ${m.createdAt}
                                    </div>
                                </div>
                            </#list>
                        </#if>
                    </#if>
                </div>
            </div>
        </div>
        <form action="/chat" class="send" method="post">
            <div class="send__container container">
                <input type="text" class="text" placeholder="Введите сообщение" name="message">
                <input type="submit" class="submit" value="Отправить сообщение">
            </div>
        </form>
    </div>
</body>
</html>