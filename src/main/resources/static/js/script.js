document.onclick = function (e) {
    if (e.target.className === "login-block-background") {
        document.getElementById("login-block-background").style.display = "none";
    }
    if (e.target.className === "side-panel") {
        hidePanel();
    }
};

function hidePanel() {
    const panel = document.getElementById("side-panel");
    panel.classList.toggle("hide");
}

function checkInputs() {
    const inp1 = document.getElementsByName("password");
    console.log(inp1);
}