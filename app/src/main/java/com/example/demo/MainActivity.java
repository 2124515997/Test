package com.example.demo;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private Fragment[]mFragments;
    private RadioButton mRadioButtonHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mFragments = mFragments.getFragments("RadioGroup Tab");
        initView();
    }

    private void initView() {
          RadioGroup mRadioGroup =findViewById(R.id.radio_group_button);
        RadioButton mRadioButtonHome =findViewById(R.id.radio_button_home);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            Fragment mFragment = null;
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.radio_button_home:
                        mFragment = mFragments[0];
                        break;
                    case R.id.radio_button_discovery:
                        mFragment = mFragments[1];
                        break;
                    case R.id.radio_button_attention:
                        mFragment = mFragments[2];
                        break;
                    case R.id.radio_button_profile:
                        mFragment = mFragments[3];
                        break;
                }
                if(mFragments!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container,mFragment).commit();
                }
            }
        });
        // 保证第一次会回调OnCheckedChangeListener
        mRadioButtonHome.setChecked(true);
    }
}
