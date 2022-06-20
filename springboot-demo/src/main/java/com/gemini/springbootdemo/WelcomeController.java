package com.gemini.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeController {

    public static final Logger logger= LoggerFactory.getLogger(WelcomeController.class);
    @GetMapping
    private String welcome(@RequestParam("name")String myName){

        logger.info("Hello"+myName);
        return myName;
    }

}
