package org.fanlychie.commons.jsp.tag;

/**
 * Web 项目中 webapp 目录下的文件资源标签配置
 * Created by fanlychie on 2017/1/19.
 */
public final class WebappFileTagConfig {

    /**
     * 版本号
     */
    static String version = String.valueOf(System.currentTimeMillis());

    /**
     * 设置文件标签的版本号
     *
     * @param version 版本号字符串
     */
    public void setVersion(String version) {
        WebappFileTagConfig.version = version;
    }

}