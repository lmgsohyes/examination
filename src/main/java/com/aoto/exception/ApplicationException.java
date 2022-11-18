package com.aoto.exception;

public class ApplicationException extends RuntimeException {
	 
	private static final long serialVersionUID = 8013836415766229915L;

	    /**
	     * [简要描述]:<br/>
	     * [详细描述]:<br/>
	     *
	     * @author zongwj
	     */
	    public ApplicationException()
	    {
	        super();
	    }

	    /**
	     * [简要描述]:<br/>
	     * [详细描述]:<br/>
	     *
	     * @author zongwj
	     * @param message String
	     */
	    public ApplicationException(String message)
	    {
	        super(message);
	    }

	    /**
	     * [简要描述]:<br/>
	     * [详细描述]:<br/>
	     *
	     * @author zongwj
	     * @param message String
	     * @param cause Throwable
	     */
	    public ApplicationException(String message, Throwable cause)
	    {
	        super(message, cause);
	    }

	    /**
	     * [简要描述]:<br/>
	     * [详细描述]:<br/>
	     *
	     * @author zongwj
	     * @param cause Throwable
	     */
	    public ApplicationException(Throwable cause)
	    {
	        super(cause);
	    }
	}
