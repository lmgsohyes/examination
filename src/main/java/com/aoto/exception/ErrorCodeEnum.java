package com.aoto.exception;

public enum ErrorCodeEnum {
	 
    /**
     * [简要描述]:
     * @author zongwj
     */
    ERROR_500(500),
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    ERROR_801(801),
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    NO_ERROR(901);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int code;
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param code int
     */
    ErrorCodeEnum(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
}
