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
@ApiModel(value="cn-java-reflect-entity-TLinks")
@Data
@Builder
public class TLinks {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String link;

    @ApiModelProperty(value="")
    private String name;

    @ApiModelProperty(value="")
    private Integer clicknum;

    /**
    * 排序字段
    */
    @ApiModelProperty(value="排序字段")
    private Integer sort;

    /**
    * 1为上架，-1为下架
    */
    @ApiModelProperty(value="1为上架，-1为下架")
    private Integer status;

    @ApiModelProperty(value="")
    private Date addtime;

    @ApiModelProperty(value="")
    private Integer isapply;
}