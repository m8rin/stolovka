<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div class="mb-1" align="center">Добавление нового пользователя</div>
${message?ifExists}
<@l.login "/registration" true />
</@c.page>
