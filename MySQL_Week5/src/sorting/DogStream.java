package sorting;

import java.util.stream.Collectors;

public class DogStream {
	
	public static void main(String[] args) {
		new DogStream().run();
	}

	private void run() {
		// @formatter:off
		String dogs = Dog.getDogs().stream()
		   .map(Dog::toString)
		   .sorted()
		   .collect(Collectors.joining(", "));
		// @formatter:on
		
		System.out.println(dogs);
	}

}
