package com.giodad.lil.roomwebapp.service;


import com.giodad.lil.roomwebapp.data.entity.EmployeeEntity;
import com.giodad.lil.roomwebapp.data.entity.RoomEntity;
import com.giodad.lil.roomwebapp.data.repository.EmployeeRepository;
import com.giodad.lil.roomwebapp.web.model.Employee;
import com.giodad.lil.roomwebapp.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> entities = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(entities.size());
        entities.forEach(e -> employees.add(this.getEmployeeFromEmployeeEntity(e)));
        return employees;
    }

    public Employee getEmployeeById(UUID id) {
        Optional<EmployeeEntity> entity = this.employeeRepository.findById(id);
        if (entity.isEmpty()) {
            return null;
        } else {
            return getEmployeeFromEmployeeEntity(entity.get());
        }
    }

    public Employee addEmployee(Employee employee) {
        EmployeeEntity entity = getEmployeeEntityFromEmployee(employee);
        entity = this.employeeRepository.save(entity);
        return this.getEmployeeFromEmployeeEntity(entity);
    }

    public Employee updateEmployee(Employee employee) {
        EmployeeEntity entity = this.getEmployeeEntityFromEmployee(employee);
        entity = this.employeeRepository.save(entity);
        return this.getEmployeeFromEmployeeEntity(entity);
    }

    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    private Employee getEmployeeFromEmployeeEntity(EmployeeEntity entity) {
        return new Employee(entity.getEmployeeId(), entity.getLastName(), entity.getFirstName(), entity.getPosition());
    }

    private EmployeeEntity getEmployeeEntityFromEmployee(Employee employee) {
        return new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getPosition());
    }
}
