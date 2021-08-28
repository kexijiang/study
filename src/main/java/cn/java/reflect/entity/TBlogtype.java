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
@ApiModel(value="cn-java-reflect-entity-TBlogtype")
@Data
@Builder
public class TBlogtype {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 类别名称
    */
    @ApiModelProperty(value="类别名称")
    private String typename;

    /**
    * 该类别下的数量
    */
    @ApiModelProperty(value="该类别下的数量")
    private Integer num;

    @ApiModelProperty(value="")
    private Date addtime;
}