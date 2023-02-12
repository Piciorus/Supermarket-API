package application.Exception;


public class CustomException extends Exception{
    public Integer status;

    public CustomException(Integer status, String message) {
        super(message);
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

