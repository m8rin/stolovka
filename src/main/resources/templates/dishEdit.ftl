<#import "parts/common.ftlh" as c>

<@c.page>
    Редактирование пользователя

    <form action="/dish" method="post">
        <div>Имя:</div>
        <input type="text" name="name" value="${dish.name}">
        <div>Номер телефона:</div>
        <input type="text" name="price" value="${dish.price}">
        <div>email:</div>
        <input type="text" name="category" value="${dish.category}">
        <input type="hidden" value="${dish.id}" name="dishId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>
