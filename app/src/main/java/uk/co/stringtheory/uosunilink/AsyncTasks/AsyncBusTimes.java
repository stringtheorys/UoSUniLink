package uk.co.stringtheory.uosunilink.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

import uk.co.stringtheory.uosunilink.Core.BusStop;
import uk.co.stringtheory.uosunilink.Core.BusTime;
import uk.co.stringtheory.uosunilink.Core.Info;

public class AsyncBusTimes extends AsyncTask<String, Void, ArrayList<BusTime>> {

    private static final String TAG = "AsyncBusTimes";

    private static final String busTimesUrl = "https://xetrev.net/unilink/api/stop.php?stopId=";

    private BusTimesInterface busTimesInterface;

    public AsyncBusTimes(BusTimesInterface newBusTimesInterface) {
        busTimesInterface = newBusTimesInterface;
    }

    @Override
    protected ArrayList<BusTime> doInBackground(String... stopIds) {
        Log.d(TAG, "DoInBackground");
        ArrayList<BusTime> allBusTimes = new ArrayList<>();

        // Gets the bus stop name
        BusStop nameBusStop = Info.convertBusStopId(stopIds[0]);
        String stopName = nameBusStop.getName();

        // For each stopid then get the stop times JSON and parse
        for (String stopId : stopIds) {
            // Get the webpage JSON
            String webpageJSON = WebScrapper.getWebpageFromUrl(busTimesUrl + stopId);
            try {

                // Bus Time JSON
                JSONObject busTimesJSON = new JSONObject(webpageJSON);
                JSONArray busTimes = busTimesJSON.getJSONArray("Buses");

                // Create all of the bus times
                for (int busPos = 0; busPos < busTimes.length(); busPos++) {
                    BusTime busTime = new BusTime((JSONObject) busTimes.get(busPos), stopName, stopId);
                    allBusTimes.add(busTime);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return allBusTimes;
    }

    @Override
    protected void onPostExecute(ArrayList<BusTime> busTimes) {
        Log.d(TAG, "OnPostExecute");
        busTimesInterface.updateBusTimes(busTimes);
    }

    public interface BusTimesInterface {
        void updateBusTimes(ArrayList<BusTime> busTimes);
    }
}

