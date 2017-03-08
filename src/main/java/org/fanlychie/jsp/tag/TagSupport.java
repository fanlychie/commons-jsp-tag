package org.fanlychie.jsp.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 自定义标签基类
 * Created by fanlychie on 2017/1/19.
 */
public abstract class TagSupport extends SimpleTagSupport {

    @Override
    public final void doTag() throws JspException, IOException {
        PageContext context = (PageContext) getJspContext();
        doTag((HttpServletRequest) context.getRequest(), context, context.getOut());
    }

    public abstract void doTag(HttpServletRequest request, PageContext context, JspWriter writer) throws JspException, IOException;

}