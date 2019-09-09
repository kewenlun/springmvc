function yanzheng() {
    // var username=document.getElementById('username');
    // var pwd=document.getElementById('psw');
    if (form.username.value=="") {
        alert("用户名不能为空");
        // username.focus();
        return false;
    }
    if (form.psw.value=="") {
        alert("密码不能为空");
        // psw.focus();
        return false;
    }
    return true;
}