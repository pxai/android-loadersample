package io.pello.android.androidloaderssample;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements
        LoaderManager.LoaderCallbacks<Cursor> {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        getLoaderManager().initLoader(0, null, this);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                Uri.parse("content://io.pello.android.androidloaderssample.provider.Students")
                , new String[]{"name","description"}, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        cursor.moveToFirst();
        String text = (String) textView.getText();
        while (!cursor.isAfterLast()) {
            text += "\n" + cursor.getString(0) + ": " + cursor.getString(1);
            cursor.moveToNext();
        }
        textView.setText(text);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        Log.d("PELLODEBUG", "On Loader Reset");
    }

    /**
     * opens the other activity
     * @param view
     */
    public void openActivitySQL (View view) {
        Intent intent = new Intent(this, SQLLoaderMainActivity.class);
        startActivity(intent);
    }
}
