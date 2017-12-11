package ro.mariantirlea.electrinv.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by mti on 11-Dec-17.
 */

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLocation(Location location);

//    @Query("SELECT * FROM location WHERE itemId = :itemId")
//    List<Location> findLocationsForItem(int itemId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateLocation(Location location);

    @Query("DELETE FROM location WHERE id = :id")
    void delete(long id);
}
