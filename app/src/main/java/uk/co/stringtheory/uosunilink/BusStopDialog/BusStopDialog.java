package uk.co.stringtheory.uosunilink.BusStopDialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import uk.co.stringtheory.uosunilink.AsyncTasks.AsyncBusStops;

public class BusStopDialog extends Dialog implements AsyncBusStops.BusStopInterface {

    public BusStopDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void updateBusSearchDialog() {

    }
}
