package bo.com.example.msas.blog.config;

/**
 * @author leandro.escalera
 */
public class BlogException extends Exception{
  private final String errcode;

  public BlogException(String message) {
    this(BlogConstants.ERR_GENERIC, message);
  }

  public BlogException(String errCode, String message) {
    super(String.format("%s: %s", errCode, message));
    this.errcode = errCode;
  }

  public String getErrCode() {
    return errcode;
  }

}
