# mini village(开发中)
城中村租客论坛
    
# 特色功能：
1. 信息交流平台：<br>
2. 租客房源交流功能：房源交流平台，已入住的房屋信息标注已出租，不下架，租客可提供后续转租信息，以吸引好评的方式进行存活<br>
3. 世界地图：分界，范围选取，算法载入，完全没想好怎么做<br>
# 后端：
1. SpringBoot、 <br>
2. JPA <br>
3. 异步框架的设计，底层使用的是Redis的异步队列，使用异步队列实现站内信，点赞，邮件等功能 <br>
4. solr结合IKAnalyzer自定义中文分词，实现搜索引擎 <br>
5. timeline推拉模式结合的时间轴，渲染新鲜事，实现内容的推送<br>
