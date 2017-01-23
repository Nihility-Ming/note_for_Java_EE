# JSP/Servlet及相关的小总结

## JSP

> 在HTML页面潜入Java代码，可以动态地提供页面内容。是展示层。

## Servlet

> JSP通过编译成Servlet对象才能运行。

## 建立Web 应用

```
<WebFolder>
|--WEB-INF
|       |--classes
|       |--lib
|       |--web.xml
|--index.jsp(此处可以放多个JSP页面)
```

### web.xml

> 一个用于配置该web应用的配置文件。

## JSP的基本原理

> 服务器把JSP页面编译成Servlet（一个特殊的Java类），再执行。
>
> JSP页面第一次访问会很慢，因为JSP需要编译成Servlet，以后则不需要。
>
> 在tomcat的work路径下有各个web app对应的servlet生成后的文件。

### JSP的四种基本语法

#### JSP注释

```JSP
<%-- JSP注释内容 --%>
```

#### JSP声明

```JSP
<%! 声明部分 %>
```

例如：

```JSP
<%! 
public int count;

public String info() {
return "Hello World!";
}
%>
```
注意

1. 不能使用abstract
2. 客户端浏览器共享同一个变量

#### 输出JSP表达式

```JSP
<%=表达式%>
```

例如：

```JSP
<%=count++%>
<%=info()%>
```

## JSP的3个编译指令

> 编译指令是通过Servlet引擎处理的消息，在编译时起作用。

### page 指令

> 用于针对当前页面的指令

1. 语言种类
2. 继承的类或实现的接口
3. 导入的包
4. 会话
5. 缓冲区
6. 页面信息
7. 错误页面
8. 编码字符集集

### include 指令

> 用于包含另一个页面

### taglib 指令

> 用于定义和访问自定义标签

## JSP的7个动作指令

> 动作指令是指运行时的动作。通常可以替换成JSP脚本。

### jsp:forward
> 执行页面转向，将请求的处理转发到下一个页面。
>
> 用于把参数传递到指定页面，也可以传递表单字段值。

### jsp:param
> 用来传递参数，与其他支持的标签一起使用。

### jsp:include
> 动态引入一个jsp页面
>
> 它是导入编译后的HTML内容，和include静态导入有区别。include静态导入是导入后和宿主页面一起编译。
> include时可以指定目标jsp页面接受的参数。

### jsp:plugin
> 下载JavaBean或Applet到客户端执行

### jsp:useBean
> 创建JavaBean的实例

### jsp:setProperty
> 设置JavaBean的实例属性值

### jsp:getProperty
> 输出JavaBean的实例属性值

## JSP脚本中的9个内置对象

### application

作用

1. 能够让整个Web App共享数据
2. 能够读取web.xml配置文件的参数，避免硬编码。如可读取写在web.xml文件的数据库连接参数。

### config

作用

1. 可以在web.xml配置某个jsp页面，指定虚拟路径访问。
2. 可以读取web.xml配置该jsp页面的配置参数。

### exception

> Throwable的实例，代表JSP脚本中产生的错误和异常。

作用

1. 在异常处理页面使用exception可以读取错误信息作处理等。
2. 只有指定page 的 isErrorPage属性为true的时候，才能使用exception对象。

### out

> 是页面的输出流，用于在页面上输出变量值和常量。
> 
> 它是字符流不能输出字节流的东西。例如（pdf、mp3）

可以使用 `<%=输出表达式%>`代替

### pageContext

> 该对象主要用于访问JSP之间的共享数据，可以访问和设置page、request、session、application范围的变量。

```JSP
pageContext.getAttribute(String name);
pageContext.getAttribute(String name, int scope);

pageContext.setAttribute(String name, Object obj);
pageContext.setAttribute(String name, Object obj, int scope);

// int scope有以下范围
PageContext.PAGE_SCOPE
PageContext.REQUEST_SCOPE
PageContext.SESSION_SCOPE
PageContext.APPLICATION_SCOPE

```

### request

> 每个request对象封装着一次用户请求和请求用的参数。
>
> 用户通过GET或POST请求发送参数到某个JSP页面，那么目标JSP页面可以使用request对象读出来。
>
> 使用request设置范围属性，然后forward到另一页面，另一页面保留之前的用户提交的请求参数和上个页面设置的范围属性。
>
> request可以执行forward和include操作代替动作指令。
> getRequestDispatcher("/xxx.jsp").include(request, response);
> getRequestDispatcher("/xxx.jsp").forward(request, response);
>
> 可以用request对象获取cookie

### response

> 代表服务器对客户端的响应。需要生成非字符响应的情况，就应该使用response而不是out。

作用

1. 响应生成非字符响应（响应返回图片、pdf、音乐、影片等资源）
2. 重定向URL

    ```JSP
    response.sendRedirect("redirect-result.jsp");
    ```

3. 增加Cookie

    ```JSP
    response.addCookie(Cookie cookie);
    ```

### session

> HttpSession的实例，代表一次用户的会话。关闭浏览器，与服务器的会话就会中断，所有保存在session的数据就会丢失。

> 通常用于判断用户是否登陆系统、跟踪用户购买的商品

> session保存的信息必须是可序列化的

```JSP
// 设置session
session.setAttribute(String name, Object value);

// 获取session
session.getAttribute(String name)
```

## Servlet的开发

> JSP的本质就是Servlet，Web容器会将JSP编译成对应的Servlet。

> MVC规范Servlet仅仅作为控制器使用。

> Servlet继承自HttpServlet类，可以响应客户的请求

> doGet/doPost/doPut/doDelete 这几个方法来响应用户的不同请求。

#### HttpServlet的三个重要方法：

> service()方法克响应客户端的所有请求

> init()初始化Servlet的资源

> destroy() 销毁Servlet实例

#### Servlet和JSP的区别：

1. Servlet没有内置对象，原来JSP中的内置对象都必须由程序显式创建。
2. 对于html，Servlet都通过页面逐行输出。

### Servlet的配置

编译好的Servlet源文件要编译成class后放在WEB-INF/classes目录下。

##### 使用`@WebServlet`注解进行配置Servlet

也可以使用web.xml配置Servlet

### Servlet 的生命周期

1. 创建Servlet实例
2. web容器调用Servlet的init方法，初始化Servlet
3. 常驻内存，响应用户的请求
4. web容器销毁Servlet，调用destroy()方法

### load-on-startup Servlet

> 它是Web应用启动时，立即创建的Servlet实例。
>
> 可以用它来做一些常驻任务，后台任务。

配置load-on-startup Servlet：
注解
`@WebServlet(loadOnStartup=1)`

也可以通过web.xml来配置

### 访问Servlet配置参数

两种方式

1. 通过@WebServlet的initParams属性指定
2. 通过web.xml

ServletConfig ：能够取得当前Servlet配置参数的类

### 使用Servlet作为控制器

**MVC JavaEE的应用遵循**

1. JavaBean充当Model：所有业务逻辑、数据访问都在Model实现。
2. JSP充当View：主要是HTML等页面展示
3. Servlet充当Controller：根据用户请求，调用Model，再调度View，最后返回给用户展示内容。

**流程**

客户端先访问Servlet，Servlet调用Model，根据Model返回的结果，Servlet再forward到指定的JSP页面。

