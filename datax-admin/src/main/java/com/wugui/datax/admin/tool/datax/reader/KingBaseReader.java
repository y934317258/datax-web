package com.wugui.datax.admin.tool.datax.reader;

import java.util.Map;

/**
 * kingbasees reader 构建类
 *
 * @author zhouhongfa@gz-yibo.com
 * @version 1.0
 * @since 2019/8/2
 */
public class KingBaseReader extends BaseReaderPlugin implements DataxReaderInterface {
    @Override
    public String getName() {
        return "kingbaseesreader";
    }

    @Override
    public Map<String, Object> sample() {
        return null;
    }
}
