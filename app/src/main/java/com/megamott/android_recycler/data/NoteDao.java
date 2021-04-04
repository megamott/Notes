package com.megamott.android_recycler.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.megamott.android_recycler.model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Note")
    List<Note> getAll();

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllLiveData();

    @Query("SELECT * FROM Note WHERE uid IN (:noteIds)")
    List<Note> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM Note " +
           "WHERE uid = :uid LIMIT 1")
    Note findByName(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note notes);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);
}