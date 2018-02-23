package com.daydelight.kabukuwa;

/**
 * Created by goood on 11/12/15.
 */
public class KabukuwaBattleParameter {
    int mCategory1;
    int mCategory2;
    int mCategory3;
    int mLv;
    int mHp;
    int mAttack;
    int mCriticalAttack;
    int mDefense;
    int mCritical;
    int mAvoid;
    int mLucky;
    int mSpeed;

    public int getmCategory1() {
        return mCategory1;
    }

    public void setmCategory1(int mCategory1) {
        this.mCategory1 = mCategory1;
    }

    public int getmCategory2() {
        return mCategory2;
    }

    public void setmCategory2(int mCategory2) {
        this.mCategory2 = mCategory2;
    }

    public int getmCategory3() {
        return mCategory3;
    }

    public void setmCategory3(int mCategory3) {
        this.mCategory3 = mCategory3;
    }

    public int getmLv() {
        return mLv;
    }

    public void setmLv(int mLv) {
        this.mLv = mLv;
    }

    public int getmHp() {
        return mHp;
    }

    public void setmHp(int mHp) {
        this.mHp = mHp;
    }

    public int getmAttack() {
        return mAttack;
    }

    public void setmAttack(int mAttack) {
        this.mAttack = mAttack;
    }

    public int getmCriticalAttack() {
        return mCriticalAttack;
    }

    public void setmCriticalAttack(int mCriticalAttack) {
        this.mCriticalAttack = mCriticalAttack;
    }

    public int getmDefense() {
        return mDefense;
    }

    public void setmDefense(int mDefense) {
        this.mDefense = mDefense;
    }

    public int getmCritical() {
        return mCritical;
    }

    public void setmCritical(int mCritical) {
        this.mCritical = mCritical;
    }

    public int getmAvoid() {
        return mAvoid;
    }

    public void setmAvoid(int mAvoid) {
        this.mAvoid = mAvoid;
    }

    public int getmLucky() {
        return mLucky;
    }

    public void setmLucky(int mLucky) {
        this.mLucky = mLucky;
    }

    public int getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(int mSpeed) {
        this.mSpeed = mSpeed;
    }

    public void setZeroValue() {
        mCategory1 = 0;
        mCategory2 = 0;
        mCategory3 = 0;
        mLv = 0;
        mAttack = 0;
        mCriticalAttack = 0;
        mDefense = 0;
        mAvoid = 0;
        mLucky = 0;
        mSpeed = 0;
    }
}
