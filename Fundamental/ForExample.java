public class ForExample {

	public static void main(String[] args) {
		System.out.println();

		for (int i=0; i<10; i++) {
			System.out.println("�ݺ���");
		}

		int sum=0;
		// 1���� 100���� ��
		for (int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println("�� : " + sum);

		for (int i=0; i<5; i++)
		{
			for (int j=5; j>i; j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i=2; i<=9; i++)
		{
			for (int j=1; j<=9; j++)
			{
				System.out.print(i + "*" + j + "=" + i*j);
				System.out.print("\t");
			}
			System.out.println();
		}

	}

}
