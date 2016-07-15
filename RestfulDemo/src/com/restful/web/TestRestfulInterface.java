package com.restful.web;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import net.sf.json.JSONObject;

public class TestRestfulInterface {
	public static void main(String[] arg){
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username", "zhangbo");
		jsonObj.put("age", 12);
		HttpPost httpPost = new HttpPost("http://localhost:8080/popd/requirement/submit");
		StringEntity entity = new StringEntity(jsonObj.toString(), HTTP.UTF_8);
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
