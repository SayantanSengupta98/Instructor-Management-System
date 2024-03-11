package com.example.hibernate_DB_mapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibernate_DB_mapping.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
