package uk.co.stringtheory.uosunilink.Core;

import java.util.ArrayList;
import java.util.HashMap;

public class Info {

    // TODO say when each array code is done
    private static ArrayList<BusTime> currentBusTimes;
    private static ArrayList<BusStop> busstops;
    private static ArrayList<String> busStopNames;

    private static HashMap<String, BusStop> busStopIdConverter;
    private static HashMap<String, ArrayList<BusStop>> busStopNameConverter;
    private static HashMap<String, Route> routeIdConverter;

    public static ArrayList<BusTime> getCurrentBusTimes() {
        return currentBusTimes;
    }

    public static void setCurrentBusTimes(ArrayList<BusTime> currentBusTimes) {
        Info.currentBusTimes = currentBusTimes;
    }

    public static ArrayList<BusStop> getBusstops() {
        return busstops;
    }

    public static void setBusstops(ArrayList<BusStop> busstops) {
        Info.busstops = busstops;
    }

    public static ArrayList<String> getBusStopNames() {
        return busStopNames;
    }

    public static void setBusStopNames(ArrayList<String> busStopNames) {
        Info.busStopNames = busStopNames;
    }

    public static HashMap<String, BusStop> getBusStopIdConverter() {
        return busStopIdConverter;
    }

    public static void setBusStopIdConverter(HashMap<String, BusStop> busStopIdConverter) {
        Info.busStopIdConverter = busStopIdConverter;
    }

    public static HashMap<String, ArrayList<BusStop>> getBusStopNameConverter() {
        return busStopNameConverter;
    }

    public static void setBusStopNameConverter(HashMap<String, ArrayList<BusStop>> busStopNameConverter) {
        Info.busStopNameConverter = busStopNameConverter;
    }

    public static HashMap<String, Route> getRouteIdConverter() {
        return routeIdConverter;
    }

    public static void setRouteIdConverter(HashMap<String, Route> routeIdConverter) {
        Info.routeIdConverter = routeIdConverter;
    }

    public static BusStop convertBusStopId(String stopId) {
        if (busStopIdConverter == null) {
            return null;
        }
        return busStopIdConverter.get(stopId);
    }
}
