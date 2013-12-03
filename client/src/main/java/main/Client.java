package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.SpringUtilities;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Client {
	private String userName;
		
	private List<NameValuePair> authenticationInfo(){
		List<NameValuePair> params = null;
		
		JPanel panel = new JPanel(new SpringLayout());
		
		JLabel userNameLabel = new JLabel("User Name:", JLabel.TRAILING);
		JTextField userName = new JTextField(10);
		userNameLabel.setLabelFor(userName);
		panel.add(userNameLabel);
		panel.add(userName);
		
		JLabel passwordLabel = new JLabel("Password:", JLabel.TRAILING);
		JPasswordField password = new JPasswordField(10);
		passwordLabel.setLabelFor(password);
		panel.add(passwordLabel);
		panel.add(password);
		
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(panel,
		                                2, 2, //rows, cols
		                                6, 6,        //initX, initY
		                                6, 6);       //xPad, yPad

		int option = JOptionPane.showOptionDialog(null, panel, "User information", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, null, JOptionPane.OK_OPTION);
		if(option == JOptionPane.OK_OPTION && !userName.getText().isEmpty() && !new String(password.getPassword()).isEmpty())
		{
			this.userName = userName.getText();
			
	        params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("userName", userName.getText()));
			params.add(new BasicNameValuePair("password", new String(password.getPassword())));
			System.out.println("userName: " + userName.getText());
			System.out.println("password: " + new String(password.getPassword()));
		}
		
		return params;
	}
	

	protected static String getContextAsString(HttpResponse response) throws IOException {

        StringWriter writer = new StringWriter();
        InputStream inputStream = response.getEntity().getContent();
        try {
            IOUtils.copy(inputStream, writer, "UTF-8");
        } finally {
            inputStream.close();
        }
        return writer.toString();
    }
	
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		Client client = new Client();
		
		// Authentication request
		HttpPost authentication = new HttpPost("http://localhost:8080/ReallySweetSadistic-services-0.1-SNAPSHOT/service/authentifier/authentication");
		
		List<NameValuePair> params = client.authenticationInfo();
		
		UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
		authentication.setEntity(encodedFormEntity);
        CloseableHttpResponse response = httpClient.execute(authentication);

        System.out.println(response);
        System.out.println(getContextAsString(response));
        
        params.clear();
        
        // Authentication request
 		HttpPost disconnection = new HttpPost("http://localhost:8080/ReallySweetSadistic-services-0.1-SNAPSHOT/service/authentifier/disconnection");
 		params.add(new BasicNameValuePair("userName", client.userName));
 		
 		encodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
		authentication.setEntity(encodedFormEntity);
        response = httpClient.execute(disconnection);

        System.out.println(response);
        System.out.println(getContextAsString(response));
        
        params.clear();
        
	}

}
