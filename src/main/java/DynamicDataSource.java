import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLException;
import java.util.logging.Logger;


/**
 * @ClassName DynamicDataSource
 * @Description DynamicDataSource
 * @Author chaoyue.fan<fcyjava@126.com>
 * @Date 2019/3/15 17:15
 */
@Order(2)
public class DynamicDataSource extends AbstractRoutingDataSource  {

//    public void initMethod() {
//        DruidDataSource oracleSource1 = null;
//        try {
//            oracleSource1 = new DruidDataSource();
//            oracleSource1.setDriverClassName("org.apache.shardingsphere.driver.ShardingSphereDriver");
//            oracleSource1.setUrl("jdbc:shardingsphere:classpath:scratch.yaml");
//            oracleSource1.init();
//            DruidPooledConnection connection = oracleSource1.getConnection();
//            System.out.println(connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 取得当前使用那个数据源。
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }

    public Logger getParentLogger() {
        // TODO Auto-generated method stub
        return null;
    }

}
