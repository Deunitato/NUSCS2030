import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

import java.util.OptionalDouble;
public class Main{

    static int y=0;
    static boolean flag = false;

	
	static OptionalDouble variance(int[] arr){
		if(arr.length <2){
			return OptionalDouble.empty();
		}
		
		double avg  = Arrays.stream(arr).asDoubleStream()
			.average().getAsDouble();
			
		double sqrdiffsum = Arrays.stream(arr).asDoubleStream()
			.map(x-> (x-avg))
			.map(y-> y*y).sum();
			
			OptionalDouble variance = OptionalDouble.of(sqrdiffsum/(arr.length-1));
			return variance;
		
	}
	
	


}
