package com.example.kigalicleaniliness.controller;

import com.example.kigalicleaniliness.model.EmployeeModel;
import com.example.kigalicleaniliness.serviceImplementation.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeServiceImplementation employeeService;

    @GetMapping("/employee/list")
    public String showEmployeeList(Model model){
        List<EmployeeModel> listEmployee = employeeService.displayEmployees();
        model.addAttribute("listEmployee", listEmployee);
        return "employeeListPage";
    }

    @GetMapping("/employee/new")
    public String showEmployeePage(Model model){
        EmployeeModel employee = new EmployeeModel();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "Create Employee");
        return "employeePage";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(EmployeeModel employee, RedirectAttributes ra){
        try {
            employeeService.saveEmployee(employee);
            ra.addFlashAttribute("message", "employee saved successfully");
        }catch (Exception e){
            e.printStackTrace();
            ra.addFlashAttribute("message", "failed to save employee");
        }
        return "redirect:/employee/list";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model, RedirectAttributes ra){

        try{
            EmployeeModel savedEmployee = employeeService.findEmployeeById(id);
            model.addAttribute("employee", savedEmployee);
            model.addAttribute("pageTitle", "edit Employee (ID: "+id+")");
            ra.addFlashAttribute("message", "Employee with ID: "+id+" successfully updated");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "employeePage";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model, RedirectAttributes ra){
       try {
           employeeService.deleteEmployee(id);
           ra.addFlashAttribute("message", "Employee with ID " + id + " deleted successfully");

       }catch (Exception ex){
           ex.printStackTrace();
       }
        return "redirect:/employee/list";
    }
}
