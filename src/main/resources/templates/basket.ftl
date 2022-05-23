<#import "parts/common.ftlh" as c>
<@c.page>
<#--    Изменения С1-->
    <p>Корзина</p>

    <div class="dishes-page">
        <#list dishes as dish>
            <div class="dish-block">
                <img class="dish-img" src="/static/img/food.png" alt="dish">
                <div class="dish-name">
                    ${dish.name}
                </div>
                <div class="dish-info">
                    <div class="dish-price">${dish.price} ₽</div>
                </div>
            </div>
        </#list>
    </div>
    <button type="submit" class="btn" style="margin-top: 100px">Оформить заказ</button>
<#--    Изменения С1-->
</@c.page>
