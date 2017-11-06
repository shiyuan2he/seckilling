var reg = {
    requestUrl_reg : 'http://localhost:8080/sso/reg',
    getData : function(json){
        console.log("回调函数返回值：",json) ;
        if(json.success){
            window.location.href = path + '/seckilling/list' ;
        }else{
            window.location.href = path + '/seckilling/list' ;
        }
    },
    doReg : function(){
        console.log("reg") ;
        var url = reg.requestUrl_reg + "?mobile="+$('#mobile').val()+"&password="+$('#password').val();
        ajax.getJsonp(url,'reg.getData') ;
    }
}
