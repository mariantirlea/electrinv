package ro.mariantirlea.electrinv.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mti on 11-Dec-17.
 */

@Entity(
        tableName = "item",
        foreignKeys = {
                @ForeignKey(
                        entity = Location.class,
                        parentColumns = "id",
                        childColumns = "locationId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(
                        value = "id"
                ),
                @Index(
                        value = "locationId"
                )
        }
)
public class Item {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public long locationId;

    public String name;
    public String description;

    public Item(long locationId, String name, String description){
        this.locationId = locationId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
