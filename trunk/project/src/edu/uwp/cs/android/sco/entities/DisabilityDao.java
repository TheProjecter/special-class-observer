package edu.uwp.cs.android.sco.entities;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.Query;
import de.greenrobot.dao.QueryBuilder;

import edu.uwp.cs.android.sco.entities.Disability;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DISABILITY.
*/
public class DisabilityDao extends AbstractDao<Disability, Long> {

    public static final String TABLENAME = "DISABILITY";

    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Info = new Property(2, String.class, "info", false, "INFO");
        public final static Property Rating = new Property(3, Integer.class, "rating", false, "RATING");
        public final static Property StudentId = new Property(4, long.class, "studentId", false, "STUDENT_ID");
    };

    private Query<Disability> student_DisabilitiesQuery;

    public DisabilityDao(DaoConfig config) {
        super(config);
    }
    
    public DisabilityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String sql = "CREATE TABLE " + (ifNotExists? "IF NOT EXISTS ": "") + "'DISABILITY' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NAME' TEXT NOT NULL ," + // 1: name
                "'INFO' TEXT," + // 2: info
                "'RATING' INTEGER," + // 3: rating
                "'STUDENT_ID' INTEGER NOT NULL );"; // 4: studentId
        db.execSQL(sql);
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DISABILITY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Disability entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String info = entity.getInfo();
        if (info != null) {
            stmt.bindString(3, info);
        }
 
        Integer rating = entity.getRating();
        if (rating != null) {
            stmt.bindLong(4, rating);
        }
        stmt.bindLong(5, entity.getStudentId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Disability readEntity(Cursor cursor, int offset) {
        Disability entity = new Disability( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // info
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // rating
            cursor.getLong(offset + 4) // studentId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Disability entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setInfo(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRating(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setStudentId(cursor.getLong(offset + 4));
     }
    
    @Override
    protected Long updateKeyAfterInsert(Disability entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Disability entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "disabilities" to-many relationship of Student. */
    public synchronized List<Disability> _queryStudent_Disabilities(long studentId) {
        if (student_DisabilitiesQuery == null) {
            QueryBuilder<Disability> queryBuilder = queryBuilder();
            queryBuilder.where(Properties.StudentId.eq(studentId));
            student_DisabilitiesQuery = queryBuilder.build();
        } else {
            student_DisabilitiesQuery.setParameter(0, studentId);
        }
        return student_DisabilitiesQuery.list();
    }

}
