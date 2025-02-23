package by.it.skorobogatyi.jd01_15; //comment

//comment

import by.it.skorobogatyi.jd01_14.FilenameGetter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class TaskB {

    /**
     * ffffsdfbsfgbsfgn
     * dghmdhmdgh
     */
    public static final String ROOT = "src";
    public static final String INPUT_FILE = "TaskB.java";
    public static final String OUTPUT_FILE = "TaskB.txt";
    public static final String SLASH = "/";
    public static final String STAR = "*";
    public static final String OPEN_COMMENT = SLASH + STAR;
    public static final String CLOSE_COMMENT = STAR + SLASH;

    public static void main(String[] args) {

        String inputFile = FilenameGetter.getFilename(TaskB.class, ROOT, INPUT_FILE);

        StringBuilder stringBuilder = new StringBuilder();

        checkForCommentsAndDelete(inputFile, stringBuilder);

        outputToTXTFile(stringBuilder);

        System.out.println(stringBuilder);
    }


    private static void checkForCommentsAndDelete(String inputFile, StringBuilder stringBuilder) {
        try {
            RandomAccessFile file = new RandomAccessFile(inputFile, "r");

            boolean shouldAppend = true;
            while (file.getFilePointer() < file.length()) {

                String tempString = file.readLine();

                if (tempString.contains("final")) {
                    stringBuilder.append(tempString).append("\n");
                    continue;
                }

                if (tempString.contains(SLASH)) {
                    if (tempString.contains(OPEN_COMMENT)) {
                        tempString = tempString.substring(0, tempString.indexOf(SLASH));
                        stringBuilder.append(tempString).append("\n");
                        shouldAppend = false;
                    } else if (tempString.contains(CLOSE_COMMENT)) {
                        shouldAppend = true;
                        continue;
                    } else {
                        tempString = tempString.substring(0, tempString.indexOf(SLASH));
                    }
                }

                if (shouldAppend) {
                    stringBuilder.append(tempString).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("IO error:", e);
        }
    }

    private static void outputToTXTFile(StringBuilder stringBuilder) {

        String outputTXTFilename = FilenameGetter.getFilename(TaskB.class, ROOT, OUTPUT_FILE);
        try (
                PrintWriter printWriter = new PrintWriter(outputTXTFilename)
        ) {
            printWriter.print(stringBuilder);

        } catch (IOException e) {
            throw  new RuntimeException("ERROR: ", e);
        }
    }
}
