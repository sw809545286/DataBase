package com.adc.database.common.exception;

import com.adc.database.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :
 * @date:2019/9/9
 * @description:自定义异常处理
 */
@Data
@ApiModel(value = "自定义异常处理类")
public class CustomizeException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;

    public CustomizeException(Integer code, String message){
        super(message);
        this.code = code;
    }
    public CustomizeException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CustomizeException{" +
                "code=" + code +
                "message=" + this.getMessage() +
                '}';
    }
}
