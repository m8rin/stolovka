<#import "parts/common.ftlh" as c>
<@c.page>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Код</th>
            <th>Цена</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order?index + 1}</td>
                <td>${order.code!!}</td>
                <td>${order.price!!}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>