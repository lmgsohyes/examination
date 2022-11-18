package com.aoto.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExceptionHandler implements HandlerExceptionResolver{
	
	 /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     * [简要描述]:
     * @author zongwj
     */
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 〈一句话功能简述〉
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Object
     * @param ex Exception
     * @return 〈功能详细描述〉
     * @author jiangp
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex)
    {
        int status = ErrorCodeEnum.ERROR_500.getCode();
        String code = "error";
        
        if (ex instanceof ApplicationException)
        {
            status = ErrorCodeEnum.ERROR_801.getCode();
            code = ex.getMessage();
        }
        
        response.setStatus(status);
        LOGGER.error("ExceptionHandler.resolveException", ex);
        String ajax = request.getHeader("X-Requested-With");

        if (!StringUtils.isEmpty(ajax))
        {
            response.setContentType("application/json");
            
            try
            {
                mapper.writeValue(response.getOutputStream(), code);
            }
            catch (IOException e)
            {
                LOGGER.error("mapper.writeValue error", e);
            }

            return null;
        }

        ModelAndView view = new ModelAndView("shared/error");
        return view;
    }
}
