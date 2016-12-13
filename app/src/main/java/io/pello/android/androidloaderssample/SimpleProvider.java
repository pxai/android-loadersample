package io.pello.android.androidloaderssample;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

/**
 * Created by PELLO_ALTADILL on 13/12/2016.
 */
public class SimpleProvider extends ContentProvider {


    @Override
    public boolean onCreate() {
        Log.i("PELLODEBUG", "onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
            MatrixCursor cursor = new MatrixCursor(new String[]{"_id","col1"});
            for(String name : new String[]{"poodle","labrador","german shephard","boston terrier","hound"}){
                cursor.addRow(new Object[]{0,name});
            }
            Log.i("PELLODEBUG","returning " + cursor);
            return cursor;
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
