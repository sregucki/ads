package shared;

import java.util.Map;
import java.util.Objects;

public class Pair<K, V> implements Comparable<Pair<K, V>> {

	final K key;
	final V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public static <K, V> Pair<K, V> entryToPair(Map.Entry<K, V> entry) {
		return new Pair<>(entry.getKey(), entry.getValue());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair<?, ?> pair = (Pair<?, ?>) o;
		return (
			Objects.equals(key, pair.key) && Objects.equals(value, pair.value)
		);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		return "Pair{" + "c=" + key + ", val=" + value + '}';
	}

	@Override
	public int compareTo(Pair<K, V> o) {
		return (int) o.value - (int) this.value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
