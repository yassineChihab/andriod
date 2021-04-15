package com.example.project

import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null,DB_VERSION) {

    companion object {
        private val DB_NAME = "database"
        private val DB_VERSION = 1;
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val q1 = "CREATE TABLE chapter" +
                "(chapter_id Integer PRIMARY KEY, " +
                "chapter_name TEXT)"
        db?.execSQL(q1)

        val q2 = "INSERT INTO chapter(chapter_id, chapter_name) " +
                "VALUES " +
                "(NULL, ' chapitre 1')," +
                "(NULL, ' chapitre 1')," +
                "(NULL, ' chapitre 2')," +
                "(NULL, ' chapitre 3')," +
                "(NULL, ' chapitre 4')," +
                "(NULL, ' chapitre 5')," +
                "(NULL, ' chapitre 6')," +
                "(NULL, ' chapitre 7')," +
                "(NULL, ' chapitre 8')," +
                "(NULL, ' chapitre 9')," +
                "(NULL, ' chapitre 10'),"+
                "(NULL, ' chapitre 11')," +
                "(NULL, ' chapitre 12')," +
                "(NULL, ' chapitre 13')"

        db?.execSQL(q2)
        val q3 = "CREATE TABLE question" +
                "(question_id Integer PRIMARY KEY, " +
                "question_phrase TEXT," +
                "id_chapter Integer," +
                "FOREIGN KEY(id_chapter) REFERENCES chapter(chapter_id))"
        db?.execSQL(q3)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun rawQuery(query: String?): Cursor? {
        val db = this.writableDatabase
        val mCursor: Cursor = db.rawQuery(query, null)
        mCursor?.moveToFirst()
        return mCursor
    }
    fun query(query: String): Boolean {
        val db = this.writableDatabase
        db.execSQL(query)
        db.close()
        return true;
    } // query

    // Count
    fun count(query: String): Int {
        val db = this.writableDatabase
        val numRows =
                DatabaseUtils.longForQuery(db, query, null).toInt()
        db.close()
        return numRows;
    }


}
