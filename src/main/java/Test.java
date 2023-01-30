import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.springframework.util.ResourceUtils.getFile;

/**
 * @author xinzhi liu
 * @date 2023/1/2817:47
 * @explain
 */
public class Test {

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
//        String jdbcUrl = "jdbc:shardingsphere:classpath:scratch.yaml";
//        Connection conn = DriverManager.getConnection(jdbcUrl);
//        System.out.println(conn);
//    }

//    public static void main(String[] args) throws IOException, SQLException {
//        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("E:\\project\\git\\shardingjdbcspring\\src\\main\\resources\\scratch.yaml"));
//        dataSource.getConnection();
//        System.out.println(dataSource);
//    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DataSource oracleSource = (DataSource)context.getBean("oracleSource");
        try {
            oracleSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}
