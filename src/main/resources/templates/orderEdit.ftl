<#import "parts/common.ftlh" as c>

<@c.page>
    Редактирование заказа:

    <form action="/order" method="post">
        <div>Код:</div>
        <input type="text" name="code" value="${order.code}">
        <div>Цена:</div>
        <input type="text" name="price" value="${order.price}">
        <div>email:</div>
        <input type="hidden" value="${order.id}" name="orderId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>
