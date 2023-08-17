package utils;

import java.io.IOException;

import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class JenkinsJobTrigger {
	private static String JenkinsAuthenticationUserName = "dishant_doshi";
	private static String JenkinsAuthenticationPassword = "Abc.123";

	public static void JenkinsRemoteAPIBuild(String param1, String param2)
			throws AuthenticationException, ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(
				"http://10.10.180.82:8080/job/Test/build?token=11055515cde732b5b19bc9242b06d3e7be");
		UsernamePasswordCredentials creds = new UsernamePasswordCredentials(JenkinsAuthenticationUserName,
				JenkinsAuthenticationPassword);
		httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
		httpPost.addHeader("Content-type", "application/json");
		httpPost.addHeader("Accept", "application/json");
		System.out.println("posting: " + httpPost);
		CloseableHttpResponse response = client.execute(httpPost);
		System.out.println(response.toString());
		System.out.println((response.getStatusLine().getStatusCode()));
		System.out.println("Response: " + response);
		client.close();
	}

	public static void main(String[] args) throws AuthenticationException, ClientProtocolException, IOException {
		JenkinsRemoteAPIBuild("Alpha", "ARM");
	}
}
