package com.soontm.kilroy.persistence;


import com.soontm.kilroy.domain.TextItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Florian on 05.09.2015.
 */
public class JSONtoObjectConverter  {
    private static final String TITLE ="title";
    private static final String CONTENT ="content";
    private String JSONResponse;
    private ArrayList<TextItem> textItems = new ArrayList<TextItem>();
public JSONtoObjectConverter(String JSONResponse){
    this.JSONResponse = JSONResponse;
try
{
    JSONArray jsonArray = new JSONArray(JSONResponse);

    for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject jsonObject= jsonArray.getJSONObject(i);
        TextItem textItem=itemMaker(jsonObject);
        textItems.add(textItem);
    }
}catch (JSONException e){
e.printStackTrace();}
}


public TextItem itemMaker(JSONObject jsonObject) {
    try {
        String title = jsonObject.getString(TITLE);
        String content = jsonObject.getString(CONTENT);
    } catch (JSONException e) {
    }return null;
}
}
