package christian.cphacademy.app.diktafon.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "recordings")
public class RecordingItem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String filePath;

    public RecordingItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private RecordingItem(Parcel parcel){
        name = parcel.readString();
        filePath = parcel.readString();
    }

    public static final Parcelable.Creator<RecordingItem> CREATOR =
            new Parcelable.Creator<RecordingItem>() {
                @Override
                public RecordingItem createFromParcel(Parcel source) {
                    return new RecordingItem(source);
                }

                @Override
                public RecordingItem[] newArray(int size) {
                    return new RecordingItem[size];
                }
            };

    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeString(name);
        parcel.writeString(filePath);
    }
}
