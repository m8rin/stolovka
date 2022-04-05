<#macro profileEdit>
    <div class="profile-edit-background hide" id="profile-edit-background">
        <div class="profile-edit-block">
            <div class="profile-edit-block-title">Редактировать данные</div>
            <#--            <form action="/user" method="post" id="userEditForm">-->
            <#--                <div class="profile-edit-inputs">-->
            <#--                    <input type="text" name="username" id="username" value="${user.name}">-->
            <#--                    <label for="username">Имя</label>-->
            <#--                </div>-->
            <#--                <div class="profile-edit-inputs">-->
            <#--                    <input type="tel" name="phoneNumber" id="phoneNumber" value="${user}">-->
            <#--                    <label for="username">Мобильный телефон</label>-->
            <#--                </div>-->
            <#--                <div class="profile-edit-inputs">-->
            <#--                    <input type="email" name="email" id="email" value="${user}">-->
            <#--                    <label for="username">E-mail</label>-->
            <#--                </div>-->
            <#--                <br>-->
            <#--                <input type="hidden" value="${user.id}" name="userId">-->
            <#--                <input type="hidden" value="${_csrf.token}" name="_csrf">-->
            <#--            </form>-->
            <button class="btn2" type="submit" form="userEditForm">Сохранить</button>
            <button class="btn2" onclick="hideBlock('profile-edit-background')">Закрыть</button>
        </div>
    </div>
</#macro>