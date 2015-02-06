package com.example.friendsterdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.friendsterdemo.entity.Attachments;
import com.example.friendsterdemo.entity.Author;
import com.example.friendsterdemo.entity.Friend;
import com.example.friendsterdemo.entity.Users;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Tools {

	public static InputStream getStream(String url){
		
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setReadTimeout(5000);
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if(conn.getResponseCode()==200){
				return conn.getInputStream();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static String read(InputStream stream){
		
		StringBuffer sb = new StringBuffer();
		byte[] buffer = new byte[1024*4];
		int len = 0;
		try {
			while((len = stream.read(buffer))>0){
				sb.append(new String(buffer, 0,len));
			}
			stream.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Bitmap getBitmap(InputStream stream){
		
		Bitmap bitmap = BitmapFactory.decodeStream(stream);
		return bitmap;
	} 
	
	public static List<Friend> parser(String str){
		
		List<Friend> list = new ArrayList<Friend>();
		try {
			JSONObject jsonObject = new JSONObject(str);
			String total = jsonObject.getInt("total")+"";
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = (JSONObject) jsonArray.get(i);
				
				Friend friend = new Friend();
				friend.setTotal(total);
				friend.setContent(object.getString("content"));
				friend.setCreated_at(object.getString("created_at"));
				friend.setTotal_replies(object.getInt("total_replies")+"");
				friend.setVisits(object.getInt("visits")+"");
				
				Author author = new Author();
				JSONObject obj = object.getJSONObject("author");
				author.setUsername(obj.getString("username"));
				author.setAvatar(obj.getString("avatar"));
				friend.setAuthor(author);
				
				JSONObject obj1 = object.getJSONObject("group");
				friend.setTitle(obj1.getString("title"));
				JSONArray array = object.getJSONArray("attachments");
				for (int j = 0; j < array.length(); j++) {
					
					JSONObject jsonObject2 = (JSONObject) array.get(j);
					Attachments attachments = new Attachments();
					attachments.setUrl(jsonObject2.getString("url"));
					attachments.setThumb(jsonObject2.getString("thumb"));
					friend.setAttachments(attachments);
				}
				
				List<Users> users = new ArrayList<Users>();
				JSONArray jsonArray2 = object.getJSONArray("last_up_users");
				for (int j = 0; j < jsonArray2.length(); j++) {
					
					JSONObject object2 = (JSONObject) jsonArray2.get(j);
					Users user = new Users();
					int id = object2.getInt("id");
					user.setUsername(object2.getString("username"));
					user.setAvatar(object2.getString("avatar"));
					users.add(user);
				}
				friend.setList(users);
				list.add(friend);
			}
			return list;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
