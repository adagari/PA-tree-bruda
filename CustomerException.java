public class CustomerException extends Exception{
 
 public CustomerExeption(String msg){
  super(msg);
 }
 
 public CustomerException(String msg, Throwable cause){
  super(msg, cause);
 }
}
