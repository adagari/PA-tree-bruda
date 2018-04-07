/*Wes Eaton
Meagan Folmar
Adam Garibay*/

public class CustomerException extends Exception
{
 public CustomerException(String msg)
 {
   super(msg);

 }//end constructor
 
 public CustomerException(String msg, Throwable cause)
 {
   super(msg, cause);

 }//end constructor

}//end public class CustomerException extends Exception
