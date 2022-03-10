<#include "security.ftlh">
<#macro panel>
    <div class="side-panel hide" id="side-panel">
        <div class="menu-panel">
            <div class="menu-profile-and-button">
                <a class="header-user" href="/">
                    <i class="fa fa-user fa-2x" aria-hidden="true"></i>
                    <div>${name}</div>
                </a>
                <button class="menu-close-but" onclick="hidePanel()">
                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                </button>
            </div>
            <div class="menu-items-block">
                <div class="menu-item">
                    <a href="/">Меню</a>
                </div>
                <div class="menu-item">
                    <a href="/">Меню</a>
                </div>
                <div class="menu-item">
                    <a href="/">Меню</a>
                </div>
                <div class="menu-item">
                    <a href="/">Меню</a>
                </div>
            </div>

        </div>
    </div>
</#macro>