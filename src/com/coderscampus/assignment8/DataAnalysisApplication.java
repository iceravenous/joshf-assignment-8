package com.coderscampus.assignment8;


import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.stream.Collectors;



public class DataAnalysisApplication {
	
	static class Task extends Thread {
		
		Assignment8 assignment = new Assignment8();
		private int number;
		
		public void Task(int number) {
			this.number = number;
		}
		
		public void run() {
			
			List<Integer> numbersList = new ArrayList<>();
			for (int i=0; i<5; i++) {
				numbersList.addAll(assignment.getNumbers());
			}	
			//end of method
		}		
	}


	public static void main(String[] args) {
//		Assignment8 assignment = new Assignment8();
		
		
		//CompletableFuture<List<Integer>> completableList = new CompletableFuture<List<Integer>>();
//		ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService boundTask = Executors.newFixedThreadPool(10);
//			completableList = CompletableFuture.supplyAsync(() -> new DataService(), pool )
//					.thenApplyAsync(dataService -> dataService.getData(), pool);
//			completableList = CompletableFuture.thenApplyAsync(data -> data.getData(), pool);
//		System.out.println(completableList);
//
		
//		for (int i=0; i<20; i++) {
//			pool.execute((Runnable) getData(assignment));
//		
//		}
//		pool.execute(new Task()); 
		boundTask.execute(new Task());
		
		
//		public List<Integer> getData(Assignment8 assignment) {
//			List<Integer> numbersList = new ArrayList<>();
//			for (int i=0; i<20; i++) {
//				numbersList.addAll(assignment.getNumbers());
//			}
//			return numbersList;
//
//		}
	}
	


}
