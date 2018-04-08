public class SwitchExample {

	public static void main(String[] args) {
		
		int score = 91;

		switch (score / 10) {
			case 10:
			case 9: System.out.println("수"); break;
			case 8: System.out.println("우"); break;
			case 7: System.out.println("미"); break;
			case 6: System.out.println("양"); break;
			default: System.out.println("가");
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

		switch ("abcd") {
			case "abcd" : System.out.println("같습니다."); break;
			default : System.out.println("같지 않습니다.");
		
		}
	}

}
