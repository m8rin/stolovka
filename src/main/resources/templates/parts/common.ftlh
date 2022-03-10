<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Stolovka</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/static/css/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/static/css/style.css">
        <script src="/static/js/script.js"></script>

    </head>
    <body>
    <#include "navbar.ftlh">
    <div>
        <#nested>
    </div>
    </body>
    </html>
</#macro>