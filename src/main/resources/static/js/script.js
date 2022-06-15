document.onclick = function (e) {
    if (e.target.className === "login-block-background") {
        document.getElementById("login-block-background").style.display = "none";
    }
    if (e.target.className === "side-panel") {
        hideBlock("side-panel");
    }
};

function hideBlock(id) {
    const block = document.getElementById(id);
    block.classList.toggle("hide");
}

function hideOrderDishes(e){
    let child = "";
    if(e.classList[0] === "orderList-item"){
        e.classList.toggle("border");
        child = e.nextElementSibling;
    }
    else{
        child = e.querySelector('.admin-orders-item-dishes');
    }
    child.classList.toggle("hidden");
}
