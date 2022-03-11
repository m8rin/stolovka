<#include "security.ftlh">
<#import "login.ftlh" as l>
<#import "sidePanel.ftlh" as sp>

<div class="header-controls">
    <div class="header-left-controls">
        <button class="header-menu" onclick="hidePanel()">
            <i class="fa fa-bars fa-2x" aria-hidden="true"></i>
        </button>
        <div class="header-address">
            <div>г. Уфа</div>
            <div>Космонавтов, 4а</div>
        </div>
        <div class="header-search">
            <form>
                <i class="fa fa-search" aria-hidden="true"></i>
                <input type="text" placeholder="Введите название блюда">
            </form>
        </div>
    </div>
    <div class="header-right-controls">
        <#if known>
            <a class="header-user" href="/profile">
                <div>${name}</div>
                <i class="fa fa-user fa-2x" aria-hidden="true"></i>
            </a>
        <#else>
            <a class="header-user" href="/login">
                <i class="fa fa-user fa-2x" aria-hidden="true"></i>
            </a>
        </#if>
        <a class="header-basket" href="/basket">
            <i class="fa fa-shopping-basket fa-2x" aria-hidden="true"></i>
        </a>

    </div>
</div>

<@sp.panel/>

<#--
<a href="/">Stolovka</a>
<div>
    <ul>
        <#if isAdmin>
            <li>
                <a href="/user">Список пользователей</a>
            </li>
        </#if>
    </ul>

</div>
-->
<@l.logoutBut/>