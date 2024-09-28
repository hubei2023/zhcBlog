hexo.extend.filter.register('before_post_render', function(data) {
    // 处理标题中的特殊字符
    if (data.title) {
      data.title = data.title.replace(/\*/g, '\\*');
    }
    
    // 处理描述中的特殊字符
    if (data.description) {
      data.description = data.description.replace(/\*/g, '\\*');
    }
    
    // 处理标签中的特殊字符
    if (data.tags && Array.isArray(data.tags)) {
      data.tags = data.tags.map(tag => tag.replace(/\*/g, '\\*'));
    }
  
    return data;
  });
  