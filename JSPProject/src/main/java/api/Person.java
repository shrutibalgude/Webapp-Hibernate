package api;

public class Person {
	private int pid;
	public Person( String address, String name, int pid) {
		// TODO Auto-generated constructor stub
		super();
		this.pid=pid;
		this.address=address;
		this.name=name;
	}
	Person(int i, String name2, String string) {
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	String name;
	String address;

}
