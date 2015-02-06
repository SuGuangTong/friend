package com.example.friendsterdemo.util;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

public class LoadImage {

	public static void getImage(final String url,final Iloadimage iloadimage){
		
		final Handler handler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				iloadimage.load(url, (Bitmap) msg.obj);
			};
		};
		
		new Thread(){
			public void run() {
				InputStream stream = Tools.getStream(url);
				Bitmap bitmap = Tools.getBitmap(stream);
				Message message = new Message();
				message.obj = bitmap;
				handler.sendMessage(message);
			};
		}.start();
	}
	public interface Iloadimage{
		void load(String url,Bitmap bitmap);
	}
}
