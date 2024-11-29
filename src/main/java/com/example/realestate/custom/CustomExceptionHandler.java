package com.example.realestate.custom;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationExceptions(MethodArgumentNotValidException ex, RedirectAttributes redirectAttributes) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.append(fieldName).append(": ").append(errorMessage).append("\n");
        });
        redirectAttributes.addFlashAttribute("errors", errors.toString());
        return "redirect:/real-estate/post";
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Kích thước file vượt quá giới hạn cho phép!");
        return "redirect:/real-estate/post";
    }
}
