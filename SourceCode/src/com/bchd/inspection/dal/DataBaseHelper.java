package com.bchd.inspection.dal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 扩展现有类，以使用Assets下的现有类，而非运行时创建数据库
 * http://www.dasheyin.com/android_app_sqlite_preloaded.html
 * 
 * @author 王树坤
 * 
 */
public class DataBaseHelper extends SQLiteOpenHelper {

	// The Android’s default system path of your application database.
	private static String DB_PATH = "/data/data/com.bchd.inspection/databases/";

	//数据库名
	private static String DB_NAME = "Inspection.db";

	private SQLiteDatabase myDataBase;

	private final Context myContext;

	/**
	 * 
	 * Constructor
	 * 
	 * Takes and keeps a reference of the passed context in order to access to
	 * the application assets and resources.
	 * 
	 * @param context
	 */
	public DataBaseHelper(Context context) {

		super(context, DB_NAME, null, 1);

		this.myContext = context;

	}

	/**
	 * 
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * 
	 * */
	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();

		if (dbExist) {

			// do nothing – database already exist

		} else {

			// By calling this method and empty database will be created into
			// the default system path of your application so we are gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();

			try {

				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");

			}

		}

	}

	/**
	 * 
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn’t
	 */

	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {

			String myPath = DB_PATH + DB_NAME;

			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does’t exist yet.

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;

	}

	/**
	 * 
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the
	 * 
	 * system folder, from where it can be accessed and handled.
	 * 
	 * This is done by transfering bytestream.
	 * 
	 * */

	private void copyDataBase() throws IOException {

		// Open your local db as the input stream

		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db

		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream

		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile

		byte[] buffer = new byte[1024];

		int length;

		while ((length = myInput.read(buffer)) > 0) {

			myOutput.write(buffer, 0, length);

		}

		// Close the streams

		myOutput.flush();

		myOutput.close();

		myInput.close();

	}

	public void openDataBase() throws SQLException {

		// Open the database

		String myPath = DB_PATH + DB_NAME;

		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);

	}

	@Override
	public synchronized void close() {

		if (myDataBase != null)

			myDataBase.close();

		super.close();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
