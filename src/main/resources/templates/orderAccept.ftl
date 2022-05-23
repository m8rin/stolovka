<#import "parts/common.ftlh" as c>
<@c.page>
    <p>Ваш заказ: ${orderCode}</p>
    <p>Статус: ${orderStatus}</p>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Код</th>
            <th>Имя</th>
            <th>Цена</th>
        </tr>
        </thead>
        <tbody>
        <#list dishes as dish>
            <tr>
                <td>${dish?index + 1}</td>
                <td>${dish.code}</td>
                <td>${dish.name}</td>
                <td>${dish.price}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
