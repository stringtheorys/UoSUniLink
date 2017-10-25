package uk.co.stringtheory.uosunilink.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

import uk.co.stringtheory.uosunilink.Core.BusTime;
import uk.co.stringtheory.uosunilink.UI.BookmarkBtn;

public class AsyncBookmarkTime extends AsyncTask<String, Void, Void> {

    private static final String TAG = "AsyncBookmarkTime";

    private BookmarkBtn bookmarkBtn;
    private ArrayList<BusTime> busTimes;

    public AsyncBookmarkTime(BookmarkBtn newBookmarkBtn) {
        bookmarkBtn = newBookmarkBtn;
    }

    @Override
    protected Void doInBackground(String... stopIds) {
        Log.d(TAG, "DoInBackground");

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.d(TAG, "OnPostExecute");

        bookmarkBtn.updateBusTimes(busTimes);
    }
}
