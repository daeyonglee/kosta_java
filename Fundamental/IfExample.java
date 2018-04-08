public class IfExample {

	public static void main(String[] args) {
		
		// 단순 if문
		int score = 77;

		if (score >= 60) {
			System.out.println("Pass");
		}

		// if ~ else 문
		if (score >= 60) {
			System.out.println("Pass");
		} else {
			System.out.println("Unpass");
		}

		// 수우미양가
		if (score >= 90) {
			System.out.println("수");
		} else if (score >= 80) {
			System.out.println("우");
		} else if (score >= 70) {
			System.out.println("미");
		} else if (score >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}
	}

}
