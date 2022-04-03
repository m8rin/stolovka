<#--<#include "parts/security.ftlh">-->
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "profileParts/profileEdit.ftlh" as p>
<@c.page>
    <div class="profile-block">
        <div class="profile-avatar">
            <img src="/static/images/avatar.jpg" alt="avatar">
        </div>
        <div class="profile-name">
            <div>${user.username}</div>
        </div>
        <div class="profile-information's">
            <div class="profile-info">
                <div class="info-name">Мобильный телефон:</div>
                <div class="info">${user.phoneNumber}</div>
            </div>
            <div class="profile-info">
                <div class="info-name">E-mail:</div>
                <div class="info">xxxxx</div>
            </div>
            <div class="profile-info">
                <div class="info-name">Дата рождения:</div>
                <div class="info">04.11.2000</div>
            </div>
        </div>
        <div class="profile-buttons">
            <button class="btn" onclick="hideBlock('profile-edit-background')">Редактировать профиль</button>
            <button class="btn">Изменить пароль</button>
        </div>
        <div class="profile-logout-but">
            <@l.logoutBut/>
        </div>
    </div>
    <@p.profileEdit/>
</@c.page>