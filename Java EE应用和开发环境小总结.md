# Java EE应用和开发环境小总结

PHP、.NET无法支撑公司业务的发展，逐而转向Java EE技术架构。（如淘宝和京东）

## Java EE应用的分层模型

1. Domain Object（领域对象）层：由普通的Java对象组成。
2. DAO（数据库访问对象）层：对数据库进行CRUD等操作。
3. 业务逻辑层：由一些业务逻辑对象组成，用于暴露Domain Object对象所实现的业务逻辑方法，或者是依赖DAO组件实现的业务逻辑方法。
4. 控制器层：由一些控制器对象组成，拦截用户请求，并调用业务逻辑方法，处理用户请求，把处理结果转发到不同的表现层组件。
5. 表现层：由一些JSP页面、Velocity页面、PDF页面组成，负责收集用户请求，并显示处理结果。

## 常用的Java EE服务器

#### 常用的Web服务器

1. Tomcat：和Java结合最好，官方推荐的JSP服务器。
2. Jetty
3. Resin

#### 专业的Java EE服务器

1. JBoss：开源，全面支持最新的Java EE规范
2. GlassFish
3. WebLogic／WebSphere：商用服务器，价格高昂。

轻量级Java EE不需要用到Java EE专业服务器，简单的Web服务器即可胜任。

## 常用软件

1. Tomcat：Java Web 服务器
2. MySQL：数据库
3. Eclipse：集成IDE开发工具
3. Ant：项目管理工具
4. Maven：项目管理工具
5. SVN：版本控制