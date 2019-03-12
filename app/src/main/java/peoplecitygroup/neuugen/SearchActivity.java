package peoplecitygroup.neuugen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    androidx.appcompat.widget.AppCompatTextView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        idLink();
        listenerLink();

        Typeface font = Typeface.createFromAsset(getAssets(), "Font Awesome 5 Free-Solid-900.otf" );
        backbtn.setTypeface(font);
    }
    
    public void idLink()
    {
        backbtn=findViewById(R.id.backbtn);
    }
    
    public void listenerLink()
    {
        backbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.backbtn)
        {
            onBackPressed();
        }
    }
}
