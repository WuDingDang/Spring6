package cn.wdd.service;

import cn.wdd.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Resource(name = "studentDaoImplForMysql")
    private StudentDao studentDao;


//    @Resource(name = "studentDaoImplForMysql")
//    public void setStudentDao(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
