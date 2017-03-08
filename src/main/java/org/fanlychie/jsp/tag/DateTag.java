package org.fanlychie.jsp.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期标签
 * Created by fanlychie on 2017/1/20.
 */
public class DateTag extends TagSupport {

    /**
     * 日期
     */
    private Date value;

    /**
     * 类型:
     * date -> 2017-01-20
     * time -> 23:55:48
     * datetime -> 2017-01-20 23:55:48
     */
    private String type;

    /**
     * 模式串
     */
    private String pattern;

    /**
     * 类型对照表
     */
    private static final Map<String, String> TYPES = new HashMap<>();

    /**
     * 模式对照表
     */
    private static final Map<String, DateFormat> FORMATS = new HashMap<>();

    @Override
    public void doTag(HttpServletRequest request, PageContext context, JspWriter writer) throws JspException, IOException {
        if (value == null) {
            throw new NullPointerException("<f:date> 标签 value 参数值不能为 null");
        }
        if ((type == null || type.isEmpty()) && (pattern == null || pattern.isEmpty())) {
            throw new IllegalArgumentException("<f:date> 标签 type 和 pattern 参数不能同时为 null");
        }
        if (type != null && pattern == null) {
            pattern = TYPES.get(type);
            if (pattern == null) {
                throw new IllegalArgumentException("<f:date> 标签 不支持的 type 类型: " + type + ", 可选值: date, time, datetime");
            }
        }
        DateFormat format = FORMATS.get(pattern);
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            FORMATS.put(pattern, format);
        }
        writer.write(format.format(value));
    }

    static {
        TYPES.put("date", "yyyy-MM-dd");
        TYPES.put("time", "HH:mm:ss");
        TYPES.put("datetime", "yyyy-MM-dd HH:mm:ss");
        for (String value : TYPES.values()) {
            FORMATS.put(value, new SimpleDateFormat(value));
        }
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}