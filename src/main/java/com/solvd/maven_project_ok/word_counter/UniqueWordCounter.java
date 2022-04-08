package com.solvd.maven_project_ok.word_counter;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UniqueWordCounter {
	public static final Logger LOGGER = LogManager.getLogger(UniqueWordCounter.class);
	private static final String SOURCE_FILE_NAME = "text.txt";
	private static final String NEW_FILE_NAME = "mapOfUniqueWordsInTextFile.txt";
	private static String allCharactersInTheTextFile;

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "/src/main/resources/";
		readLinesFromFile(SOURCE_FILE_NAME, path);
		Pattern pattern = Pattern.compile("[^[a-zA-Z]]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(allCharactersInTheTextFile);
		String string = matcher.replaceAll(" ");
		Set<String> setOfStrings = new HashSet<>();
		for (String word : string.split(" ")) {
			setOfStrings.add(word);
		}
		Map<String, Integer> mapOfUniqueWords = new HashMap<String, Integer>();
		for (String uniqueWord : setOfStrings) {
			Integer matches = StringUtils.countMatches(allCharactersInTheTextFile, uniqueWord);
			mapOfUniqueWords.put(uniqueWord, matches);
		}
		createNewFile(NEW_FILE_NAME, path, mapOfUniqueWords);
		LOGGER.info("The text file has been created successfully");
	}

	private static File readTextFile(String fileName, String path) throws IOException {
		File souceFile = new File(path + fileName);
		return souceFile;
	}

	private static void logErrorIOException(Exception e) {
		LOGGER.error(e);
		LOGGER.info("Cannot acces to the file");
	}

	private static void readLinesFromFile(String fileName, String path) {
		try {
			allCharactersInTheTextFile = FileUtils.readFileToString(readTextFile(fileName, path), "UTF-8");
		} catch (IOException e) {
			logErrorIOException(e);
		}
	}

	public static File writeTextFile(String fileName, String path) throws IOException {
		File newFile = new File(path + fileName);
		return newFile;
	}

	public static void createNewFile(String fileName, String path, Map<String, Integer> map) {
		try (BufferedWriter bf = new BufferedWriter(new FileWriter(writeTextFile(fileName, path)))) {
			for (String key : map.keySet()) {
				bf.write(key + " = " + map.get(key));
				bf.newLine();
			}
			bf.flush();
			bf.close();

		} catch (IOException e) {
			logErrorIOException(e);
		}
	}
}
