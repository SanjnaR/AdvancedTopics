
public class Merge {
int[] arr;
	public Merge(int []arr) {
		this.arr = arr;
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] num = new int [arr1.length + arr2.length];
		int j = 0;
		int k = 0;
		int i = 0;
		while(j < arr1.length && k < arr2.length && i < num.length) {
		
			if(arr1[j] <= arr2[k]) {
				num[i] = arr1[j];
				j++;
			}
			else {
				num[i] = arr2[k];
				k++;
			}
			i++;
	}
		
		while(j < arr1.length) {
			num[i] = arr1[j];
			i++;
			j++;
		}
		
		while(k < arr2.length) {
			num[i] = arr2[k];
			i++;
			k++;
		}	
		return num;
	}
	
	
	public static void display(int []arr) { 
		for (int x : arr) 
			System.out.print(x + " "); 
		System.out.println(); 
	} 
	
	public void display() { 
		for (int x : arr) 
			System.out.print(x + " "); 
		System.out.println(); 
	} 
	
	public void mergeSort() {
		int length = arr.length;
		doMergeSort(0, length - 1);
	}
	
	private void doMergeSort(int lowerIndex, int higherIndex) {
		if(lowerIndex < higherIndex) {
			 
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			doMergeSort(lowerIndex, middle);
			doMergeSort(middle + 1, higherIndex);		 
			mergeParts(lowerIndex, middle, higherIndex);			 
		}				
	}
	
	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		int[] tempMerge = new int[arr.length];
		for(int i = lowerIndex; i <= higherIndex; i++) {
			tempMerge[i] = arr[i];		 
		}
		
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while(i <= middle && j <= higherIndex) {
			if(tempMerge[i] <= tempMerge[j]) {
				arr[k] = tempMerge[i];
				i++;			 
			}
			
			else {
				arr[k] = tempMerge[j];
				j++;			 
			}
			
			k++;
		}
		while(i <= middle) {
			arr[k] = tempMerge[i];
			k++;
			i++; 
		}
	}

	public static void main(String[] args) {
		int one[] = {1, 3, 5, 7, 9};
		int two[] = {2, 4, 6, 8};
		int three[] = merge(one, two);
		
		display(three);
		
		int four[] = {2,5,2,6,4,7,1,4,7};
		
		Merge m1 = new Merge(four);
		m1.mergeSort();
		m1.display();
		
	}
}
