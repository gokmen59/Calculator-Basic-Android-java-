package com.mutlu.calculatorproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView screen;
    private TextView displayText;
    private String result="";
    private String display="";
    private String currentOperator="";
    double[] number = new double[2] ;
    int i=0;
    double number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView)findViewById(R.id.input_box);
        screen.setText(display);
        inputText = findViewById(R.id.input_box);
        displayText = findViewById(R.id.result_box);
    }

    private void appendToLast(String str) { // append komutu eski metni koruyup yanına ekleme yapmak için kullanılır. append yeni değerimizi varolan değere ekler.
        this.inputText.getText().append(str);
    }

    public void onClickNumber(View view){
    Button button = (Button) view;
    display = display+ button.getText();
    appendToLast(display);
    display="";
    }

    private void replace(String string) { // replace yerine koymak anlamina gelir.
        inputText.getText().replace(getInput().length() - 1, getInput().length(), string);
    }
    /* public void onClickOperator(View view){
    Button button = (Button) view;
    display = display+ button.getText(); // display in içine tıklanan butondaki text eklendi.
    if (endsWithOperator()){
        replace(display); // replace fonksiyonu çağırıldı.
        currentOperator = button.getText().toString();
        display = "";
    }
    else {
        appendToLast(display);
        currentOperator = button.getText().toString();

        display = "";
    }
    } */

    public void  onClickSum (View view){
/*
        number[i] = Double.valueOf(String.valueOf(inputText.getText()));

        if(displayText.toString()==""){
            displayText.setText(String.valueOf(number[i]));
          inputText.getText().clear();
        }
        else {
            displayText.setText(""+(number[0]+number[1]));


        }i
        i++;

 */  // TOPLAMA İŞLEMİ
            if ( getInput().trim().equals("") ){
                displayText.setText("0");
                inputText.setText(""); }
            else {
                number1= Double.parseDouble(String.valueOf(inputText.getText()));
                number2= Double.parseDouble(String.valueOf(displayText.getText()));
                displayText.setText(String.valueOf(number1+number2));
                inputText.getText().clear();
            }

    }
    public void onClickSub (View view){ // HATA VAR SONUC NEGATİF OLUNCA - GELMİYOR.

            if ( getInput().trim().equals("") ){
                displayText.setText("0");
                inputText.setText(""); }
            else {
                number1= Double.parseDouble(String.valueOf(inputText.getText()));
                number2= Double.parseDouble(String.valueOf(displayText.getText()));
                if (number1-number2<0&& number2!=0) {
                    displayText.setText(String.valueOf((number2-number1)));
                }
                else if (number2==0){
                    displayText.setText(inputText.getText());
                }
                else {
                    displayText.setText(String.valueOf((number2-number1)));
                }
                inputText.getText().clear();
            }
    }
    public void onClickMulti(View view){
        if ( getInput().trim().equals("") ){
            displayText.setText("0");
            inputText.setText(""); }
        else{
            if(Double.parseDouble(String.valueOf(displayText.getText()))!=0.0){

                number1= Double.parseDouble(String.valueOf(inputText.getText()));
                number2= Double.parseDouble(String.valueOf(displayText.getText()));
                displayText.setText(String.valueOf(number1*number2));
            }
            else{
                displayText.setText(inputText.getText());
            }

            inputText.getText().clear();
        }
    }
    public void onClickDiv(View view){
        if ( getInput().trim().equals("") ){
            displayText.setText("0");
            inputText.setText(""); }
            else{
                if(Double.parseDouble(String.valueOf(displayText.getText()))!=0.0){

                    number1= Double.parseDouble(String.valueOf(inputText.getText()));
                    number2= Double.parseDouble(String.valueOf(displayText.getText()));
                    displayText.setText(String.valueOf(number2/number1));
                }
                else{
                    displayText.setText(inputText.getText());
                }

                inputText.getText().clear();
            }

        }




    public void onClickClear(View view) {
        inputText.getText().clear();
        displayText.setText("0");
    }

    @NonNull
    private String getInput(){
        return this.inputText.getText().toString();
    }

    private boolean endsWithOperator(){ //endsWith komutu karakter dizisinin durumunu sorgular. içeriği şu değer ile bitiyorsa true veya false değerleri çekmeye yarar.
        return getInput().endsWith("+") || getInput().endsWith("-")|| getInput().endsWith("*")|| getInput().endsWith("/");
    }


    public void onClickResult(View view){
        String input = getInput();

        if(input.contains("+")){


        }

    }


}