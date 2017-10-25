package uk.co.stringtheory.uosunilink.Core;

import org.json.JSONException;
import org.json.JSONObject;

public class Route {

    private String id;
    private String name;

    public Route(JSONObject routeJSON) throws JSONException {
        id = routeJSON.getString("RouteId");
        name = routeJSON.getString("RouteName");
    }
}
