package my.edu.tarc.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
    }

    protected void calculateBMI(){
        double weight, height, BMI;
        ImageView image;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        BMI = weight/(height * height);

        if(BMI == 0.00){
            image = (ImageView)findViewById(R.id.imageViewResult);
            image.setImageResource(R.drawable.empty);
            textViewResult.setText("BMI : " + String.format("%.2f",BMI) + " .Please enter Weight & Height");
        }

        else if(BMI <= 18.5){
            image = (ImageView)findViewById(R.id.imageViewResult);
            image.setImageResource(R.drawable.under);
            textViewResult.setText("BMI : " + String.format("%.2f",BMI) + " .You're underweight");
        }

        else if(BMI > 18.5 && BMI <25){
            image = (ImageView)findViewById(R.id.imageViewResult);
            image.setImageResource(R.drawable.normal);
            textViewResult.setText("BMI : " + String.format("%.2f",BMI) + " .You're normal");
        }

        else if(BMI >= 25){
            image = (ImageView)findViewById(R.id.imageViewResult);
            image.setImageResource(R.drawable.over);
            textViewResult.setText("BMI : " + String.format("%.2f",BMI) + " .You're overweight");
        }
    }

    public void displayResult(View view){
        calculateBMI();
    }

    public void resetResult(View view){
        ImageView image;

        editTextHeight.setText("");
        editTextWeight.setText("");
        textViewResult.setText("");

        image = (ImageView)findViewById(R.id.imageViewResult);
        image.setImageResource(R.drawable.empty);

    }
}
