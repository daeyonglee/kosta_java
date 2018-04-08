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
		
		char[] days = {'일','월','화','수','목','금','토'};
		
		System.out.println(year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second);
		
		System.out.println("오늘은 " + days[day-1] +"요일 입니다.");
		
		switch(day) {
			case Calendar.SUNDAY: System.out.println("오늘은 일요일 입니다.");	break;
			case 2: System.out.println("오늘은 월요일 입니다.");  	break;
			case 3: System.out.println("오늘은 화요일 입니다.");  	break;
			case 4: System.out.println("오늘은 수요일 입니다.");  	break;
			case 5: System.out.println("오늘은 목요일 입니다.");  	break;
			case Calendar.FRIDAY: System.out.println("오늘은 금요일 입니다.");  	break;
			case 7: System.out.println("오늘은 토요일 입니다.");  	break;
		}
		
	}
}
