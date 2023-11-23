package com.example.tree_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tree_demo.domain.TreeStringId;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author flyingpigeon
* @description 针对表【tree_string_id】的数据库操作Service
* @createDate 2023-08-18 00:05:28
*/
@Service
public interface TreeStringIdService extends IService<TreeStringId> {
    public List<TreeStringId> getAll();

    List<TreeStringId> getbyID(int id);
    Boolean deleteByID(int id);
    Boolean add(TreeStringId t);
}
