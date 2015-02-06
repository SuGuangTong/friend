package com.example.friendsterdemo;

import java.io.InputStream;
import java.util.List;

import com.example.friendsterdemo.adapter.FriendAdapter;
import com.example.friendsterdemo.entity.Friend;
import com.example.friendsterdemo.util.Tools;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private PopupWindow window;
	private Context context;
	private ListView lv;
	private TextView camera,photo,pictrue;
	private ImageView iv,quit;
	private FriendAdapter adapter;
	private List<Friend> list;
	private static final String url = "http://www.yasite.net/rss.php"; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		camera.setOnClickListener(this);
		photo.setOnClickListener(this);
		pictrue.setOnClickListener(this);
		new Thread(){
			public void run() {
				InputStream stream = Tools.getStream(url);
				String str = Tools.read(stream);
				list = Tools.parser(str);
				Message message = new Message();
				message.obj = list;
				handler.sendMessage(message);
			};
		}.start();
		
	}
	
	private void initView() {
		
		context = this;
		View view = getLayoutInflater().inflate(R.layout.head, null);
		View popupwindow = getLayoutInflater().inflate(R.layout.popwindow, null);
		window = new PopupWindow(popupwindow, 100, 100, true);
		photo = (TextView) popupwindow.findViewById(R.id.photo);
		pictrue = (TextView) popupwindow.findViewById(R.id.picture);
		lv = (ListView) findViewById(R.id.lv);
		lv.addHeaderView(view);
		camera = (TextView) findViewById(R.id.camera);
		iv = (ImageView) findViewById(R.id.IV);
		quit = (ImageView) findViewById(R.id.quit);
	}

	Handler handler = new Handler(){
		
		@SuppressWarnings("unchecked")
		public void handleMessage(android.os.Message msg) {
			
			list = (List<Friend>) msg.obj;
			adapter = new FriendAdapter(list, context);
			lv.setAdapter(adapter);
		};
	};
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.camera:
			
			window.showAsDropDown(v);
			break;
		case R.id.photo:
					
			break;
		case R.id.picture:
			
			Intent intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			startActivityForResult(intent, 1);
			break;
		case R.id.quit:
			finish();
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
			if(requestCode==1){
				String sdState=Environment.getExternalStorageState();
				   if(!sdState.equals(Environment.MEDIA_MOUNTED)){
				    Log.e("<<<<<<<<<<<<<<<", "sd card unmount");
				    return;
				   }
				   try {
					Uri uri = data.getData();
					   String[] pojo = { MediaStore.Images.Media.DATA };

					     Cursor cursor = getContentResolver().query(uri, pojo, null, null, null);
					         ContentResolver cr = this.getContentResolver();
					         int colunm_index = cursor
					                 .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
					         cursor.moveToFirst();
					         String path = cursor.getString(colunm_index);
					    
					         if (path.endsWith("jpg") || path.endsWith("png")) {
					             Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
					             iv.setImageBitmap(bitmap);
					         }else{
					        	 Toast.makeText(context, "您选择的不是有效图片", 0).show();
					         }
				} catch (Exception e) {
					e.printStackTrace();
				} 
	       }
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

