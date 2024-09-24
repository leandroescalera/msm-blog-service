package bo.com.bancobisa.msm.blog.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CommonResponse {
    default ResponseEntity notFound() {
        return this.response(HttpStatus.NOT_FOUND);
    }

    default <R> ResponseEntity<R> notFound(R r) {
        return this.response(HttpStatus.NOT_FOUND, r);
    }

    default ResponseEntity conflict() {
        return this.response(HttpStatus.CONFLICT);
    }

    default <R> ResponseEntity<R> conflict(R r) {
        return this.response(HttpStatus.CONFLICT, r);
    }

    default ResponseEntity badRequest() {
        return this.response(HttpStatus.BAD_REQUEST);
    }

    default <R> ResponseEntity<R> badRequest(R response) {
        return this.response(HttpStatus.BAD_REQUEST, response);
    }

    default <R> ResponseEntity<R> ok(R response) {
        return this.response(HttpStatus.OK, response);
    }

    default <R> ResponseEntity<R> error(R response) {
        return this.response(HttpStatus.INTERNAL_SERVER_ERROR, response);
    }

    default ResponseEntity response(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).build();
    }

    default <R> ResponseEntity<R> response(HttpStatus httpStatus, R response) {
        return ResponseEntity.status(httpStatus).body(response);
    }
}
