package org.loyy.arithmetic;
import java.util.Arrays;

public class BubbleSortAndSelectSort{
	public static void main(String[] args){
		int[] arr={5,2,1,6,74};
		int[] arr1={8,37,3,4,96,6};
				
		
		//选择排序
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
				
				}

			}
		}

		//冒泡排序

		for(int i=0;i<arr1.length;i++){
			for (int n=0; n<arr1.length-1-i; n++) {
			 	if(arr1[n]>arr1[n+1]){
			 		int t=arr1[n];
			 		arr1[n]=arr1[n+1];
			 		arr1[n+1]=t;
			 	}
			}
		}

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
			
		}
			System.out.println();
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr1[i]+" ");
			}
	}
}