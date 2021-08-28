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
@ApiModel(value="cn-java-reflect-entity-TLog")
@Data
@Builder
public class TLog {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String usertype;

    @ApiModelProperty(value="")
    private String ip;

    @ApiModelProperty(value="")
    private String description;

    @ApiModelProperty(value="")
    private String param;

    @ApiModelProperty(value="")
    private Date addtime;
}