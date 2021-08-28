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
@ApiModel(value="cn-java-reflect-entity-TBlackip")
@Data
@Builder
public class TBlackip {


    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private Integer vid;

    @ApiModelProperty(value="")
    private String ip;

    @ApiModelProperty(value="")
    private String city;

    @ApiModelProperty(value="")
    private String browsertype;

    @ApiModelProperty(value="")
    private String platformtype;

    @ApiModelProperty(value="")
    private Date time;
}