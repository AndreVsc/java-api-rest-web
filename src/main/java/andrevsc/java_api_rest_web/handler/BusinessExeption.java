package andrevsc.java_api_rest_web.handler;

public class BusinessExeption  extends RuntimeException {
    public BusinessExeption(String message) {
        super(message);
    }

    public BusinessExeption(String message, Object ... Params) {
        super(String.format(message, Params));
    }
}