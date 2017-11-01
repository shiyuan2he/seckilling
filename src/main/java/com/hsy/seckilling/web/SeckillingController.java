package com.hsy.seckilling.web;

import com.hsy.seckilling.dto.Exposer;
import com.hsy.seckilling.dto.SecKillingExecute;
import com.hsy.seckilling.dto.SeckillingResult;
import com.hsy.seckilling.entity.TSeckillingItem;
import com.hsy.seckilling.service.ITSeckillingItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.web
 * @date 2017/10/31 11:11
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Controller
@RequestMapping("/seckilling")
public class SeckillingController {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @Autowired
    private ITSeckillingItemService seckillingItemService ;
    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    public String list(Model model){
        List<TSeckillingItem> list = seckillingItemService.getSeckillItemList() ;
        if(null!=list&&list.size()>0){
            model.addAttribute("list",list);
        }
        return "list" ;
    }
    @RequestMapping(
            value = "/{seckillingId}/detail",
            method = RequestMethod.GET
    )
    public String detail(@PathVariable(value = "seckillingId") long seckillingId,Model model){
        if(0 == seckillingId) return "redirect:/seckill/list" ;
        TSeckillingItem seckillingItem = seckillingItemService.getById(seckillingId) ;
        if(null==seckillingItem) return "redirect:/seckill/list" ;
        model.addAttribute("seckillingItem",seckillingItem) ;
        return "detail" ;
    }
    @RequestMapping(
            value = "/{seckillingId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"}
    )
    @ResponseBody
    public SeckillingResult<Exposer> exposer(@PathVariable(value = "seckillingId") long seckillingId){
        Exposer exposer = seckillingItemService.exportSeckillingUrl(seckillingId) ;
        if(null != exposer) return new SeckillingResult(true,exposer);
        return new SeckillingResult(false,"失败");
    }
    @RequestMapping(
            value = "/{seckillingId}/{md5}/execute",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"}
    )
    @ResponseBody
    public SeckillingResult<SecKillingExecute> executeSeckillingResult(
            @PathVariable(value = "seckillingId") long seckillingId,
            @PathVariable(value = "md5") String md5,
            @CookieValue(value = "seckillingPhone",required = false) long seckillingPhone){
        if(0 == seckillingPhone) return new SeckillingResult(false,"用户未注册") ;
        try{
            SecKillingExecute secKillingExecute = seckillingItemService.executeSeckilling(seckillingId,seckillingPhone,md5) ;
            if(null != secKillingExecute){
                return new SeckillingResult<>(true,secKillingExecute) ;
            }
        }catch(Exception e){
            _logger.error(e.getMessage(),e);
            return new SeckillingResult<>(false,e.getMessage()) ;
        }
        return new SeckillingResult<>(false,"系统异常");
    }
    @RequestMapping(
            value = "/time/now",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"}
    )
    @ResponseBody
    public SeckillingResult<Long> getTime(){
        Date date = Calendar.getInstance().getTime() ;
        return new SeckillingResult<>(true ,date.getTime()) ;
    }
}
