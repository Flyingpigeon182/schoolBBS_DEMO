package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName news_table
 */
@TableName(value ="news_table")
public class NewsTable implements Serializable {
    @TableId(value ="news_ID",type = IdType.AUTO)
    private Integer newsid;
    private String newsTitle;
    private String newsTest;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * 
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * 
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 
     */
    public String getNewsTest() {
        return newsTest;
    }

    /**
     * 
     */
    public void setNewsTest(String newsTest) {
        this.newsTest = newsTest;
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
        NewsTable other = (NewsTable) that;
        return (this.getNewsid() == null ? other.getNewsid() == null : this.getNewsid().equals(other.getNewsid()))
            && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
            && (this.getNewsTest() == null ? other.getNewsTest() == null : this.getNewsTest().equals(other.getNewsTest()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsid() == null) ? 0 : getNewsid().hashCode());
        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
        result = prime * result + ((getNewsTest() == null) ? 0 : getNewsTest().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsid=").append(newsid);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsTest=").append(newsTest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    public NewsTable(String newsTitle,String newsTest){
        this.newsTest=newsTest;
        this.newsTitle=newsTitle;
    }
}