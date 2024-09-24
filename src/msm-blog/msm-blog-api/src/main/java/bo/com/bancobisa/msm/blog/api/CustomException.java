package bo.com.bancobisa.msm.blog.api;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    private HttpStatus httpStatus;
    private String urlReference;
    private String code;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CustomException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }

    public CustomException(String message, HttpStatus httpStatus, Throwable thrwbl) {
        super(message, thrwbl);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getUrlReference() {
        return this.urlReference;
    }

    public String getCode() {
        return this.code;
    }

    public CustomException setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public CustomException setUrlReference(final String urlReference) {
        this.urlReference = urlReference;
        return this;
    }

    public CustomException setCode(final String code) {
        this.code = code;
        return this;
    }

    public String toString() {
        return "CustomException(httpStatus=" + this.getHttpStatus() + ", urlReference=" + this.getUrlReference() + ", code=" + this.getCode() + ")";
    }
}
