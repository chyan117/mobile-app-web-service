package springframework.mobile.app.mobileappws.exception;



//Custom Exception
public class UserServiceException extends RuntimeException{

    private static final long serialVersionId= 4332414;

    public UserServiceException(String message) {
        super(message);
    }
}
