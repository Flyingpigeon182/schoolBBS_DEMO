package Controller;
import generator.domain.NewsTable;
import generator.service.NewsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("operate")
@CrossOrigin
public class mySQLcontroller {
    @Autowired
    private NewsTableService newsTableService;

    @RequestMapping("/add")
    Boolean addNews(@RequestParam(value= "title")String title,@RequestParam(value= "test")String test){
        System.out.println("收到的添加新闻请求：\n标题："+title+"\n正文"+test);
        return newsTableService.add(new NewsTable(title,test));
    }

    @RequestMapping("/delete")
    int deletestring(@RequestParam(value= "ID")int ID){
        System.out.println("收到的删除ID请求号："+ID);
        return newsTableService.deleteByID(ID)?1:0;
    }

    @RequestMapping("/getall")
    Map<String,List<NewsTable>> sendnews(){
        Map<String, List<NewsTable>> temp = new HashMap<>();
        System.out.println("发送所有新闻数据。");
        temp.put("newslist",newsTableService.getall());
        return temp;
    }

    @RequestMapping("/change")
    Boolean changeNews(@RequestParam(value= "id")int id,@RequestParam(value= "title")String title,
                       @RequestParam(value= "test")String test){
        System.out.println("收到的修改新闻请求：\nID:"+id+"\n标题："+title+"\n正文"+test);
        return newsTableService.change(id,new NewsTable(title,test));
    }
}