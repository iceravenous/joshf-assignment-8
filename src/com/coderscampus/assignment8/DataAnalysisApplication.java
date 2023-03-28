package com.coderscampus.assignment8;


import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
//import java.util.concurrent.Future;
//import java.util.stream.Collectors;



public class DataAnalysisApplication {
	
	public static void main(String[] args) {
		Assignment8 assignment = new Assignment8();
		CompletableFuture<List<Integer>> completableListTemp = new CompletableFuture<List<Integer>>();
		List<Integer> finishList = new ArrayList<Integer>();
		
		
		CompletableFuture<List<Integer>> completableList = new CompletableFuture<List<Integer>>();
		ExecutorService pool = Executors.newCachedThreadPool();

		for (int i=0; i < 1000; i++) {
			completableList = CompletableFuture.supplyAsync(() -> assignment.getNumbers(), pool);
			//completableListTemp.add(completableList);
	
		}
		

		
		finishList = completableList.join();
		//finishList.addAll(completableList);
		


		Map<Object, Long> counts = finishList.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println("\nSize of list: " + finishList.size());
		System.out.println("\n===================\n");
		for (Map.Entry<Object, Long> entry : counts.entrySet()) {
			System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
			
		}

		
	
	}
	


}
