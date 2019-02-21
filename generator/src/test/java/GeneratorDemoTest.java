import com.zhaodf.dao.MalltUserMapper;
import com.zhaodf.model.MalltUser;
import com.zhaodf.model.MalltUserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class GeneratorDemoTest {
    @Test
    public void findUser() {

        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("generator/db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserMapper malltUserDao = sqlSession.getMapper(MalltUserMapper.class);
            MalltUserExample example = new MalltUserExample();
            example.createCriteria().andIdEqualTo(9);
            List<MalltUser> user = malltUserDao.selectByExample(example);
            Assert.assertEquals("zhaodf",user.get(0).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }
}
