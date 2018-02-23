package com.daydelight.kabukuwa;

/**
 * Created by goood on 6/8/15.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.DataStt;
import com.daydelight.kabukuwa.DuLieu;

public class dbHandler extends SQLiteOpenHelper {
    static String db_name = "qlDanhbas";
    static int db_version = 2;
    String tb_name = "Danhba";
    String _id = "id";
    String _name = "name";
    String _hang = "hang";
    String _tien = "tien";
    String _loai = "loai";
    String _live = "live";
    String _sale = "sale";
    String _tuoi = "tuoi";
    String _nuoi = "nuoi";
    String _mat = "mat";
    String _hornNo = "hornNo";
    String _horn2No = "horn2No";
    String _wingNo = "wingNo";
    String _headNo = "headNo";
    String _neckNo = "neckNo";
    String _faceNo = "faceNo";
    String _bodyNo = "bodyNo";
    String _personality = "personality";
    String _excreteS = "excreteS";
    String _satiety = "satiety";
    String _sleep = "sleep";
    String _phaseETime = "phaseETime";
    String _strength = "strength";
    String _bornTime = "bornTime";
    String _excreteB = "excreteB";
    String _form = "form";
    String _phaseTime = "phaseTime";
    String _size = "size";
    String _moisture = "moisture";
    String _health = "health";
    String _mood = "mood";
    String _clearn = "clearn";
    String _lastCleanTime = "lastCleanTime";
    String _runpaStartTime = "runpaStartTime";
    String _beetleID = "beetleID";
    String _hp = "hp";
    String _attack = "attack";
    String _criticalAttack = "criticalAttack";
    String _defense = "defense";
    String _critical = "critical";
    String _avoid = "avoid";
    String _lucky = "lucky";
    String _speed = "speed";
    String _level = "level";
    String _exp = "exp";
    String _fightsum = "_fightsum";
    String _fightwin = "_fightwin";

    String tb_stt = "Stt";
    String _idstt = "idstt";
    String _namestt = "namestt";

    String tb_showpet = "Showpet";
    String _idshowpet = "idshowpet";
    String _positionpet = "positionpet";
    String _idpetshow = "idpetshow";
    String _timeshowpet = "timeshowpet";

    String _tb_part = "Tbpart";
    String _idpart = "idpart";
    String _namepart = "namepart";
    String _sumpart = "sumpart";
    String _numpart = "numpart";
    String _usepart = "usepart";


    public dbHandler(Context context) {
        super(context, db_name, null, db_version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Part = "CREATE TABLE " + _tb_part + "(" + _idpart
                + " INTEGER PRIMARY KEY," + _namepart + " LONG," + _sumpart +
                " INTEGER," + _numpart + " INTEGER," + _usepart + " INTEGER" + ")";
        db.execSQL(CREATE_Part);
        //
        String CREATE_ShowPet = "CREATE TABLE " + tb_showpet + "(" + _idshowpet
                + " INTEGER PRIMARY KEY," + _positionpet + " INTEGER," + _idpetshow + " INTEGER," + _timeshowpet + " LONG" + ")";
        db.execSQL(CREATE_ShowPet);
        //
        String CREATE_SaveSTT = "CREATE TABLE " + tb_stt + "(" + _idstt
                + " INTEGER PRIMARY KEY," + _namestt + " INTEGER" + ")";
        db.execSQL(CREATE_SaveSTT);
        //
        String CREATE_DanhbaS_TABLE = "CREATE TABLE " + tb_name + "(" + _id
                + " INTEGER PRIMARY KEY," + _name + " TEXT," + _hang + " TEXT," + _loai + " TEXT,"
                + _live + " INTEGER," + _sale + " INTEGER," + _tuoi + " FLOAT," + _tien + " TEXT,"
                + _nuoi + " INTEGER," + _mat + " INTEGER," + _hornNo + " INTEGER," + _horn2No + " INTEGER," + _wingNo + " INTEGER,"
                + _headNo + " INTEGER," + _neckNo + " INTEGER," + _faceNo + " INTEGER," + _bodyNo + " INTEGER," +
                _personality + " INTEGER," + _excreteS + " INTEGER," + _satiety + " INTEGER," + _sleep + " INTEGER," +
                _phaseETime + " LONG," + _strength + " INTEGER," + _bornTime + " LONG," + _excreteB + " INTEGER," +
                _form + " INTEGER," + _phaseTime + " LONG," + _size + " INTEGER," + _moisture + " INTEGER," + _health + " INTEGER,"
                + _mood + " INTEGER," + _clearn + " INTEGER," + _lastCleanTime + " LONG," + _beetleID + " TEXT," + _hp + " DOUBLE,"
                + _attack + " INTEGER," + _criticalAttack + " INTEGER," + _defense + " INTEGER," + _critical + " INTEGER,"
                + _avoid + " INTEGER," + _lucky + " INTEGER," + _speed + " INTEGER," + _level + " INTEGER," + _exp + " INTEGER,"
                + _fightsum + " INTEGER," + _fightwin + " INTEGER," + _runpaStartTime + " LONG" + ")";
        db.execSQL(CREATE_DanhbaS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tb_name);
        db.execSQL("DROP TABLE IF EXISTS " + tb_stt);
        db.execSQL("DROP TABLE IF EXISTS " + tb_showpet);
        db.execSQL("DROP TABLE IF EXISTS " + _tb_part);
        onCreate(db);

    }

    // Insert Value
    public void adddata(Context context, String name, String s2, String s3, String s4, int s5, int s6,
                        float s7, int s8, int s9, int s10, int s11, int s12, int s13, int s14, int s15, int s16, int s17,
                        int s18, int s19, int s20, long s21, int s22, long s23, int s24, int s25, long s26, int s27, int s28,
                        int s29, int s30, int s31, long s32, String s33, double hp, int attack, int criticalAttack, int defense,
                        int critical, int avoid, int lucky, int speed, int level, int exp, int sum, int win, long runpaStartTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_name, name);
        values.put(_hang, s2);
        values.put(_tien, s3);
        values.put(_loai, s4);
        values.put(_live, s5);// 2: completed  0: live  1: die
        values.put(_sale, s6);
        values.put(_tuoi, s7);
        values.put(_nuoi, s8);
        values.put(_mat, s9);
        values.put(_hornNo, s10);
        values.put(_horn2No, s11);
        values.put(_wingNo, s12);
        values.put(_headNo, s13);
        values.put(_neckNo, s14);
        values.put(_faceNo, s15);
        values.put(_bodyNo, s16);
        values.put(_personality, s17);
        values.put(_excreteS, s18);
        values.put(_satiety, s19);
        values.put(_sleep, s20);
        values.put(_phaseETime, s21);
        values.put(_strength, s22);
        values.put(_bornTime, s23);
        values.put(_excreteB, s24);
        values.put(_form, s25);
        values.put(_phaseTime, s26);
        values.put(_size, s27);
        values.put(_moisture, s28);
        values.put(_health, s29);
        values.put(_mood, s30);
        values.put(_clearn, s31);
        values.put(_lastCleanTime, s32);
        values.put(_beetleID, s33);
        values.put(_hp, hp);
        values.put(_attack, attack);
        values.put(_criticalAttack, criticalAttack);
        values.put(_defense, defense);
        values.put(_critical, critical);
        values.put(_avoid, avoid);
        values.put(_lucky, lucky);
        values.put(_speed, speed);
        values.put(_level, level);
        values.put(_exp, exp);
        values.put(_fightsum, sum);
        values.put(_fightwin, win);
        values.put(_runpaStartTime, runpaStartTime);
        db.insert(tb_name, null, values);
        db.close();
    }

    // Get Row Count
    public int getCount() {
        String countQuery = "SELECT  * FROM " + tb_name + " where " + _sale + " = " + 0 + " and " + _tuoi + " >= " + 5;
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor != null && !cursor.isClosed()) {
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

    // Delete Query
    public void removeFav(int id) {
        String countQuery = "DELETE FROM " + tb_name + " where " + _id + "= "
                + id;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }


    //test
    public void removePetLive() {
        String countQuery = "DELETE FROM " + tb_name + " where " + _live + "= "
                + 0;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    // Get FavList
    public List<DuLieu> getAll() {
        String selectQuery = "SELECT  * FROM " + tb_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<DuLieu> FavList = new ArrayList<DuLieu>();
        if (cursor.moveToFirst()) {
            do {
                DuLieu list = new DuLieu();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setContent(cursor.getString(1));
                list.setHang(cursor.getString(2));
                list.setLoai(cursor.getString(3));
                list.setLive(cursor.getInt(4));
                list.setSale(cursor.getInt(5));
                list.setTuoi(cursor.getFloat(6));
                list.setTien(cursor.getString(7));
                list.setNuoi(cursor.getInt(8));
                list.setMat(cursor.getInt(9));
                list.setHornNo(cursor.getInt(10));
                list.setHorn2No(cursor.getInt(11));
                list.setWingNo(cursor.getInt(12));
                list.setHeadNo(cursor.getInt(13));
                list.setNeckNo(cursor.getInt(14));
                list.setFaceNo(cursor.getInt(15));
                list.setBodyNo(cursor.getInt(16));
                list.setPersonality(cursor.getInt(17));
                list.setExcreteS(cursor.getInt(18));
                list.setSatiety(cursor.getInt(19));
                list.setSleep(cursor.getInt(20));
                list.setPhaseETime(cursor.getInt(21));
                list.setStrength(cursor.getInt(22));
                list.setBornTime(cursor.getInt(23));
                list.setExcreteB(cursor.getInt(24));
                list.setForm(cursor.getInt(25));
                list.setPhaseTime(cursor.getInt(26));
                list.setSize(cursor.getInt(27));
                list.setMoisture(cursor.getInt(28));
                list.setHealth(cursor.getInt(29));
                list.setMood(cursor.getInt(30));
                list.setClearn(cursor.getInt(31));
                list.setLastCleanTime(cursor.getInt(32));
                list.setBeetleID(cursor.getString(33));
                list.setHp(cursor.getDouble(34));
                list.setAttack(cursor.getInt(35));
                list.setCriticalAttack(cursor.getInt(36));
                list.setDefense(cursor.getInt(37));
                list.setCritical(cursor.getInt(38));
                list.setAvoid(cursor.getInt(39));
                list.setLucky(cursor.getInt(40));
                list.setSpeed(cursor.getInt(41));
                list.setLevel(cursor.getInt(42));
                list.setExp(cursor.getInt(43));
                list.setFightsum(cursor.getInt(44));
                list.setFightwin(cursor.getInt(45));
                list.setRunpaStartTime(cursor.getLong(46));
                FavList.add(list);
            } while (cursor.moveToNext());
        }
        return FavList;
    }

    //------------------------------------
    public List<DuLieu> getPetTruongThanh() {
        String selectQuery = "SELECT  * FROM " + tb_name + " where " + _sale + " = " + 0 + " and " + _tuoi + " >= " + 5;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<DuLieu> FavList = new ArrayList<DuLieu>();
        if (cursor.moveToFirst()) {
            do {
                DuLieu list = new DuLieu();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setContent(cursor.getString(1));
                list.setHang(cursor.getString(2));
                list.setLoai(cursor.getString(3));
                list.setLive(cursor.getInt(4));
                list.setSale(cursor.getInt(5));
                list.setTuoi(cursor.getInt(6));
                list.setTien(cursor.getString(7));
                list.setNuoi(cursor.getInt(8));
                list.setMat(cursor.getInt(9));
                list.setHornNo(cursor.getInt(10));
                list.setHorn2No(cursor.getInt(11));
                list.setWingNo(cursor.getInt(12));
                list.setHeadNo(cursor.getInt(13));
                list.setNeckNo(cursor.getInt(14));
                list.setFaceNo(cursor.getInt(15));
                list.setBodyNo(cursor.getInt(16));
                list.setPersonality(cursor.getInt(17));
                list.setExcreteS(cursor.getInt(18));
                list.setSatiety(cursor.getInt(19));
                list.setSleep(cursor.getInt(20));
                list.setPhaseETime(cursor.getInt(21));
                list.setStrength(cursor.getInt(22));
                list.setBornTime(cursor.getInt(23));
                list.setExcreteB(cursor.getInt(24));
                list.setForm(cursor.getInt(25));
                list.setPhaseTime(cursor.getInt(26));
                list.setSize(cursor.getInt(27));
                list.setMoisture(cursor.getInt(28));
                list.setHealth(cursor.getInt(29));
                list.setMood(cursor.getInt(30));
                list.setClearn(cursor.getInt(31));
                list.setLastCleanTime(cursor.getInt(32));
                list.setBeetleID(cursor.getString(33));
                list.setHp(cursor.getDouble(34));
                list.setAttack(cursor.getInt(35));
                list.setCriticalAttack(cursor.getInt(36));
                list.setDefense(cursor.getInt(37));
                list.setCritical(cursor.getInt(38));
                list.setAvoid(cursor.getInt(39));
                list.setLucky(cursor.getInt(40));
                list.setSpeed(cursor.getInt(41));
                list.setLevel(cursor.getInt(42));
                list.setExp(cursor.getInt(43));
                list.setFightsum(cursor.getInt(44));
                list.setFightwin(cursor.getInt(45));
                list.setRunpaStartTime(cursor.getLong(46));
                FavList.add(list);
            } while (cursor.moveToNext());
        }
        return FavList;
    }

    //------------------------------------
    public void update(int id, int s6) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_sale, s6);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_hp(int id, double s6) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_hp, s6);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    // insert to table stt
    public void adddatastt(Context context, int name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_namestt, name);
        db.insert(tb_stt, null, values);
        db.close();
    }

    // insert to table showpet
    public void addshowpet(Context context, int name, int idpet, long time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_positionpet, name);
        values.put(_idpetshow, idpet);
        values.put(_timeshowpet, time);
        db.insert(tb_showpet, null, values);
        db.close();
    }

    // Get all position
    public List<DuLieuShowPet> getAllShowpet() {
        String selectQuery = "SELECT * FROM " + tb_showpet + " ORDER BY " + _timeshowpet + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<DuLieuShowPet> FavList = new ArrayList<DuLieuShowPet>();
        if (cursor.moveToFirst()) {
            do {
                DuLieuShowPet list = new DuLieuShowPet();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setPos(cursor.getInt(1));
                list.setIdpet(cursor.getInt(2));
                list.setTime(cursor.getLong(3));
                FavList.add(list);
            } while (cursor.moveToNext());
        }
        return FavList;
    }

    // Delete Query
    public void DeleteIconPetDeath(int name) {
        String countQuery = "DELETE FROM " + tb_stt + " where " + _namestt + "= "
                + name;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    public void removeTabSTT() {
        String countQuery = "DELETE FROM " + tb_stt;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    public void removeTabPart() {
        String countQuery = "DELETE FROM " + _tb_part;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    public void removeTabshowpet() {
        String countQuery = "DELETE FROM " + tb_showpet;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    public void removeTabshowpetWithID(int id) {
        String countQuery = "DELETE FROM " + tb_showpet + " where " + _idpetshow + " = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    public void updateTabshowpetWithPOS(int id, int pos) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_positionpet, pos);
        db.update(tb_showpet, values, _idpetshow + "=" + id, null);
    }
    public void updateTabshowpetWithTIME(int id, long time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_timeshowpet, time);
        db.update(tb_showpet, values, _idpetshow + "=" + id, null);
    }

    // delete all
    public void removeAll() {
        String countQuery = "DELETE FROM " + tb_name;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    // Get FavList
    public List<com.daydelight.kabukuwa.DataStt> getAllDataStt() {
        String selectQuery = "SELECT  * FROM " + tb_stt;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<com.daydelight.kabukuwa.DataStt> FavList = new ArrayList<com.daydelight.kabukuwa.DataStt>();
        if (cursor.moveToFirst()) {
            do {
                com.daydelight.kabukuwa.DataStt list = new com.daydelight.kabukuwa.DataStt();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setContent(cursor.getInt(1));
                FavList.add(list);
            } while (cursor.moveToNext());
        }
        return FavList;
    }

    // count
    public int getNumpet() {
        String countQuery = "SELECT  * FROM " + tb_stt;
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor != null && !cursor.isClosed()) {
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

    //
    public void addpart(Context context, long name, int sum, int num, int use) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_namepart, name);
        values.put(_sumpart, sum);
        values.put(_numpart, num);
        values.put(_usepart, use);
        db.insert(_tb_part, null, values);
        db.close();
    }

    // Get all part
    public List<TablePart> getAllPart() {
        String selectQuery = "SELECT * FROM " + _tb_part;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<TablePart> FavList = new ArrayList<TablePart>();
        if (cursor.moveToFirst()) {
            do {
                TablePart list = new TablePart();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setName(cursor.getLong(1));
                list.setSum(cursor.getInt(2));
                list.setNum(cursor.getInt(3));
                list.setUse(cursor.getInt(4));
                FavList.add(list);
            } while (cursor.moveToNext());
        }
        return FavList;
    }

    public void update_Sumpart(long name, int sum) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_sumpart, sum);
        db.update(_tb_part, values, _namepart + "=" + name, null);
    }

    public void update_Numpart(long name, int num) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_numpart, num);
        db.update(_tb_part, values, _namepart + "=" + name, null);
    }

    public void update_fittingroom(int id, int s9, int s10, int s11, int s12, int s13, int s14, int s15, int s16) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_mat, s9);
        values.put(_hornNo, s10);
        values.put(_horn2No, s11);
        values.put(_wingNo, s12);
        values.put(_headNo, s13);
        values.put(_neckNo, s14);
        values.put(_faceNo, s15);
        values.put(_bodyNo, s16);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_horn(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_hornNo, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_horn2(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_horn2No, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_face(int id, int s, int s2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_faceNo, s);
        values.put(_mat, s2);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_head(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_headNo, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_body(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_bodyNo, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_neck(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_neckNo, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_wing(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_wingNo, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_fight(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_fightsum, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_fightwin(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_fightwin, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_exp(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_exp, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

    public void update_level(int id, int s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(_level, s);
        db.update(tb_name, values, _id + "=" + id, null);
    }

}
