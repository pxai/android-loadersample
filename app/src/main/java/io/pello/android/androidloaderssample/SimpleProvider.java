package io.pello.android.androidloaderssample;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

/**
 * Created by PELLO_ALTADILL on 13/12/2016.
 * Simple provider with just one query
 */
public class SimpleProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        Log.i("PELLODEBUG", "onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
            MatrixCursor mCursor = new MatrixCursor(new String[] {"_id","name","description"});
        mCursor.addRow(new Object[] {2,"The End Ika","The Ghost Student"});
        mCursor.addRow(new Object[] {1,"D. Larris","The Night Stalker"});
        mCursor.addRow(new Object[] {4,"Raúl","The one man army"});
        mCursor.addRow(new Object[] {3,"D. Dandola","The killer machine"});
            Log.i("PELLODEBUG","returning " + mCursor);
            return mCursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
