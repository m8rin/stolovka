<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="dish-edit">
        <div class="main-title">Редактирование блюда</div>
        <form action="/dish" method="post" enctype="multipart/form-data">
            <div class="input-container">
                <input type="file" name="file">
            </div>
            <div class="input-container">
                <#if dish.imgURL??>
                    <img class="dish-img" src="${dish.imgURL!""}" alt="dish">
                <#else>
                    <img class="dish-img" src="/static/img/food.png" alt="dish">
                </#if>
            </div>
            <div class="input-container">
                <input class="input" type="text" name="name" value="${dish.name}" placeholder=" "/>
                <div class="cut"></div>
                <label class="placeholder">Название</label>
            </div>
            <div class="input-container">
                <input class="input" type="text" name="price" value="${dish.price}" placeholder=" "/>
                <div class="cut"></div>
                <label class="placeholder" >Стоимость</label>
            </div>
            <div class="input-container">
                <select class="input" type="text" name="category" value="${dish.category}" placeholder=" ">
                    <option>Первые</option>
                    <option>Вторые</option>
                    <option>Гарниры</option>
                    <option>Напитки</option>
                    <option>Холодные</option>
                    <option>Десерты</option>
                    <option>Другое</option>
                </select>
                <div class="cut"></div>
                <label class="placeholder">Категория</label>
            </div>

            <input type="hidden" value="${dish.id}" name="dishId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn" style="margin-top: 30px; height: 40px; width: 130px">Сохранить</button>
        </form>
    </div>
</@c.page>
