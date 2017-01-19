package org.fanlychie.commons.jsp.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * URL 链接标签
 * Created by fanlychie on 2017/1/20.
 */
public class URLConnectionTag extends TagSupport {

    /**
     * URL 链接地址
     */
    private String href;

    @Override
    public void doTag(HttpServletRequest request, PageContext context, JspWriter writer) throws JspException, IOException {
        if (href != null && !href.isEmpty()) {
            String url = href;
            if (!href.startsWith("http://") && !href.startsWith("https://")) {
                String contextPath = request.getContextPath();
                if (!href.startsWith("/")) {
                    contextPath += "/";
                }
                url = contextPath + href;
            }
            writer.write(url);
        }
    }

    public void setHref(String href) {
        this.href = href;
    }

}