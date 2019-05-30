import java.util.ArrayList;
import java.util.HashSet;

public class RandomHashSet<T> {

	private HashSet<T> set;
	private ArrayList<T> data;

	public RandomHashSet() {
		set = new HashSet<>();
		data = new ArrayList<>();
	}

	public boolean contains(T object) {
		return set.contains(object);
	}

	public T randomElement() {
		return data.get((int) (Math.random() * data.size()));
	}

	public void clear() {
		data.clear();
		set.clear();
	}

	public int size() {
		return data.size();
	}

	public void add(T object) {
		if (!set.contains(object)) {
			set.add(object);
			data.add(object);
		}
	}

	public T get(int index) {
		return data.get(index);
	}

	public ArrayList<T> getData() {
		return data;
	}


}
