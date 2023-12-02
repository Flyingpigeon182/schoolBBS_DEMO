package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.TreeStringId;
import com.example.demo.mapper.TreeStringIdMapper;
import com.example.demo.service.TreeStringIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author flyingpigeon
* @description 针对表【tree_string_id】的数据库操作Service实现
* @createDate 2023-08-18 00:05:28
*/
@Service
public class TreeStringIdServiceImpl extends ServiceImpl<TreeStringIdMapper, TreeStringId>
    implements TreeStringIdService{
    @Autowired
    TreeStringIdMapper treeStringIdMapper;
    @Override
    public List<TreeStringId> getAll() {
        return treeStringIdMapper.selectList(null);
    }

    @Override
    public List<TreeStringId> getbyID(int id) {
        System.out.println("getbyID:"+id);
        QueryWrapper<TreeStringId> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tree_string_id", id );
        return treeStringIdMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean deleteByID(int id) {
        try {
            QueryWrapper<TreeStringId> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("tree_string_id", id );
            if(!treeStringIdMapper.exists(queryWrapper))return false;
            treeStringIdMapper.deleteById(id);
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




