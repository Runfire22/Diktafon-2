package christian.cphacademy.app.diktafon.room.dao;

import christian.cphacademy.app.diktafon.room.entity.RecordingItem;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;



@Dao
public interface RecordItemDAO {
    @Query("Select * from recordings")
    List<RecordingItem> getAllRecordings();

    @Insert
    long insertNewRecordItem(RecordingItem recordingItem);

    @Update
    int updateRecordItem(RecordingItem recordingItem);

    @Delete
    int deleteRecordItem(RecordingItem recordingItem);

    @Query("Select count() from recordings") int getCount();
}
