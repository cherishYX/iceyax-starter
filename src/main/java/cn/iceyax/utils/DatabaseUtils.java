package cn.iceyax.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cn.iceyax.config.DatabaseInfo;
import cn.iceyax.config.TableInfo;
import cn.iceyax.config.db.DBField;
import cn.iceyax.config.eu.DBType;

/**
 * 数据库工具类
 *
 * @author yanxiang
 * @date 2018/5/23
 */
public class DatabaseUtils {
	
    /**
     * 获取数据库连接
     *
     * @param databaseInfo
     * @return
     * @throws Exception
     */
    public static Connection getConnection(DatabaseInfo databaseInfo) throws Exception {
        DriverManager.setLoginTimeout(3);
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        Class.forName(dbType.getDriverClass());
        String url = getConnectionURL(databaseInfo);
        Properties props =new Properties();
        props.setProperty("user", databaseInfo.getDbUsername());
        props.setProperty("password", databaseInfo.getDbPassword());
        //设置可以获取remarks信息
        props.setProperty("remarks", "true");
        //设置可以获取tables remarks信息
        props.setProperty("useInformationSchema", "true");
        Connection connection = DriverManager.getConnection(url, props);
        return connection;
    }

    /**
     *
     * @param databaseInfo
     * @return
     * @throws ClassNotFoundException
     */
    private static String getConnectionURL(DatabaseInfo databaseInfo) throws ClassNotFoundException {
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        String connectionRUL = String.format(dbType.getConnectionUrlPattern(), databaseInfo.getDbIP(),
                databaseInfo.getDbPort(), databaseInfo.getDbName());
        return connectionRUL;
    }

    
    public static List<DBField> getTableColumns(DatabaseInfo databaseInfo,TableInfo tableInfo) throws Exception {
        Connection connection = getConnection(databaseInfo);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getColumns(null, null, tableInfo.getName(), null);
        List<DBField> fieldList = new ArrayList<>();
        while (resultSet.next()) {
            DBField field = new DBField();
            field.setColumnName(resultSet.getString("COLUMN_NAME"));
            field.setDataType(resultSet.getInt("DATA_TYPE"));
            field.setTypeName(resultSet.getString("TYPE_NAME"));
            field.setColumnSize(resultSet.getInt("COLUMN_SIZE"));
            field.setDecimalDigits(resultSet.getInt("DECIMAL_DIGITS"));
            field.setNullable("YES".equalsIgnoreCase(resultSet.getString("IS_NULLABLE")));
            field.setAutoIncrement("YES".equalsIgnoreCase(resultSet.getString("IS_AUTOINCREMENT")));
            field.setRemarks(resultSet.getString("REMARKS"));
            field.setColumnDef(resultSet.getObject("COLUMN_DEF"));
            field.setCharOctetLength(resultSet.getInt("CHAR_OCTET_LENGTH"));

            fieldList.add(field);
        }

        return fieldList;
    }
    
}
