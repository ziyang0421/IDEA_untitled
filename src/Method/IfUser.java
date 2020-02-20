package Method;

import doMain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

/**
 * Created by ZIYANG on 2020/2/19.
 * 此类用来判断从request传来的username和password是否与mysql中的匹配
 * 如果匹配，那么返回包含全部user数据的User对象，否则返回null
 */
public class IfUser {
    public static User isUser(User request_user) {
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

        try {
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    request_user.getUsername(),
                    request_user.getPassword());
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
