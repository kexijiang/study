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
@ApiModel(value="cn-java-reflect-entity-TVisit")
@Data
@Builder
public class TVisit {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String ip;

    @ApiModelProperty(value="")
    private String useragent;

    @ApiModelProperty(value="")
    private String city;

    @ApiModelProperty(value="")
    private String url;

    /**
    * 浏览器
    */
    @ApiModelProperty(value="浏览器")
    private String browsertype;

    /**
    * OS
    */
    @ApiModelProperty(value="OS")
    private String platformtype;

    @ApiModelProperty(value="")
    private Date time;
}