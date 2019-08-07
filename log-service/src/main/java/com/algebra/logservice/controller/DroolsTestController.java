package com.algebra.logservice.controller;

import com.algebra.logservice.interfaces.IDroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author al
 * @date 2019/8/7 9:11
 * @description
 */
@RestController
public class DroolsTestController {

    @Autowired
    private IDroolsService droolsService;

    @GetMapping("/showRults")
    public String showRults(){
        return droolsService.fireRule();
    }

}
