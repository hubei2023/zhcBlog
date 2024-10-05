const fs = require('fs');
const path = require('path');

// 获取当前工作目录名
const currentDirectoryName = path.basename(process.cwd());

// 定义要插入的模板文本格式
const textTemplate = (title, date, tags) => `---
title: "${title}"
date: ${date}
tags: ${tags.join(', ')}
---
`;

// 获取当前日期

const date = new Date(); // 这里的月份是基于 0 的，8 表示 9 月
const year = date.getFullYear();
const month = String(date.getMonth() + 1).padStart(2, '0'); // 月份从 0 开始，所以需要 +1，确保有两位数
const day = String(date.getDate()).padStart(2, '0'); // 确保日期是两位数

const formattedDate = `${year}-${month}-${day}`;
console.log(formattedDate); // 输出 "2024-09-28"

const currentDate = formattedDate; // 可以根据需要动态生成

// 读取当前目录中的所有文件
fs.readdir(process.cwd(), (err, files) => {
  if (err) {
    console.error('无法读取目录', err);
    return;
  }

  files.forEach((file) => {
    const filePath = path.join(process.cwd(), file);

    // 检查是否为普通文件，并且是 Markdown 文件（如 `.md`）
    if (fs.statSync(filePath).isFile() && path.extname(file) === '.md') {
      // 读取文件内容
      let fileContent = fs.readFileSync(filePath, 'utf8');

      // 提取文件名并构造新的 title（不含扩展名）
      const fileNameWithoutExt = path.basename(file, path.extname(file));
      const newTitle = `《${currentDirectoryName}》-${fileNameWithoutExt}`;

      // 替换现有的 title 或插入新的 title
      // 匹配 front-matter 中的 title 字段
      fileContent = fileContent.replace(/(?<=^title: ").*(?="$)/m, newTitle);

      // 如果没有 title 字段，则插入完整的 front-matter
      if (!/^title: /m.test(fileContent)) {
        const newText = textTemplate(newTitle, currentDate, ['']);
        fileContent = newText + fileContent;
      }

      // 写回文件
      fs.writeFileSync(filePath, fileContent, 'utf8');
      console.log(`已成功在 ${filePath} 中插入或更新标题为：${newTitle}`);
    }
  });
});
