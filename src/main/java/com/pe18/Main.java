package com.pe18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String fileName = "giant_pyramid.txt";

        List<int[]> pyramid = turnFiletoList(fileName);
        int[][] matrix = convertArrayListToMatrix(pyramid);

        // System.out.println();
        // System.out.println("\nOriginal Matrix");
        // printMatrix(matrix);

        int[][] matrixNew = deepCopyMatrix(matrix);

        int number = 0;
        int nextNumber = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {

                number = matrixNew[i][j];
                nextNumber = matrixNew[i][j + 1];

                if (j == 0) {
                    matrixNew[i + 1][j] += number;
                }
                
                if (number > nextNumber) {
                    matrixNew[i + 1][j + 1] += number;
                } else {
                    matrixNew[i + 1][j + 1] += nextNumber;
                }
            }
        }

        // System.out.println();
        // System.out.println("\nNew Matrix");
        // printMatrix(matrixNew);

        findHighestValue(matrixNew);
    }

    private static void findHighestValue(int[][] matrixNew){
        int highestValue = 0;
        //Find largest value in last row.
        for (int i = 0; i < matrixNew.length; i++) {
            if(matrixNew[matrixNew.length - 1][i] > highestValue){
                highestValue = matrixNew[matrixNew.length - 1][i];
            }
        }
        System.out.println("\nHighest value is: " + highestValue);
    }

    private static int[][] deepCopyMatrix(int[][] existingMatrix) {
        int numRows = existingMatrix.length;
        int[][] newMatrix = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            newMatrix[i] = existingMatrix[i].clone();
        }

        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] convertArrayListToMatrix(List<int[]> arrayList) {
        int numRows = arrayList.size();
        int numCols = arrayList.get(numRows - 1).length;

        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            int[] row = arrayList.get(i);
            for (int j = 0; j < numCols; j++) {
                if (j < row.length) {
                    matrix[i][j] = row[j];
                }
            }
        }

        return matrix;
    }

    private static void printList(List<int[]> list) {
        System.out.println("Pyramid stored in List<int[]>");

        for (int[] row : list) {

            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static List<int[]> turnFiletoList(String fileName) {
        List<int[]> arrayList = new ArrayList<>();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] numbers = line.trim().split("\\s+");
                    int[] row = new int[numbers.length];
                    for (int i = 0; i < numbers.length; i++) {
                        row[i] = Integer.parseInt(numbers[i]);
                    }
                    arrayList.add(row);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File not found: " + fileName);
        }
        return arrayList;
    }
}