package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

	public static List<String> readLines(String filename) {
		try {
			return Files.readAllLines(Path.of(filename));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
