public class IfExample {

	public static void main(String[] args) {
		
		// �ܼ� if��
		int score = 77;

		if (score >= 60) {
			System.out.println("Pass");
		}

		// if ~ else ��
		if (score >= 60) {
			System.out.println("Pass");
		} else {
			System.out.println("Unpass");
		}

		// ����̾簡
		if (score >= 90) {
			System.out.println("��");
		} else if (score >= 80) {
			System.out.println("��");
		} else if (score >= 70) {
			System.out.println("��");
		} else if (score >= 60) {
			System.out.println("��");
		} else {
			System.out.println("��");
		}
	}

}
