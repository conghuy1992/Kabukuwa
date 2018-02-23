package com.daydelight.kabukuwa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daydelight.kabukuwa.R;

/**
 * Created by goood on 5/15/15.
 */
public class adaptermenu_2 extends Activity {
    TextView Title, content;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adaptermenu_2);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        Title = (TextView) findViewById(R.id.textView7);
        content = (TextView) findViewById(R.id.textView10);
        Intent intent = getIntent();
        String TITLE = intent.getStringExtra("TITLE");
        Title.setText(TITLE);
        String CONTENT = intent.getStringExtra("DETAIL");
        content.setText(CONTENT);
        button = (Button) findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
