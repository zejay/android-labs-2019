package edu.hzuapps.androidlabs.com1714080901125;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;


import com.example.myapplication.R;

public class Com1714080901125Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1714080901125);

        textView=(TextView)findViewById(R.id.touxiang);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Com1714080901125Activity.this,AnotherActivity.class);
                startActivity(intent);
            }
        });
    }
}