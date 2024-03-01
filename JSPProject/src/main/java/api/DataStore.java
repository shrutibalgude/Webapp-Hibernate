package api;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
	Map<String, Person> pMap=new HashMap<>();
	
	private static DataStore instance=new DataStore();
	
	public static DataStore getInstance() {
		return instance;
		
	}
	
	private DataStore() {
		pMap.put("Shruti", new Person(101, "Shruti", "Pune"));
		pMap.put("Shruti", new Person(102, "Vedant", "Pune"));
		pMap.put("Shruti", new Person(103, "Pranali", "Pune"));
		pMap.put("Shruti", new Person(104, "Parnika", "Pune"));
		pMap.put("Shruti", new Person(105, "Palak", "Pune"));
		
	}
	
	public Person getPerson(String name) {
		return pMap.get(name);
		
	}
	
	public void putPerson(Person person) {
		pMap.put(person.getName(), person);
	}
}
