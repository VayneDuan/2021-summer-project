# 2021-summer-project

**实体类，实体类Example，Mapper，Mapper.xml通过程序自动生成，无需手写**  

Mapper中有一些已经创建的方法，对于普通的单表查询，直接使用example文件中的的方法即可  

对于复杂多表查询，在Mapper中自己声明一个方法，然后在Mapper.xml中实现对应的查询语句<select>，如果查询返回的属性涉及多表，那么使用标签中的resultMap属性来设置
  
具体使用见[mybatis官方文档](https://mybatis.org/mybatis-3/zh/sqlmap-xml.html)
具体的服务通过两个文件，一个是接口，一个是接口实现  

在接口实现中调用Mapper中的方法来实现对数据库的增删改查  

