package com.sanley.coronavirus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: bonbon
 * @Date: 2021/4/17 23:24
 */
@Controller
public class DashBoardController {

    @RequestMapping(value = "/dashboard/index")
    @ResponseBody
    public String toDashBoard(Model model) throws IOException {
        URL u1 = new URL("https://zaixianke.com/yq/all");
        URLConnection conn = u1.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String text1 = br.readLine();
        br.close();
        return text1;
    }

    @RequestMapping(value = "/to/dashboard")
    public String toDashBoards() {
        return "dashboard";
    }

    @RequestMapping(value = "/dashboard/vaccination")
    public String toVaccination() {
        return "vaccination";
    }

    @RequestMapping(value = "/dashboard/acidTest")
    public String toAcidTest() {
        return "nucleicAcidTest";
    }

    @RequestMapping(value = "/dashboard/supply")
    public String toSupply() {
        return "supply";
    }

    @RequestMapping(value = "/noAccess")
    public String toNoAccess() {
        return "noAccess";
    }
}
