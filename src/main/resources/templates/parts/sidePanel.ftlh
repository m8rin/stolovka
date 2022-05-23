<#include "security.ftlh">
<#macro panel>
    <div class="side-panel hide" id="side-panel">
        <div class="menu-panel">
            <div class="menu-profile-and-button">
                <a class="header-user" href="/profile">
                    <i class="fa fa-user fa-2x" aria-hidden="true"></i>
<#--                    <div>${name}</div>-->
                </a>
                <button class="menu-close-but" onclick="hideBlock('side-panel')">
                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                </button>
            </div>
            <div class="menu-items-block">
                <div class="menu-item img-menu"onclick="window.location.replace('/')">
                    <a href="/">Меню</a>
                </div>
                <div class="menu-item img-profile" onclick="window.location.replace('/profile')">
                    <a href="/profile">Профиль</a>
                </div>
                <div class="menu-item img-basket" onclick="window.location.replace('/basket')">
                    <a href="/basket">Корзина</a>
                </div>
                <div class="menu-item img-map" onclick="window.location.replace('/map')">
                    <a href="/map">Мы на карте</a>
                </div>
                <div class="menu-item img-orders" onclick="window.location.replace('/orders')">
                    <a href="/orders">Заказы</a>
                </div>
                <#if isAdmin>
                    <div class="menu-item admin-item" onclick="window.location.replace('/editDishes')">
                        <a href="/editDishes">Редактирование меню</a>
                    </div>
                </#if>
            </div>

        </div>
    </div>
</#macro>
