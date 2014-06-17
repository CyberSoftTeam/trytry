package vn.rta.cyber.unzip;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.util.Log;

public class ZipUtils {
	private static String TAG="ZipUtils";
	/**
	 * unzip file
	 * the original file will be storage in @path
	 * you can copy file go to ODK folder then delete file in @path
	 * @param path
	 * @param zipname
	 * @return
	 */
	public static boolean unpackZip(String sourcePath, String destinationPath, String zipname)
	{       

		if(destinationPath.equals("")){
			destinationPath=sourcePath;
		}
		InputStream is;
		ZipInputStream zis;
		try 
		{
			is = new FileInputStream(sourcePath + zipname);
			zis = new ZipInputStream(new BufferedInputStream(is));          
			ZipEntry ze;

			while((ze = zis.getNextEntry()) != null) 
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int count;

				String filename = ze.getName();
				Log.i(TAG, "zip name" + filename);
				String pathDirectory = destinationPath + filename;
				
				
				if (ze.isDirectory()) {
					Log.i(TAG, pathDirectory +"is folder");
					File unzipFile = new File(pathDirectory);
					unzipFile.mkdirs();
				} 
				else {
					FileOutputStream fout = new FileOutputStream(destinationPath + filename);
					// reading and writing
					while((count = zis.read(buffer)) != -1) 
					{
						baos.write(buffer, 0, count);
						byte[] bytes = baos.toByteArray();
						fout.write(bytes);             
						baos.reset();
					}
					fout.close();
				}
				zis.closeEntry();
			}

			zis.close();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
