public class SwitchExample {

	public static void main(String[] args) {
		
		int score = 91;

		switch (score / 10) {
			case 10:
			case 9: System.out.println("��"); break;
			case 8: System.out.println("��"); break;
			case 7: System.out.println("��"); break;
			case 6: System.out.println("��"); break;
			default: System.out.println("��");
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

		switch ("abcd") {
			case "abcd" : System.out.println("�����ϴ�."); break;
			default : System.out.println("���� �ʽ��ϴ�.");
		
		}
	}

}
