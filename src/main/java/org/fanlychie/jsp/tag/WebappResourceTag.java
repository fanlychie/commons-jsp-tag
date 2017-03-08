package org.fanlychie.jsp.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * Web 项目中 webapp 目录下的资源文件标签
 * Created by fanlychie on 2017/1/19.
 */
public class WebappResourceTag extends TagSupport {

    /**
     * 文件资源路径地址
     */
    private String path;

    @Override
    public void doTag(HttpServletRequest request, PageContext context, JspWriter writer) throws JspException, IOException {
        if (path != null && !path.isEmpty()) {
            String contextPath = request.getContextPath();
            if (!path.startsWith("/")) {
                contextPath += "/";
            }
            writer.write(contextPath + path + "?v" + WebappResourceTagConfig.version);
        } else {
            throw new IllegalArgumentException("<f:resource> 标签的 path 参数不能为空");
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

}