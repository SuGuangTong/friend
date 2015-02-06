package com.example.friendsterdemo.adapter;

import java.util.List;

import com.example.friendsterdemo.R;
import com.example.friendsterdemo.entity.Friend;
import com.example.friendsterdemo.entity.Users;
import com.example.friendsterdemo.util.LoadImage;
import com.example.friendsterdemo.util.LoadImage.Iloadimage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendAdapter extends BaseAdapter {

	List<Friend> Item;
	Context context;
	
	public FriendAdapter(List<Friend> item, Context context) {
		super();
		Item = item;
		this.context = context;
	}

	@Override
	public int getCount() {
		return Item.size()
				;
	}

	@Override
	public Object getItem(int position) {
		return Item.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class Holder{
		ImageView iv;
		Button comment;
		GridView gv;
		TextView content,username,time;
	}
	@SuppressWarnings("static-access")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Holder holder;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
			holder = new Holder();
			holder.username = (TextView) convertView.findViewById(R.id.username);
			holder.iv = (ImageView) convertView.findViewById(R.id.iv);
			holder.gv = (GridView) convertView.findViewById(R.id.gv);
			holder.time = (TextView) convertView.findViewById(R.id.time);
			holder.comment = (Button) convertView.findViewById(R.id.comment);
			holder.content = (TextView) convertView.findViewById(R.id.content);
			convertView.setTag(holder);
		} else{
			holder = (Holder) convertView.getTag();
			}
		LoadImage loadImage = new LoadImage();

		holder.username.setText(Item.get(position).getAuthor().getUsername());
		loadImage.getImage(Item.get(position).getAuthor().getAvatar(), new Iloadimage() {
			
			@Override
			public void load(String url, Bitmap bitmap) {
				
				holder.iv.setImageBitmap(bitmap);
				
			}
		});
		holder.content.setText(Item.get(position).getContent());
		List<Users> list = Item.get(position).getList();
		if(list!=null){
			if(list.size()<1){
				holder.gv.setVisibility(View.GONE);
			}else if(list.size() == 1){
				holder.gv.setNumColumns(1);
			}else if(list.size() == 2){
				holder.gv.setNumColumns(2);
			}else if(list.size() >2){
				holder.gv.setNumColumns(3);
			}
		}
		ImageAdapter adapter = new ImageAdapter(list, context);
		holder.gv.setAdapter(adapter);
		holder.time.setText(Item.get(position).getCreated_at());
		holder.comment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				View view = LayoutInflater.from(context).inflate(R.layout.anim, null);
				
			}
		});
		return convertView;
	}

}
