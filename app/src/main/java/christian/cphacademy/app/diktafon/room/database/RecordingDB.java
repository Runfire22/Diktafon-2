package christian.cphacademy.app.diktafon.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import christian.cphacademy.app.diktafon.room.dao.RecordItemDAO;
import christian.cphacademy.app.diktafon.room.entity.RecordingItem;
import christian.cphacademy.app.diktafon.room.roomdb.RecordItemDataSource;

@Database(entities = {RecordingItem.class}, version = 1, exportSchema = false)
public abstract class RecordingDB extends RoomDatabase {
    public abstract RecordItemDAO recordItemDAO();

    private static final String DATABASE_NAME = "saved_recordings.db";

    private static RecordingDB recordingDBInstance;
    private RecordItemDataSource recordItemDataSource;

    public static RecordingDB getInstance(Context context){
        if (recordingDBInstance == null){
            recordingDBInstance = Room.databaseBuilder(context, RecordingDB.class, DATABASE_NAME).build();
            //recordingDBInstance.recordItemDataSource =
            //new RecordItemDataSource(recordingDBInstance.recordItemDAO());
        }
        return recordingDBInstance;
    }

    public RecordItemDataSource getRecordItemDataSource(){
        return recordItemDataSource;
    }
}
