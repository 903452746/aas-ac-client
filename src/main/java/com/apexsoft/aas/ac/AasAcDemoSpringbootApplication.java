package com.apexsoft.aas.ac;

import com.alibaba.fastjson.JSONObject;
import com.apexsoft.aas.ac.model.AuthUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@Controller
public class AasAcDemoSpringbootApplication {

    public static void main(String[] args) {


        SpringApplication.run(AasAcDemoSpringbootApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public JSONObject index() {
        JSONObject json = new JSONObject();
        json.put("note","我是首页");
        return json;
    }

    @RequestMapping("/session")
    @ResponseBody
    public AuthUser session(HttpServletRequest request, HttpServletResponse response) {
        AuthUser acUser = AcSession.getAcUser();
        return acUser;
    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        AcSession.acLogout(AcSession.getAcTicket(request),request,response);
    }
}
