var seckilling = {
    URL : "" ,
    validatePhone : function(phone){
        if(phone && phone.length == 11 && !isNaN(phone)){
            return true ;
        }else{
            return false ;
        }
    },
    detail : {
        init : function(params) {
            var seckillingPhone = $.cookie('seckillingPhone');
            var startTime = params['startTime'] ;
            var endTime = params['endTime'] ;
            var seckillingId = params['seckillingId'] ;
            // cookie中没有手机号
            if(!seckilling.validatePhone(seckillingPhone)){
                var killPhoneModal = $('#')
            }

        }
    }

};