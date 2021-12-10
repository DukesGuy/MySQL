package sorting;

import java.util.List;

public class DogSorter {

	public static void main(String[] args) {
		new DogSorter().run();
	}

	private void run() {
		List<Dog> lambdaDogs = sortByLambda();
		System.out.println(lambdaDogs);
		List<Dog> methodDogs = sortByMethod();
		System.out.println(methodDogs);
	}

	private List<Dog> sortByLambda() {
		List<Dog> lambdaDogs = Dog.getDogs();
		lambdaDogs.sort((d1,d2) -> Dog.compare(d1, d2));
		return lambdaDogs;
	}
	
	private List<Dog> sortByMethod() {
		List<Dog> methodDogs = Dog.getDogs();
		methodDogs.sort(Dog::compare);
		return methodDogs;
	}

}
