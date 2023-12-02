package generator.mapper;

import generator.domain.NewsTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author flyingpigeon
* @description 针对表【news_table】的数据库操作Mapper
* @createDate 2023-11-21 14:57:37
* @Entity generator.domain.NewsTable
*/
@Mapper
public interface NewsTableMapper extends BaseMapper<NewsTable> {

}




