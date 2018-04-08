/**
 * 
 * @author ÀÌ´ë¿ë
 *
 */
public class Student<T> {
	
	private String name;
	private T ssn;
	
	public Student() {
		super();
	}
	
	public Student(String name, T ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getSsn() {
		return ssn;
	}
	public void setSsn(T ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", ssn=" + ssn + "]";
	}

	public static void main(String[] args) {
		Student<Integer> student = new Student<Integer>();
		student.setSsn(new Integer(9012390));
	}
	
}
