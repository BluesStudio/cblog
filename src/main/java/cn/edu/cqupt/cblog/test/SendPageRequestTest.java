package cn.edu.cqupt.cblog.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class SendPageRequestTest {

	public static void main(String[] args) {
		getArticlePage();

	}
	public static void getArticlePage(){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> formParams=new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("clazzId", "1"));
		UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(formParams, Consts.UTF_8);
		HttpPost httpPost = new HttpPost("http://localhost:8080/cblog/albums/list");
		httpPost.addHeader("Accept", "application/json");
		httpPost.setEntity(formEntity);
		
		CloseableHttpResponse response=null;
		InputStream instream=null;
		try {
			response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				instream = entity.getContent();
				byte[] b = new byte[200];
				int len = -1;
				StringBuilder strBuilder = new StringBuilder();
				while ((len = instream.read(b)) > 0) {
					strBuilder.append(new String(b, 0, len));
				}
				System.out.println(strBuilder.toString());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(instream!=null){
				try {
					instream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(response!=null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(httpclient!=null){
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
