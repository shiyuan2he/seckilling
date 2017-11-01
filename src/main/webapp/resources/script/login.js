var login = {
    requestUrl : 'http://localhost:8080/sso/login',
    getData : function(json){
        console.log("回调函数返回值：",json) ;
    },
    init : function(){
        var url = login.requestUrl + "?mobile=11111111111&password=123" ;
        //login.getJsonp(url,login.getData) ;
        login.testJson(url) ;
    },
    getJsonp: function(serviceUrl,callbackFunc){
        $.ajax({
            type:"get",
            dataType : "jsonp",
            jsonp : "callback",
            jsonpCallback : callbackFunc,
            url:serviceUrl,
            dataType:'jsonp',
            success:function(data){
                console.log("jsonp请求成功返回：",data) ;
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                console.log("jsonp请求成失败返回：",XMLHttpRequest.status,XMLHttpRequest.readyState,textStatus) ;
            }
        });
    },
    testJson : function(url){
        $.ajax({
            type:'get',
            url:url,
            dataType:'jsonp',
            jsonp:"callback",
            success:function (data) {
                console.log(data) ;
                if(data.success){
                    window.location.href = '/seckilling/list' ;
                }
            },
            error:function (err) {
                alert('出现错误了!!!');
            }
        });
    },
    getJson : function(serviceUrl){
        $.ajax({
            type : "get",
            dataType : "json",
            jsonp : "callback",
            url : serviceUrl,
            success:function(data){
                console.log(data) ;
                if(data.success){
                    window.location.href = '<%=basePath%>/seckilling/list' ;
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    },
    doLogin : function(){
        console.log("login") ;
        var url = login.requestUrl + "?mobile="+$('#mobile').val()+"&password="+$('#password').val();
        //login.getJsonp(url,'login.getData') ;
        login.testJson(url) ;
    }
}
