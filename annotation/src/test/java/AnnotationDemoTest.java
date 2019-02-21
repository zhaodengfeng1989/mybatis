import com.zhaodf.dao.MalltUserMapper;
import com.zhaodf.model.MalltUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class AnnotationDemoTest {
    @Test
    public void findUserByAnnotation() {

        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserMapper malltUserDao = sqlSession.getMapper(MalltUserMapper.class);
            MalltUser user = malltUserDao.selectByPrimaryKey(9);
            Assert.assertEquals("zhaodf",user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
