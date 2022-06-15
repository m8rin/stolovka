<#import "parts/common.ftlh" as c>
<@c.page>
<div class="ordersList">
    <div class="main-title">История заказов</div>
    <div class="orderList-items">
        <#if orders??>
            <#list orders as order>
                <div class="orderList-item-with-icon">
                    <div style="width: 100%">
                        <div class="orderList-item border" onclick="hideOrderDishes(this, ${order.id!})">
                            <div class="order-item-icon"><i class="fa fa-cutlery" aria-hidden="true"></i></div>

                            <div>
                                <div class="order-item-info">№ ${order.code!} - ${order.status!"Неизвестно"}</div>
                                <div class="order-item-date">${order.date!}</div>
                            </div>
                            <div class="order-item-price">${order.cost!} ₽</div>

                        </div>

                        <div class="orderList-item-dishes hidden">
                            <div class="user-order-list-item">
                                <div>Крышки гриль</div>
                                <div>x 2</div>
                            </div>
                            <div class="user-order-list-item">
                                <div>Крышки гриль</div>
                                <div>x 2</div>
                            </div>
                            <div class="user-order-list-item">
                                <div>Крышки гриль</div>
                                <div>x 2</div>
                            </div>
                        </div>
                    </div>
                    <div style="align-self: start; padding-top: 8%">
                        <i class="fa fa-undo fa-2x" aria-hidden="true"></i>
                    </div>

                </div>
            </#list>
        </#if>

<#--        <#if dishes??>
            <#list dishes as dish>
                <div class="user-order-list-item">
                    <div>${dish.name}</div>
                    <div>${dish.price}</div>
                </div>
            </#list>
        </#if>-->


        <div class="orderList-item">
            <div class="order-item-icon green"><i class="fa fa-flag-checkered" aria-hidden="true"></i></div>
            <div>
                <div class="order-item-info">A-03 - Выдан</div>
                <div class="order-item-date">2 июня, 13:50</div>
            </div>
            <div class="order-item-price">312 ₽</div>
        </div>
        <div class="orderList-item">
            <div class="order-item-icon green"><i class="fa fa-flag-checkered" aria-hidden="true"></i></div>
            <div>
                <div class="order-item-info">Б-40 - Выдан</div>
                <div class="order-item-date">1 июня, 18:39</div>
            </div>
            <div class="order-item-price">699 ₽</div>
        </div>

    </div>

    </@c.page>
