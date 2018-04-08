/**
 * 배열 선언, 생성, 초기화
 * @author 이대용
 */
public class ArrayExample {

	public static void main(String[] args) {
		// 1차원 배열
		int[] array;
		array = new int[5];
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		System.out.println(array[0]);
		System.out.println(array[4]);
		
		int[] array2 = array;
		
		System.out.println(array[0]);
		
		// for문을 이용한 배열 원소 출력
		for (int i=0; i<5; i++) {
			System.out.println(array[i]);
		}
		
		//int[] array3 = new int[] {5, 4, 3, 2, 1};
		int[] array3 = {5,4,3,2,1};
		
		for (int i = 0; i < array3.length; i++) {
			System.out.println(array3[i]);
		}
		
		int[] array4 = {2, 7, 8, 9, 10};
		
		// 배열 복사
		int[] copyArray = new int[array4.length+2];
		
		for (int i = 0; i < array4.length; i++) {
			copyArray[i] = array4[i];
			System.out.println(copyArray[i]);
		}
		
		System.out.println("===========");
		
		int[] array5 = {8, 1, 3, 9, 6, 2, 7, 10, 4, 5};
		int[] sort = new int[array5.length];
		int temp = 0;
		
		for (int i = 0; i < array5.length; i++) {
			
			if (i == 0) {
				sort[i] = array5[i];
				continue;
			}
			
			int value = array5[i];
			
			for (int j = 0; j <= i; j++) {
				
				if (sort[j] > value) {
					temp = sort[j];
					sort[j] = value;
					value = temp;
				}
				
				if (j == i)
				{
					sort[j] = value;
				} 
			}
		}
		
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
		
	}
}
