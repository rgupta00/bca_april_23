package com.demo.one2one.bi;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Employee {

	private int empId;
	private String empName;

	private Parking parking;

	public Employee(String empName) {
		this.empName = empName;
	}
}
