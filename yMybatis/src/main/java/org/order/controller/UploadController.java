package org.order.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.order.dao.CartOperation;
import org.order.dao.GoodOperation;
import org.order.po.Good;
import org.order.support.HttpCode;
import org.order.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @Author libolin
 * @Create 2018/3/14 15:44
 */
@Controller
@RequestMapping(value = "/yMybatis/upload",method = RequestMethod.POST,produces = "multipart/form-data; charset=utf-8")
public class UploadController {
    private Logger logger= LogManager.getLogger();
    private static final String URL_PREX="http://192.168.3.143:8080/image/";
    @Autowired
    GoodOperation goodOperation;

    // 上传文件(支持批量)
    @RequestMapping("/temp/image")
    public Object uploadImage(HttpServletRequest request) {
        Map<String,String> fileNames = UploadUtil.uploadImage(request, false);
        Map<String,String> result=new HashMap<>();

        //存储到商品表中
        for(String key:fileNames.keySet()){
            Good good=new Good((int)System.currentTimeMillis(),key,new BigDecimal(0),URL_PREX + fileNames.get(key),URL_PREX + fileNames.get(key),null);
            goodOperation.insert(good);
        }

        if (fileNames.size() > 0) {
            result.put("statusCode", HttpCode.OK.value().toString());
            result.put("data", "图片上传成功");
            return result;
        } else {
            result.put("statusCode", HttpCode.BAD_REQUEST.value().toString());
            result.put("data", "请选择要上传的文件！");
            return result;
        }
    }
}
