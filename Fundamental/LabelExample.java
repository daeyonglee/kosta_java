public class LabelExample {

	public static void main(String[] args) {
		
		MyLabel:
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++)
			{
				System.out.println("j = " + j);

				if (j == 5)
				{
					break MyLabel;
				}
			}

			System.out.println("i = " + i);
		}
	}
}
