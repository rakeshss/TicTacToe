package com.tictactoe;

public class Demo {
	private Demo d = new Demo();
	
	private void m1(Demo d) {
		System.out.println("hello"); 
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		d.m1(d); 
	}
}
