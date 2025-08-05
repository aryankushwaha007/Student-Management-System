package com.studentmanagement.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FileUtil {
    private static final String FILE_PATH = "data/students.txt";

    public static List<String> readAllLines() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            return new ArrayList<>();
        }
        if (file.length() == 0)
            return new ArrayList<>();
        List<String> lines = Files.readAllLines(file.toPath());
        return lines.stream()
                .filter(line -> line != null && !line.trim().isEmpty() && line.contains(","))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void writeAllLines(List<String> lines) throws IOException {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        Files.write(Paths.get(FILE_PATH), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void appendLine(String line) throws IOException {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(line);
            bw.newLine();
        }
    }
}
