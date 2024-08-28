package andrevsc.java_api_rest_web.handler;

import java.util.Date; 

public class ResponseError {
    private Date timestamp = new Date();
    private String status = "Internal Server Error";
    private Integer statusCode = 500;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }


    public String getStatus() {
        return status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "timestamp=" + timestamp +
                ", status='" + status + '\'' +
                ", statusCode=" + statusCode +
                ", error='" + error + '\'' +
                '}';
    }
}
