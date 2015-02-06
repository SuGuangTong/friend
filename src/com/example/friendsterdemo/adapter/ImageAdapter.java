package com.example.friendsterdemo.adapter;

import java.util.List;

import com.example.friendsterdemo.R;
import com.example.friendsterdemo.entity.Friend;
import com.example.friendsterdemo.entity.Users;
import com.example.friendsterdemo.util.LoadImage;
import com.example.friendsterdemo.util.LoadImage.Iloadimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	List<Users> Item;
	Context context;
	
	public ImageAdapter(List<Users> item, Context context) {
		super();
		Item = item;
		this.context = context;
	}

	@Override
	public int getCount() {
		return Item.size();
	}

	@Override
	public Object getItem(int position) {
		return Item.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressWarnings("static-access")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final Holder holder;
		if(convertView==null){
			
			convertView = LayoutInflater.from(context).inflate(R.layout.child, null);
			holder = new Holder();
			holder.iv = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		}else{
			holder = (Holder) convertView.getTag();
		}
		new LoadImage().getImage(Item.get(position).getAvatar(), new Iloadimage() {
			
			@Override
			public void load(String url, Bitmap bitmap) {
				
				holder.iv.setImageBitmap(bitmap);
			}
		});
		return convertView;
	}
	
	class Holder{
		ImageView iv;
	}

}
