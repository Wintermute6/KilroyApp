package com.soontm.kilroy.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.soontm.kilroy.R;
import com.soontm.kilroy.adapters.TextAdapter;
import com.soontm.kilroy.domain.TextItem;

import java.util.ArrayList;


public class ChatActivity extends Activity {
TextAdapter textAdapter;
    ArrayList<TextItem>arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
listView();
    }
    private void hideKeyboard() {//android developers
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }
public void listView(){
    arrayList= new ArrayList<TextItem>();
    textAdapter= new TextAdapter(ChatActivity.this,arrayList);
    ListView list = (ListView)findViewById(R.id.list);
    list.setAdapter(textAdapter);
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
if(id==R.id.edit_settings){
    addPosts();
}
        return super.onOptionsItemSelected(item);

    }
    private void handle(){
       }
    private  void addPosts(){final EditText editText = (EditText)findViewById(R.id.edit_text_chat);//name-
        editText.setVisibility(View.VISIBLE);
        final Button button = (Button)findViewById(R.id.checkbutton_id);
        button.setBackground(getResources().getDrawable(R.drawable.ic_done_black_24dp));
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {

            int buttonpressed =0;
            String texte="";
            @Override
            public void onClick(View view) {





                texte =  editText.getText().toString();

                TextItem item1 = new TextItem(texte, buttonpressed);
                    arrayList.add(item1);
                button.setBackgroundResource(0);

                button.setBackground(getResources().getDrawable(R.drawable.ic_done_all_black_24dp));

                Log.d("arrayList" + arrayList.toString(), "");
                    textAdapter.notifyDataSetChanged();
                final Handler handler = new Handler(){};
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        button.setVisibility(View.INVISIBLE);

                        button.setBackground(getResources().getDrawable(R.drawable.ic_done_black_24dp));

                        button.setBackgroundResource(0);
                        button.setVisibility(View.GONE);
                    }
                }, 500);

                editText.setVisibility(View.INVISIBLE);

hideKeyboard();
            }
        });}
}
