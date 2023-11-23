package com.example.tree_demo.controller;

import com.example.tree_demo.DTO.treeprinter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static com.example.tree_demo.DTO.treeprinter.*;
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

    public static Set<treeprinter.lineclass> getlinelist() {
        Iterator<treeprinter.lineclass> a=linelist.iterator();
        while(a.hasNext()){
            treeprinter.lineclass temp=a.next();
            System.out.println("line:"+temp.x1+" "+temp.y1+" "+temp.x2+" "+temp.y2);
        }
        return linelist;
    }

    public static Set<treeprinter.nodeclass>getnodelist(){
        Iterator<treeprinter.nodeclass> a=nodelist.iterator();
        while(a.hasNext()){
            treeprinter.nodeclass temp=a.next();
            System.out.println("node:"+temp.x+" "+temp.y+" "+temp.i);
        }
        return nodelist;
    }
}