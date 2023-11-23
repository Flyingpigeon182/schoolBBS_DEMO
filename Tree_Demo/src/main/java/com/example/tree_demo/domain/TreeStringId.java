package com.example.tree_demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName tree_string_id
 */
@TableName(value ="tree_string_id")
public class TreeStringId implements Serializable {
    /**
     * 建树字符串位置索引
     */
    @TableId(type = IdType.AUTO)
    private Integer treeStringId;

    /**
     * 建树字符串项
     */
    private String treeString;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 建树字符串位置索引
     */
    public Integer getTreeStringId() {
        return treeStringId;
    }

    /**
     * 建树字符串位置索引
     */
    public void setTreeStringId(Integer treeStringId) {
        this.treeStringId = treeStringId;
    }

    /**
     * 建树字符串项
     */
    public String getTreeString() {
        return treeString;
    }

    /**
     * 建树字符串项
     */
    public void setTreeString(String treeString) {
        this.treeString = treeString;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TreeStringId other = (TreeStringId) that;
        return (this.getTreeStringId() == null ? other.getTreeStringId() == null : this.getTreeStringId().equals(other.getTreeStringId()))
            && (this.getTreeString() == null ? other.getTreeString() == null : this.getTreeString().equals(other.getTreeString()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTreeStringId() == null) ? 0 : getTreeStringId().hashCode());
        result = prime * result + ((getTreeString() == null) ? 0 : getTreeString().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", treeStringId=").append(treeStringId);
        sb.append(", treeString=").append(treeString);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    public TreeStringId(String input){
        this.treeString=input;
    }
}