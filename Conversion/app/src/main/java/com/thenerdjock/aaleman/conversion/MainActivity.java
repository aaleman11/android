package com.thenerdjock.aaleman.conversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner unitTypeSpinner;
    private EditText amountTextView;

    TextView teaspoonTextView, tablespoonTextView, cupTextView, ounceTextView,
        pintTextView, quartTextView, gallonTextView, poundTextView,
        milliliterTextView,literTextView, milligramTextView, kilogramTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitTypeSpinner();

        addListenerToUnitTypeSpiner();

        amountTextView = (EditText) findViewById(R.id.amount_textview);

        initializeTextViews();

    }

    public void initializeTextViews(){

        teaspoonTextView = (TextView) findViewById(R.id.tsp_textview);
        tablespoonTextView = (TextView) findViewById(R.id.tbs_text_view);
        cupTextView = (TextView) findViewById(R.id.cup_textview);
        ounceTextView = (TextView) findViewById(R.id.oz_text_view);
        pintTextView = (TextView) findViewById(R.id.pint_text_view);
        quartTextView = (TextView) findViewById(R.id.quart_text_view);
        gallonTextView = (TextView) findViewById(R.id.gallon_text_view);
        poundTextView = (TextView) findViewById(R.id.pound_text_view);
        milliliterTextView = (TextView) findViewById(R.id.ml_text_view);
        milligramTextView = (TextView) findViewById(R.id.mg_text_view);
        literTextView = (TextView) findViewById(R.id.liter_text_view);
        kilogramTextView = (TextView) findViewById(R.id.kg_text_view);

    }

    public void addItemsToUnitTypeSpinner(){

        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        //Conversion types xml file
        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.conversion_types,
                        android.R.layout.simple_spinner_item);

        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);

    }

    public void addListenerToUnitTypeSpiner(){

        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

                //checkIfConvertingFromTsp(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //TODO something later

            }
        });

    }

    public void checkIfConvertingFromTsp(String currentUnit) {

        if(currentUnit.equals("teaspoon")){
            updateUnitTypeUsingTsp(Quantity.Unit.tsp);
        }
        else{
            if(currentUnit.equals("tablespoon")){

                updateUnitTypesUsingOther(Quantity.Unit.tbs);

            } else if(currentUnit.equals("cup")){

                updateUnitTypesUsingOther(Quantity.Unit.cup);

            } else if(currentUnit.equals("ounce")){

                updateUnitTypesUsingOther(Quantity.Unit.oz);

            } else if(currentUnit.equals("pint")){

                updateUnitTypesUsingOther(Quantity.Unit.pint);

            } else if(currentUnit.equals("quart")){

                updateUnitTypesUsingOther(Quantity.Unit.quart);

            } else if(currentUnit.equals("gallon")){

                updateUnitTypesUsingOther(Quantity.Unit.gallon);

            } else if(currentUnit.equals("pound")){

                updateUnitTypesUsingOther(Quantity.Unit.pound);

            } else if(currentUnit.equals("milliliter")){

                updateUnitTypesUsingOther(Quantity.Unit.ml);

            } else if(currentUnit.equals("liter")){

                updateUnitTypesUsingOther(Quantity.Unit.liter);

            } else if(currentUnit.equals("milligram")){

                updateUnitTypesUsingOther(Quantity.Unit.mg);

            } else {

                updateUnitTypesUsingOther(Quantity.Unit.kg);

            }
        }
    }

    public void updateUnitTypeUsingTsp(Quantity.Unit currentUnit){

        double doubleToConvert = Double.parseDouble(amountTextView.getText().toString());

        String teaspoonValueAndUnit = doubleToConvert + " tsp";

        teaspoonTextView.setText(teaspoonValueAndUnit);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.tbs, tablespoonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.cup, cupTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.oz, ounceTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.pint, pintTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.quart, quartTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.gallon, gallonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.pound, poundTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.ml, milliliterTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.liter, literTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.mg, milligramTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit,
                Quantity.Unit.kg, kilogramTextView);

        if(currentUnit.name().equals(currentQuantitySelected.unit.name())){

            String currentUnitTextViewText = doubleToConvert + " " +
                    currentQuantitySelect.unit.name();

            String currentTextViewName = currentQuantitySelected.unit.name() +
                    "_text_view";

            int currentId = getResources().getIdentifier(currentTextViewName, "id",
                    MainActivity.this.getPackageName());

            TextView currentTextView = (TextView) findViewById(currentId);

            currentTextView.setText(currentUnitTextViewText);

        }

    }

    public void updateUnitTextFieldUsingTsp(double doubleToConvert, Quantity.Unit currentUnit,
                                            Quantity.Unit unitConvertingTo,
                                            TextView textViewToUpdate){

        Quantity unitQuantity = new Quantity(doubleToConvert, Quantity.Unit.tsp);

        String tempUnit = unitQuantity.to(unitConvertingTo).toString();

        textViewToUpdate.setText(tempUnit);

    }

    public void updateUnitTypesUsingOther(Quantity.Unit currentUnit){

        double doubleToConvert = Double.parseDouble(amountTextView.getText().toString());

        Quantity currentQuantitySelected = new Quantity(doubleToConvert, currentUnit);

        String valueInTeaspoons = currentQuantitySelected.to(Quantity.Unit.tsp).toString();

        teaspoonTextView.setText(valueInTeaspoons);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.tbs, tablespoonTextView);


    }

    
}
