package nl.arthurtech.hueapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements LampUpdateCallback{
    List<LampItem> lamps= new ArrayList<>();
    RecyclerView recyclerView;
    LampRecyclerViewAdapter lampRecyclerViewAdapter;

    private OnFragmentInteractionListener mListener;
    private static final String TAG = "ListFragment";

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(List<LampItem> lamps) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(()->{
            while(true){
                UpdateLamps();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
            }}
        }).start();
    }

    private void UpdateLamps() {
        //TODO updateLamps
        LampListActivity.lampCommunication.getLamps();
    }

    //Moet de lampen in de lijst met lampitems stoppen
    private void GetLamps() {
        Log.i(TAG, "addLamps");
        lamps.add(new LampItem("Lamp 1",1235));
        lamps.add(new LampItem("Lamp 2",2725));
        lamps.add(new LampItem("Lamp 3",9521));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "createView");
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        LampDetailFragment lampDetailFragment = (LampDetailFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_lamp_detail);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        lampRecyclerViewAdapter = new LampRecyclerViewAdapter(getContext(), lamps,lampDetailFragment);
        recyclerView.setAdapter(lampRecyclerViewAdapter);
        return view;
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
    public void updateLampList(List<LampItem> lamps) {
        //Sets the new lamplist ands gives notification to update lamp list
        this.lamps = lamps;
        lampRecyclerViewAdapter.notifyDataSetChanged();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(LampItem lamp);
    }
}
