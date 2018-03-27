public class SecurityException extends Exception{

  public SecurityException(String msg){
  super(msg);
  }

  public SecurityException(String msg, Throwable cause){
  super(msg, cause);
  }
}
