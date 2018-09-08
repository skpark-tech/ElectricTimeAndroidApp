package html.netcs160_fl2018index.paulos.httpteaching.electrictime;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.os.LocaleListCompat.create;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] deviceNames={"Walking","Boosted Mini S Board","Evolve Skateboard","OneWheel","MotoTec SkateBoard", "Segway Ninebot One S1", "Segway i2 SE", "Razor Scooter", "GeoBlade 500", "Hovertrax Hoverboard"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.deviceOptions);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,deviceNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        int spinnerPosition = aa.getPosition("Walking");
        spin.setSelection(spinnerPosition);

        final Button getTimeButton = findViewById(R.id.getTimeButton);
        getTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText distanceIO = (EditText)findViewById(R.id.distanceIO);
                EditText timeIO = (EditText)findViewById(R.id.timeIO);
                Spinner spin = findViewById(R.id.deviceOptions);
                String deviceName = spin.getSelectedItem().toString();
                String milesInput = distanceIO.getText().toString();
                String timeInput = timeIO.getText().toString();
                if(milesInput.equals("")){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Incorrect Input");
                    alertDialog.setMessage("Please input correct distance");
                    alertDialog.show();
                    timeIO.setText("");
                } else {
                    double distanceInput = Double.parseDouble(milesInput);

                    boolean b1 = distanceInput>30.0;
                    boolean b2 = distanceInput>7.0;
                    boolean b3 = distanceInput>31.0;
                    boolean b4 = distanceInput>7.0;
                    boolean b5 = distanceInput>10.0;
                    boolean b6 = distanceInput>15.0;
                    boolean b7 = distanceInput>24.0;
                    boolean b8 = distanceInput>7.0;
                    boolean b9 = distanceInput>8.0;
                    boolean b10 = distanceInput>8.0;

                    double walkTime = round(distanceInput/3.1*60.0, 1);
                    double BMSBTime = round(distanceInput/18.0*60.0, 1);
                    double ESTime = round(distanceInput/26.0*60.0, 1);
                    double OWTime = round(distanceInput/19.0*60.0, 1);
                    double MTSTime = round(distanceInput/22.0*60.0, 1);
                    double S1Time = round(distanceInput/12.5*60.0, 1);
                    double i2Time = round(distanceInput/12.5*60.0, 1);
                    double RSTime = round(distanceInput/10.0*60.0, 1);
                    double GBTime = round(distanceInput/15.0*60.0, 1);
                    double HHTime = round(distanceInput/8.0*60.0, 1);

                    String walkTimeString = Double.toString(walkTime);
                    String BMSBTimeString = Double.toString(BMSBTime);
                    String ESTimeString = Double.toString(ESTime);
                    String OWTimeString = Double.toString(OWTime);
                    String MTSTimeString = Double.toString(MTSTime);
                    String S1TimeString = Double.toString(S1Time);
                    String i2TimeString = Double.toString(i2Time);
                    String RSTimeString = Double.toString(RSTime);
                    String GBTimeString = Double.toString(GBTime);
                    String HHTimeString = Double.toString(HHTime);


                    String r1 = walkTimeString + "mins";
                    String r2 = BMSBTimeString + "mins";
                    String r3 = ESTimeString + "mins";
                    String r4 = OWTimeString + "mins";
                    String r5 = MTSTimeString + "mins";
                    String r6 = S1TimeString + "mins";
                    String r7 = i2TimeString + "mins";
                    String r8 = RSTimeString + "mins";
                    String r9 = GBTimeString + "mins";
                    String r10 = HHTimeString + "mins";

                    TextView walkResultText = (TextView)findViewById(R.id.walkResultText);
                    if(b1){
                        r1 = "N/A";
                    }
                    walkResultText.setText(r1);

                    TextView BMSBResultText = (TextView)findViewById(R.id.BMSBResultText);
                    if(b2){
                        r2 = "N/A";
                    }
                    BMSBResultText.setText(r2);

                    TextView ESResultText = (TextView)findViewById(R.id.ESResultText);
                    if(b3){
                        r3 = "N/A";
                    }
                    ESResultText.setText(r3);

                    TextView OWResultText = (TextView)findViewById(R.id.OWResultText);
                    if(b4){
                        r4 = "N/A";
                    }
                    OWResultText.setText(r4);

                    TextView MTSResultText = (TextView)findViewById(R.id.MTSResultText);
                    if(b5){
                        r5 = "N/A";
                    }
                    MTSResultText.setText(r5);

                    TextView S1ResultText = (TextView)findViewById(R.id.S1ResultText);
                    if(b6){
                        r6 = "N/A";
                    }
                    S1ResultText.setText(r6);

                    TextView i2ResultText = (TextView)findViewById(R.id.i2ResultText);
                    if(b7){
                        r7 = "N/A";
                    }
                    i2ResultText.setText(r7);

                    TextView RSResultText = (TextView)findViewById(R.id.RSResultText);
                    if(b8){
                        r8 = "N/A";
                    }
                    RSResultText.setText(r8);

                    TextView GBResultText = (TextView)findViewById(R.id.GBResultText);
                    if(b9){
                        r9 = "N/A";
                    }
                    GBResultText.setText(r9);

                    TextView HHResultText = (TextView)findViewById(R.id.HHResultText);
                    if(b10){
                        r10 = "N/A";
                    }
                    HHResultText.setText(r10);


                    switch(deviceName){
                        case "Walking":
                            timeIO.setText(r1);
                            break;
                        case "Boosted Mini S Board":
                            timeIO.setText(r2);
                            break;
                        case "Evolve Skateboard":
                            timeIO.setText(r3);
                            break;
                        case "OneWheel":
                            timeIO.setText(r4);
                            break;
                        case "MotoTec SkateBoard":
                            timeIO.setText(r5);
                            break;
                        case "Segway Ninebot One S1":
                            timeIO.setText(r6);
                            break;
                        case "Segway i2 SE":
                            timeIO.setText(r7);
                            break;
                        case "Razor Scooter":
                            timeIO.setText(r8);
                            break;
                        case "GeoBlade 500":
                            timeIO.setText(r9);
                            break;
                        case "Hovertrax Hoverboard":
                            timeIO.setText(r10);
                            break;
                        default:
                            System.out.println("no match");
                    }
                }


            }
        });


        final Button getMilesButton = findViewById(R.id.getMilesButton);
        getMilesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText distanceIO = (EditText)findViewById(R.id.distanceIO);
                EditText timeIO = (EditText)findViewById(R.id.timeIO);
                Spinner spin = findViewById(R.id.deviceOptions);
                String deviceName = spin.getSelectedItem().toString();
                String milesInput = distanceIO.getText().toString();
                String timeInput = timeIO.getText().toString();
                if(timeInput.equals("")){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Incorrect Input");
                    alertDialog.setMessage("Please input correct time");
                    alertDialog.show();
                    distanceIO.setText("");
                } else {
                    double minsInput = Double.parseDouble(timeInput);

                    boolean b1 = minsInput>30.0/3.1*60.0;
                    boolean b2 = minsInput>7.0/18.0*60.0;
                    boolean b3 = minsInput>31.0/26.0*60.0;
                    boolean b4 = minsInput>7.0/19.0*60.0;
                    boolean b5 = minsInput>10.0/22.0*60.0;
                    boolean b6 = minsInput>15.0/12.5*60.0;
                    boolean b7 = minsInput>24.0/12.5*60.0;
                    boolean b8 = minsInput>7.0/10.0*60.0;
                    boolean b9 = minsInput>8.0/15.0*60.0;
                    boolean b10 = minsInput>8.0/9.0*60.0;

                    double walkDistance = round(minsInput/60.0*3.1, 1);
                    double BMSBDistance = round(minsInput/60.0*18.0, 1);
                    double ESDistance = round(minsInput/60.0*26.0, 1);
                    double OWDistance = round(minsInput/60.0*19.0, 1);
                    double MTSDistance = round(minsInput/60.0*22.0, 1);
                    double S1Distance = round(minsInput/60.0*12.5, 1);
                    double i2Distance = round(minsInput/60.0*12.5, 1);
                    double RSDistance = round(minsInput/60.0*12.5, 1);
                    double GBDistance = round(minsInput/60.0*15.0, 1);
                    double HHDistance = round(minsInput/60.0*8.0, 1);

                    String walkDistanceString = Double.toString(walkDistance);
                    String BMSBDistanceString = Double.toString(BMSBDistance);
                    String ESDistanceString = Double.toString(ESDistance);
                    String OWDistanceString = Double.toString(OWDistance);
                    String MTSDistanceString = Double.toString(MTSDistance);
                    String S1DistanceString = Double.toString(S1Distance);
                    String i2DistanceString = Double.toString(i2Distance);
                    String RSDistanceString = Double.toString(RSDistance);
                    String GBDistanceString = Double.toString(GBDistance);
                    String HHDistanceString = Double.toString(HHDistance);


                    String r1 = walkDistanceString + "miles";
                    String r2 = BMSBDistanceString + "miles";
                    String r3 = ESDistanceString + "miles";
                    String r4 = OWDistanceString + "miles";
                    String r5 = MTSDistanceString + "miles";
                    String r6 = S1DistanceString + "miles";
                    String r7 = i2DistanceString + "miles";
                    String r8 = RSDistanceString + "miles";
                    String r9 = GBDistanceString + "miles";
                    String r10 = HHDistanceString + "miles";

                    TextView walkResultText = (TextView)findViewById(R.id.walkResultText);
                    if(b1){
                        r1 = "N/A";
                    }
                    walkResultText.setText(r1);

                    TextView BMSBResultText = (TextView)findViewById(R.id.BMSBResultText);
                    if(b2){
                        r2 = "N/A";
                    }
                    BMSBResultText.setText(r2);

                    TextView ESResultText = (TextView)findViewById(R.id.ESResultText);
                    if(b3){
                        r3 = "N/A";
                    }
                    ESResultText.setText(r3);

                    TextView OWResultText = (TextView)findViewById(R.id.OWResultText);
                    if(b4){
                        r4 = "N/A";
                    }
                    OWResultText.setText(r4);

                    TextView MTSResultText = (TextView)findViewById(R.id.MTSResultText);
                    if(b5){
                        r5 = "N/A";
                    }
                    MTSResultText.setText(r5);

                    TextView S1ResultText = (TextView)findViewById(R.id.S1ResultText);
                    if(b6){
                        r6 = "N/A";
                    }
                    S1ResultText.setText(r6);

                    TextView i2ResultText = (TextView)findViewById(R.id.i2ResultText);
                    if(b7){
                        r7 = "N/A";
                    }
                    i2ResultText.setText(r7);

                    TextView RSResultText = (TextView)findViewById(R.id.RSResultText);
                    if(b8){
                        r8 = "N/A";
                    }
                    RSResultText.setText(r8);

                    TextView GBResultText = (TextView)findViewById(R.id.GBResultText);
                    if(b9){
                        r9 = "N/A";
                    }
                    GBResultText.setText(r9);

                    TextView HHResultText = (TextView)findViewById(R.id.HHResultText);
                    if(b10){
                        r10 = "N/A";
                    }
                    HHResultText.setText(r10);


                    switch(deviceName){
                        case "Walking":
                            distanceIO.setText(r1);
                            break;
                        case "Boosted Mini S Board":
                            distanceIO.setText(r2);
                            break;
                        case "Evolve Skateboard":
                            distanceIO.setText(r3);
                            break;
                        case "OneWheel":
                            distanceIO.setText(r4);
                            break;
                        case "MotoTec SkateBoard":
                            distanceIO.setText(r5);
                            break;
                        case "Segway Ninebot One S1":
                            distanceIO.setText(r6);
                            break;
                        case "Segway i2 SE":
                            distanceIO.setText(r7);
                            break;
                        case "Razor Scooter":
                            distanceIO.setText(r8);
                            break;
                        case "GeoBlade 500":
                            distanceIO.setText(r9);
                            break;
                        case "Hovertrax Hoverboard":
                            distanceIO.setText(r10);
                            break;
                        default:
                            System.out.println("no match");
                    }
                }


            }
        });
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), deviceNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

}
