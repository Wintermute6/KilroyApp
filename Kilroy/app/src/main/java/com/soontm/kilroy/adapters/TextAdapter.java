package com.soontm.kilroy.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.soontm.kilroy.R;
import com.soontm.kilroy.domain.TextItem;

import java.util.ArrayList;



/**
 * Created by Florian on 25.08.2015.
 */
public class TextAdapter extends ArrayAdapter<TextItem>{

private Context context;
    private ArrayList<TextItem>table;



    public TextAdapter(Context context, ArrayList<TextItem>arrayList) {
        super(context,  R.layout.singletext, arrayList);
        this.context=context;
        table=arrayList;
    }

    @Override
    public View getView(final int position, View converView, ViewGroup partent) {//create one item, L
    // ösungen Android
        View v = converView;
        Log.d("getView","");
        if (v == null) {
Log.d("getView","v==null");
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.singletext, null);

        }
        Button button  = (Button)v.findViewById(R.id.test_button);
        TextView textView=(TextView)v.findViewById(R.id.single_text_view);
Log.d("talbe"+table.toString(),"");
        final TextItem titem = table.get(position);//
        textView.setText(titem.getText());


        return v;
    }

}
