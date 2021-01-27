package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class JsonRead {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        /*try{
            //init reader
            Reader reader = new FileReader("resource/test.json");
            //parse our json
            JSONObject object = (JSONObject) parser.parse(reader);
            //main has another object
            JSONObject tempIn = (JSONObject) object.get("main");
            //object in object main
            double temperature = (double) tempIn.get("temp");
            System.out.println("Actual temperature: " + (Math.round((temperature - 273.15) * 100)/100.0) + "°C");
            long pressure = (long) tempIn.get("pressure");
            System.out.println("Pressure: " + Math.round(pressure*100)/100.0 + "hPa");
            //not in main
            long visibility = (long) object.get("visibility");
            System.out.println("Visibility: " + visibility + "m");
            long humidity = (long) tempIn.get("humidity");
            System.out.println("Humidity: " + humidity + "%");
            //system object
            JSONObject sys = (JSONObject) object.get("sys");
            long sunrise = (long) sys.get("sunrise")*1000;
            long sunset = (long) sys.get("sunset")*1000;
            DateFormat sun = new SimpleDateFormat("HH:mm");
            System.out.println("Sunrise at " + sun.format(new Date(sunrise)));
            System.out.println("Sunset at " + sun.format(new Date(sunset)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }*/
        try {
            Reader reader = new FileReader("resource/another.json");
            JSONObject object = (JSONObject) parser.parse(reader);
            JSONArray data = (JSONArray) object.get("data");
            for (int i = 0; i < data.size(); i++){
                JSONObject temp = (JSONObject) data.get(i);
                String city = (String) temp.get("city");
                System.out.println("City: " + city);
                String region = (String) temp.get("region");
                System.out.println("Region: " + region);
                String wikiDataID = (String) temp.get("wikiDataId");
                System.out.println("Wiki Data: " + wikiDataID);
                double latitude = (double) temp.get("latitude");
                double longitude = (double) temp.get("longitude");
                System.out.println("Latitude : " + latitude + "\n" + "Longitude: " + longitude);
                System.out.println("-----------------------------------------");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
