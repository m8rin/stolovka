<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="user-order">
        <div class="user-order-block">
            <!--<div class="user-order-number">Заказ № ${orderCode}</div>-->
            <div class="user-order-number">Заказ № A-03</div>
            <div class="user-order-statuses">
                <#if orderStatus='Обрабатывается...'>
                    <div class="user-order-status">
                        <div><i class="fa fa-spinner" aria-hidden="true"></i>
                            <!--<i class="fa fa-clock-o" aria-hidden="true"></i>--></div>
                        <div>${orderStatus}</div>
                    </div>
                    <div class="user-order-status inactive-status">
                        <div><i class="fa fa-cutlery" aria-hidden="true"></i></div>
                        <div>Готовится</div>
                    </div>
                    <div class="user-order-status inactive-status">
                        <div><i class="fa fa-check" aria-hidden="true"></i></div>
                        <div>Готов</div>
                    </div>
                    <div class="user-order-status inactive-status">
                        <div><i class="fa fa-flag-checkered" aria-hidden="true"></i></div>
                        <div>Выдан</div>
                    </div>
                </#if>
            </div>
            <div class="user-order-list-title">Состав заказа</div>
            <#list dishes as dish>
                <div class="user-order-list-item">
                    <div>${dish.name}</div>
                    <div>${dish.price}</div>
                </div>
            </#list>
        </div>
    </div>

</@c.page>
