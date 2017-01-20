package com.ihs.convergence.utils;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.shiro.web.util.WebUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletRequest;

/**
 * Project name is convergence
 * Created by pengfei.zhou on 2017-01-20 
 */
public class CommonUtil {
    //convergence 模块url统一前缀
    public static final String 	CONVERGENCE_URL_PREFIX = "convergence";
    //url produces xml
    public static final String PRODUCES_APPLICATION_XML = "application/xml;charset=UTF-8";
    //url produces json
    public static final String PRODUCES_APPLICATION_JSON = "application/json;charset=UTF-8";
    //convergence default code
    public static final int CODE_CONVERGENCE = 10;
    
  //permission default code
    public static final int CODE_PERMISSION = 12;
    //default del_flag
    public static final int DEL_FLAG = 1;
    
    static String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
  
    
    public static List<String> languageList = Arrays.asList("zh-cn","en","es");
     
    public static String getTime(long timeInMills) {
        return DurationFormatUtils.formatDuration(timeInMills, "HH:mm:ss.S") + " (HH:mm:ss.S)";
    }
    
    public static String FormatDate(Date date) {
        return new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss).format(date);
    }


    public static String randomName() {
        return String.valueOf((int) (Math.random() * 10000));
    }

    /**
     * convert a string to md5string
     *
     * @param input normal string
     * @return md5string
     * @throws NoSuchAlgorithmException
     */
    public static String md5sum(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
      
    }
    

    
    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getHost(ServletRequest request) {
		String host = WebUtils.toHttp(request).getHeader("x-forwarded-for");
		if (host == null || host.isEmpty()) {
			return request.getRemoteHost();
		} else {
			return host;
		}
	}
}
