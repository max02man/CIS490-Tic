package com.hawsawi02.alaa.tic;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by MAX MAN on 9/26/2016.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;

    public MainActivityTest(){
        super(MainActivity.class);
    }
    @Override
    protected void setUp ()throws Exception{
        super.setUp();
        activity = getActivity();

    }
    @Test
    public void buttoniscorrect(){
      Button a1 = (Button) activity.findViewById(R.id.A1);
        Button a2 = (Button) activity.findViewById(R.id.A2);
        Button a3 = (Button) activity.findViewById(R.id.A3);
        Button b1 = (Button) activity.findViewById(R.id.B1);
        Button b2 = (Button) activity.findViewById(R.id.B2);
        Button b3 = (Button) activity.findViewById(R.id.B3);
        Button c1 = (Button) activity.findViewById(R.id.C1);
        Button c2 = (Button) activity.findViewById(R.id.C2);
        Button c3 = (Button) activity.findViewById(R.id.C3);
        Button rest = (Button) activity.findViewById(R.id.Rest);
        TextView result = (TextView) activity.findViewById(R.id.winner_box);
        TextView Who_turn =(TextView) activity.findViewById(R.id.turn);


      assertNotNull(a1);
        assertNotNull(a2);
        assertNotNull(a3);
        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
        assertNotNull(c1);
        assertNotNull(c2);
        assertNotNull(c3);
        assertNotNull(rest);
        assertNotNull(result);
        assertNotNull(Who_turn);


    }

    @Override
    protected void tearDown()throws Exception{
        super.tearDown();
    }
}
