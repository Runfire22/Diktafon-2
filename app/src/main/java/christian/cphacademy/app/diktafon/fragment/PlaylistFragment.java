package christian.cphacademy.app.diktafon.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import christian.cphacademy.app.diktafon.R;


public class PlaylistFragment extends Fragment {
    private static final String LOG_TAG = "PlaylistFragment";
    private RecyclerView mPlaylistView;
    private TextView emptyLabel;
    private MediaPlayer mediaPlayer;

    public PlaylistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container);
    }
}
