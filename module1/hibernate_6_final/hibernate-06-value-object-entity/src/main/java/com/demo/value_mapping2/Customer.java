package com.demo.value_mapping2;
import java.util.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {

	private Integer id;

	private String name;

	private String email;

	private String mobile;

	private List<Address> addresses=new ArrayList<>();


	public Customer(String name, String email, String mobile) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
}
