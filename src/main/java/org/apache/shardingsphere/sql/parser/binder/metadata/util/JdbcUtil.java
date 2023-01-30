package org.apache.shardingsphere.sql.parser.binder.metadata.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author xinzhi liu
 * @date 2023/1/3011:51
 * @explain
 */
public class JdbcUtil {

    /**
     * Get schema.
     *
     * @param connection connection
     * @param databaseType database type
     * @return schema
     */
    public static String getSchema(final Connection connection, final String databaseType) {
        String result = null;
        try {
            result = connection.getSchema();
        } catch (final SQLException ignore) {
        }
        return result;
    }
}
