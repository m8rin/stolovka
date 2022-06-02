<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="ordersList">
        <div class="main-title">История заказов</div>
        <div class="orderList-items">

            <div class="orderList-item">
                <div class="order-item-icon"><i class="fa fa-cutlery" aria-hidden="true"></i></div>
                <div>
                    <div class="order-item-info">А-45 - Готов</div>
                    <div class="order-item-date">3 июня, 00:15</div>
                </div>
                <div class="order-item-price">450 ₽</div>
            </div>

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


<#--    <table>-->
<#--        <thead>-->
<#--        <tr>-->
<#--            <th>#</th>-->
<#--            <th>Код</th>-->
<#--            <th>Цена</th>-->
<#--        </tr>-->
<#--        </thead>-->
<#--        <tbody>-->

<#--        <#list orders as order>-->
<#--            <tr>-->
<#--                <td>${order?index + 1}</td>-->
<#--                <td>${order.code}</td>-->
<#--                <td>${order.price}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--        </tbody>-->
<#--    </table>-->
</@c.page>