package com.pe18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {

        String fileName = "small_pyramid.txt";
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File not found: " + fileName);
        }
    }
}

// try {
// List<int[]> arrays = readNumbersFromFile(filename);

// // Print the arrays
// for (int i = 0; i < arrays.size(); i++) {
// System.out.println("Array " + (i + 1) + ": " +
// java.util.Arrays.toString(arrays.get(i)));
// }
// } catch (IOException e) {
// System.err.println("Error reading this file: " + e.getMessage());
// }

// System.out.println("Program finished!");
// }

// private static List<int[]> readNumbersFromFile(String filename) throws
// IOException {

// // Creates a list of arrays
// List<int[]> arrayList = new ArrayList<>();

// try {
// // Creates a FileReader
// FileReader file = new FileReader(filename);

// // Creates a BufferedReader
// BufferedReader buffer = new BufferedReader(file);

// String line;
// while ((line = buffer.readLine()) != null) {
// System.out.println(line);

// }

// buffer.close();
// }

// catch (Exception e) {
// e.getStackTrace();
// }

// return arrayList;
// }