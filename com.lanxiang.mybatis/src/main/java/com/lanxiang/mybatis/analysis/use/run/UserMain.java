package com.lanxiang.mybatis.analysis.use.run;

import com.lanxiang.mybatis.analysis.use.mapper.KindleMapper;
import com.lanxiang.mybatis.analysis.use.model.Kindle;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lanxiang on 2017/4/11.
 */
public class UserMain {


    private ApplicationContext context;

    private KindleMapper mapper;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        mapper = context.getBean(KindleMapper.class);
    }

    private void insert() {
        Kindle kindle = new Kindle();
        kindle.setName("Kindle paper white 3");
        kindle.setPrice(998L);
        kindle.setVersion(3);
        mapper.insert(kindle);
        System.out.println(kindle);
    }

    private void select() {
        System.out.println(mapper.queryByVersion(3));
    }

    private void selectAssociation() {
        System.out.println(mapper.selectKindle(3));
    }

    private void joinSelectAssociation() {
        System.out.println(mapper.joinSelect(3));
    }

    @Test
    public void run() {
        joinSelectAssociation();
    }
}
