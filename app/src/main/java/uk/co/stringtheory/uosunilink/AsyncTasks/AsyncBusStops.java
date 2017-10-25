package uk.co.stringtheory.uosunilink.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import uk.co.stringtheory.uosunilink.Core.BusStop;
import uk.co.stringtheory.uosunilink.Core.Info;

public class AsyncBusStops extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "AsyncBusStops";

    private String busStopsUrl = "https://xetrev.net/unilink/api/stops.php?withroutes";

    private BusStopInterface busStopsInterface;

    private ArrayList<BusStop> busStops;        // Bus Stops
    private HashSet<String> busStopNames;       // Bus Stop Names
    private HashMap<String, ArrayList<BusStop>> busStopNameConverter;
    private HashMap<String, BusStop> busStopIdConverter;

    public AsyncBusStops(BusStopInterface newBusStopInterface) {
        busStopsInterface = newBusStopInterface;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.d(TAG, "DoInBackground");

        // Init all attributes
        busStops = new ArrayList<>();
        busStopNames = new HashSet<>();
        busStopNameConverter = new HashMap<>();
        busStopIdConverter = new HashMap<>();

        String busStopWebpage = WebScrapper.getWebpageFromUrl(busStopsUrl);
        try {
            JSONObject busStopJSON = new JSONObject(busStopWebpage);
            JSONArray stopsJSON = busStopJSON.getJSONArray("Stops");
            for (int stopPos = 0; stopPos < stopsJSON.length(); stopPos++) {
                BusStop busStop = new BusStop((JSONObject) stopsJSON.get(stopPos));

                // Adds the bus stop to general list
                busStops.add(busStop);

                // Adds the bus stop name to the name list
                busStopNames.add(busStop.getName());

                // Adds the bus stop name to the bus stop name converter
                ArrayList<BusStop> stopNames = busStopNameConverter.get(busStop.getName());
                if (stopNames == null) {
                    // If null then doesnt exist yet and add to the converter
                    ArrayList<BusStop> newBusNameStops = new ArrayList<>();
                    newBusNameStops.add(busStop);
                    busStopNameConverter.put(busStop.getName(), newBusNameStops);
                } else {
                    // If does exist then add to the arraylist the new bus stop of the same name
                    stopNames.add(busStop);
                }

                // Adds the bus stop id to the bus stop id converter
                busStopIdConverter.put(busStop.getId(), busStop);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d(TAG, "OnPostExecute");

        // Update the bus stop names
        ArrayList<String> newBusStopNames = new ArrayList<>(busStopNames);
        Info.setBusStopNames(newBusStopNames);

        // Update the bus stops
        Info.setBusstops(busStops);

        // Update the bus stop id converter
        Info.setBusStopIdConverter(busStopIdConverter);

        // Update the bus stop name converter
        Info.setBusStopNameConverter(busStopNameConverter);

        busStopsInterface.updateBusSearchDialog();
    }

    public interface BusStopInterface {
        void updateBusSearchDialog();
    }
}
