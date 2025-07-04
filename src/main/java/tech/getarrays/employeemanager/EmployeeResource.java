package tech.getarrays.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	private final EmployeeService employeeService;
	
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity <List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<> (employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long Id){
		Employee employee = employeeService.findEmployeeById(Id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> AddEmployee(@RequestBody Employee emp){
		Employee newEmployee=employeeService.addEmployee(emp);
		return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee=employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long Id){
		employeeService.deleteEmployee(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity <List<Employee>> getAEmployee(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<> (employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/new")
	public ResponseEntity <List<Employee>> getAnEmployee(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<> (employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/newly")
	public ResponseEntity <List<Employee>> getAndEmployee(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<> (employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/newlyG")
	public ResponseEntity <List<Employee>> getAndADEmployee(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<> (employees,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	

}
