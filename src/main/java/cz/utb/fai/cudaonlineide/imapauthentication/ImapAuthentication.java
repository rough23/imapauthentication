package cz.utb.fai.cudaonlineide.imapauthentication;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * ImapAuthentication class provides method for user authentication.
 * 
 * @author Belanec
 * 
 */
public class ImapAuthentication {

	/**
	 * Method test if user is able to login.
	 * 
	 * @param username User name.
	 * @param password User password.
	 * @return True if user is able to login.
	 */
	public boolean isUserToLog(String username, String password) {
		
		try {
			
			System.out.println("ImapAuthentication LOG [Authentication for " + username + "]");
			
			Properties props = System.getProperties();
			props.setProperty(ImapAuthenticationConstants.PROPERTY_PROTOCOL, ImapAuthenticationConstants.PROTOCOL_IMAPS);

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore();

			store.connect(ImapAuthenticationConstants.HOST, username, password);
			
			return true;
            
		} catch (MessagingException e) {
			Logger.getLogger(ImapAuthentication.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}
}
