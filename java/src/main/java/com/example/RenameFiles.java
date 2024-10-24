package com.example;

import java.io.IOException;
import java.nio.file.*;

public class RenameFiles {

    public static void main(String[] args) {
        // 指定要操作的目录
        String directoryPath = "/Users/huocheng/hubei2023.github.io/source/_posts/";

        try {
            // 遍历指定目录及其子目录下的所有文件
            Files.walk(Paths.get(directoryPath))
                    .filter(Files::isRegularFile)  // 只处理文件，不处理目录
                    .forEach(filePath -> {
                        try {
                            renameFile(filePath);
                        } catch (IOException e) {
                            System.err.println("Error renaming file: " + filePath + " - " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error walking through directory: " + e.getMessage());
        }
    }

    // 重命名文件，移除文件名中的 # 和 *
    private static void renameFile(Path filePath) throws IOException {
        // 获取文件名（不包含路径）
        String fileName = filePath.getFileName().toString();

        // 替换文件名中的 # 和 *
        String newFileName = fileName.replace("#", "").replace("*", "");

        // 如果文件名没有变化，直接返回
        if (fileName.equals(newFileName)) {
            return;
        }

        // 获取文件的父目录
        Path parentDir = filePath.getParent();

        // 构建新的文件路径
        Path newFilePath = parentDir.resolve(newFileName);

        // 重命名文件
        Files.move(filePath, newFilePath);
        System.out.println("Renamed: " + filePath + " -> " + newFilePath);
    }
}