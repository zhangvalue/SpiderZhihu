# SpiderZhihu
Java爬取指定知乎问题图片

# Java爬取指定知乎问题图片
## 初衷：
在知乎上有的楼主们分享了那么多图片，比如壁纸，如果想要保存还需要一个一个保存的很麻烦，所以整一个Java爬取指定的知乎问题的图片

## 输入选项：
需要输入的为需要下载的问题的questionID
## 输出选项：
最终的将指定的questionID的图片下载到指定的文件夹
## 效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191114105134211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poYW5ndmFsdWU=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191114105254424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poYW5ndmFsdWU=,size_16,color_FFFFFF,t_70)
## 具体思路
1.使用Maven管理
2.使用Jsoup来解析相应的标签获取到对应照片的url的地址
3.使用的是httpclient库来请求下载对应的url

