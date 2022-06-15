<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="user-order">
        <div class="user-order-block">
            <div class="user-order-number">Заказ № ${order.code!}</div>
            <div class="user-order-statuses">
                <#if order.status == 'PROCESSED'>
                    <div class="user-order-status">
                <#else>
                    <div class="user-order-status inactive-status">
                </#if>
                        <div><i class="fa fa-spinner" aria-hidden="true"></i>
                            <!--<i class="fa fa-clock-o" aria-hidden="true"></i>--></div>
                        <div>Обрабатывается</div>
                    </div>
                <#if order.status == 'PREPARED'>
                    <div class="user-order-status">
                <#else>
                    <div class="user-order-status inactive-status">
                </#if>
                        <div><i class="fa fa-cutlery" aria-hidden="true"></i></div>
                        <div>Готовится</div>
                    </div>
                <#if order.status == 'FINISHED'>
                    <div class="user-order-status">
                <#else>
                     <div class="user-order-status inactive-status">
                </#if>
                         <div><i class="fa fa-check" aria-hidden="true"></i></div>
                         <div>Готов</div>
                    </div>
                <#if order.status == 'CLOSE'>
                        <div class="user-order-status">
                <#else>
                        <div class="user-order-status inactive-status">
                </#if>
                        <div><i class="fa fa-flag-checkered" aria-hidden="true"></i></div>
                        <div>Выдан</div>
                    </div>
            </div>
            <div class="user-order-list-title">Состав заказа</div>
            <#if dishes??>
                <#list dishes as dish>
                    <div class="user-order-list-item">
                        <div>${dish.name!}</div>
                        <div>${dish.price!}</div>
                    </div>
                </#list>
            </#if>

        </div>
    </div>

</@c.page>
