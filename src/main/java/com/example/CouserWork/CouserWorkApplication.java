package com.example.CouserWork;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CouserWorkApplication {
	public static void main(String[] args) {
		SpringApplication.run(CouserWorkApplication.class, args);
	}

}

//	private static volatile AtomicBoolean run=new AtomicBoolean(true);
//	private static TicketPool ticketPool;
//
//	public static void main(String[] args) {
//		Scanner input=new Scanner(System.in);
//
//		int i=0;
//		CountDownLatch count=new CountDownLatch(1);
//
//		Thread startOrStrop=new Thread(new Runnable() {
//			@Override
//			public void run() {
//							while (run.get()){
//								while(true){
//									try{
//										count.await();
//									}catch (InterruptedException err){
//
//									}
//									synchronized (input){
//											System.out.println("Do you want to stop the programme or continue running: ");
//											String txt=input.next();
//											if(txt.equals("stop")){
//												run.set(false);
//												break;
//											}else{
//												System.out.println("Please enter only stop and not other characters! ");
//
//
//
//
//
//
//
//									}
//								}
//
//								}
//			}
//			}
//		});
//		startOrStrop.start();
//
//		int totalTickets = validation(input, "Enter the total number of tickets: ");
//		int ticketReleaseRate = validation(input, "Enter the ticket release rate: ");
//		int customerRetrivalRate = validation(input, "Enter the customer retrieval rate: ");
//		int maxTicketCapacity = validation(input, "Enter the maximum ticket capacity: ");
//
//		if (totalTickets < maxTicketCapacity) {
//			ticketPool = new TicketPool(10,run);
//			Vendor vendor = new Vendor(ticketPool, totalTickets, "abb1", "Music", ticketReleaseRate);
//			Customer customer = new Customer(ticketPool, customerRetrivalRate, true, totalTickets);
//			System.out.println("run is " + run);
//			System.out.println("Aval" + ticketPool.NumberOfAvalTicket());
//
//			count.countDown();
//			while(true){
//				if(!run.get()){
//					break;
//				}
//				Thread vendor1 = new Thread(vendor);
//				Thread customer1 = new Thread(customer);
//
//				vendor1.start();
//				customer1.start();
//
//				try {
//
//					vendor1.join();
//					customer1.join();
//
//				} catch (InterruptedException err) {
//					System.out.println(err.getMessage());
//				}
//			}
//
//
//		}
//		System.out.println("Umm");
//
//
//
//
//		try{
//			startOrStrop.join();
//				System.out.println("");
//
//
//
//
//		}catch (InterruptedException err){
//
//		}








//
//			try{
//				System.out.println(ticketPool.NumberOfAvalTicket());
//				vendor1.join();
//
////				customer1.join();
//
//
//
//			}catch (InterruptedException err){
//				System.out.println(err.getMessage());
//			}
//













// pool.removeTicket();








//	public static int validation(Scanner input,String txt){
//		synchronized (input){
//			while(true){
//				try{
//					System.out.print(txt);
//						int number = input.nextInt();
//						if (number >= 0) {
//							return number;
//						} else {
//							System.out.println("! Enter a positive number ");
//						}
//
//				}catch (InputMismatchException err){
//					System.out.println("! Please make sure to enter a valid number");
//					input.next();
//				}
//			}
//		}
//
//	}



