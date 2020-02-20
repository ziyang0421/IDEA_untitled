package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by ZIYANG on 2020/2/19.
 * mysql的连接，使用了Druid连接池和Spring JdbcTemplate
 */
public class JdbcUtils {
    // 创建连接池对象
    private static DataSource ds;

    // Druid连接池初始化
    static {
        try {
            // 加载配置文件到DruidDataSource
            Properties pro = new Properties();
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            // 通过pro创建DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接池
    public static DataSource getDataSource() {
        return ds;
    }

    public static void close() {
        // 释放资源
    }
}
