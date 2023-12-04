package cn.wdd.dao.impl;

import cn.wdd.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImplForOracle implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("oracle正在删除学生信息。。。");
    }
}
