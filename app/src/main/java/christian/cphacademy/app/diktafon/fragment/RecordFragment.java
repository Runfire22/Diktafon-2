package christian.cphacademy.app.diktafon.fragment;

import christian.cphacademy.app.diktafon.R;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import christian.cphacademy.app.diktafon.activity.PlaylistActivity;

public class RecordFragment extends Fragment {
    private MediaRecorder mRecorder;
    private String mFileName = null;
    private static final String LOG_TAG = "Record log";

    public static RecordFragment newInstance() {
        return new RecordFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_record, container, false);
        //chronometer = getView().findViewById(R.id.chronometer);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";

        Button btnPlay = v.findViewById(R.id.play);
        btnPlay.setOnClickListener((View view) -> {btnPlayClicked(); });

        Button btnRecord = v.findViewById(R.id.record);
        btnRecord.setOnClickListener((View view) -> {btnRecordClicked(); });

        Button btnStop = v.findViewById(R.id.stop);
        btnStop.setOnClickListener((View view) -> {btnStopClicked(); });

        Button btnPlayList = v.findViewById(R.id.playList);
        btnPlayList.setOnClickListener((View view) -> {btnPlayListClicked(); });


        return v;
    }

    private void btnPlayClicked(){
        MediaPlayer mPlayer = new MediaPlayer();
        try{
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();

            Toast.makeText(getActivity().getApplicationContext(), "Playing Audio", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void btnRecordClicked() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        Toast.makeText(getActivity().getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void btnStopClicked() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
        Toast.makeText(getActivity().getApplicationContext(), "Recording stopped", Toast.LENGTH_LONG).show();
    }

    private void btnPlayListClicked(){
        Intent intent = new Intent(getActivity(), PlaylistActivity.class);
        startActivity(intent);
    }
}
