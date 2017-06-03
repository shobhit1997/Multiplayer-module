package com.example.shobhit.multiplayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
 import android.view.ViewGroup.LayoutParams;

public class Buzz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzz);
        setQuestion(n);
        LinearLayout myLayout =
                (LinearLayout)findViewById(R.id.Buzz);

        myLayout.setOnTouchListener(
                new LinearLayout.OnTouchListener() {
                    public boolean onTouch(View v,
                                           MotionEvent m) {
                        if(flag==1)
                        handleTouch(m);
                        return true;
                    }
                }
        );




    }
    void handleTouch(MotionEvent m)
    {

        //int pointerCount = m.getPointerCount();
        int i=m.getActionIndex();
            size();
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
       // TextView ques = (TextView) findViewById(R.id.Ques);
       // ques. setText(width+","+height+","+x+","+y);
            if(x<=width/2)
            {

                flag=0;
                player=1;
                RadioGroup R1=(RadioGroup) findViewById(R.id.R1);
                R1.setVisibility(View.VISIBLE);

            }
            else
            {
                flag=0;
                player=2;
                RadioGroup R2=(RadioGroup) findViewById(R.id.R2);
                R2.setVisibility(View.VISIBLE);
            }


    }

    String answer="";
    int n=0,height,width ,flag=1,player=0;
    int score[]=new int[2];
    public void size()
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
         height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
    }
    public void setQuestion(int n)
    {
        RadioGroup R1=(RadioGroup) findViewById(R.id.R1);
        R1.setVisibility(View.INVISIBLE);
        RadioGroup R2=(RadioGroup) findViewById(R.id.R2);
        R2.setVisibility(View.INVISIBLE);
        flag=1;
        if(n<10) {

        String q1[]={"Which of the following countries have won the Fifa World Cup 4 time since its orign in 1930 ?","Who invented the Mercury Thermometer ?","Who won the NKP Challengers Trophy 2013-14 ?","Who discovered neutron ?","Who is the First Indian Bowler to take a wicket on his first ball in debut in T20 and oneday Internationals ?","Who invented Gas engine ?","The term 'Back-hand-drive' is associated with which sport ?","Who predicted Black Holes ?","Where is the Green Park Cricket Stadium located ?","What did Simpson and Harrison invented in field of Organic Chemistry ?"};
        String ans1[]={"Brazil","Farenheit","India Blue","Chadwick","Bhuvneshwar Kumar","Daimler","Lawn Tenis","Einstein","Kanpur","Chloroform"};
        String op1[][]={{"Argentina","Germany","Brazil","England"},{"Galileo","Farenheit","Newton","Priestley"},{"India Red","India Blue","Delhi","Chennai Super Kings"},{"Chadwick","Rutherford","Bohr","Newton"},{"Ashwin","Ishant Sharma","Kapil Dev","Bhuvneshwar Kumar"},{"Daimler","Davy","Diesel","Charles"},{"Lawn Tenis","Table Tenis","Badminton","Volleyball"},{"Copernicus","Hermamn Bondi","Rutherford","Einstein"},{"England","Mumbai","Kanpur","Delhi"},{"CFC","Chloroform","Methane","Alcohol"}};
        TextView ques = (TextView) findViewById(R.id.Ques);
        RadioButton O11 = (RadioButton) findViewById(R.id.Option1L1);
        RadioButton O21 = (RadioButton) findViewById(R.id.Option2L1);
        RadioButton O31 = (RadioButton) findViewById(R.id.Option3L1);
        RadioButton O41 = (RadioButton) findViewById(R.id.Option4L1);
        RadioButton O12 = (RadioButton) findViewById(R.id.Option1L2);
        RadioButton O22 = (RadioButton) findViewById(R.id.Option2L2);
        RadioButton O32 = (RadioButton) findViewById(R.id.Option3L2);
        RadioButton O42 = (RadioButton) findViewById(R.id.Option4L2);
        answer=ans1[n];
        ques.setText(q1[n]);
        O11.setText(op1[n][0]);
        O21.setText(op1[n][1]);
        O31.setText(op1[n][2]);
        O41.setText(op1[n][3]);
        O12.setText(op1[n][0]);
        O22.setText(op1[n][1]);
        O32.setText(op1[n][2]);
        O42.setText(op1[n][3]);
    }
    else
        {
            LinearLayout l=(LinearLayout)findViewById(R.id.Buzz);
            l.setEnabled(false);
        }

    }
    public void Check(View view)
    {
        RadioButton rb=(RadioButton)findViewById(view.getId());

        String Ans=rb.getText().toString();
        TextView Score[]=new TextView[2];
        Score[0]=(TextView)findViewById(R.id.scr1);
        Score[1]=(TextView)findViewById(R.id.scr2);

        if(Ans.equals(answer))
        {
            score[player-1]++;
            Score[player-1].setText(score[player-1]+"");
        }
        rb.setChecked(false);

        setQuestion(++n);


    }
 }



