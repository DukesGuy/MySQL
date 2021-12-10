package sorting;

import java.util.NoSuchElementException;
import java.util.Optional;

public class DogOptional {
	public static void main(String[] args) {
		new DogOptional().run();
	}

	private void run() {
		Dog dog = dogMethod(Optional.of(new Dog("Chihuahua")));
		System.out.println(dog);
		
		try {
			dogMethod(Optional.empty());
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private Dog dogMethod(Optional<Dog> optionalDog) {
		return optionalDog.orElseThrow(() -> new NoSuchElementException("No such dog!"));
	}

}
