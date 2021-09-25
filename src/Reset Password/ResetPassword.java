import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class ReadEmail 
{
    static String hostName ="imap.1and1.com";
    static  String username = "";
    static String password = "";
    static int messageCount;
    public static String url=null;
    public static String userid = null;
    public static String pass=null;

    //public static void showEmail()
    public static void main(String ar[])
    {
        Properties sysProps = System.getProperties();
        sysProps.setProperty("mail.store.protocol", "imap");

        try 
        {
                Session session = Session.getInstance(sysProps, null);      
                Store store = session.getStore();       
                store.connect(hostName, username, password);        
                Folder emailInbox = store.getFolder("INBOX");       
                emailInbox.open(Folder.READ_WRITE);     
                messageCount = emailInbox.getMessageCount();        
                System.out.println("Total Message Count: " + messageCount);     
                int unreadMsgCount = emailInbox.getNewMessageCount();       
                System.out.println("Unread Emails count:"+unreadMsgCount);
                Message emailMessage = emailInbox.getMessage(messageCount); 
                System.out.println("Email Subject: " + emailMessage.getSubject());  
                Multipart multipart = (Multipart) emailMessage.getContent();
                BodyPart part = multipart.getBodyPart(0);                   
                String responseMessage = part.getContent().toString();


                    System.out.println("================"+responseMessage);

                    // Get Email ID
                    Pattern p = Pattern.compile("EmailId:   (.+)");
                    Matcher m = p.matcher(responseMessage);             
                    if (m.find()) {
                        userid = m.group(1);
                    }
                    System.out.println(userid);



                    /*Get URL*/
                    Pattern p2 = Pattern.compile("http(.+)");
                    Matcher m2 = p2.matcher(responseMessage);

                    if (m2.find()) {
                        url = m2.group();  
                    }
                    System.out.println("URL  :="+ url);

                    /*Get password from email*/
                    Pattern p1 = Pattern.compile("Password:     (.*)");
                    Matcher m1 = p1.matcher(responseMessage);

                    if (m1.find()) {
                        pass = m1.group(1);  
                    }
                    System.out.println(pass);

                    /*System.out.println("Email Content: " + emailMessage.getContent().toString());

                    Pattern p = Pattern.compile("<td>Password:<.*?td>([^<]+)<td>(.+)<.*?td>");
                    Matcher m = p.matcher(responseMessage);

                    if (m.find()) {
                        password1 = m.group(1); // this variable should contain the link URL
                    }*/

                emailMessage.setFlag(Flags.Flag.SEEN, true);        
                emailInbox.close(true);
                store.close();          

        }
        catch (Exception mex) 
        {
            mex.printStackTrace();
        }
        //return new ReadEmail();


    }
}