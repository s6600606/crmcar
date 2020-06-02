package com.crm.common.exception.user;

import com.crm.common.exception.base.BaseException;
import com.crm.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author crm
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
