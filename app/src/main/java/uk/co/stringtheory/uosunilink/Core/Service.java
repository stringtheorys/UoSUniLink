package uk.co.stringtheory.uosunilink.Core;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// TODO add service image gif
public class Service {

    private String name;
    private String id;
    private Route[] routes;
    private String description;

    public Service(JSONObject serviceJSON) throws JSONException {
        name = serviceJSON.getString("ServiceName");
        id = serviceJSON.getString("ServiceId");
        description = serviceJSON.getString("ServiceDesciption");
        JSONArray routesJSON = serviceJSON.getJSONArray("Routes");
        routes = new Route[routesJSON.length()];
        for (int routePos = 0; routePos < routesJSON.length(); routePos++) {
            routes[routePos] = new Route((JSONObject) routesJSON.get(routePos));
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public String getDescription() {
        return description;
    }
}
