package com.example.PryParseoJSON;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private JSONObject jsonObject=null;
    private TextView textView;

    private String stringParseValue = null;
    private String strJSONValue = "{  \"FirstObject\":{\n" +
            "        \"attr1\":\"one value\",\n" +
            "        \"attr2\":\"two value\",\n" +
            "        \"sub\":{\n" +
            "            \"sub1\":[\n" +
            "                {\n" +
            "                    \"sub1_attr\":\"syb1_attr_value\"\n" +
            "                },{\n" +
            "                    \"sub2_attr\":\"syb2_attr_value\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView)findViewById(R.id.idTextViewDato);
        parseJSON();
    }

    public void parseJSON(){
        Toast.makeText(getApplicationContext(),"Entro a parsear",Toast.LENGTH_SHORT).show();
        try {
            jsonObject = new JSONObject(strJSONValue);
            JSONObject object = jsonObject.getJSONObject("FirstObject");
            String attr1 = object.getString("attr1");
            String attr2 = object.getString("attr2");

            stringParseValue = "Valor de attr1  = " + attr1;
            stringParseValue += "\nValor de attr2  = " + attr2;

            JSONObject subObject = object.getJSONObject("sub");
            JSONArray subArray = subObject.getJSONArray("sub1");

            stringParseValue += "\nLongitud del Array es" + subArray.length();
            textView.setText(stringParseValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    /*
 {  "FirstObject":{
        "attr1":"one value",
        "attr2":"two value",
        "sub":{
            "sub1":[
                {
                    "sub1_attr":"syb1_attr_value"
                },{
                    "sub2_attr":"syb2_attr_value"
                }
            ]
        }
    }
}
    */
}
