package com.example.duliri;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {
	private SwipeMenuListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	public void init() {
		list = (SwipeMenuListView) findViewById(R.id.listview);
		appadpter app = new appadpter(this);
		list.setAdapter(app);

		SwipeMenuCreator creator = new SwipeMenuCreator() {

			@Override
			public void create(SwipeMenu menu) {
				SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
				// set item background
				openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
				// set item width
				openItem.setWidth(100);
				// set item title
				openItem.setTitle("Open");
				// set item title fontsize
				openItem.setTitleSize(18);
				// set item title font color
				openItem.setTitleColor(Color.WHITE);
				// add to menu
				menu.addMenuItem(openItem);

				// create "delete" item
				SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
				// set item background
				deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
				// set item width
				deleteItem.setWidth(100);
				// set a icon
				deleteItem.setIcon(R.drawable.ic_delete);
				// add to menu
				menu.addMenuItem(deleteItem);
			}
		};

		list.setMenuCreator(creator);
	}

}

class appadpter extends BaseAdapter {
	Context con;

	public appadpter(Context con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = View.inflate(con, R.layout.item, null);
			new ViewHolder(convertView);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		// ApplicationInfo item = getItem(position);
		// holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
		// holder.tv_name.setText(item.loadLabel(getPackageManager()));
		return convertView;
	}

	class ViewHolder {
		TextView iv_icon;
		TextView tv_name;

		public ViewHolder(View view) {
			iv_icon = (TextView) view.findViewById(R.id.textView1);
			tv_name = (TextView) view.findViewById(R.id.textView2);
			view.setTag(this);
		}
	}

}
