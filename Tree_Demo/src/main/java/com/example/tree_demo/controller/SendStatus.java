package com.example.tree_demo.controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.tree_demo.DTO.treeprinter.legaltree;

@SpringBootApplication
@RestController
public class SendStatus {
    @RequestMapping(value="/getstatus",method= RequestMethod.GET)
    public static boolean sendstatus(){
        System.out.println("Sending status: "+legaltree);
        return legaltree;
    }
}