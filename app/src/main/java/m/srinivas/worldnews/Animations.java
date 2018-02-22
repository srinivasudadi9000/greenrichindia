package m.srinivas.worldnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Animations extends AppCompatActivity {
    Button mybutton;
    TextView mytext;
    Animation move;
    LinearLayout mylinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animations);
        mybutton = (Button) findViewById(R.id.mybutton);
        mytext = (TextView) findViewById(R.id.mytext);
        mylinear = (LinearLayout) findViewById(R.id.mylinear);
        move = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.grow_from_left_bottom);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytext.startAnimation(move);
                mylinear.startAnimation(move);
            }
        });
    }
}
