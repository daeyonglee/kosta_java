import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		char[] days = {'��','��','ȭ','��','��','��','��'};
		
		System.out.println(year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second);
		
		System.out.println("������ " + days[day-1] +"���� �Դϴ�.");
		
		switch(day) {
			case Calendar.SUNDAY: System.out.println("������ �Ͽ��� �Դϴ�.");	break;
			case 2: System.out.println("������ ������ �Դϴ�.");  	break;
			case 3: System.out.println("������ ȭ���� �Դϴ�.");  	break;
			case 4: System.out.println("������ ������ �Դϴ�.");  	break;
			case 5: System.out.println("������ ����� �Դϴ�.");  	break;
			case Calendar.FRIDAY: System.out.println("������ �ݿ��� �Դϴ�.");  	break;
			case 7: System.out.println("������ ����� �Դϴ�.");  	break;
		}
		
	}
}
