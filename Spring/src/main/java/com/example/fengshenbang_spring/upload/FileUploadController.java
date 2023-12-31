package com.example.fengshenbang_spring.upload;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin-api")
public class FileUploadController {
    @Value("${file.allowed-types}")
    private String allowedTypes;
    @Value("${file.max-size}")
    private long maxFileSize;
    @Value("${file.upload-path}")
    private String uploadPath;

    @PostMapping("/file/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return "上传文件不能为空";
        }
        if (!StringUtils.hasText(uploadPath)) {
            return "文件上传路径未配置";
        }
        if (!isFileTypeAllowed(file)) {
            return "不允许上传该文件类型";
        }
        if (!isFileContentValid(file)) {
            return "文件内容不合法";
        }
        if (file.getSize() > maxFileSize) {
            return "文件大小超过限制";
        }
        try {
            String fileName = generateUniqueFileName(file.getOriginalFilename());

            String filePath = uploadPath + File.separator + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            // 将文件名保存到数据库中
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("文件上传失败");
        }
    }

    private boolean isFileTypeAllowed(MultipartFile file) {
        String fileExtension = getFileExtension(file.getOriginalFilename());
        if (fileExtension != null) {
            List<String> allowedExtensions = Arrays.asList(allowedTypes.split(","));
            return allowedExtensions.contains(fileExtension.toLowerCase());
        }
        return false;
    }

    private boolean isFileContentValid(MultipartFile file) throws IOException {
        // 验证文件类型是否为图像类型
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            return false;
        }
        // 示例：验证文件内容为图片（JPEG 或 PNG）
        byte[] fileBytes = file.getBytes();
        // JPEG 文件的文件头：FF D8 FF E0
        // PNG 文件的文件头：89 50 4E 47 0D 0A 1A 0A
        if (fileBytes.length >= 4) {
            byte[] jpegHeader = {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE0};
            byte[] pngHeader = {(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};
            return startsWith(fileBytes, jpegHeader) || startsWith(fileBytes, pngHeader);
        }
        return false;
    }

    private boolean startsWith(byte[] array, byte[] prefix) {
        if (array.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (array[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }

    private String generateUniqueFileName(String originalFileName) {
        String fileExtension = getFileExtension(originalFileName);
        String uniqueFileName = UUID.randomUUID().toString();
        if (fileExtension != null) {
            uniqueFileName += "." + fileExtension;
        }
        return uniqueFileName;
    }

    private String getFileExtension(String fileName) {
        if (StringUtils.hasText(fileName)) {
            int dotIndex = fileName.lastIndexOf(".");
            if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
                return fileName.substring(dotIndex + 1);
            }
        }
        return null;
    }
}
