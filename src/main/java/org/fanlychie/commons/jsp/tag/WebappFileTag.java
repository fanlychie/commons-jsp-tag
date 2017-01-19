package org.fanlychie.commons.jsp.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * Web 项目中 webapp 目录下的文件资源标签
 * Created by fanlychie on 2017/1/19.
 */
public class WebappFileTag extends TagSupport {

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
            writer.write(contextPath + path + "?v" + WebappFileTagConfig.version);
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

}