package com.xjj.e_07_upload;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @Author LJ
 * @Date 2020/11/26
 * msg 控制器可以与存储层（如文件系统）交互。
 */

public interface StorageService {
    // 创建目录等
    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
