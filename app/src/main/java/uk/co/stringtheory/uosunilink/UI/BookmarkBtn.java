package uk.co.stringtheory.uosunilink.UI;

import android.content.Context;
import android.widget.Button;

import java.util.ArrayList;

import uk.co.stringtheory.uosunilink.AsyncTasks.AsyncBookmarkTime;
import uk.co.stringtheory.uosunilink.Core.BusTime;

public class BookmarkBtn extends Button {

    private String[] stopIds;
    private String stopName;
    private ArrayList<BusTime> busTimes;

    public BookmarkBtn(Context context, String newStopName, String[] newStopIds) {
        super(context);

        stopName = newStopName;
        stopIds = newStopIds;

        new AsyncBookmarkTime(this).execute(stopIds);
    }

    public void updateBusTimes(ArrayList<BusTime> busTimes) {

    }
}
