package nl.arthurtech.hueapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

public class LampDetailFragment extends Fragment implements AdapterView.OnItemClickListener, FragmentCallBack{

    private OnFragmentInteractionListener mListener;
    private static final String TAG = "LampDetailFragment";
    private LampItem lamp;
    private ImageView lampColorImage;
    private Switch lampSwitch;
    private SeekBar sbSaturation;
    private SeekBar sbBrightness;
    private SeekBar sbHue;



    public LampDetailFragment() {
        // Required empty public constructor
    }

    private String getFromSharedPreferences(String key){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(key,"127.0.0.1");
    }

    public void setLamp(LampItem lamp){
        Log.i(TAG, "setLamp");
        this.lamp = lamp;
        UpdateDetailUI();
    }

    private void UpdateDetailUI() {
        Log.i(TAG,"lampupdate"+lamp.getLampID());
        lampSwitch.setText(lamp.getLampID());
    }

    public static LampDetailFragment newInstance() {
        LampDetailFragment fragment = new LampDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lamp_detail, container, false);
        lampColorImage = view.findViewById(R.id.imageDetailColor);
        lampSwitch = view.findViewById(R.id.lampSwitch);
        sbBrightness = view.findViewById(R.id.seekBarBrightness);
        sbHue = view.findViewById(R.id.seekBarHue);
        sbSaturation = view.findViewById(R.id.seekBarSaturation);
        lampSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            lampSwitched(isChecked);
        });
        sbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                brightnessChanged(progress,fromUser);

            }
        });
        sbHue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                hueChanged(progress,fromUser);

            }
        });
        sbSaturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                saturationChanged(progress,fromUser);
            }
        });
        return view;
    }

    private void lampSwitched(boolean isChecked) {
        lamp.setOn(isChecked);
        LampCommunication.lampCommunication.updateLamp(lamp);
    }

    private void saturationChanged(int progress, boolean fromUser){
        if(fromUser) {
            lamp.setSaturation(progress);
            LampCommunication.lampCommunication.updateLamp(lamp);
        }
    }

    private void hueChanged(int progress, boolean fromUser){
        if(fromUser) {
            lamp.setLampHue(progress);
            LampCommunication.lampCommunication.updateLamp(lamp);
        }
    }

    private void brightnessChanged(int progress, boolean fromUser){
        if(fromUser) {
            lamp.setBrightness(progress);
            LampCommunication.lampCommunication.updateLamp(lamp);
        }
    }

    private void updateColor(){
        lampColorImage.setColorFilter(lamp.getColor());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void updateLampDetails(LampItem lamp) {
        Log.i("Callback","-called");
        setLamp(lamp);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(LampItem lamp);
    }
}
