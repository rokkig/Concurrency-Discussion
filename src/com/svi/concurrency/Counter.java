package com.svi.concurrency;

public class Counter implements Runnable {

//	public int threadNo;
//
//	public Counter(int threadNo) {
//		this.threadNo = threadNo;
//	}

//	@Override
//	public void run() {
//		for (int i = 1; i < 6; i++) {
//			System.out.printf("Thread %d: %d\n", threadNo, i);
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
//	alternate
//	@Override
//	public void run() {
//		for (int i = 1; i < 6; i++) {
//			System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), i);
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}

	private int count = 0;
	
	@Override
	public void run() {
		synchronized (Counter.class) {
			count++;
			System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), count);
			count--;
			System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), count);			
		}
	}
}