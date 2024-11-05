package bo.com.example.msm.blog.api;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BaseResponse<T> implements Serializable {
    static final long serialVersionUID = 1L;
    private String transactionId = UUID.randomUUID().toString();
    private T result;
    private Date timestamp = new Date();

    public BaseResponse() {
    }

    public String toString() {
        return "BaseResponse{transactionId=" + this.transactionId + ", result=" + this.result + ", timestamp=" + this.timestamp + '}';
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public T getResult() {
        return this.result;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public BaseResponse<T> setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public BaseResponse<T> setResult(final T result) {
        this.result = result;
        return this;
    }

    public BaseResponse<T> setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
