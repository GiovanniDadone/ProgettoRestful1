package com.giodad.lil.roomwebapp.web.api;

import com.giodad.lil.roomwebapp.service.EmployeeService;
import com.giodad.lil.roomwebapp.web.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {
    private final EmployeeService employeeService;

    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable(name="id") UUID id) {
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable(name="id") UUID id, @RequestBody Employee employee){
        employee.setId(id);
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEmployee(@PathVariable(name = "id") UUID id) {
        this.employeeService.deleteEmployee(id);
    }
}
