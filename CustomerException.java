public class CustomerException extends Exception{
 
 public CustomerException(String msg){
  super(msg);
 }
 
 public CustomerException(String msg, Throwable cause){
  super(msg, cause);
 }
}
