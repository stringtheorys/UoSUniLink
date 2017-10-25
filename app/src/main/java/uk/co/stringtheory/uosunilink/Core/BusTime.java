package uk.co.stringtheory.uosunilink.Core;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BusTime {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    private static final TimeUnit minutes = TimeUnit.MINUTES;
    private static final TimeUnit milliseconds = TimeUnit.MILLISECONDS;

    private Date arrivalTime;
    private String dueTime;
    private String destination;
    private String service;
    private String stopName;
    private String stopId;

    public BusTime(JSONObject stopJSON, String newStopName, String newStopId) throws JSONException, ParseException {
        stopName = newStopName;
        stopId = newStopId;

        service = stopJSON.getString("Service");
        destination = stopJSON.getString("Destination");

        arrivalTime = dateFormat.parse(stopJSON.getString("TimeArrival"));

        Date currentTime = Calendar.getInstance().getTime();
        long time = arrivalTime.getTime() - currentTime.getTime();

        dueTime = Long.toString(milliseconds.convert(time, minutes));
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getDueTime() {
        return dueTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getService() {
        return service;
    }

    public String getStopName() {
        return stopName;
    }

    public String getStopId() {
        return stopId;
    }
}
