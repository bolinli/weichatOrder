package org.order.support.Exception;

import org.order.support.HttpCode;

/**
 * ${DESCRIPTION}
 *
 * @Author libolin
 * @Create 2018/3/14 16:20
 */
public class DataParseException extends BaseException{
    public DataParseException() {
    }

    public DataParseException(Throwable ex) {
        super(ex);
    }

    public DataParseException(String message) {
        super(message);
    }

    public DataParseException(String message, Throwable ex) {
        super(message, ex);
    }

    protected HttpCode getCode() {
        return HttpCode.INTERNAL_SERVER_ERROR;
    }

}
