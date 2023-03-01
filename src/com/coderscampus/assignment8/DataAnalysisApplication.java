package com.coderscampus.assignment8;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class DataAnalysisApplication {

	public static void main(String[] args) {
		//DataService.getDataWrong();
//		List<Integer> numbers = DataService.getList();
//		System.out.println(numbers);
		
//		DataService.getData();
		
		CompletableFuture<List<Integer>> completableList = new CompletableFuture<List<Integer>>();
		List<CompletableFuture<Integer>> tasks = new ArrayList<>();
		ExecutorService pool = Executors.newCachedThreadPool();
//		ExecutorService boundTask2 = Executors.newFixedThreadPool(10);
		
				

			//List<Integer> numbersList =
//		for (int i=0; i>10;i++ ) {
			completableList = CompletableFuture.supplyAsync(() -> new DataService(), pool )
					.thenApplyAsync(dataService -> dataService.getData(), pool);
//					.thenAcceptAsync(dto -> System.out.println(dto), boundTask);
//		}

		System.out.println(completableList);
		
//		Map<Object, Long> counts = completableList.stream()
//				.collect(Collectors.groupingBy(e->e, Collectors.counting()));
//		System.out.println(counts);
//	
	}

}
