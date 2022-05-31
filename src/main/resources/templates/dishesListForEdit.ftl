<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="dishes-list-edit">
        <div style="background: #ada096; height: 100%; margin: 0; ">Код</div>
        <div style="background: #ada096; height: 100%; margin: 0;">Название</div>
        <div style="background: #ada096; height: 100%; margin: 0;">Категория</div>
        <div style="background: #ada096; height: 100%; margin: 0; ">Цена</div>
        <div style="background: #ada096;height: 100%; margin: 0; "></div>
        <#list dishes as dish>
            <div>${dish.code}</div>
            <div>${dish.name}</div>
            <div>${dish.category!"Не задана"}</div>
            <div>${dish.price} ₽</div>
            <a href="/dish/${dish.id}" style="color: black; text-align: center"><i class="fa fa-pencil" aria-hidden="true"></i></a>
        </#list>
    </div>
</@c.page>
