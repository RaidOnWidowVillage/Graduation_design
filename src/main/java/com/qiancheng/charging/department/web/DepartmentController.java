package com.qiancheng.charging.department.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Department;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.department.service.DepartmentService;
import javafx.scene.control.Alert;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/add_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse addDepartment(Department dep){
        dep.setCreateUser("yananding");
        dep.setUpdateUser("yananding");
        return departmentService.addDepartment(dep);
    }
    @RequestMapping(value="/delete_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteDepartment(Department dep){
        dep.setUpdateUser("yananding");
        return departmentService.deleteDepartment(dep);
    }
    @RequestMapping(value="/update_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateDepartment(Department dep){
        dep.setUpdateUser("yananding");
        return departmentService.updateDepartment(dep);
    }
    @RequestMapping(value="/select_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse selectDepartment(){
        return  departmentService.queryAllDepartment();
    }
    @RequestMapping(value="/queryby" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse querybyname(Department depts){
        depts.setUpdateUser("yananding");
        return departmentService.queryBy(depts);
    }
}
