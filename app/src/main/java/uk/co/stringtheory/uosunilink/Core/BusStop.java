package uk.co.stringtheory.uosunilink.Core;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusStop {

    private String name;
    private String id;
    private double lng;
    private double lat;
    private String[] routes;

    public BusStop(JSONObject busJSON) throws JSONException {
        name = busJSON.getString("StopName");
        id = busJSON.getString("StopId");
        lng = Double.parseDouble(busJSON.getString("Lng"));
        lat = Double.parseDouble(busJSON.getString("Lat"));
        JSONArray routeJSON = busJSON.getJSONArray("Routes");
        routes = new String[routeJSON.length()];
        for (int routePos = 0; routePos < routeJSON.length(); routePos++) {
            routes[routePos] = (String) routeJSON.get(routePos);
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public String[] getRoutes() {
        return routes;
    }
}
