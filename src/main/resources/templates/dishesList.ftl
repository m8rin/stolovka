<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="dish-categories">
        <div class="category selected">Популярное</div>
        <div class="category">Супы</div>
        <div class="category">Вторые блюда</div>
        <div class="category">Напитки</div>
        <div class="category">Другое</div>
    </div>
    <div class="dishes-page">
        <#list dishes as dish>
            <div class="dish-block">
                <img class="dish-img" src="/static/img/food.png" alt="dish">
                <div class="dish-name">
                    ${dish.name}
                </div>
                <div class="dish-info">
                    <div class="dish-price">${dish.price} ₽</div>
                    <button class="btn-add-dish-to-basket" style="font-weight: lighter"><i class="fa fa-plus" aria-hidden="true"></i></button>
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