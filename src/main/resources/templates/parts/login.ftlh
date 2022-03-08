<#macro login path isRegisterForm>

    <div class="form-group row">
        <label class="col"> </label>
    </div>
    <div class="container align-middle">
        <div class="row justify-content-center align-items-center">
            <form action="${path}" method="post">
                <div class="form-group row ">
                    <label class="col-sm-5 col-form-label">Имя пользователя:</label>
                    <div class="col-sm-6">
                        <input type="text" name="username" class="form-control" placeholder="Имя пользователя"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label">Пароль:</label>
                    <div class="col-sm-6">
                        <input type="password" name="password" class="form-control" placeholder="Пароль"/>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-secondary btn-sm"
                        type="submit"><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
                <div class="form-group row">
                    <label class="col-sm-5 col-form-label"></label>
                    <div class="row gy-5">
                        <#if !isRegisterForm><a href="/registration">Регистрация</a></#if>
                    </div>
                </div>
            </form>
        </div>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-secondary btn-sm" type="submit">Выйти</button>
    </form>
</#macro>