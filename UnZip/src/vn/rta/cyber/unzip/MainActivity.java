package vn.rta.cyber.unzip;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String path = Environment.getExternalStorageDirectory()+ "/testzip/";
		String zipName = "test.zip";
		boolean isUnzipSuccess= ZipUtils.unpackZip(path, "", zipName);
		Log.i("unzip test", "path + "+ path +" zipname + "+ zipName);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
