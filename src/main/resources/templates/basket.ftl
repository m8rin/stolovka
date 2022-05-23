<#import "parts/common.ftlh" as c>
<@c.page>
<#--    Изменения С1-->
    <div class="basket-page">
        <div class="basket-title">
            Корзина
        </div>

        <div>
            <#list dishes as dish>
                <div class="basket-dish-item">
                    <div class="basket-item-img-name">
                        <img class="basket-item-img" src="/static/img/food.png" alt="dish">
                        <div class="basket-item-name">
                            ${dish.name!}
                        </div>
                    </div>
                    <div class="basket-item-price">
                        ${dish.price!} ₽
                    </div>
                    <div class="basket-item-count">
                        <div class="basket-item-count-block">
                            <button class="basket-item-count-minus minus">
                                <i class="fa fa-minus" aria-hidden="true"></i>
                            </button>
                            <div class="basket-item-count-number">
                                <span>1</span>
                            </div>
                            <button class="basket-item-count-minus plus">
                                <i class="fa fa-plus" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </#list>
            <div class="basket-dish-item" style="border-bottom: none">
                <div class="basket-item-img-name">
                    <div class="basket-item-total-title">
                        Итого к оплате
                    </div>
                </div>
                <div class="basket-item-price total">
                    ${totalSum!""}  ₽
                </div>
                <!--<button type="submit" class="btn">Оформить заказ</button>-->
                <form action="/addOrder" method="post">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit" class="btn" style="margin-top: 100px">Оформить заказ</button>
                </form>
            </div>
        </div>
    </div>

<#--    Изменения С1-->

</@c.page>
