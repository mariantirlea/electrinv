package ro.mariantirlea.electrinv.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by mti on 11-Dec-17.
 */

@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addItem(Item item);

    @Query("SELECT * FROM ITEM")
    public List<Item> getAllItems();

    @Query("SELECT * FROM ITEM WHERE ID = :itemId")
    public List<Item> getItem(long itemId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateItem(Item item);

    @Query("DELETE FROM ITEM")
    void removeAllItems();
}
