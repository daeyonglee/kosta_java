/**
 * 다차원 배열 테스트
 * @author 이대용
 *
 */
public class MultiArrayExample {
	public static void main(String[] args) {
		int[][] array;
		array = new int[5][6];
		array[0][0] = 10;
		array[4][5] = 20;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		
		for (int[] is : array) {
			for (int i : is) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
