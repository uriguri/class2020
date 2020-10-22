package generic;

public class FruitBox<T> { // T -> Apple
	
	T fruit;	// Apple fruit;
	
	public FruitBox(T fruit) { //public FruitBox(Apple fruit)
		this.fruit = fruit;
	}
	
	public void store(T fruit) { // (Apple fruit)
		this.fruit = fruit;
	}
	
	public T pullOut() {	// Apple pullOut()
		return fruit;
	}
	
}
