package com.example.realestate.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FileUtils {
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("jpg", "jpeg", "png");
    private static final long MAX_FILE_SIZE = 2 * 1024 * 1024; // 2MB

    public static boolean isValidImage(MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            return false;
        }

        // Kiểm tra phần mở rộng
        String extension = getFileExtension(originalFilename).toLowerCase();
        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            return false;
        }

        // Kiểm tra kích thước
        return file.getSize() <= MAX_FILE_SIZE;
    }
    public static String saveImage(MultipartFile file, String uploadDir) throws IOException {
        if (!isValidImage(file)) {
            throw new IllegalArgumentException("File không hợp lệ");
        }

        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(filename);
        Files.copy(file.getInputStream(), filePath);

        return filename;
    }

    private static String getFileExtension(String filename) {
        int lastDotPosition = filename.lastIndexOf('.');
        if (lastDotPosition == -1) {
            return "";
        }
        return filename.substring(lastDotPosition + 1);
    }
}
