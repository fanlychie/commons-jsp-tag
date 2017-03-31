# jsp-tag

JSP 自定义标签库

# 下载依赖

```xml
<repositories>
    <repository>
        <id>github-maven-repo</id>
        <url>https://raw.github.com/fanlychie/maven-repo/releases</url>
    </repository>
</repositories>

<dependency>
    <groupId>org.fanlychie</groupId>
    <artifactId>jsp-tag</artifactId>
    <version>1.0.2</version>
</dependency>
```

# 引入标签库

```jsp
<%@ taglib prefix="f" uri="http://fanlychie.org/tags/function" %>
```

# &lt;f:resource path="" /&gt;

此标签用于表示 web 项目中 webapp 目录下的资源文件。

```jsp
// 脚本资源
<script src='<f:resource path="/statics/js/index.js"/>'></script>
// 样式资源
<link href='<f:resource path="/statics/css/index.css"/>' rel="stylesheet" type="text/css">
// 图片资源
<img src='<f:resource path="/statics/images/logo.png"/>' />
```

**资源文件版本**

默认每次服务重新启动时，资源标签输出一个新的版本，强制客户端刷新资源文件，避免客户端缓存旧版的文件资源。如要自行控制管理资源文件，可在 Spring 配置文件中添加如下代码：

```xml
<!-- 引入 p 命名空间 xmlns:p="http://www.springframework.org/schema/p" -->
<bean class="org.fanlychie.jsp.tag.WebappResourceTagConfig" p:version="1.0"/>
```

# &lt;f:url href="" /&gt;

此标签用于表示链接地址，可以是 http 或 https 的绝对地址，也可以是相对于项目的相对地址：

```jsp
// 绝对地址，输出 http://baidu.com
<f:url href="http://baidu.com" />
// 相对地址，输出 /项目名/user/home
<f:url href="/user/home" />
```

# &lt;f:datetime value="" /&gt;

此标签用于将 java.util.Date 对象转成字符串表示：

```jsp
// 2017-03-07
<f:datetime value="${now}" type="date" />
// 01:41:41
<f:datetime value="${now}" type="time" />
// 2017-03-07 01:41:41
<f:datetime value="${now}" type="datetime" />
// 2017/03/07 01:41:41:236
<f:datetime value="${now}" pattern="yyyy/MM/dd HH:mm:ss:SSS" />
```