/**
 * @ Author zhangsf
 * @CreateTime 2019/11/14 - 9:28
 */
package com.zhangsf.spider.httpClient;

import com.typesafe.config.Config;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.Jsoup.connect;
public class Crawler {
    public static void main(String[] args){

        Config config = AppConfig.getInstance();
        String url = config.getString("config.url");
        String path = config.getString("config.savePath");
        process(url, path);
    }

    private static void process(String url, String path) {
        Document document = null;
        try {
            document = connect(url).get();
            System.out.println(document);
            System.out.println("页面->" + url);
            String title = document.getElementsByTag("title").first().text();
            System.out.println(title);

            Elements figures = document.getElementsByTag("figure");

            List<String> list = new ArrayList<String>();

            for (Element figure : figures) {
                String img = figure.select("img").attr("src");
                list.add(img);
            }

            for (String resourceUrl : list) {
                downloadResource(resourceUrl, path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadResource(String resourceUrl, String savePath) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(resourceUrl);

        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("User-Agent", Util.getRandomHeader());
        httpGet.setHeader("Referer", "http://www.baidu.com/");

        //3.使用客户端执行请求,获取响应
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            System.out.print("downloading...  ");
            System.out.print("resourceUrl -> " + resourceUrl+" ");
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            //获取资源的后缀
            String suffixName = resourceUrl.substring(resourceUrl.lastIndexOf("."));
            //创建一个随时间毫秒值变化的的文件名
            String imgName = Util.getDateStr();
            imgName = imgName + suffixName;

            FileOutputStream fos = new FileOutputStream(savePath + "\\" + imgName);

            IOUtils.copy(is, fos);
            //关流
            fos.close();
            is.close();
            System.out.println("ok");
        }
    }
}
