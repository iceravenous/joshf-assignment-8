package com.coderscampus.assignment8;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;




public class DataAnalysisApplication {
	
	public static void main(String[] args) {
		Assignment8 assignment = new Assignment8();
		List<Integer> finishList = new ArrayList<Integer>();
		ExecutorService pool = Executors.newCachedThreadPool();
		
List<CompletableFuture<List<Integer>>> completableList = new ArrayList<>();
		
		List<Integer> outputList = new ArrayList<>();
		for (int i=0; i < 1000; i++) {

			CompletableFuture<List<Integer>> completableFuture = CompletableFuture.supplyAsync(
					() -> {
						List<Integer> subList = new ArrayList<>();
						subList.addAll(assignment.getNumbers());
						return subList;
					}, pool);
			completableList.add(completableFuture);

			completableFuture.thenAccept(subList -> {
				outputList.addAll(subList);
			});
		}
		
		CompletableFuture.allOf(completableList.toArray(new CompletableFuture[0])).join();
		

		finishList = completableList.stream()
				.flatMap(completableFuture -> completableFuture.join().stream())
				.collect(Collectors.toList());
		

		 
		Map<Object, Long> counts = finishList.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		String countsString = counts.toString();
		countsString = countsString.substring(1, countsString.length() - 1); 

		System.out.println(countsString);
				

		
	
	}
	


}
