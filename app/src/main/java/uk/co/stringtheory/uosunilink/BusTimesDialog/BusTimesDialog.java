package uk.co.stringtheory.uosunilink.BusTimesDialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import uk.co.stringtheory.uosunilink.AsyncTasks.AsyncBusTimes;
import uk.co.stringtheory.uosunilink.Core.BusTime;

public class BusTimesDialog extends Dialog implements AsyncBusTimes.BusTimesInterface {

    public BusTimesDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void updateBusTimes(ArrayList<BusTime> busTimes) {

    }
}
