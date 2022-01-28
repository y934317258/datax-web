package com.wugui.datax.admin.tool.datax.writer;

import java.util.Map;

/**
 * kingbase writer构建类
 *
 * @author zhouhongfa@gz-yibo.com
 * @version 1.0
 * @since 2019/8/2
 */
public class KingBaseWriter extends BaseWriterPlugin implements DataxWriterInterface {
    @Override
    public String getName() {
        return "kingbaseeswriter";
    }

    @Override
    public Map<String, Object> sample() {
        return null;
    }
}
