package sorting;

import java.util.ArrayList;
import java.util.List;

public class Dog {
	private String name;
	
	private static List<Dog> dogs  = List.of(
			new Dog("Golden Retriever"),
			new Dog("Beagle"),
			new Dog("Daschund"),
			new Dog("Boston Terrier"),
			new Dog("Labrador")
			);
	
	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static int compare(Dog d1, Dog d2) {
		return d1.name.compareTo(d2.name);
	}

	public static List<Dog> getDogs() {
		return new ArrayList<>(dogs);
	}

	

}
