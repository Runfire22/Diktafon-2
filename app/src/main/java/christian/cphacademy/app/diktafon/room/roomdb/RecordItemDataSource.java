package christian.cphacademy.app.diktafon.room.roomdb;

import christian.cphacademy.app.diktafon.room.dao.RecordItemDAO;
import christian.cphacademy.app.diktafon.room.entity.RecordingItem;

import java.util.List;

import rx.Single;
import rx.schedulers.Schedulers;

public class RecordItemDataSource {
    private RecordItemDAO recordItemDAO;

    public RecordItemDataSource(RecordItemDAO recordingItemDAO) {
        this.recordItemDAO = recordingItemDAO;
    }

    public Single<List<RecordingItem>> getAllRecordings(){
        return Single.fromCallable(() -> recordItemDAO.getAllRecordings())
                .subscribeOn(Schedulers.io());
    }

    public Single<Boolean> insertNewRecordItemAsync(RecordingItem recordingItem){
        return Single.fromCallable(() -> recordItemDAO.insertNewRecordItem(recordingItem) > 1)
                .subscribeOn(Schedulers.io());
    }

    public long insertNewRecrdItem(RecordingItem recordingItem){
        return recordItemDAO.insertNewRecordItem(recordingItem);
    }

    public Single<Boolean> deleteRecordItemAsync(RecordingItem recordingItem){
        return Single.fromCallable(() -> recordItemDAO.deleteRecordItem(recordingItem) > 1)
                .subscribeOn(Schedulers.io());
    }

    public int deleteRecordItem(RecordingItem recordingItem){
        return recordItemDAO.deleteRecordItem(recordingItem);
    }

    public Single<Boolean> updateRecordItemAsync(RecordingItem recordingItem){
        return Single.fromCallable(() -> recordItemDAO.updateRecordItem(recordingItem) > 1)
                .subscribeOn(Schedulers.io());
    }

    public int updateRecordItem(RecordingItem recordingItem){
        return recordItemDAO.updateRecordItem(recordingItem);
    }

    public int getRecordingCount(){
        return  recordItemDAO.getCount();
    }
}
