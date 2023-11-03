package com.springboot.thymeleaf.controller;

import com.springboot.thymeleaf.entity.Employee;
import com.springboot.thymeleaf.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService theEmployeeService;

	// since only one constructor we dont need @Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.theEmployeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = theEmployeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

		// get the employee from the service
		Employee theEmployee = theEmployeeService.findById(theId);

		// set employee in the model to repopulate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to our form

		return "employees/employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// save the employee
		theEmployeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// delete the employee
		theEmployeeService.deleteById(theId);

		// redirect to /employee/list
		return "redirect:/employees/list";
	}
}









