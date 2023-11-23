package com.example.tree_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tree_demo.domain.TreeStringId;
import com.example.tree_demo.mapper.TreeStringIdMapper;
import com.example.tree_demo.service.TreeStringIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author flyingpigeon
* @description 针对表【tree_string_id】的数据库操作Service实现
* @createDate 2023-08-18 00:05:28
*/
//@Service
public class TreeStringIdServiceImpl extends ServiceImpl<TreeStringIdMapper, TreeStringId>
    implements TreeStringIdService{
    @Autowired
    TreeStringIdMapper treeStringIdMapper;
    @Autowired
    private TreeStringIdService treeStringIdService;
    @Override
    public List<TreeStringId> getAll() {
        return treeStringIdService.list();
    }

    @Override
    public List<TreeStringId> getbyID(int id) {
        QueryWrapper<TreeStringId> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("TreeStringId", id);
        return treeStringIdMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean deleteByID(int id) {
        try {
            QueryWrapper<TreeStringId> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("TreeStringId", id);
            treeStringIdMapper.deleteById(queryWrapper);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean add(TreeStringId t) {
        try{
            treeStringIdMapper.insert(t);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}




