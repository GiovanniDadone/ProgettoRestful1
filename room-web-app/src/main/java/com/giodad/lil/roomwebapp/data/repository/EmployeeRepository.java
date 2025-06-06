package com.giodad.lil.roomwebapp.data.repository;

import com.giodad.lil.roomwebapp.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
}