package com.github.hcsp.io;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAccessor {

    // 使用JDK原始方法读取
    public static List<String> readFile1(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> lineList = new ArrayList<>();
        String lineStr;
        while (true) {
            lineStr = br.readLine();
            if (lineStr == null) {
                break;
            }
            lineList.add(lineStr);
        }

        return lineList;
    }

    // 使用JDK 1.7自带Files工具类读取
    public static List<String> readFile2(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // 使用第三方Apache commons-io工具包中的FileUtils类读取
    public static List<String> readFile3(File file) throws IOException {
        return FileUtils.readLines(file, Charset.defaultCharset());
    }


    // 使用JDK原始方法写入
    public static void writeLinesToFile1(List<String> lines, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
    }

    // 使用JDK 1.7自带Files工具类写入
    public static void writeLinesToFile2(List<String> lines, File file) throws IOException {
        Files.write(file.toPath(), lines);
    }

    // 使用第三方Apache commons-io工具包中的FileUtils类写入
    public static void writeLinesToFile3(List<String> lines, File file) throws IOException {
        FileUtils.writeLines(file, lines);
    }


    public static void main(String[] args) throws IOException {
        File projectDir = new File(System.getProperty("basedir", System.getProperty("user.dir")));
        File testFile = new File(projectDir, "target/test.txt");
        List<String> lines = Arrays.asList("AAA", "BBB", "CCC");
        writeLinesToFile1(lines, testFile);
        writeLinesToFile2(lines, testFile);
        writeLinesToFile3(lines, testFile);

        System.out.println(readFile1(testFile));
        System.out.println(readFile2(testFile));
        System.out.println(readFile3(testFile));
    }
}
