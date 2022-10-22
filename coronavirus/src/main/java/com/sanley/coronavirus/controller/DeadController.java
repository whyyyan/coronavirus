package com.sanley.coronavirus.controller;

import com.github.pagehelper.PageInfo;
import com.sanley.coronavirus.entity.Dead;
import com.sanley.coronavirus.entity.User;
import com.sanley.coronavirus.service.DeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeadController {
    @Autowired
    DeadService service;

    @RequestMapping(value = "dead/list",method = RequestMethod.GET)
    public String list(Model model,@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Dead> deads = service.findAll( page, size);
        PageInfo<User> pageInfo=new PageInfo(deads);
        model.addAttribute("pageInfo",pageInfo);
        return "deadList";
    }

    //添查看死亡详情
    @RequestMapping(value = "dead/info/{id}",method = RequestMethod.GET)
    public String info(@PathVariable("id")int id, Model model){
        Dead dead = service.get(id);
        model.addAttribute("dead",dead);
        return "deadInfo";
    }

    /**
     * 查询死者
     * @param model
     * @param name
     * @return
     */
    @RequestMapping(value = "/dead/listByDeadName")
    public String listByDeadName(Model model, @RequestParam(name = "name", required = true) String name) {
        List<Dead> deads = service.findByName(name);
        System.out.println(deads);
        PageInfo<Dead> pageInfo = new PageInfo<>(deads);
        model.addAttribute("pageInfo", pageInfo);
        return "deadList";
    }

}
