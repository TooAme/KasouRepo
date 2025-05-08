package com.chenhy.config;

import com.chenhy.web.rest.ImportProcessResource;
import org.hibernate.resource.jdbc.spi.StatementInspector;

public class DynamicTableInterceptor implements StatementInspector {

    @Override
    public String inspect(String sql) {
        // 从线程本地变量获取当前表名
        String currentTableName = ImportProcessResource.CURRENT_TABLE_NAME.get();
        if (currentTableName != null) {
            // 替换 SQL 中的默认表名（假设原表名为 "import_table"）
            return sql.replace("t_import_table", currentTableName);
        }
        return sql;
    }
}
