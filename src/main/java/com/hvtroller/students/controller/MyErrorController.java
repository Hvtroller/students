package com.hvtroller.students.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class MyErrorController implements ErrorController {

    @GetMapping
    public String getError(Model model, HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status == null) {
            return "redirect:/";
        }
        int statusCode = Integer.parseInt(status.toString());

        if(statusCode == HttpStatus.NOT_FOUND.value()) {
            return "error/404";
        }

        return "error/default_error";
    }
}
