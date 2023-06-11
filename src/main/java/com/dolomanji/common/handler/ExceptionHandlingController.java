package com.dolomanji.common.handler;

import com.dolomanji.ErrorEntry;
import com.dolomanji.ErrorWrapper;
import com.dolomanji.common.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorWrapper> handleCommonException(final CommonException exception) {
        final List<ErrorEntry> errorEntries = List.of(
                buildErrorEntry(exception.getField(), exception.getMessage())
        );

        return ResponseEntity.badRequest().body(
                buildErrorWrapper(
                        exception.getSource(),
                        errorEntries
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorWrapper> handleMethodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        final List<ErrorEntry> errorEntries = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> buildErrorEntry(objectError.getObjectName(), objectError.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(buildErrorWrapper("Application", errorEntries));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorWrapper> handleRuntimeException(final RuntimeException runtimeException) {
        final ErrorEntry errorEntry = buildErrorEntry("system", "Unexpected exception");
        final ErrorWrapper errorWrapper = buildErrorWrapper("Application", List.of(errorEntry));

        return ResponseEntity.badRequest().body(errorWrapper);
    }

    private static ErrorWrapper buildErrorWrapper(final String source, final List<ErrorEntry> errorEntries) {
        final ErrorWrapper errorWrapper = new ErrorWrapper();
        errorWrapper.setErrors(errorEntries);
        errorWrapper.setSource(source);
        errorWrapper.setTimestamp(OffsetDateTime.now());
        return errorWrapper;
    }

    private static ErrorEntry buildErrorEntry(final String fieldName, final String message) {
        final ErrorEntry errorEntry = new ErrorEntry();
        errorEntry.setFieldName(fieldName);
        errorEntry.setMessage(message);
        return errorEntry;
    }


}
