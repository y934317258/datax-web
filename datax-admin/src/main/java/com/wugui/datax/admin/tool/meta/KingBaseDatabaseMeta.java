package com.wugui.datax.admin.tool.meta;

/**
 * Kingbase数据库 meta信息查询
 *
 * @author zhouhongfa@gz-yibo.com
 * @ClassName KingBaseDatabaseMeta
 * @Version 1.0
 * @since 2019/8/2 11:02
 */
public class KingBaseDatabaseMeta extends BaseDatabaseMeta implements DatabaseInterface {

    private volatile static KingBaseDatabaseMeta single;

    public static KingBaseDatabaseMeta getInstance() {
        if (single == null) {
            synchronized (KingBaseDatabaseMeta.class) {
                if (single == null) {
                    single = new KingBaseDatabaseMeta();
                }
            }
        }
        return single;
    }

    @Override
    public String getSQLQueryComment(String schemaName, String tableName, String columnName) {
        return String.format("select B.comments \n" +
                "  from user_tab_columns A, user_col_comments B\n" +
                " where a.COLUMN_NAME = b.column_name\n" +
                "   and A.Table_Name = B.Table_Name\n" +
                "   and A.Table_Name = upper('%s')\n" +
                "   AND A.column_name  = '%s'", tableName, columnName);
    }

    @Override
    public String getSQLQueryPrimaryKey() {
        return "select cu.column_name from user_cons_columns cu, user_constraints au where cu.constraint_name = au.constraint_name and au.owner = ? and au.constraint_type = 'P' and au.table_name = ?";
    }

    @Override
    public String getSQLQueryTablesNameComments() {
        return "select table_name,comments from user_tab_comments";
    }

    @Override
    public String getSQLQueryTableNameComment() {
        return "select table_name,comments from user_tab_comments where table_name = ?";
    }

    @Override
    public String getSQLQueryTables(String... tableSchema) {
        return "select table_name from dba_tables where owner='" + tableSchema[0] + "'";
    }

    @Override
    public String getSQLQueryTableSchema(String... args) {
        return "select username from dba_users";
    }


    @Override
    public String getSQLQueryTables() {
        return "select table_name from user_tab_comments";
    }

    @Override
    public String getSQLQueryColumns(String... args) {
        return "select table_name,comments from user_tab_comments where table_name = ?";
    }
}
