package com.svi.concurrency;

import java.util.concurrent.Callable;

public class Square implements Callable<Integer>{

//	@Override
//	public Integer call() throws Exception {
//		return null;
//	}
	
	private	Integer num;
	
	public Square(Integer num) {
		this.num = num;
	}
	
	@Override
	public Integer call() throws Exception{
		return num * num;
	}
}