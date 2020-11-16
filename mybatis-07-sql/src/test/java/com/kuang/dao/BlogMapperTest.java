package com.kuang.dao;

import com.kuang.pojo.Blog;
import com.kuang.utils.IdUtils;
import com.kuang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/15 22:25
 */
public class BlogMapperTest {
    @Test
    public void te1() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        mapper.addBlog(new Blog(IdUtils.getId(),"Android第一行代码", "郭霖", new Date(), 12300));
        mapper.addBlog(new Blog(IdUtils.getId(),"Android精彩实例", "启舰", new Date(), 3100));
        mapper.addBlog(new Blog(IdUtils.getId(),"Android深挖底层", "郭霖", new Date(), 33100));
       /* mapper.addBlog(new Blog(IdUtils.getId(),"Java葵花宝典", "网二", new Date(), 2350));
        mapper.addBlog(new Blog(IdUtils.getId(),"Java全栈开发", "敖丙", new Date(), 3425));
        mapper.addBlog(new Blog(IdUtils.getId(),"Java成神之路", "快斗", new Date(), 6579));
*/

        sqlSession.close();
    }

    @Test
    public void queryBlogTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        // sql不变化的情况下，只需要在这里追加一条语句，就可以实现查询某个特定的blog的效果
        // map.put("title", "Java葵花宝典");
        map.put("author", "郭霖");

        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        // map.put("author", "快斗");
        map.put("views", 33100);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogForEach() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(8);

        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlogTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("id", "b52a084b92c94683a15dc8a91dbae79b");
        map.put("title", "Java天下第一(第二版)");
        int res = mapper.updateBlog(map);
        if (res > 0) {
            System.out.println("修改信息成功~！");
        }

        sqlSession.close();
    }
}
