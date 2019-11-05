package com.airui.restfulcrud.controller;

import com.airui.restfulcrud.dao.EmployeeDao;
import com.airui.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 员工管理
 * @author dangbaoqi
 * @date 2019/11/1-11:11
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao  employeeDao;
    /**
     * 查询所有员工列表页面
     */
    @GetMapping("/emps")
    public String listEmp(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //将返回值放在请求域中进行共享
        model.addAttribute("emps",employees);
        //thymeleaf默认会自动拼接
        //classpath:/templates/xxxx.html
        return "emp/list";
    }
}
