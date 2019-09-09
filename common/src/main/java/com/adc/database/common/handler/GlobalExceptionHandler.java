package com.adc.database.common.handler;

import com.adc.database.common.constants.ResultCodeEnum;
import com.adc.database.common.exception.CustomizeException;
import com.adc.database.common.util.ExceptionUtil;
import com.adc.database.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLSyntaxErrorException;

/**
 * @author :
 * @date:
 * @detail:统一异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        //log.error(e.getMessage());
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R BadSqlGrammerException(BadSqlGrammarException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }
    @ExceptionHandler(SQLSyntaxErrorException.class)
    @ResponseBody
    public R sqlSyntaxErrorException(SQLSyntaxErrorException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R httpMessageNotReadableException(HttpMessageNotReadableException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }
    @ExceptionHandler(CustomizeException.class)
    @ResponseBody
    public R customizeException(CustomizeException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error().code(e.getCode()).message(e.getMessage());
    }

}
