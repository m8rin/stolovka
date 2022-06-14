<#macro login path isRegisterForm>
    <div class="login-block-background" id="login-block-background">
        <div class="login-block">
            <#if !isRegisterForm>
                <div class="login-title">Авторизация</div>
            <#else>
                <div class="login-title">Регистрация</div>
            </#if>

            <form action="${path}" method="post">
                <div class="login-inputs">
                    <input type="text" name="username" placeholder="Логин"/>
                </div>
                <div class="login-inputs">
                    <input type="password" name="password" placeholder="Пароль" autocomplete="new-password"/>
                </div>
                <#if isRegisterForm>
                    <div class="login-inputs">
                        <input type="password" placeholder="Повторите пароль" autocomplete="new-password"/>
                    </div>
                </#if>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn" style="margin-top: 10px">
                    <#if isRegisterForm>Зарегистрироваться<#else>Войти</#if>
                </button>
                <div class="login-registration-link">
                    <#if !isRegisterForm>Еще не зарегестрированы? <a href="/registration">Регистрация</a></#if>
                </div>
                <div class="message">
                    ${message!}
                </div>
            </form>
        </div>

    </div>
</#macro>

<#macro logoutBut>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn2" type="submit">Выйти из профиля</button>
    </form>
</#macro>


<#macro loginBut>
    <a href="/login" class="btn">Войти</a>
</#macro>
