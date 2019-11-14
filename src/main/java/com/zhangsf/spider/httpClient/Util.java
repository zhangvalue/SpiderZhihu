/**
 * @ Author zhangsf
 * @CreateTime 2019/11/14 - 9:28
 */
package com.zhangsf.spider.httpClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {
    public static String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dateStr = sdf.format(new Date());
        return dateStr;
    }
    //随机UA
    public static String getRandomHeader(){
        String[] userAgent ={
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0) Gecko/20100101 Firefox/6.0",
                "Opera/9.80 (Windows NT 6.1; U; zh-cn) Presto/2.9.168 Version/11.50",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1",
                "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; GTB7.0)",
                "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)",
                "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.3; .NET4.0C; .NET4.0E)",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36(KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36",

        };

        int index = new Random().nextInt(userAgent.length);
        return userAgent[index];
    }
}
