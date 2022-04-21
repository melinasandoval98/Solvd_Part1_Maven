package com.solvd.mavenprojectok.wordcounter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UniqueWordCounter {
	public static final Logger LOGGER = LogManager.getLogger(UniqueWordCounter.class);
	private static final String SOURCE_FILE_NAME = "text.txt";
	private static final String NEW_FILE_NAME = "mapOfUniqueWordsInTextFile.txt";

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir") + "/src/main/resources/";
		readLinesFromFileToString(SOURCE_FILE_NAME, path);
		Pattern pattern = Pattern.compile("[^[a-zA-Z]]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(readLinesFromFileToString(SOURCE_FILE_NAME, path));
		String string = matcher.replaceAll(" ");
		Set<String> setOfStrings = new HashSet<>();
		for (String word : string.split(" ")) {
			if (word.length() > 1 || "a".equalsIgnoreCase(word) || "I".equalsIgnoreCase(word)) {
				setOfStrings.add(word.toLowerCase());
			}
		}
		Map<String, Integer> mapOfUniqueWords = new HashMap<String, Integer>();
		for (String uniqueWord : setOfStrings) {
			Integer matches = StringUtils.countMatches(readLinesFromFileToString(SOURCE_FILE_NAME, path).toLowerCase(),
					uniqueWord);
			mapOfUniqueWords.put(uniqueWord, matches);
		}
		for (String key : mapOfUniqueWords.keySet()) {
			FileUtils.writeStringToFile(createNewFile(NEW_FILE_NAME, path),
					key + " = " + mapOfUniqueWords.get(key).toString() + "\n", StandardCharsets.UTF_8, true);
		}
		LOGGER.info("The map of unique words and the number of ocurrences of each in the\n" + "text file \""
				+ SOURCE_FILE_NAME + "\" has been stored successfully in the text file \"" + NEW_FILE_NAME
				+ "\"\nlocated at " + path);
	}

	private static File readTextFile(String fileName, String path) throws IOException {
		File souceFile = new File(path + fileName);
		return souceFile;
	}

	private static String readLinesFromFileToString(String fileName, String path) {
		String allCharactersInTheTextFile;
		while (true) {
			try {
				allCharactersInTheTextFile = FileUtils.readFileToString(readTextFile(fileName, path), "UTF-8");
				return allCharactersInTheTextFile;
			} catch (IOException e) {
				LOGGER.error("A file with the specified name could not be found. Please try again.", e);
				continue;
			}
		}
	}

	public static File createNewFile(String fileName, String path) throws IOException {
		File newFile = new File(path + fileName);
		return newFile;
	}

}
