package generator.service;

import generator.domain.NewsTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author flyingpigeon
* @description 针对表【news_table】的数据库操作Service
* @createDate 2023-11-21 14:57:37
*/
public interface NewsTableService extends IService<NewsTable> {
    public List<NewsTable> getall();
    List<NewsTable> getbyID(int id);
    Boolean deleteByID(int id);
    Boolean add(NewsTable t);
    Boolean change(int id, NewsTable t);
}
