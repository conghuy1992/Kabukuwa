package com.daydelight.kabukuwa;

/**
 * Created by goood on 6/8/15.
 */
public class Contact {
    // private variables
    int _id;
    String _name;
    byte[] _image;
    String _dong2;
    String _dong3;

    // Empty constructor
    public Contact() {

    }

    // constructor
    public Contact(int keyId, String name, byte[] image, String s2, String s3) {
        this._id = keyId;
        this._name = name;
        this._image = image;
        this._dong2 = s2;
        this._dong3 = s3;

    }

    // constructor
    public Contact(String name, byte[] image, String s2, String s3) {
        this._name = name;
        this._image = image;
        this._dong2 = s2;
        this._dong3 = s3;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int keyId) {
        this._id = keyId;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

    // getting phone number
    public byte[] getImage() {
        return this._image;
    }

    // setting phone number
    public void setImage(byte[] image) {
        this._image = image;
    }

    public String get_dong2() {
        return _dong2;
    }

    public void set_dong2(String _dong2) {
        this._dong2 = _dong2;
    }

    public String get_dong3() {
        return _dong3;
    }

    public void set_dong3(String _dong3) {
        this._dong3 = _dong3;
    }
}
