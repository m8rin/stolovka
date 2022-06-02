<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="dish-categories">
        <div class="category selected">Популярное</div>
        <div class="category">Первые</div>
        <div class="category">Вторые</div>
        <div class="category">Гарниры</div>
        <div class="category">Напитки</div>
        <div class="category">Холодные</div>
        <div class="category">Десерты</div>
        <div class="category">Другое</div>
    </div>
    <div class="dishes-page">
        <#list dishes as dish>
            <div class="dish-block">
                <#if dish.imgURL??>
                    <img class="dish-img" src="${dish.imgURL!""}" alt="dish">
                <#else>
                    <img class="dish-img" src="/static/img/food.png" alt="dish">
                </#if>
                <div class="dish-name">
                    ${dish.name}
                </div>
                <div class="dish-info">
                    <form action="/addDishToBasket" method="post">
                        <input type="hidden" value="${dish.id}" name="dishId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn-add-dish-to-basket">${dish.price} ₽</button>
                    </form>
                </div>
            </div>
        </#list>
    </div>
<#--    <table>-->
<#--        <thead>-->
<#--        <tr>-->
<#--            <th>#</th>-->
<#--            <th>Код</th>-->
<#--            <th>Имя</th>-->
<#--            <th>Цена</th>-->
<#--        </tr>-->
<#--        </thead>-->
<#--        <tbody>-->
<#--        <#list dishes as dish>-->
<#--            <tr>-->
<#--                <td>${dish?index + 1}</td>-->
<#--                <td>${dish.code}</td>-->
<#--                <td>${dish.name}</td>-->
<#--                <td>${dish.price}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--        </tbody>-->
<#--    </table>-->
</@c.page>
