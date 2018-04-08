
public class Bicycle {
	int id;
	String brand;
	String frame;
	
	public Bicycle() {
		this(0, null, null);
	}
	
	public Bicycle(int id, String brand, String frame) {
		this.id = id;
		this.brand = brand;
		this.frame = frame;
		
	}
	
	public void some() {
		System.out.println("Bicycle의 some()메소드 입니다.");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicycle other = (Bicycle) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (frame == null) {
			if (other.frame != null)
				return false;
		} else if (!frame.equals(other.frame))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return + id + ", " + brand + ", " + frame;
	}
}
