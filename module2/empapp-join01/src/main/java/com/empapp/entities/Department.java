package com.empapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dept_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;
	private List<Employee> employees=new ArrayList<>();
}
