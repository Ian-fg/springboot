package com.how2java.springboot.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        System.out.println("----do it --------------");
        mav.addObject("exception", e);
        System.out.println(e.toString());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }

}