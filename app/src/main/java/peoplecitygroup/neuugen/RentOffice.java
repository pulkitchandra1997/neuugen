package peoplecitygroup.neuugen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class RentOffice extends AppCompatActivity implements View.OnClickListener {

    AppCompatTextView backtopost2;

    TextInputEditText arearo,cityro,landmarkro,builtarearo,monthlyrentro,shopno,pincodero;

    MaterialButton submitroform,addimgro1,addimgro2,addimgro3;

    AppCompatSpinner propertytypero;

    ChipGroup constatusro;

    Chip readytomovero,underconro;

    LinearLayout romainlayout;

    AppCompatImageView imgro1,imgro2,imgro3;

    String propertytype,arearotext,cityrotext,landmarkrotext,pincoderotext,builtarearotext,monthlyrentrotext,shopnorotext,propertytyperotext,constatusrotext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_office);

        idLink();
        listenerLink();
        hideSoftKeyboard();

        Typeface font = Typeface.createFromAsset(getAssets(), "Font Awesome 5 Free-Solid-900.otf" );
        backtopost2.setTypeface(font);
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
    public void listenerLink()
    {
        backtopost2.setOnClickListener(this);
        submitroform.setOnClickListener(this);
        addimgro1.setOnClickListener(this);
        addimgro2.setOnClickListener(this);
        addimgro3.setOnClickListener(this);
    }

    public void idLink()
    {
        backtopost2=findViewById(R.id.backtopost2);
        arearo=findViewById(R.id.arearo);
        cityro=findViewById(R.id.cityro);
        landmarkro=findViewById(R.id.landmarkro);
        builtarearo=findViewById(R.id.builtarearo);
        monthlyrentro=findViewById(R.id.monthlyrentro);
        propertytypero=findViewById(R.id.propertytypero);
        submitroform=findViewById(R.id.submitroform);
        constatusro=findViewById(R.id.constatusro);
        readytomovero=findViewById(R.id.readytomovero);
        underconro=findViewById(R.id.underconro);
        shopno=findViewById(R.id.shopno);
        romainlayout=findViewById(R.id.romainlayout);
        imgro1=findViewById(R.id.imgro1);
        imgro2=findViewById(R.id.imgro2);
        imgro3=findViewById(R.id.imgro3);
        addimgro1=findViewById(R.id.addimgro1);
        addimgro2=findViewById(R.id.addimgro2);
        addimgro3=findViewById(R.id.addimgro3);
        pincodero=findViewById(R.id.pincodero);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.backtopost2)
        {
            onBackPressed();
        }
        if (v.getId()==R.id.submitroform)
        {
            arearotext=arearo.getText().toString().trim();
            shopnorotext=shopno.getText().toString().trim();
            cityrotext=cityro.getText().toString().trim();
            landmarkrotext=landmarkro.getText().toString().trim();
            builtarearotext=builtarearo.getText().toString().trim();
            monthlyrentrotext=monthlyrentro.getText().toString().trim();
            propertytyperotext=propertytypero.getSelectedItem().toString();
            pincoderotext=pincodero.getText().toString().trim();

            if (constatusro.getCheckedChipId()==R.id.readytomove)
            {
                constatusrotext="0";
            }else
            if (constatusro.getCheckedChipId()==R.id.undercon)
            {
                constatusrotext="1";
            }

            if (propertytyperotext.equalsIgnoreCase("Office Area"))
            {
                propertytype="4";
            }else
            if (propertytyperotext.equalsIgnoreCase("Shop Area"))
            {
                propertytype="5";
            }
            if (TextUtils.isEmpty(pincoderotext) ||TextUtils.isEmpty(arearotext) || TextUtils.isEmpty(shopnorotext)||TextUtils.isEmpty(cityrotext)||TextUtils.isEmpty(builtarearotext)||TextUtils.isEmpty(monthlyrentrotext)||propertytyperotext.equalsIgnoreCase("Select Property Type")||!(constatusro.getCheckedChipId()==R.id.undercon)&&!(constatusro.getCheckedChipId()==R.id.readytomove))
            {
                if (TextUtils.isEmpty(shopnorotext) )
                {
                    shopno.setError("Enter Shop Number");
                    shopno.requestFocus();
                }else
                if (TextUtils.isEmpty(arearotext) )
                {
                    arearo.setError("Enter Area");
                    arearo.requestFocus();
                }else

                if (TextUtils.isEmpty(cityrotext) )
                {
                    cityro.setError("Enter City");
                    cityro.requestFocus();
                }else
                if (TextUtils.isEmpty(pincoderotext) )
                {
                    pincodero.setError("Enter Pincode");
                    pincodero.requestFocus();
                }else
                if (TextUtils.isEmpty(builtarearotext) )
                {
                    builtarearo.setError("Enter Built Area");
                    builtarearo.requestFocus();
                }else
                if (TextUtils.isEmpty(monthlyrentrotext) )
                {
                    monthlyrentro.setError("Enter Monthly Rent");
                    monthlyrentro.requestFocus();
                }else

                if (propertytyperotext.equalsIgnoreCase("Select Property Type"))
                {
                    Snackbar.make(romainlayout, "Select Property Type", Snackbar.LENGTH_LONG)
                            .show();

                    propertytypero.requestFocus();
                }else

                if (!(constatusro.getCheckedChipId()==R.id.undercon)&&!(constatusro.getCheckedChipId()==R.id.readytomove)) {
                    Snackbar.make(romainlayout, "Select Construction Status", Snackbar.LENGTH_LONG)
                            .show();

                    constatusro.requestFocus();
                }

            }
            else
            {

            }
        }
    }
    
}
