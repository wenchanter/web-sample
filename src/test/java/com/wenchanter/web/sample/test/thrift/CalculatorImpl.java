package com.wenchanter.web.sample.test.thrift;

import org.apache.thrift.TException;

public class CalculatorImpl implements Calculator.Iface{

	@Override
	public void ping() throws TException {
		
		System.out.println("this is ping...");
		
	}

	@Override
	public int add(int num1, int num2) throws TException {
		return num1 + num2;
	}

	@Override
	public int calculate(int id, String name) throws TException {
		
		System.out.println("id: " + id + " name: " + name);
		
		return id * 10;
	}
}
