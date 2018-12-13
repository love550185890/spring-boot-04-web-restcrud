package com.study.springboot.controller;

import com.study.springboot.dao.DepartmentDao;
import com.study.springboot.dao.EmployeeDao;
import com.study.springboot.entities.Department;
import com.study.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 员工列表
     * @return
     */
    @GetMapping("/emps")
    public String emps(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "list";
    }

    /**
     * 添加页面
     * @return
     */
    @GetMapping("/emp")
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String add(Employee employee) {
        System.out.println("Employee:----------------->"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 编辑页面（员工信息回显页面与添加页面可以使用同一个页面）
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }

    /**
     * 修改员工
     * @return
     */
    @PutMapping("/emp")
    public String edit(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
