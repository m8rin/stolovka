<#import "parts/common.ftlh" as c>
<@c.page>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Код</th>
            <th>Имя</th>
            <th>Категория</th>
            <th>Цена</th>
        </tr>
        </thead>
        <tbody>
        <#list dishes as dish>
            <tr>
                <td>${dish?index + 1}</td>
                <td>${dish.code}</td>
                <td>${dish.name}</td>
                <td>${dish.category!"Не задана"}</td>
                <td>${dish.price}</td>
                <td><a href="/dish/${dish.id}">Изменить</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
