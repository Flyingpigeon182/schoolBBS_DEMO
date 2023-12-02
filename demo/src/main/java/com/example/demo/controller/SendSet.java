package com.example.demo.controller;

import com.example.demo.DTO.treeprinter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static com.example.demo.DTO.treeprinter.*;
@SpringBootApplication
@RestController
public class SendSet {
    @RequestMapping ("/getset")
    public static Map<String,Object> sendset(){
        Map<String,Object> temp=new HashMap<>();
        temp.put("line",getlinelist());
        temp.put("node",getnodelist());
        return temp;
    }

    public static Set<lineclass> getlinelist() {
        Iterator<lineclass> a=linelist.iterator();
        while(a.hasNext()){
            lineclass temp=a.next();
            System.out.println("line:"+temp.x1+" "+temp.y1+" "+temp.x2+" "+temp.y2);
        }
        return linelist;
    }

    public static Set<nodeclass>getnodelist(){
        Iterator<nodeclass> a=nodelist.iterator();
        while(a.hasNext()){
            nodeclass temp=a.next();
            System.out.println("node:"+temp.x+" "+temp.y+" "+temp.i);
        }
        return nodelist;
    }
}