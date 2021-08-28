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
@ApiModel(value="cn-java-reflect-entity-TResource")
@Data
@Builder
public class TResource {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String content;

    /**
    * 链接
    */
    @ApiModelProperty(value="链接")
    private String link;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 增加时间
    */
    @ApiModelProperty(value="增加时间")
    private Date addtime;

    /**
    * 审核
    */
    @ApiModelProperty(value="审核")
    private Integer status;
}