const fs = require('fs');
const path = require('path');

// 定义要处理的目录路径
const directoryPath = '/Users/huocheng/hubei2023.github.io/source/_posts'; // 请将 'your-directory' 替换为你的实际目录路径

// 递归处理目录中的文件和子目录
function processDirectory(directory) {
  // 读取目录下的所有文件和子目录
  fs.readdir(directory, { withFileTypes: true }, (err, items) => {
    if (err) {
      console.error('无法读取目录:', err);
      return;
    }

    // 遍历目录下的所有文件和子目录
    items.forEach((item) => {
      const fullPath = path.join(directory, item.name);

      if (item.isDirectory()) {
        // 如果是目录，递归处理该子目录
        processDirectory(fullPath);
      } else {
        // 如果是文件，检查是否以 .md 或 .MD 结尾
        if (!item.name.toLowerCase().endsWith('.md')) {
          const newFileName = item.name+'.md'; // 替换扩展名为 .md
          const newFilePath = path.join(directory, newFileName);

          // 重命名文件
          fs.rename(fullPath, newFilePath, (err) => {
            if (err) {
              console.error('重命名文件时出错:', err);
            } else {
              console.log(`重命名文件: ${fullPath} -> ${newFilePath}`);
            }
          });
        }
      }
    });
  });
}

// 开始处理目录
processDirectory(directoryPath);
