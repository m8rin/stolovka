<#import "parts/common.ftlh" as c>

<@c.page>

<div class="container">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>Имя</th>
            <th>Права</th>
            <th>Номер телефона</th>
            <th>email</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div>
        </@c.page>
