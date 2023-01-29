/**
 * @ClassName DataSourceContextHolder
 * @Description DataSourceContextHolder
 * @Author chaoyue.fan<fcyjava@126.com>
 * @Date 2019/3/15 17:06
 */
public class DataSourceContextHolder {

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = DataSourceConst.MYSQL_SOURCE;


    /**
     * 数据源标识保存在线程变量中，避免多线程操作数据源时互相干扰
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置当前数据库。
     * @param dbType
     */
    public static void setDbType(String dbType)
    {
        contextHolder.set(dbType);
    }

    /**
     * 取得当前数据源。
     * @return
     */
    public static String getDbType() {
        if (contextHolder.get() == null){
            return DEFAULT_DS;
        }else {
            return (String) contextHolder.get();
        }
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType()
    {
        contextHolder.remove();
    }
}
