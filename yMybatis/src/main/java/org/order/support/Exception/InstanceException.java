package org.order.support.Exception;

import org.order.support.HttpCode;

/**
 * ${DESCRIPTION}
 *
 * @Author libolin
 * @Create 2018/3/14 16:34
 */
public class InstanceException extends BaseException{
    public InstanceException() {
        super();
    }

    public InstanceException(Throwable t) {
        super(t);
    }

    protected HttpCode getCode() {
        return HttpCode.INTERNAL_SERVER_ERROR;
    }
}
