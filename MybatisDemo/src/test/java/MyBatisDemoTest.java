import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import com.zhaodf.dao.MalltUserDao;
import com.zhaodf.model.MalltUserModel;
import com.zhaodf.objectFactory.ExampleObjectFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;


public class MyBatisDemoTest {
    @Test
    public void findUserById() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            MalltUserModel malltUser = new MalltUserModel();
            malltUser.setId(101);
            //malltUser.setName("zhaodf");
            List<MalltUserModel> users = malltUserDao.findMalltUserById(malltUser);
            //List<MalltUserModel> users = malltUserDao.findMalltUser(malltUser);
            System.out.println(users.get(0).getSex());
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
            MalltUserModel user = new MalltUserModel();
            user.setName("zhaodx");
            user.setMobile("15311250559");
            user.setEmail("zhaodengfeng@163.com");
            user.setBirthday(new Date());
            int id = malltUserDao.insert(user);
            //int id = malltUserDao.insertMalltUser(user);
            System.out.println(id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateMalltUser() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            MalltUserModel user = new MalltUserModel();
            user.setId(55);
            user.setBirthday(new Date());
            malltUserDao.updateMalltUser(user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteMalltUser() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
//            List list = new ArrayList(2);
//            list.add(25);
//            list.add(29);
//            malltUserDao.deleteByIds(list);
            Map map = new HashMap();
            map.put("ids123",new Integer[]{41,43});
            malltUserDao.deleteByMap(map);
//            malltUserDao.deleteByArray(new Integer[]{27,33});
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testObjectFactory() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            ExampleObjectFactory factory = new ExampleObjectFactory();
            List constructorArgTypes = new ArrayList();
            constructorArgTypes.add(Integer.class);
            constructorArgTypes.add(String.class);
            constructorArgTypes.add(String.class);
            constructorArgTypes.add(String.class);
            constructorArgTypes.add(Date.class);

            List constructorArgs = new ArrayList();
            constructorArgs.add(100);
            constructorArgs.add("zhaodf");
            constructorArgs.add("15311250559");
            constructorArgs.add("zhaodengfeng123@163.com");
            constructorArgs.add(new Date());

            MalltUserModel model = (MalltUserModel)factory.create(MalltUserModel.class,constructorArgTypes,constructorArgs);
            Assert.assertEquals(model.getName(),"zhaodf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void inserBatchMalltUser() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            //设置批量操作，自动提交为false
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            for(int i=0;i<10;i++){
                MalltUserModel user = new MalltUserModel();
                user.setName("dengxiap"+i);
                user.setMobile("15"+i+"11250559");
                user.setEmail("zhaodengfeng@163.com");
                user.setBirthday(new Date());
                //malltUserDao.insert(user);
                malltUserDao.insertMalltUser(user);
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserByPageHelper() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            PageHelper.startPage(2, 10);
            MalltUserModel malltUser = new MalltUserModel();
            List<MalltUserModel> users = malltUserDao.findMalltUser(malltUser);
            System.out.println(users.get(0).getBirthday());
            //分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
            Page pageInfo = ((Page) users);
            System.out.println(pageInfo.getTotal());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserRoleById() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            MalltUserModel malltUser = new MalltUserModel();
            malltUser.setId(57);
            MalltUserModel user = malltUserDao.findMalltUser3(malltUser);
            System.out.println(user.getRole().getRoleName());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserCourseById() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession = sessionFactory.openSession();
            MalltUserDao malltUserDao = sqlSession.getMapper(MalltUserDao.class);
            MalltUserModel malltUser = new MalltUserModel();
            malltUser.setId(55);
            MalltUserModel user = malltUserDao.findMalltUser4(malltUser);
            System.out.println(user.getCouseLst().size());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserCourse() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession1 = null;
        SqlSession sqlSession2 = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession1 = sessionFactory.openSession();
            MalltUserDao malltUserDao1 = sqlSession1.getMapper(MalltUserDao.class);
            MalltUserModel malltUser = new MalltUserModel();
            malltUser.setId(55);
            //MalltUserModel user = malltUserDao.selectUserCourseByResultNesting(malltUser);
            MalltUserModel user1 = malltUserDao1.findMalltUser3(malltUser);
            System.out.println("====user1的email信息："+user1.getEmail());
            sqlSession1.close();

            sqlSession2 = sessionFactory.openSession();
            MalltUserDao malltUserDao2 = sqlSession2.getMapper(MalltUserDao.class);
            MalltUserModel user2 = malltUserDao2.findMalltUser3(malltUser);
            System.out.println("====user2的email信息："+user2.getEmail());
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Test
    public void selectTime() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession1 = null;
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("db-core.xml"));
            sqlSession1 = sessionFactory.openSession();
            MalltUserDao malltUserDao1 = sqlSession1.getMapper(MalltUserDao.class);
            MalltUserModel malltUser = new MalltUserModel();
            malltUser.setId(55);
            //MalltUserModel user = malltUserDao.selectUserCourseByResultNesting(malltUser);
            String time = malltUserDao1.selectTime();
            System.out.println("====返回的时间信息："+time);
            sqlSession1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
