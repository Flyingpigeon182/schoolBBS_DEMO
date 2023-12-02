package com.example.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.DTO.treeprinter;
@SpringBootApplication
@Controller
public class GetString {
    @RequestMapping(value="/getstring",method= RequestMethod.POST)
    @ResponseBody
    public String getstring(@RequestParam(value= "Treestring")String string)
    {
        treeprinter.treestring(string);
        return "success";
    }
}