package com.example.demo.controller;

import com.example.demo.DTO.treeprinter;
import com.example.demo.domain.TreeStringId;
import com.example.demo.service.TreeStringIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.example.demo.DTO.treeprinter.dobody2;

@RestController
@RequestMapping("operate")
@CrossOrigin
public class MysqlController {
    @Autowired
    private TreeStringIdService treeStringIdService;
    @RequestMapping("/add")
    Boolean addstring(@RequestParam(value= "string")String input){
        treeprinter.treestring(input);
        if(treeprinter.legaltree){
            treeStringIdService.add(new TreeStringId(input));
            return true;
        }
        else return false;
    }
    @RequestMapping("/get")
    String domap(@RequestParam(value= "ID")int ID){
        System.out.println("收到的ID请求号："+ID);
        try{
            TreeStringId treeStringId=treeStringIdService.getbyID(ID).get(0);
            String target=treeStringId.getTreeString();
            dobody2(target);
            return target;
        }catch(Exception e){
            e.printStackTrace();
            return "error!!!";
        }
    }
    @RequestMapping("/show")
    Map<Integer,String> showtable(){
        List<TreeStringId> temp = treeStringIdService.getAll();
        Map<Integer,String> table=new HashMap<>();
        for (TreeStringId t:temp) {
            table.put(t.getTreeStringId(),t.getTreeString());
        }
        return table;
    }
    @RequestMapping("/delete")
    int deletestring(@RequestParam(value= "ID")int ID){
        System.out.println("收到的ID请求号："+ID);
        return treeStringIdService.deleteByID(ID)?1:0;
    }
}