var login = {
    requestUrl_login : 'http://localhost:8080/sso/login',
    requestUrl_logout : 'http://localhost:8080/sso/logout',
    getData : function(json){
        console.log("回调函数返回值：",json) ;
        if(json.success){
            window.location.href = path + '/seckilling/list' ;
        }else{
            if(json.code == 'SSO9999'){
                login.changeImageCode();
            }else{
                window.location.href = path + '/seckilling/list' ;
            }
        }
    },
    doLogin : function(){
        console.log("login") ;
        var url = login.requestUrl_login + "?mobile="+$('#mobile').val()+"&password="+$('#password').val()+"&codeImage="+$("#codeImage").val();
        ajax.getJsonp(url,"login.getData") ;
    },
    logout : function(){
        console.log("logout") ;
        ajax.getJsonp(login.requestUrl_logout,login.getData()) ;
    },
    changeImageCode : function () {
        console.log("changeImageCode");
        $("#codeImg")[0].src = "http://localhost:8080/sso/image/kaptchaCode";
    }
}
