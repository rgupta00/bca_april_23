package com.empapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp_table")
public class Employee {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String name;
	private double salary;

	private Department department;

}