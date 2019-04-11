import com.zhaodf.dao.MalltUserDao;
import com.zhaodf.model.MalltUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;


public class MyBatisDemoTest {
    @Test
    public void findUserById() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            MalltUser user = malltUserDao.findMalltUserById(9);
            Assert.assertEquals("zhaodf",user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void inserMalltUser() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            MalltUser user = new MalltUser();
            user.setName("baixw");
            user.setMobile("18333828888");
            user.setBirthday(new Date());
            malltUserDao.insert(user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
