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
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * ${DESCRIPTION}
 *
 * @Author libolin
 * @Create 2018/3/14 15:44
 */
@Controller
@RequestMapping(value = "/yMybatis/upload",method = RequestMethod.POST)
public class UploadController {
    private Logger logger= LogManager.getLogger();
    private static final String URL_PREX="http://192.168.3.143:8080/image/";
    @Autowired
    GoodOperation goodOperation;

    // 上传文件(支持批量)
    @RequestMapping("/temp/image")
    public Object uploadImage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        Map<String,String> fileNames = UploadUtil.uploadImage(request, false);

        //存储到商品表中
        for(String key:fileNames.keySet()){
            Good good=new Good((int)System.currentTimeMillis(),key,new BigDecimal(0),URL_PREX + fileNames.get(key),URL_PREX + fileNames.get(key),null);
            goodOperation.insert(good);
        }
        if (fileNames.size() > 0) {
            modelMap.put("fileNames", fileNames);
            modelMap.put("code", HttpCode.OK.value().toString());
            modelMap.put("msg",HttpCode.OK.msg());
            modelMap.put("timestamp", System.currentTimeMillis());
            logger.info("RESPONSE : " + JSON.toJSONString(modelMap));
            return modelMap;
        } else {
            modelMap.put("code", HttpCode.BAD_REQUEST.value().toString());
            modelMap.put("msg", "请选择要上传的文件！");
            return modelMap;
        }
    }

}
