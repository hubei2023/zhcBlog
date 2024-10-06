package com.example;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {
//    static int i = 0;

    public static void main(String[] args) {
        System.out.println("menu:\n" + "  Home: / || fas fa-home");
        printMenu("/Users/whoareyou/hubei2023.github.io/source/_posts/香港大学推荐50本/");
    }

    public static void printMenu(String path) {
        // 获取当前工作目录
        File currentDir = new File(path);

        // 获取当前目录下的所有子文件和子文件夹
        File[] filesAndDirs = currentDir.listFiles();

        if (filesAndDirs != null && filesAndDirs.length > 0) {
            for (File fileOrDir : filesAndDirs) {
                if (fileOrDir.isDirectory()) {
                    System.out.println("  " + fileOrDir.getName() + "||fas fa-list:");
                } else if (fileOrDir.isFile()) {
                    if (fileOrDir.getName().contains("#") || fileOrDir.getName().contains("*")) {
                        String fileName = fileOrDir.getName();
                        String newString = fileName.replace("#", "");
                        String var3 = newString.replace("*", "");
                        File newFile = new File(fileOrDir.getParent() + "/" + var3);
                        fileOrDir.renameTo(newFile);
                    }
                    String date = readData(fileOrDir.getAbsolutePath());
                    if (date != null) {
                        String fileName = fileOrDir.getAbsolutePath().substring(67, fileOrDir.getAbsolutePath().length() - 3);
                        System.out.println("     " + fileOrDir.getName().substring(0, fileOrDir.getName().length() - 3) + ": " + date + fileName + "/");
                    }
                }
                printMenu(fileOrDir.getAbsolutePath());
            }
        }
    }


    public static String readData(String path) {
        File logFile = new File(path); // 替换为你的日志文件路径

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            String title = null;
            String date = null;
            Pattern titlePattern = Pattern.compile("^title:\\s*\"(.*?)\"");
            Pattern datePattern = Pattern.compile("^date:\\s*(\\d{4}-\\d{2}-\\d{2})");

            // 读取日志文件
            while ((line = br.readLine()) != null) {
                Matcher titleMatcher = titlePattern.matcher(line);
                Matcher dateMatcher = datePattern.matcher(line);

                if (titleMatcher.find()) {
                    title = titleMatcher.group(1);
                }

                if (dateMatcher.find()) {
                    date = dateMatcher.group(1);
                }

                // 如果都找到，跳出循环
                if (title != null && date != null) {
                    break;
                }
            }

            // 如果找到 date，按 /yyyy/mm/dd/ 格式输出
            if (date != null) {
                String[] dateParts = date.split("-");
                return String.format("/%s/%s/%s/", dateParts[0], dateParts[1], dateParts[2]);
            }
            return null;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
