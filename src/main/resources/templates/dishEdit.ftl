<#import "parts/common.ftlh" as c>

<@c.page>
<#--    Изменения С1-->
    Редактирование блюда

    <form action="/dish" method="post">
        <div>Название:</div>
        <input type="text" name="name" value="${dish.name}">
        <div>Стоимость:</div>
        <input type="text" name="price" value="${dish.price}">
        <div>Категория:</div>
        <select type="text" name="category" value="${dish.category}">
            <option>Первые</option>
            <option>Вторые</option>
            <option>Гарниры</option>
            <option>Напитки</option>
            <option>Холодные</option>
            <option>Десерты</option>
            <option>Другое</option>
        </select>
<#--        <input type="text" name="category" value="${dish.category}">-->
        <input type="hidden" value="${dish.id}" name="dishId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
        <#--    Изменения С1-->
    </form>
</@c.page>
