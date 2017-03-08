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
 * 日期时间标签
 * Created by fanlychie on 2017/1/20.
 */
public class DatetimeTag extends TagSupport {

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
     * 时间格式化模式串
     */
    private static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * 日期格式化模式串
     */
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 日期时间格式化模式串
     */
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 类型对照表
     */
    private static final Map<String, String> TYPE_PATTERN_MAP = new HashMap<>();

    /**
     * 模式对照表
     */
    private static final Map<String, DateFormat> PATTERN_DATE_FORMAT_MAP = new HashMap<>();

    @Override
    public void doTag(HttpServletRequest request, PageContext context, JspWriter writer) throws JspException, IOException {
        if (value != null) {
            if ((type == null || type.isEmpty()) && (pattern == null || pattern.isEmpty())) {
                pattern = DATE_TIME_PATTERN;
            }
            if (type != null && !TYPE_PATTERN_MAP.containsKey(type)) {
                throw new IllegalArgumentException("undefined type: " + type + ", optional values: date, time, datetime");
            } else {
                pattern = TYPE_PATTERN_MAP.get(type);
            }
            if (!PATTERN_DATE_FORMAT_MAP.containsKey(pattern)) {
                PATTERN_DATE_FORMAT_MAP.put(pattern, new SimpleDateFormat(pattern));
            }
            writer.write(PATTERN_DATE_FORMAT_MAP.get(pattern).format(value));
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

    static {
        TYPE_PATTERN_MAP.put("date", DATE_PATTERN);
        PATTERN_DATE_FORMAT_MAP.put(DATE_PATTERN, new SimpleDateFormat(DATE_PATTERN));
        TYPE_PATTERN_MAP.put("time", TIME_PATTERN);
        PATTERN_DATE_FORMAT_MAP.put(TIME_PATTERN, new SimpleDateFormat(TIME_PATTERN));
        TYPE_PATTERN_MAP.put("datetime", DATE_TIME_PATTERN);
        PATTERN_DATE_FORMAT_MAP.put(DATE_TIME_PATTERN, new SimpleDateFormat(DATE_TIME_PATTERN));
    }

}