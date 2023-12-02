package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.domain.TreeStringId;

import java.util.List;

/**
* @author flyingpigeon
* @description 针对表【tree_string_id】的数据库操作Service
* @createDate 2023-08-18 00:05:28
*/
public interface TreeStringIdService extends IService<TreeStringId> {
    public List<TreeStringId> getAll();

    public List<TreeStringId> getbyID(int id);
    public Boolean deleteByID(int id);
    public Boolean add(TreeStringId t);
}
