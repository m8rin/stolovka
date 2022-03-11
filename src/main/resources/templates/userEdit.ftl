<#import "parts/common.ftlh" as c>

<@c.page>
Редактирование пользователя

<form action="/user" method="post">
    <div>Имя:</div>
    <input type="text" name="username" value="${user.username}">
    <div>Номер телефона:</div>
    <input type="text" name="phoneNumber" value="${user.phoneNumber}">
    <div>email:</div>
    <input type="text" name="email" value="${user.email}">
    <div>Права доступа:</div>
    <#list roles as role>
        <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
</form>
</@c.page>
