package co.example.endangeredspecies;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	Integer[] Animals = { R.drawable.elephant, R.drawable.gorilla,
			R.drawable.leopard, R.drawable.monkey, R.drawable.panda,
			R.drawable.redpanda };

	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Gallery glrMain = (Gallery) findViewById(R.id.glrMain);
		imageView = (ImageView) findViewById(R.id.imgAnimal);

		glrMain.setAdapter(new ImageAdapter(this));

		OnItemClickListener listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long row) {
				Toast.makeText(
						getBaseContext(),
						"You have selected picture " + (position + 1)
								+ " of the endanged species",
						Toast.LENGTH_SHORT).show();
				imageView.setImageResource(Animals[position]);
			}

		};

		glrMain.setOnItemClickListener(listener);
	}

	public class ImageAdapter extends BaseAdapter {
		
		private Context context;
		
		public ImageAdapter(Context c) {
			context = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Animals.length;
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
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ImageView pic = new ImageView(context);
			pic.setImageResource(Animals[arg0]);
			pic.setScaleType(ImageView.ScaleType.FIT_XY);
			pic.setLayoutParams(new Gallery.LayoutParams(200, 175));
			return pic;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
