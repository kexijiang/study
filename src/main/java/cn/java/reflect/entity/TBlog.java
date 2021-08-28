package cn.java.reflect.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@ApiModel(value="cn-java-reflect-entity-TBlog")
@Data
public class TBlog {
    /**
    * 自增
    */
    @ApiModelProperty(value="自增")
    private Integer id;

    /**
    * 博客标题
    */
    @ApiModelProperty(value="博客标题")
    private String title;

    /**
    * 博客简介/摘要
    */
    @ApiModelProperty(value="博客简介/摘要")
    private String introduction;

    @ApiModelProperty(value="")
    private String keyword;

    /**
    * 封面缩略图等
    */
    @ApiModelProperty(value="封面缩略图等")
    private String images;

    /**
    * 博客内容
    */
    @ApiModelProperty(value="博客内容")
    private String content;

    /**
    * 点击量
    */
    @ApiModelProperty(value="点击量")
    private Integer clicknum;

    /**
    * 评论量
    */
    @ApiModelProperty(value="评论量")
    private Integer commentnum;

    /**
    * 点赞量
    */
    @ApiModelProperty(value="点赞量")
    private Integer agreenum;

    /**
    * 1置顶，0普通
    */
    @ApiModelProperty(value="1置顶，0普通")
    private Integer istop;

    /**
    * 博主推荐,1为推荐，0为普通
    */
    @ApiModelProperty(value="博主推荐,1为推荐，0为普通")
    private Integer isrecommend;

    @ApiModelProperty(value="")
    private Date updatetime;

    @ApiModelProperty(value="")
    private Date addtime;

    /**
    * -1为草稿，1为正文，2为回收站
    */
    @ApiModelProperty(value="-1为草稿，1为正文，2为回收站")
    private Integer status;

    /**
    * 类别
    */
    @ApiModelProperty(value="类别")
    private Integer typeId;
}