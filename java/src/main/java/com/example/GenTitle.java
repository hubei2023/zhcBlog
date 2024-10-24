package com.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 给博客生成 标题
 */
public class GenTitle {


    // 获取当前工作目录名
    static String currentDirectoryName = "/Users/huocheng/hubei2023.github.io/source/_posts";

    public static void main(String[] args) {
        // 获取当前日期并格式化
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate = date.format(formatter);

        try {
            processDirectory(Paths.get(currentDirectoryName), currentDate);
        } catch (IOException e) {
            System.err.println("Error processing directory: " + e.getMessage());
        }
    }

    // 递归遍历目录并处理文件
    public static void processDirectory(Path directoryPath, String currentDate) throws IOException {
        Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                // 只处理 Markdown 文件（.md）
                if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".md")) {
                    writeTitle(filePath, currentDate);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Error visiting file: " + file.toString() + " - " + exc.getMessage());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    // 写入或更新 Markdown 文件中的标题
    public static void writeTitle(Path filePath, String currentDate) {
        try {
            List<String> lines = Files.readAllLines(filePath);

            StringBuilder content = new StringBuilder();
            boolean titleExists = false;
            String fileNameWithoutExt = filePath.getFileName().toString().replaceFirst("[.][^.]+$", ""); // 去掉扩展名

            String parentDirectoryName = filePath.getParent().getFileName().toString();
            String newTitle = "《" + parentDirectoryName + "》-" + fileNameWithoutExt;

            // 正则表达式匹配 title
            Pattern titlePattern = Pattern.compile("^title: \".*\"", Pattern.MULTILINE);
            for (String line : lines) {
                if (titlePattern.matcher(line).find()) {
                    // 如果找到 title 行，替换它
                    line = line.replaceFirst("(?<=^title: \").*(?=\"$)", newTitle);
                    titleExists = true;
                }
                content.append(line).append(System.lineSeparator());
            }
            if (content.toString().contains("title")) {
                return;
            }

            // 如果没有找到 title 行，插入新的 front-matter
            if (!titleExists) {
                String newText = textTemplate(newTitle, currentDate);
                String newText1 = newText.replace("*", "");
                String newText2 = newText1.replace("#", "");
                content.insert(0, newText2);
            }

            // 写回文件
            Files.write(filePath, content.toString().getBytes());
            System.out.println("已成功在 " + filePath.toString() + " 中插入或更新标题为：" + newTitle);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // 定义要插入的模板文本格式
    public static String textTemplate(String title, String date) {
        return "---\n" + "title: \"" + title + "\"\n" + "date: " + date + "\n" + "tags: \n" + "---\n";
    }
}
