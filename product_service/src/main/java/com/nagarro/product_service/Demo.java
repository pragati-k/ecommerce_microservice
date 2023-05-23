package com.nagarro.product_service;

import java.util.Arrays;
import java.util.stream.Stream;

//public class Demo extends Thread{
//	
//	public void run() {
//		
//		System.out.println("Hi");
//	}
//
//	public static void main(String[] args) {
//		
//		Demo d =  new Demo();
//		d.start();
//		
////		int[] arr = {7, 8, 9, 10, 11};
////		Arrays.stream(arr).filter(even -> even%2 == 0).forEach(e -> System.out.print(e));
//			
//	}
//}

public class Demo implements Runnable{
	
	public void run() {
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		Thread d1 = new Thread(d);
		d1.start();
	}
}
