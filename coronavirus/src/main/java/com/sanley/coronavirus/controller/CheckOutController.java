package com.sanley.coronavirus.controller;

import com.github.pagehelper.PageInfo;
import com.sanley.coronavirus.entity.CheckOut;
import com.sanley.coronavirus.entity.Cure;
import com.sanley.coronavirus.entity.User;
import com.sanley.coronavirus.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Author: bonbon
 * @Date: 2021/4/15 15:48
 */
@Controller
public class CheckOutController {
    @Autowired
    CheckOutService checkOutService;

    //打卡
    @RequestMapping(value = "/checkOut/toAdd")
    public String toAdd() {
        return "checkOutAdd";
    }

    //打卡
    @RequestMapping(value = "/checkOut/add", method = RequestMethod.POST)
    public String addCheckOut(@RequestParam("currentPosition") String currentPosition, @RequestParam("bodyTemperature") Double bodyTemperature,
                             @RequestParam("healthState") String healthState, @RequestParam("isToHighArea") String isToHighArea,
                             @RequestParam("isTouch") String isTouch, @RequestParam("remarks") String remarks,
                              @RequestParam("name") String name, @RequestParam("checkOutDate") Date checkOutDate) {
        CheckOut checkOut = new CheckOut().setCurrentPosition(currentPosition).setBodyTemperature(bodyTemperature)
                .setHealthState(healthState).setIsToHighArea(isToHighArea).setIsTouch(isTouch)
                .setRemarks(remarks).setName(name).setCheckOutDate(checkOutDate);
        checkOutService.add(checkOut);
        return "redirect:/checkOut/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping(value = "/checkOut/list", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25")int size){
        java.util.List<CheckOut> checkOuts = checkOutService.findAll(page,size);
        PageInfo<User> pageInfo=new PageInfo(checkOuts);
        model.addAttribute("pageInfo",pageInfo);
        return "checkOutList";
    }

    @RequestMapping(value = "/checkOut/listByCheckOutName")
    public String listByCureName(Model model, @RequestParam(name = "name", required = true) String name) {
        java.util.List<CheckOut> checkOut = checkOutService.findByName(name);
        PageInfo<Cure> pageInfo = new PageInfo(checkOut);
        model.addAttribute("pageInfo", pageInfo);
        return "checkOutList";
    }
}
