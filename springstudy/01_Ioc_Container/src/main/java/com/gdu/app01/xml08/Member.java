package com.gdu.app01.xml08;

import java.util.List;

public class Member {
	private String name;
	private List<String> course;
	private double height;
	private double weight;
	private BMICalculator bmiCalc;
	
	
	public Member(String name, List<String> course, double height, double weight, BMICalculator bmiCalc) {
		super();
		this.name = name;
		this.course = course;
		this.height = height;
		this.weight = weight;
		this.bmiCalc = bmiCalc;
	}
	
	//info()
	public void info() {
		System.out.println("Name :" + name);
		for(String str : course) {
			System.out.println("coures: " + str);
		}
		System.out.println("키:" + height);
		System.out.println("몸무게:" + weight);
		bmiCalc.info();
	}
	
}


