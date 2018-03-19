package org.order.support.Exception;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.order.support.HttpCode;

/**
 * ${DESCRIPTION}
 *
 * @Author libolin
 * @Create 2018/3/14 16:21
 */
public abstract class BaseException extends  RuntimeException{
    public BaseException() {
    }

    public BaseException(Throwable ex) {
        super(ex);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable ex) {
        super(message, ex);
    }

    public void handler(ModelMap modelMap) {
        modelMap.put("code", getCode().value());
        if (StringUtils.isNotBlank(getMessage())) {
            modelMap.put("msg", getMessage());
        } else {
            modelMap.put("msg", getCode().msg());
        }
        modelMap.put("timestamp", System.currentTimeMillis());
    }

    protected abstract HttpCode getCode();
}
