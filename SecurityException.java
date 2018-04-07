 /*Wes Eaton
Meagan Folmar
Adam Garibay*/

public class SecurityException extends Exception //creating subclass
{
  public SecurityException(String msg) //receiving String msg to use in super method
  {
    super(msg);

  }//end constructor

  public SecurityException(String msg, Throwable cause) //receiving String msg and Throwable clause to use in super method
  {
    super(msg, cause);

  }//end constructor

}//end public class SecurityException extends Exception
