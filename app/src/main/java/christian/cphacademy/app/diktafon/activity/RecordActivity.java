package christian.cphacademy.app.diktafon.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;

import christian.cphacademy.app.diktafon.R;
import christian.cphacademy.app.diktafon.fragment.RecordFragment;
import pub.devrel.easypermissions.EasyPermissions;

public class RecordActivity extends Activity {
    private static final int PERMISSSION_REQ = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentFrame, RecordFragment.newInstance())
                    .commit();
        }
        getPermission();
    }

    @TargetApi(15)
    private void getPermission(){
        String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO};
        if(!EasyPermissions.hasPermissions(RecordActivity.this, permissions)){
            EasyPermissions.requestPermissions(this, getString(R.string.permission_required),
                    PERMISSSION_REQ, permissions);
        }
    }
}
