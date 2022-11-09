package com.svi.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	
	public static void main(String[] args) {
//		for (int i = 1; i <= 50; i++) {
//			Thread thread1 = new Thread(new Counter(i));
//			thread1.start();
//		}
		
//		Alternate
		
//		Counter counter = new Counter();
//		Thread thread1 = new Thread(counter, "1");
//		Thread thread2 = new Thread(counter, "2");
////		thread1.run();
////		thread2.run();
//		thread1.start();
//		thread2.start();
////		run() calls the method one after another(Not Multithreading)
		
		List<Future<Integer>> integers = new ArrayList<>();
		ExecutorService executor = Executors.newWorkStealingPool();
		
		for(Integer i = 1; i <5; i++) {
			integers.add(executor.submit(new Square(i)));
		}
		
		executor.shutdown();
		
		for (Future<Integer> integer: integers) {
			try {
				System.out.println(integer.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		} 
	}
}
