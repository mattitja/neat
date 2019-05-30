import java.util.ArrayList;

public class RandomSelector<T> {

	private ArrayList<T> objects = new ArrayList<>();
	private ArrayList<Double> scores = new ArrayList<>();

	private double totalScore = 0;

	public void add(T element, double score) {
		objects.add(element);
		scores.add(score);
		totalScore += score;
	}

	public T random() {
		double randomScore = Math.random() * totalScore;

		double temporarySum = 0;

		for (int i = 0; i < objects.size(); i++) {
			temporarySum += scores.get(i);

			if (temporarySum > randomScore) {
				return objects.get(i);
			}
		}

		return null;
	}

	public void reset() {
		objects.clear();
		scores.clear();
	}
}
