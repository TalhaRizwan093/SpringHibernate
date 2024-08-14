package com.toosterr.backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.lang.Nullable;

import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Data
public class CustomErrorResponse implements ErrorResponse {

    private final HttpStatusCode statusCode;
    private final ProblemDetail problemDetail;
    private final Map<String, String> errors;
    private final String errorType;
    private int errorCode;

    public CustomErrorResponse(HttpStatusCode statusCode, ProblemDetail problemDetail, Map<String, String> errors, String errorType, int errorCode) {
        this.statusCode = statusCode;
        this.problemDetail = problemDetail;
        this.errors = errors;
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    @Override
    public ProblemDetail getBody() {
        return problemDetail;
    }

    @Override
    public ProblemDetail updateAndGetBody(@Nullable MessageSource messageSource, Locale locale) {
        if (messageSource != null) {
            String type = messageSource.getMessage(this.getTypeMessageCode(), (Object[]) null, (String) null, locale);
            if (type != null) {
                this.getBody().setType(URI.create(type));
            }

            Object[] arguments = this.getDetailMessageArguments(messageSource, locale);
            String detail = messageSource.getMessage(this.getDetailMessageCode(), arguments, (String) null, locale);
            if (detail != null) {
                this.getBody().setDetail(detail);
            }

            String title = messageSource.getMessage(this.getTitleMessageCode(), (Object[]) null, (String) null, locale);
            if (title != null) {
                this.getBody().setTitle(title);
            }
        }
        return this.getBody();
    }
}
