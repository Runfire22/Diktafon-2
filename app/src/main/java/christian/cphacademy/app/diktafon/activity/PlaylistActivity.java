package christian.cphacademy.app.diktafon.activity;


import christian.cphacademy.app.diktafon.R;
import christian.cphacademy.app.diktafon.fragment.PlaylistFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentFrame, new PlaylistFragment())
                .commit();
    }
}
