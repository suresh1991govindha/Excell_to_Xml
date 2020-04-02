package Utils_Manager;


import java.util.Date;
import java.sql.Timestamp;
 
public class GetTime
{
   
	public static Timestamp getCurrentTime()
    {
 
 Date date= new Date();
 
 long time = date.getTime();
 Timestamp ts = new Timestamp(time);
 
return ts;
    }
}