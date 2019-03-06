package com.qiancheng.charging.department.web;

import com.qiancheng.charging.common.ServerResponse;
import com.qiancheng.charging.entity.Department;
import com.qiancheng.charging.entity.User;
import com.qiancheng.charging.department.service.DepartmentService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        String name = dep.getName();
        String manager = dep.getManager();
        return departmentService.addDepartment(dep);
    }
    @RequestMapping(value="/delete_department" , method = {RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteDepartment(Department dep){
        dep.setUpdateUser("yananding");
        String name = dep.getName();
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
}
