package ro.mariantirlea.electrinv.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mti on 11-Dec-17.
 */

@Entity(
        tableName = "location",
        indices = {
                @Index(
                        value = "id"
                )
        }
)
public class Location {

    @PrimaryKey
    public long id;

    public String name;
    public String description;

    public Location(long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
