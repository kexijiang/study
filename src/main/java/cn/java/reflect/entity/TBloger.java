package cn.java.reflect.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author: Jiang
 * @createTime: ${Date} 11:40
 * @description: 
 */
@ApiModel(value="cn-java-reflect-entity-TBloger")
@Data
@Builder
public class TBloger {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 博主邮箱
    */
    @ApiModelProperty(value="博主邮箱")
    private String email;

    @ApiModelProperty(value="")
    private Integer haspermission;
}