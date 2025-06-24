package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employee;
import com.employee.repository.IEmployeeRepository;

@Controller
public class EmployeeController 
{
	@Autowired
	private IEmployeeRepository empRepo;
	
	@GetMapping({"/showEmployees","/","/list"})
	public ModelAndView showEmployees() 
	{
		ModelAndView mav=new ModelAndView("employeeslist");
		List<Employee> list = empRepo.findAll();
		mav.addObject("employees", list);
		return mav;
	}
	
	@GetMapping({"/addEmployeeForm"})
	public ModelAndView addEmployeeForm()
	{
		ModelAndView mav = new ModelAndView("addEmployeeForm");
		Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping({"/saveEmployee"})
	public String saveEmployee(@ModelAttribute Employee employee)
	{
		empRepo.save(employee);
		return "redirect:/list";
	}
	
	
	@GetMapping({"/showUpdateForm"})
	public ModelAndView showUpdateForm(@RequestParam Long employeeId)
	{
		ModelAndView mav=new ModelAndView("addEmployeeForm");
		Employee employee=empRepo.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}
	
	@GetMapping({"/deleteEmployee"})
	public String deleteEmployee(@RequestParam Long employeeId)
	{
		empRepo.deleteById(employeeId);
		return "redirect:/list";
	}
}
