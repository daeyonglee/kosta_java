package kr.or.kosta.java5;

import java.util.Calendar;
import java.util.Formatter;

public class FormatterExample {
	public static void main(String[] args) {

		int number = 1234567;
		Formatter formatter = new Formatter();
		// Formatter format(String format,Object... args)
		// format : "%[������ڼ���$][��¿ɼ�(-, +, (,,..)][����ڸ���][.�Ҽ��������ڸ���]��µ���������"
		// args : ������ �ϰ��� �ϴ� ��������
		String formatedString = null;
		formatedString = formatter.format("%d", number).toString();
		System.out.println(formatedString);

		formatter = new Formatter();
		// �������� �� ������ ���
		System.out.println(formatter.format("%1$d", number));

		formatter = new Formatter();
		// 20�ڸ�Ȯ���ϰ�, 3�ڸ����� �޸� ���, ��ȣ�ް�, �������� �� ������ ����
		System.out.println(formatter.format("%,+-20d", number));

		double height = 23454.34343434356;
		formatter = new Formatter();
		// 20�ڸ�Ȯ���ϰ�, 3�ڸ����� �޸� ���, ��ȣ�ް�, �������� �� �Ҽ��� ���� 2�ڸ� �Ǽ��� ����
		System.out.println(formatter.format("%,+-20.2f", height));
		
		String name = "�����";
		formatter = new Formatter();
		// 10�ڸ�Ȯ���ϰ� �������� �� ���ڿ� ����
		System.out.println(formatter.format("%10s", name));

		formatter = new Formatter();
		System.out.println(formatter.format("%o", 150)); //8���� ����
		System.out.println(formatter.format("%x", 458)); //16���� ����
		
		System.out.printf("%1$,20.2f\n",1412376.8974);
		
		System.out.println(String.format("%1$-30s", "�Ҷ��� ���"));
		
		System.out.println(String.format("%tY", Calendar.getInstance())); //4�ڸ��⵵
		System.out.println(String.format("%ty", Calendar.getInstance())); //2�ڸ��⵵
		System.out.println(String.format("%tm", Calendar.getInstance())); //���ڿ� 
		System.out.println(String.format("%tB", Calendar.getInstance())); //���ڿ���
		System.out.println(String.format("%td", Calendar.getInstance())); //��
		System.out.println(String.format("%tA", Calendar.getInstance())); //����

		System.out.println(String.format("%tH", Calendar.getInstance())); //24�ð�
		System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); //����/���� 12�ð�System.out.println(String.format("%tM", Calendar.getInstance())); //��
		System.out.println(String.format("%tS", Calendar.getInstance())); //��

		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", Calendar.getInstance()));

		// ��¥/�ð� �ռ����� ���
		System.out.println(String.format("%1$tF %1$tT", Calendar.getInstance()));

		System.out.println(String.format("%1$tT %1$tF", Calendar.getInstance()));
		
	}
}
