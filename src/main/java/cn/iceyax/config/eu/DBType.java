package cn.iceyax.config.eu;

public enum DBType {
	/**
     * MySQL数据库
     */
    MySQL("com.mysql.jdbc.Driver", "jdbc:mysql://%s:%d/%s?useSSL=false&characterEncoding=utf-8");
    
    private final String driverClass;
    private final String connectionUrlPattern;

    DBType(String driverClass, String connectionUrlPattern) {
        this.driverClass = driverClass;
        this.connectionUrlPattern = connectionUrlPattern;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getConnectionUrlPattern() {
        return connectionUrlPattern;
    }
}
