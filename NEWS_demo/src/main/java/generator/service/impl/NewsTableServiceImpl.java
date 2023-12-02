package generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.NewsTable;
import generator.service.NewsTableService;
import generator.mapper.NewsTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author flyingpigeon
* @description 针对表【news_table】的数据库操作Service实现
* @createDate 2023-11-21 14:57:37
*/
@Service
public class NewsTableServiceImpl extends ServiceImpl<NewsTableMapper, NewsTable>
    implements NewsTableService{
    @Autowired
    NewsTableMapper newstablemapper;
    @Autowired
    private NewsTableService _newstableservice;

    @Override
    public List<NewsTable> getall() {
        return _newstableservice.list();
    }

    @Override
    public List<NewsTable> getbyID(int id) {
        QueryWrapper<NewsTable> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("news_ID", id);
        return newstablemapper.selectList(queryWrapper);
    }

    @Override
    public Boolean deleteByID(int id) {
        try {
            QueryWrapper<NewsTable> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("news_ID", id);
            return newstablemapper.delete(queryWrapper)!=0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean add(NewsTable t) {
        try{
            return newstablemapper.insert(t)!=0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean change(int id, NewsTable t){
        try{
            QueryWrapper<NewsTable> wrapper=new QueryWrapper<>();
            wrapper.eq("News_ID",id);
            return newstablemapper.update(t, wrapper) != 0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}