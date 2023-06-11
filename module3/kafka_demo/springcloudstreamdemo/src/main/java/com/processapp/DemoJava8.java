package com.processapp;
import java.util.*;
public class DemoJava8 {
	
	public static void main(String[] args) {
		//Steam is flow of data
		List<Emp> list=Arrays.asList(new Emp(1,"raj",57000),new Emp(2,"ekta",97000),new Emp(15,"gun",11000));
		
		
		list.stream()
		.sorted(Comparator.comparing(Emp::getSalary).reversed())
	
		.map(e-> e.getName())
		.forEach(name-> System.out.println(name));
		
		
		//java 7
//		List<String> names= new ArrayList<>();
//		
//		Collections.sort(list, new Comparator<Emp>() {
//
//			@Override
//			public int compare(Emp o1, Emp o2) {
//				return Double.compare(o2.getSalary(), o1.getSalary());
//			}
//		});
//		
//		for(Emp emp: list) {
//			names.add(emp.getName());
//		}
//		
//		
//		for(String name: names) {
//			System.out.println(name);
//		}
	}

}
