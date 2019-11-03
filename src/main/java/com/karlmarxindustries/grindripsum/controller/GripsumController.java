package com.karlmarxindustries.grindripsum.controller;

import com.karlmarxindustries.grindripsum.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GripsumController {
    @Autowired
    ServiceImpl service;

}
