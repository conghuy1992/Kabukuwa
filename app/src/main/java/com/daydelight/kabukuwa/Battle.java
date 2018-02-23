package com.daydelight.kabukuwa;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;


public class Battle extends Activity implements View.OnClickListener {
    String tempid = "", tempdis = "", tempjewel = "", temprarity = "", tempnumitem = "", tempcoin = "";
    public static ArrayList<String> Supplement_hp;
    public static ArrayList<String> Supplement_attack;
    public static ArrayList<String> Supplement_criticalAttack;
    public static ArrayList<String> Supplement_defense;
    public static ArrayList<String> Supplement_critical;
    public static ArrayList<String> Supplement_avoid;
    public static ArrayList<String> Supplement_lucky;
    public static ArrayList<String> Supplement_species;
    boolean bsound = false;
    public static MediaPlayer soundbg;
    private PublisherAdView mAdView;
    int lifeMax, friendlyMax, personalityMax, formMax, strengthMax;
    String name = "";
    ImageView easy, normal, hard, king, imgback, f_coin, f_jewel, f_shin1, f_shin2,
            confetti1, confetti2, confetti3, confetti4, confetti5, confetti6, confetti7;
    AnimationDrawable anim_coin, anim_jewel, anim_shin1, anim_shin2;
    int subKind, subKind_pl, kind, imagoCurStamina, inKind;
    int defHP, attack, attackCritical, defense, critical, avoid, lucky, speed;
    ListBattle _ListBattle;
    ArrayList<Integer> arrStamina;
    ArrayList<Integer> star;
    ArrayList<Integer> arrLevel;

    public static ArrayList<String> itemDes = null;
    ArrayList<Integer> id_item;
    ArrayList<String> id_des;
    public static ArrayList<String> list_name;
    ArrayList<String> id_desbattle;
    ProgressIndicator indicator;
    int CPU_species;
    int parts_Category1, parts_Category2, parts_Category3, parts_Lv, parts_hp, parts_attack, parts_CriticalAttack,
            parts_Defense, parts_Critical, parts_Avoid, parts_Lucky, parts_Speed;

    int param_Category1, param_Category2, param_Category3, param_Lv, param_hp, param_attack, param_CriticalAttack,
            param_Defense, param_Critical, param_Avoid, param_Lucky, param_Speed;
    int param_Category1_supplement, param_Category2_supplement, param_Category3_supplement, param_Lv_supplement, param_hp_supplement,
            param_attack_supplement, param_CriticalAttack_supplement, param_Defense_supplement, param_Critical_supplement,
            param_Avoid_supplement, param_Lucky_supplement, param_Speed_supplement;
    int setup_Lv, setup_hp, setup_attack, setup_CriticalAttack,
            setup_Defense, setup_Critical, setup_Avoid, setup_Lucky, setup_Speed;
    int setup_Lv_supplement, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement, setup_Defense_supplement,
            setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement, setup_Speed_supplement;
    int setup_parts_Category1, setup_parts_Category2, setup_parts_Category3, setup_parts_Lv, setup_parts_hp, setup_parts_attack, setup_parts_CriticalAttack,
            setup_parts_Defense, setup_parts_Critical, setup_parts_Avoid, setup_parts_Lucky, setup_parts_Speed;
    private long mLastClickTime = 0;
    int dPartsIndex_Horn = 0,
            dPartsIndex_Horn2 = 1,
            dPartsIndex_Head = 2,
            dPartsIndex_Face = 3,
            dPartsIndex_Neck = 4,
            dPartsIndex_Body = 5,
            dPartsIndex_Wing = 6;
    int imagoHornRank,
            imagoHorn2Rank,
            imagoHeadRank,
            imagoFaceRank,
            imagoNeckRank,
            imagoBodyRank,
            imagoWingRank,
            imagoCurHpPercent;
    int mCategory1 = 0,
            mCategory2 = 0,
            mCategory3 = 0,
            mLv = 0,
            mAttack = 0,
            mCriticalAttack = 0,
            mDefense = 0,
            mAvoid = 0,
            mLucky = 0,
            mSpeed = 0;
    String part_horn = "", part_horn2 = "", part_head = "", part_face = "", part_neck = "", part_body = "", part_wing = "";

    int imagoLevel, imagoDropPartsIndex, rank;
    ArrayList<Integer> partsIndexes = null;
    ArrayList<Integer> arr_imagoDropPartsIndex = null;
    ArrayList<Integer> id_Index = null;

    ArrayList<String> arr_horn;
    ArrayList<String> arr_horn2;
    ArrayList<String> arr_wing;
    ArrayList<String> arr_neck;
    ArrayList<String> arr_face;
    ArrayList<String> arr_body;
    ArrayList<String> arr_head;
    ArrayList<Integer> arr_subkind;

    public static ArrayList<Integer> head_cpu;
    public static ArrayList<Integer> horn_cpu;
    public static ArrayList<Integer> horn2_cpu;
    public static ArrayList<Integer> wing_cpu;
    public static ArrayList<Integer> body_cpu;
    public static ArrayList<Integer> neck_cpu;
    public static ArrayList<Integer> face_cpu;

    ArrayList<Integer> temp_head_cpu;
    ArrayList<Integer> temp_horn_cpu;
    ArrayList<Integer> temp_horn2_cpu;
    ArrayList<Integer> temp_wing_cpu;
    ArrayList<Integer> temp_body_cpu;
    ArrayList<Integer> temp_neck_cpu;
    ArrayList<Integer> temp_face_cpu;

    public void setZeroValue() {
        s_at = 0;
        s_hp = 0;
        s_criat = 0;
        s_de = 0;
        s_cri = 0;
        s_avoid = 0;
        s_luc = 0;
        s_spe = 0;
    }

    public String get_part(int subKind, int part, int position) {
        String part_kind = "";
        if ((part == 4 && subKind == 0) || (part == 4 && subKind == 2) || (part == 4 && subKind == 3) || (part == 4 && subKind == 1003)) {
            if (position > 2 && position != 10)
                position = 2;
        } else if ((part == 4 && subKind == 1000) || (part == 4 && subKind == 1001) || (part == 4 && subKind == 1002)) {
            if (position > 1 && position != 10)
                position = 1;
        }
        if (subKind == 0) {
            if (position < 10)
                part_kind = "100" + part + "0" + position;
            else if (position >= 10)
                part_kind = "100" + part + position;
        } else if (subKind == 1) {
            if (position < 10)
                part_kind = "101" + part + "0" + position;
            else if (position >= 10)
                part_kind = "101" + part + position;
        } else if (subKind == 2) {
            if (position < 10)
                part_kind = "102" + part + "0" + position;
            else if (position >= 10)
                part_kind = "102" + part + position;
        } else if (subKind == 3) {
            if (position < 10)
                part_kind = "103" + part + "0" + position;
            else if (position >= 10)
                part_kind = "103" + part + position;
        } else if (subKind == 1000) {
            if (position < 10)
                part_kind = "110" + part + "0" + position;
            else if (position >= 10)
                part_kind = "110" + part + position;
        } else if (subKind == 1001) {
            if (position < 10)
                part_kind = "111" + part + "0" + position;
            else if (position >= 10)
                part_kind = "111" + part + position;
        } else if (subKind == 1002) {
            if (position < 10)
                part_kind = "112" + part + "0" + position;
            else if (position >= 10)
                part_kind = "112" + part + position;
        } else if (subKind == 1003) {
            if (position < 10)
                part_kind = "113" + part + "0" + position;
            else if (position >= 10)
                part_kind = "113" + part + position;
        }
        return part_kind;
    }

    public int expendingStaminaAtCPULevelRegion(int inLevelRegion, int inIndex) {
        int minStaminaInLevel = 0;
        int maxStaminaInLevel = 100;
        int numOfCPUInLevel = Chat.dNumOfCPUForEasy;
        int result = 100;
        switch (inLevelRegion) {
            case 0: {
                minStaminaInLevel = 1;
                maxStaminaInLevel = 20;
                numOfCPUInLevel = Chat.dNumOfCPUForEasy;
            }
            break;
            case 1: {
                minStaminaInLevel = 30;
                maxStaminaInLevel = 50;
                numOfCPUInLevel = Chat.dNumOfCPUForNormal;
            }
            break;
            case 2: {
                minStaminaInLevel = 60;
                maxStaminaInLevel = 80;
                numOfCPUInLevel = Chat.dNumOfCPUForHard;
            }
            break;
            default:
            case 3: {
                minStaminaInLevel = 99;
                maxStaminaInLevel = 99;
                numOfCPUInLevel = Chat.dNumOfCPUForKing;
            }
            break;
        }
        if (inIndex <= 0)
            result = minStaminaInLevel;
        else if (inIndex >= (numOfCPUInLevel - 1))
            result = maxStaminaInLevel;
        else
            result = minStaminaInLevel + (int) Math.round((double) (maxStaminaInLevel - minStaminaInLevel) / (double) (numOfCPUInLevel - 1) * (double) inIndex);
        return (result);
    }

    public void makeSelectionContentsAtLevel(int inLevelRegion) {
        int numOfCPU = Chat.dNumOfCPUForEasy;
        if (inLevelRegion == 0)
            numOfCPU = Chat.dNumOfCPUForEasy;
        else if (inLevelRegion == 1)
            numOfCPU = Chat.dNumOfCPUForNormal;
        else if (inLevelRegion == 2)
            numOfCPU = Chat.dNumOfCPUForHard;
        else if (inLevelRegion == 3)
            numOfCPU = Chat.dNumOfCPUForKing;
        for (int index = 0; index < numOfCPU; ++index) {
            makeEnemyBeetleAtLevel(inLevelRegion, index, numOfCPU);
            int stamina = expendingStaminaAtCPULevelRegion(inLevelRegion, index);
            arrStamina.add(stamina);
        }
    }

    public int itemIdOfSubKind(int inSubKind, int inPartsIndex, int inRank) {
        int itemId = Chat.kShopItemNo_Parts_Imago_Start;
        // 10000の位はカブトムシかクワガタか
        itemId += (inSubKind / 1000) * 10000;
        // 1000の位は0=カブトムシ/コクワガタ、1=コーカサス/オオクワガタ、2=サタン/ギラファ、3=ヘラクレス/オウゴンオニクワガタ
        itemId += (inSubKind % 1000) * 1000;
        // 100の位はパーツNo
        itemId += inPartsIndex * 100;
        // 10の二桁はパーツのランク
        itemId += inRank;
        return (itemId);
    }

    String beetleEnemyNameStringAtSubKind(int inSubKind) {
        String name = "";
        switch (inSubKind) {
            case 0:
            default:
                name = "カブトムシ";
                break;
            case 1:
                name = "コーカサス";
                break;
            case 2:
                name = "サタン";
                break;
            case 3:
                name = "ヘラクレス";
                break;
            case 1000:
                name = "コクワ";
                break;
            case 1001:
                name = "オオクワ";
                break;
            case 1002:
                name = "ギラファ";
                break;
            case 1003:
                name = "オニクワ";
                break;
        }
        return name;
    }

    boolean beetleHasBackHornAtSubKind(int inSubKind) {
        switch (inSubKind) {
            case 1:
            case 2:
            case 3:
                return true;
        }
        return false;
    }

    public void makeEnemyBeetleAtLevel(int inLevelRegion, int inTableIndex, int inNumTables) {
        int levelTable[][] = {
                {0, 1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 12, 14, 16, 18, 20},
                {22, 24, 28, 32, 36, 40, 44, 48},
                {50, 55, 60, 65, 70, 75, 80, 85}
        };
        int rank = inTableIndex / (inNumTables / 8);
        if (rank >= 8)
            rank = 7;
        imagoLevel = levelTable[inLevelRegion][rank];
        arrLevel.add(imagoLevel);
//        Log.e("imagoLevel", "" + imagoLevel);
        // レベルにより、種類を選定
        int subKindTable[][] =
                {
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                        },
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                                Chat.kBeetleSubKind_Satanas,
                                Chat.kBeetleSubKind_ProsopocoilusGiraffa,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                        },
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_Satanas,
                                Chat.kBeetleSubKind_Hercules,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                                Chat.kBeetleSubKind_ProsopocoilusGiraffa,
                                Chat.kBeetleSubKind_AllotopusRosenbergi,
                        },
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_Satanas,
                                Chat.kBeetleSubKind_Hercules,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                                Chat.kBeetleSubKind_ProsopocoilusGiraffa,
                                Chat.kBeetleSubKind_AllotopusRosenbergi,
                        },
                };
        subKind = subKindTable[inLevelRegion][new Random().nextInt(8)];
//        Log.e("subKind", "" + subKind);
        arr_subkind.add(subKind);
        kind = subKind / 1000;
        name = beetleEnemyNameStringAtSubKind(subKind);
        list_name.add(name);
        imagoCurStamina = 1000;    // 敵のスタミナは意味がないので仮設定でよい
        CPU_species = Chat.convertSpeciesValue(subKind);
//        Log.e("inKind", "" + inKind);
        // ツノ
        int hornTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoHornRank = hornTable[inLevelRegion][rank];
        part_horn = get_part(subKind, 0, imagoHornRank);
        arr_horn.add(part_horn);
        horn_cpu.add(imagoHornRank);
//        Log.e("part_horn", "" + part_horn);
        // ツノ２
        int horn2Table[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoHorn2Rank = horn2Table[inLevelRegion][rank];
        horn2_cpu.add(imagoHorn2Rank);
        if (beetleHasBackHornAtSubKind(subKind)) {
            part_horn2 = get_part(subKind, 1, imagoHorn2Rank);
            arr_horn2.add(part_horn2);
        }
        if (!beetleHasBackHornAtSubKind(subKind)) {
            arr_horn2.add("111222"); // dont exist id 111222
        }
        // ヘッド
        int headTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoHeadRank = headTable[inLevelRegion][rank];
        part_head = get_part(subKind, 2, imagoHeadRank);
        arr_head.add(part_head);
        head_cpu.add(imagoHeadRank);
//        Log.e("part_head", "" + part_head);
        // 顔
        int faceTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 2, 3, 1, 2, 3, 1, 2},
                        {3, 4, 3, 4, 3, 4, 3, 4},
                        {4, 10, 4, 10, 4, 10, 4, 10},    // 10はアルビノ
                };
        imagoFaceRank = faceTable[inLevelRegion][rank];
        part_face = get_part(subKind, 3, imagoFaceRank);
        arr_face.add(part_face);
        face_cpu.add(imagoFaceRank);
        // 首
        int neckTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 2, 3, 1, 2, 3, 1, 2},
                        {3, 3, 3, 3, 3, 3, 3, 3},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoNeckRank = neckTable[inLevelRegion][rank];
        part_neck = get_part(subKind, 4, imagoNeckRank);
        arr_neck.add(part_neck);
        if ((subKind == 0) || (subKind == 2) || (subKind == 3) || (subKind == 1003)) {
            if (imagoNeckRank > 2 && imagoNeckRank != 10)
                imagoNeckRank = 2;
        }
        if ((subKind == 1000) || (subKind == 1001) || (subKind == 1002)) {
            if (imagoNeckRank > 1 && imagoNeckRank != 10)
                imagoNeckRank = 1;
        }
        neck_cpu.add(imagoNeckRank);
        // 体
        int bodyTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoBodyRank = bodyTable[inLevelRegion][rank];
        part_body = get_part(subKind, 5, imagoBodyRank);
        arr_body.add(part_body);
        body_cpu.add(imagoBodyRank);
        // ハネ
        int wingTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 2, 3, 1, 2, 3, 1, 2},
                        {3, 3, 3, 3, 3, 3, 3, 3},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoWingRank = wingTable[inLevelRegion][rank];
        part_wing = get_part(subKind, 6, imagoWingRank);
        arr_wing.add(part_wing);
        wing_cpu.add(imagoWingRank);
        int _lv = imagoLevel + 1;
        maxParamObj(_lv, CPU_species);
//        int maxParam = totalParam(obj_hp, obj_attack, obj_attackCritical, obj_defence, obj_critical, obj_avoid, obj_lucky, obj_speed);
        int maxParam = 6120;
//        Log.e("maxParam",""+maxParam);
        int cpu_hp = _returnHp2(setup_hp, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement, setup_Defense_supplement,
                setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement, setup_Speed_supplement, s_hp, subKind);
        int cpu_attack = _returnAttack2(setup_attack, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, s_at, subKind);
        int _cc = s_criat / 2;
        int cpu_atcri = _returnAttackCri2(setup_CriticalAttack, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, _cc, subKind);
        int cpu_def = _returnDefence2(setup_Defense, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, s_de, subKind);
        int cpu_cri = _returnCritical2(setup_Critical, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, s_cri, subKind);
        int cpu_avoid = _returnAvoid2(setup_Avoid, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, s_avoid, subKind);
        int cpu_lucky = _returnLucky2(setup_Lucky, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, s_luc, subKind);
        int cpu_speed = _return2(setup_Speed, setup_hp_supplement, setup_attack_supplement, setup_CriticalAttack_supplement,
                setup_Defense_supplement, setup_Critical_supplement, setup_Avoid_supplement, setup_Lucky_supplement,
                setup_Speed_supplement, s_spe, subKind);
//        Log.e("TAG", "" + cpu_hp + "-" + cpu_attack + "-" + cpu_atcri + "-" + cpu_def +
//                "-" + cpu_cri + "-" + cpu_avoid + "-" + cpu_lucky + "-" + cpu_speed);
        arr_s_hp.add(cpu_hp);
        arr_s_at.add(cpu_attack);
        arr_s_criat.add(cpu_atcri);
        arr_s_de.add(cpu_def);
        arr_s_cri.add(cpu_cri);
        arr_s_avoid.add(cpu_avoid);
        arr_s_luc.add(cpu_lucky);
        arr_s_spe.add(cpu_speed);
        int beetleParam = totalParam(cpu_hp, cpu_attack, cpu_atcri, cpu_def, cpu_cri, cpu_avoid, cpu_lucky, cpu_speed);
//        Log.e("beetleParam","beetleParam:"+beetleParam);
        int numOfStar = (int) Math.round((double) beetleParam / (double) maxParam * 24.0);
        if (numOfStar <= 0)
            numOfStar = 1;
        if (numOfStar > 8)
            numOfStar = 8;
        star.add(numOfStar);
        imagoCurHpPercent = 100;
        partsIndexes.add(0);
        if (beetleHasBackHornAtSubKind(subKind))
            partsIndexes.add(1);
        partsIndexes.add(2);
        partsIndexes.add(3);
        partsIndexes.add(4);
        partsIndexes.add(5);
        if (wingNosale > 0)
            partsIndexes.add(6);
        while (1 < 2) {
            int _size = partsIndexes.size();
            int targetIndex = new Random().nextInt(_size);
            imagoDropPartsIndex = partsIndexes.get(targetIndex);
            int rank_item = partsRankAtPartsIndex(imagoDropPartsIndex);
            int item = itemIdOfSubKind(subKind, imagoDropPartsIndex, rank_item);
//            id_Index.add(item);
            if (itemInfoAtId(item))
                break;
            else {
//                Log.e("TAG", "part does'nt exist.   -   " + "item: " + item);
            }
        }
        arr_imagoDropPartsIndex.add(imagoDropPartsIndex);
    }

    public boolean itemInfoAtId(int inItemId) {
        for (int i = 0; i < id_item.size(); i++) {
            int a = id_item.get(i);
            if (a == inItemId) {
                id_desbattle.add(id_des.get(i));
                return true;
            }
        }
        return false;
    }

    public int partsRankAtPartsIndex(int inPartsIndex) {
        switch (inPartsIndex) {
            case 0:
                return imagoHornRank;
            case 1:
                return imagoHorn2Rank;
            case 2:
                return imagoHeadRank;
            case 3:
                return imagoFaceRank;
            case 4:
                return imagoNeckRank;
            case 5:
                return imagoBodyRank;
            case 6:
                return imagoWingRank;
        }
        return (0);
    }

    Handler handler;
    FrameLayout confetti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_layout);
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        handler = new Handler();
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Intent intent = getIntent();
        String g = intent.getStringExtra("dialog");
        if (g.equals("mp")) {
            _initView();
        } else {
            finish();
        }
    }

    @Override
    protected void onPause() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("theluc", mypage.theluc);
        editor.putInt("fightsum", 0);
        editor.putInt("win", 0);
        editor.putInt("joinbattle", 0);
        editor.commit();
        super.onPause();
        for (int i = 0; i < confetti.getChildCount(); i++) {
            View view = confetti.getChildAt(i);
            view.clearAnimation();
        }
        confetti.removeAllViews();
        bsound = true;
        flaganim.set(false);
        if (mAdView != null) {
            mAdView.pause();
        }
        try {
//            if (isApplicationSentToBackground(this)) {
            if (soundbg.isPlaying()) {
                soundbg.pause();
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void _getnumitem() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        _FOOD = pre.getInt("01001", 0);
        _FOODBIG = pre.getInt("01003", 0);
        _FOODBIG2 = pre.getInt("01013", 0);
        _FOODBIG3 = pre.getInt("01014", 0);
        _FOODBIG4 = pre.getInt("01011", 0);
        _FOODBIG5 = pre.getInt("01012", 0);
        _FOODBIG6 = pre.getInt("03003", 0);
        _FOODBIG7 = pre.getInt("01015", 0);
        _FOODBIG8 = pre.getInt("01016", 0);
        _DRINK = pre.getInt("00001", 0);
        _DRINKBIG = pre.getInt("00003", 0);
        _ITEM = pre.getInt("03001", 0);
        _ITEMBIG = pre.getInt("03002", 0);
        _ITEMBIG2 = pre.getInt("03004", 0);
        _ITEMBIG3 = pre.getInt("03005", 0);
        _ITEMBIG4 = pre.getInt("03006", 0);
        _ITEMBIG5 = pre.getInt("03007", 0);
        _ITEMGOLD = pre.getInt("03008", 0);

    }

    public static int cur_CPU, cur_CPU2, cur_CPU3, inLevelRegion;
    int normal_cpu, hard_cpu;

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        _getnumitem();
        _setInfor();
        flaganim.set(true);
        bsound = false;
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        int smoney = pre.getInt("money", 0);
        int sjewel = pre.getInt("jewel", 0);
        String yourFormattedString = formatter.format(smoney);
        formatcoin.setText(yourFormattedString);
        formatjewel.setText(formatter.format(sjewel));
        cur_CPU = pre.getInt("cur_CPU", 0);
        cur_CPU2 = pre.getInt("cur_CPU2", 0);
        cur_CPU3 = pre.getInt("cur_CPU3", 0);
        normal_cpu = pre.getInt("normal_cpu", 0);
        hard_cpu = pre.getInt("hard_cpu", 0);
        if (pre.getInt("joinbattle", 0) == 1) {
            mypage._fightSum += 1;
            if (pre.getInt("win", 0) == 1) {
//                mypage._fightWin += 1;
                fighttext.setText("" + mypage._fightSum + "戦 " + mypage._fightWin + "勝");
            } else if (pre.getInt("win", 0) == 0) {
                fighttext.setText("" + mypage._fightSum + "戦 " + mypage._fightWin + "勝");
            }
        }

        if (mAdView != null) {
            mAdView.resume();
        }
        try {
            if (pre.getBoolean("sound", true) == true) {
                soundbg.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (chooseLevel != null) {
            _ListBattle.notifyDataSetChanged();
        }
        if (pre.getString("gotomypage", "").equals("gotomypage")) {
            finish();
        }
    }

    TextView txtyesbutton;

    public void shownotifyWhenBuy() {
        final Dialog dialogwhenbuy = new Dialog(Battle.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogwhenbuy.dismiss();
            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();
    }

    ImageView c_battle_title;
    Dialog chooseLevel;

    public void Dialog_chooseLevel() {
        chooseLevel = new Dialog(Battle.this);
        chooseLevel.requestWindowFeature(Window.FEATURE_NO_TITLE);
        chooseLevel.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        chooseLevel.setContentView(R.layout.battle_dialog);
        ImageView imgback = (ImageView) chooseLevel.findViewById(R.id.imgback);
        c_battle_title = (ImageView) chooseLevel.findViewById(R.id.c_battle_title);
        if (inLevelRegion == 1)
            c_battle_title.setImageResource(R.drawable.c_battle_title_normal);
        else if (inLevelRegion == 2)
            c_battle_title.setImageResource(R.drawable.c_battle_title_hard);
        else if (inLevelRegion == 3)
            c_battle_title.setImageResource(R.drawable.c_battle_title_king);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                id_Index.clear();
                id_desbattle.clear();
                arrStamina.clear();
                star.clear();
                list_name.clear();
                arr_horn.clear();
                arr_horn2.clear();
                arr_head.clear();
                arr_body.clear();
                arr_face.clear();
                arr_neck.clear();
                arr_wing.clear();
                arrLevel.clear();
                horn_cpu.clear();
                horn2_cpu.clear();
                head_cpu.clear();
                wing_cpu.clear();
                body_cpu.clear();
                neck_cpu.clear();
                face_cpu.clear();
                arr_s_at.clear();
                arr_s_hp.clear();
                arr_s_criat.clear();
                arr_s_de.clear();
                arr_s_cri.clear();
                arr_s_avoid.clear();
                arr_s_luc.clear();
                arr_s_spe.clear();
                arr_subkind.clear();
                chooseLevel.dismiss();
            }
        });
        chooseLevel.setCanceledOnTouchOutside(false);
        makeSelectionContentsAtLevel(inLevelRegion);
        _ListBattle = new ListBattle(this, arrStamina, star, id_desbattle, list_name,
                arr_horn, arr_horn2, arr_head, arr_face, arr_neck, arr_body, arr_wing);
        ListView listeasy = (ListView) chooseLevel.findViewById(R.id.listeasy);
        listeasy.setAdapter(_ListBattle);
        listeasy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
//                if (pre.getInt("joinbattle", 0) == 1) {
//                    if (SystemClock.elapsedRealtime() - mLastClickTime < 3000) {
//                        return;
//                    }
//                    mLastClickTime = SystemClock.elapsedRealtime();
//                } else {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
//                }
                if (inLevelRegion == 0) {
                    if (position <= cur_CPU) {
                        if (mypage.theluc < arrStamina.get(position)) {
                            shownotifyWhenBuy();
                            txtyesbutton.setText("スタミナが不足しています。");
                        } else {
                            _click = position;
                            _tempstamina = arrStamina.get(position);
                            lv = arrLevel.get(position) + 1;
                            ChooseBattle();
                            txtcontent.setText("" + list_name.get(position) + " Lv." + lv + " と戦いますか？");
                        }
                    }
                } else if (inLevelRegion == 1) {
                    if (position <= cur_CPU2) {
                        if (mypage.theluc < arrStamina.get(position)) {
                            shownotifyWhenBuy();
                            txtyesbutton.setText("スタミナが不足しています。");
                        } else {
                            _click = position;
                            _tempstamina = arrStamina.get(position);
                            lv = arrLevel.get(position) + 1;
                            ChooseBattle();
                            txtcontent.setText("" + list_name.get(position) + " Lv." + lv + " と戦いますか？");
                        }
                    }
                } else if (inLevelRegion == 2) {
                    if (position <= cur_CPU3) {
                        if (mypage.theluc < arrStamina.get(position)) {
                            shownotifyWhenBuy();
                            txtyesbutton.setText("スタミナが不足しています。");
                        } else {
                            _click = position;
                            _tempstamina = arrStamina.get(position);
                            lv = arrLevel.get(position) + 1;
                            ChooseBattle();
                            txtcontent.setText("" + list_name.get(position) + " Lv." + lv + " と戦いますか？");
                        }
                    }
                }

            }
        });
        chooseLevel.show();
//        for (int i = 0; i < arr_neck.size(); i++) {
//            Log.e("arr_neck", "" + arr_neck.get(i));
//        }
//        for (int i = 0; i < arr_horn2.size(); i++) {
//            Log.e("arr_horn2", "" + arr_horn2.get(i));
//        }
    }

    public static int _click, lv;
    int _tempstamina = 0;

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v == imgback)
            finish();
        else if (v == easy) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            inLevelRegion = 0;
            Dialog_chooseLevel();
        } else if (v == normal) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 2000) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            inLevelRegion = 1;
            if (normal_cpu == 0) {
                shownotifyWhenBuy();
                txtyesbutton.setText("EASYを全てクリアするとNORMALが選べます。");
            } else if (normal_cpu != 0)
                Dialog_chooseLevel();
        } else if (v == hard) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            inLevelRegion = 2;
            if (hard_cpu == 0) {
                shownotifyWhenBuy();
                txtyesbutton.setText("NORMALを全てクリアするとHARDが選べます。");
            } else if (hard_cpu != 0)
                Dialog_chooseLevel();
        } else if (v == king) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            inLevelRegion = 3;
            shownotifyWhenBuy();
            txtyesbutton.setText("KINGは現在準備中です。開催をお楽しみに！");
        } else if (v == img_menu) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            _ShowDialog();
        } else if (v == img_shop) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            Intent intent = new Intent(Battle.this, shop.class);
            intent.putExtra("dialog", "battle");
            intent.putExtra("flag", "battle");
            intent.putExtra("namesell", namesell);
            intent.putExtra("_hp", _hp);
            intent.putExtra("hangsell", hangsell);
            intent.putExtra("loaisale", loaisale);
            intent.putExtra("wingNosale", wingNosale);
            intent.putExtra("faceNosale", faceNosale);
            intent.putExtra("neckNosale", neckNosale);
            intent.putExtra("matsale", matsale);
            intent.putExtra("bodyNosale", bodyNosale);
            intent.putExtra("horn2Nosale", horn2Nosale);
            intent.putExtra("hornNosale", hornNosale);
            intent.putExtra("headNosale", headNosale);
            intent.putExtra("_level", _level);
            startActivity(intent);
        } else if (v == mochimono) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            Dialog_Mochimono();
        } else if (v == btnimgbreeding) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            SharedPreferences.Editor editor = pre.edit();
            String ten1 = pre.getString("tenzukan", "");
            String ten2 = pre.getString("tenzukan2", "");
            String ten3 = pre.getString("tenzukan3", "");
            String ten4 = pre.getString("tenzukan4", "");
            String ten5 = pre.getString("tenzukan5", "");
            String ten6 = pre.getString("tenzukan6", "");
            String ten7 = pre.getString("tenzukan7", "");
            String ten8 = pre.getString("tenzukan8", "");
            if (ten1.length() > 0 || ten2.length() > 0 || ten3.length() > 0 || ten4.length() > 0
                    || ten5.length() > 0 || ten6.length() > 0 || ten7.length() > 0 || ten8.length() > 0) {
                Intent intent = new Intent(Battle.this, zukan_main.class);
                intent.putExtra("flag", "mypage");
                startActivity(intent);
                finish();
            } else if (ten1.length() == 0 || ten2.length() == 0 || ten3.length() == 0 || ten4.length() == 0
                    || ten5.length() == 0 || ten6.length() == 0 || ten7.length() == 0 || ten8.length() == 0) {
                DialogCreatePet();
            }
        } else if (v == imggacha) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            v.startAnimation(mypage.animScale);
            Intent intent = new Intent(Battle.this, Gacha.class);
            intent.putExtra("flag", "battle");
            startActivity(intent);
        } else if (v == imgfriend) {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                return;
            }
            v.startAnimation(mypage.animScale);
            mLastClickTime = SystemClock.elapsedRealtime();
            _btnFriend();
        }
    }

    public void DialogCreatePet() {
        final Dialog dialog = new Dialog(Battle.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.createpet);
        Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
        Button btnno = (Button) dialog.findViewById(R.id.btnno);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialog.cancel();
                Create_Character();
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    Dialog createcharacter, mcustomdialog;
    EditText editText;

    public void Create_Character() {
        createcharacter = new Dialog(Battle.this);
        createcharacter.requestWindowFeature(Window.FEATURE_NO_TITLE);
        createcharacter.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        createcharacter.setContentView(R.layout.createcharacter_layout);
        editText = (EditText) createcharacter.findViewById(R.id.editText);
        ImageView imageViewback = (ImageView) createcharacter.findViewById(R.id.imageView12);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    return;
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    return;
                } else {
                    final Dialog dialogchange = new Dialog(Battle.this);
                    dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogchange.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialogchange.setContentView(R.layout.dialog_change);
                    dialogchange.setCanceledOnTouchOutside(false);
                    TextView txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
                    txtcontent.setText("[" + editText.getText().toString() + "]" + " でよろしいですか？");
                    ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
                    ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
                    btnyes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                            CreateNewPet();
                            createcharacter.dismiss();
                        }
                    });
                    btnno.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                        }
                    });
                    dialogchange.show();
//                    createcharacter.dismiss();
                }
            }
        });
        Button btnOK = (Button) createcharacter.findViewById(R.id.button15);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    return;
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    return;
                } else {
                    final Dialog dialogchange = new Dialog(Battle.this);
                    dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogchange.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialogchange.setContentView(R.layout.dialog_change);
                    dialogchange.setCanceledOnTouchOutside(false);
                    TextView txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
                    txtcontent.setText("[" + editText.getText().toString() + "]" + " でよろしいですか？");
                    ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
                    ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
                    btnyes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                            CreateNewPet();
                            createcharacter.dismiss();
                        }
                    });
                    btnno.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                        }
                    });
                    dialogchange.show();
//                    createcharacter.dismiss();
                }
            }
        });
        createcharacter.setCanceledOnTouchOutside(false);
        createcharacter.show();
    }

    public void ShowCustomDialog() {
        try {
            mcustomdialog = new Dialog(Battle.this);
            mcustomdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mcustomdialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mcustomdialog.setCanceledOnTouchOutside(false);
            mcustomdialog.setContentView(R.layout.dialog_item);
            mcustomdialog.show();
        } catch (Exception ex) {
        }
    }

    public void HideCustomDiaglog() {
        try {
            mcustomdialog.dismiss();
        } catch (Exception ex) {
        }
    }

    JSONParser jsonParser = new JSONParser();

    private void CreateNewPet() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int gio = c.get(Calendar.HOUR);
        int phut = c.get(Calendar.MINUTE);
        int giay = c.get(Calendar.SECOND);
        String str = "" + year;
        String str2 = str.substring(2, 4);
        String stringID = "" + str2 + month + date + gio + phut + giay;
//                    Intent intent = new Intent(Battle.this, story.class);
//                    startActivity(intent);
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        boolean dataonhanvat = true;
        long bornTime = System.currentTimeMillis() / 1000;
        editor.putLong("bornTime", bornTime);
        if (!dataonhanvat) {
            editor.putString("tenzukan", "");
        } else {
            editor.putBoolean("dataonhanvat", dataonhanvat);
            editor.putString("tenzukan", editText.getText().toString());
            editor.putString("tenhis", editText.getText().toString());
            editor.putString("id", stringID);
            editor.putString("create", "create");
            editor.commit();
            db.adddatastt(getApplicationContext(), 1);
        }
        editor.commit();

    }

    public void _ShowDialog() {
        final Dialog dialog = new Dialog(Battle.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.layout_menudetail);
        Button img = (Button) dialog.findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialog.dismiss();
            }
        });

        TextView button = (TextView) dialog.findViewById(R.id.button);
        TextView button2 = (TextView) dialog.findViewById(R.id.button2);
        TextView button3 = (TextView) dialog.findViewById(R.id.button3);
        TextView button4 = (TextView) dialog.findViewById(R.id.button4);
        TextView button5 = (TextView) dialog.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(Battle.this, DesLevel.class);
                    intent.putExtra("flag", "battle");
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(Battle.this, mypageMenu2.class);
                    startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(Battle.this, mypageMenu3.class);
                    startActivity(intent);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(Battle.this, mypageMenu4.class);
                    startActivity(intent);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(Battle.this, mypageMenu5.class);
                    startActivity(intent);
                }
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void _btnFriend() {
        final Dialog dialogwhenbuy = new Dialog(Battle.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        TextView txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        txtyesbutton.setText("この機能はただいま準備中です。しばらくお待ち下さい。");
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogwhenbuy.dismiss();
            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();
    }

    TextView txtcontent;

    public void ChooseBattle() {
        final Dialog dialogchange = new Dialog(Battle.this);
        dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogchange.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogchange.setContentView(R.layout.dialog_change);
        dialogchange.setCanceledOnTouchOutside(false);
        TextView title = (TextView) dialogchange.findViewById(R.id.title);
        txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
        title.setText("対戦確認");
        ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
        ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
        final String str_CPU = list_name.get(_click);
        final int head = head_cpu.get(_click);
        final int horn = horn_cpu.get(_click);
        final int horn2 = horn2_cpu.get(_click);
        final int wing = wing_cpu.get(_click);
        final int body = body_cpu.get(_click);
        final int neck = neck_cpu.get(_click);
        final int face = face_cpu.get(_click);
        final int cpu_kind = arr_subkind.get(_click);
        final int part_index = arr_imagoDropPartsIndex.get(_click);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogchange.dismiss();
                mypage.theluc -= _tempstamina;
                _fight++;
                db.update_fight(idpetsell, _fight);
                Intent i = new Intent(Battle.this, Chairmain.class);
                i.putExtra("idpetsell", idpetsell);
                i.putExtra("_fight", _fight);
                i.putExtra("loaisale", loaisale);
                i.putExtra("namesell", namesell);
                i.putExtra("wingNosale", wingNosale);
                i.putExtra("faceNosale", faceNosale);
                i.putExtra("neckNosale", neckNosale);
                i.putExtra("bodyNosale", bodyNosale);
                i.putExtra("horn2Nosale", horn2Nosale);
                i.putExtra("hornNosale", hornNosale);
                i.putExtra("headNosale", headNosale);
                i.putExtra("matsale", matsale);
                i.putExtra("_level", _level);
                i.putExtra("inKind", inKind);
                i.putExtra("cpu_kind", cpu_kind);
                i.putExtra("part_index", part_index);
                i.putExtra("arr_head", head);
                i.putExtra("arr_horn", horn);
                i.putExtra("arr_horn2", horn2);
                i.putExtra("arr_face", face);
                i.putExtra("arr_body", body);
                i.putExtra("arr_wing", wing);
                i.putExtra("arr_neck", neck);
                i.putExtra("str_CPU", str_CPU);
                i.putExtra("lv", lv);

                i.putExtra("lv2", _click);
                i.putIntegerArrayListExtra("head_cpu", head_cpu);
                i.putIntegerArrayListExtra("horn_cpu", horn_cpu);
                i.putIntegerArrayListExtra("horn2_cpu", horn2_cpu);
                i.putIntegerArrayListExtra("wing_cpu", wing_cpu);
                i.putIntegerArrayListExtra("body_cpu", body_cpu);
                i.putIntegerArrayListExtra("neck_cpu", neck_cpu);
                i.putIntegerArrayListExtra("face_cpu", face_cpu);
                i.putStringArrayListExtra("list_name", list_name);

                i.putExtra("arr_s_hp", arr_s_hp.get(_click));
                i.putExtra("arr_s_at", arr_s_at.get(_click));
                i.putExtra("arr_s_criat", arr_s_criat.get(_click));
                i.putExtra("arr_s_de", arr_s_de.get(_click));
                i.putExtra("arr_s_cri", arr_s_cri.get(_click));
                i.putExtra("arr_s_avoid", arr_s_avoid.get(_click));
                i.putExtra("arr_s_luc", arr_s_luc.get(_click));
                i.putExtra("arr_s_spe", arr_s_spe.get(_click));

                i.putExtra("pl_hp", getIntent().getIntExtra("pl_hp", 0));
                i.putExtra("pl_at", getIntent().getIntExtra("pl_at", 0));
                i.putExtra("pl_criat", getIntent().getIntExtra("pl_criat", 0));
                i.putExtra("pl_de", getIntent().getIntExtra("pl_de", 0));
                i.putExtra("pl_cri", getIntent().getIntExtra("pl_cri", 0));
                i.putExtra("pl_avoid", getIntent().getIntExtra("pl_avoid", 0));
                i.putExtra("pl_luc", getIntent().getIntExtra("pl_luc", 0));
                i.putExtra("pl_spe", getIntent().getIntExtra("pl_spe", 0));

                startActivity(i);
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogchange.dismiss();
            }
        });
        dialogchange.show();
    }

    public int totalParam(int defHP, int attack, int attackCritical, int defense, int critical, int avoid, int lucky, int speed) {
        int result = 0;
        result += defHP;
        result += attack;
        result += attackCritical;
        result += defense;
        result += critical;
        result += avoid;
        result += lucky;
        result += speed;
        return result;
    }

    ImageView img_menu, img_shop, mochimono, btnimgbreeding, imggacha, imgfriend;
    ImageView mphead, mpface, mphorn, mphorn2, bgmphead, bgmpface, bgmphorn, bgmphorn2;
    TextView nickname, coin, jewel, txtlv, txttitle, formatcoin, formatjewel, txtnampet, txtkind, fighttext, foresttext;
    public static TextView txtphantram, txtHp;
    LinearLayout layoutLevel, lnlvpet;
    public static ProgressBar progressBar3, prhp;
    DecimalFormat formatter;
    dbHandler db;

    public void _initView() {
        f_coin = (ImageView) findViewById(R.id.f_coin);
        f_jewel = (ImageView) findViewById(R.id.f_jewel);
        f_shin1 = (ImageView) findViewById(R.id.f_shin1);
        f_shin2 = (ImageView) findViewById(R.id.f_shin2);
        f_coin.setBackgroundResource(R.drawable.animation_coin);
        anim_coin = (AnimationDrawable) f_coin.getBackground();
        f_jewel.setBackgroundResource(R.drawable.animation_jewel);
        anim_jewel = (AnimationDrawable) f_jewel.getBackground();
        f_shin1.setBackgroundResource(R.drawable.animation_shine);
        anim_shin1 = (AnimationDrawable) f_shin1.getBackground();
        f_shin2.setBackgroundResource(R.drawable.animation_shine);
        anim_shin2 = (AnimationDrawable) f_shin2.getBackground();
        soundbg = MediaPlayer.create(this, R.raw.bgm006);
        soundbg.setLooping(true);
        animation = AnimationUtils.loadAnimation(Battle.this, R.anim.trans_left_in);
        db = new dbHandler(this);
        confetti = (FrameLayout) findViewById(R.id.confetti);
        indicator = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator1);
        indicator.setForegroundColor(Color.parseColor("#ebbd36"));
        indicator.setBackgroundColor(Color.parseColor("#000000"));
        indicator.setPieStyle(true);
        indicator.setValue(mypage.valueindicator);
        lnlvpet = (LinearLayout) findViewById(R.id.lnlvpet);
        txtnampet = (TextView) findViewById(R.id.txtnampet);
        txtkind = (TextView) findViewById(R.id.txtkind);
        txtHp = (TextView) findViewById(R.id.txthp);
        fighttext = (TextView) findViewById(R.id.fighttext);
        foresttext = (TextView) findViewById(R.id.foresttext);
        mphead = (ImageView) findViewById(R.id.mphead);
        mpface = (ImageView) findViewById(R.id.mpface);
        mphorn = (ImageView) findViewById(R.id.mphorn);
        mphorn2 = (ImageView) findViewById(R.id.mphorn2);
        bgmphead = (ImageView) findViewById(R.id.bgmphead);
        bgmpface = (ImageView) findViewById(R.id.bgmpface);
        bgmphorn = (ImageView) findViewById(R.id.bgmphorn);
        bgmphorn2 = (ImageView) findViewById(R.id.bgmphorn2);
        layoutLevel = (LinearLayout) findViewById(R.id.layoutLevel);
        nickname = (TextView) findViewById(R.id.txtten);
        coin = (TextView) findViewById(R.id.txtcoin);
        txtphantram = (TextView) findViewById(R.id.txtphantram);
        jewel = (TextView) findViewById(R.id.txtjewel);
        txttitle = (TextView) findViewById(R.id.txttitle);
        txtlv = (TextView) findViewById(R.id.txtlv);
        formatcoin = (TextView) findViewById(R.id.formatcoin);
        formatjewel = (TextView) findViewById(R.id.formatjewel);

        img_menu = (ImageView) findViewById(R.id.imgmenu);
        img_shop = (ImageView) findViewById(R.id.imgshop);
        mochimono = (ImageView) findViewById(R.id.imgmochimono);
        btnimgbreeding = (ImageView) findViewById(R.id.imgbreeding);
        imggacha = (ImageView) findViewById(R.id.imggacha);
        imgfriend = (ImageView) findViewById(R.id.imgfriend);
        img_menu.setOnClickListener(this);
        img_shop.setOnClickListener(this);
        mochimono.setOnClickListener(this);
        btnimgbreeding.setOnClickListener(this);
        imggacha.setOnClickListener(this);
        imgfriend.setOnClickListener(this);

        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        prhp = (ProgressBar) findViewById(R.id.prhp);
        formatter = new DecimalFormat("#,###,###");
        easy = (ImageView) findViewById(R.id.easy);

        normal = (ImageView) findViewById(R.id.normal);
        hard = (ImageView) findViewById(R.id.hard);
        king = (ImageView) findViewById(R.id.king);
        imgback = (ImageView) findViewById(R.id.imgback);
        easy.setOnClickListener(this);
        normal.setOnClickListener(this);
        hard.setOnClickListener(this);
        king.setOnClickListener(this);
        imgback.setOnClickListener(this);
        Intent intent = getIntent();
        loaisale = intent.getStringExtra("loaisale");
        hangsell = intent.getStringExtra("hangsell");
        namesell = intent.getStringExtra("namesell");
        wingNosale = intent.getIntExtra("wingNosale", 0);
        faceNosale = intent.getIntExtra("faceNosale", 0);
        neckNosale = intent.getIntExtra("neckNosale", 0);
        bodyNosale = intent.getIntExtra("bodyNosale", 0);
        horn2Nosale = intent.getIntExtra("horn2Nosale", 0);
        hornNosale = intent.getIntExtra("hornNosale", 0);
        headNosale = intent.getIntExtra("headNosale", 0);
        matsale = intent.getIntExtra("matsale", 0);

        if (loaisale.equals("loai1")) {
            inKind = 0;
            formMax = 800;
        } else if (loaisale.equals("loai2")) {
            inKind = 1000;
            formMax = 800;
        } else if (loaisale.equals("loai3")) {
            inKind = 1;
            formMax = 1000;
        } else if (loaisale.equals("loai4")) {
            inKind = 1001;
            formMax = 2000;
        } else if (loaisale.equals("loai5")) {
            inKind = 2;
            formMax = 2000;
        } else if (loaisale.equals("loai6")) {
            inKind = 1002;
            formMax = 2000;
        } else if (loaisale.equals("loai7")) {
            inKind = 1003;
            formMax = 1500;
        } else if (loaisale.equals("loai8")) {
            inKind = 3;
            formMax = 3000;
        }
        strengthMax = formMax;
        personalityMax = formMax;
        friendlyMax = formMax;
        lifeMax = strengthMax * 10;

        idpetsell = intent.getIntExtra("idpetsell", 0);
        _hp = intent.getIntExtra("_hp", 0);
        _attack = intent.getIntExtra("_attack", 0);
        _criticalAttack = intent.getIntExtra("_criticalAttack", 0);
        _defense = intent.getIntExtra("_defense", 0);
        _critical = intent.getIntExtra("_critical", 0);
        _avoid = intent.getIntExtra("_avoid", 0);
        _lucky = intent.getIntExtra("_lucky", 0);
        _speed = intent.getIntExtra("_speed", 0);
        _level = intent.getIntExtra("_level", 0);

        _exp = intent.getIntExtra("_exp", 0);
        _fight = intent.getIntExtra("_fightSum", 0);

        _strength = intent.getIntExtra("_strengthsale", 0);
        _strength2 = _strength;
        _life = _strength * 10;
        _life2 = _life;
        _form = intent.getIntExtra("_formsale", 0);
        _form2 = _form;
        _friendly = intent.getIntExtra("nuoisale", 0);
        _friendly2 = _friendly;
        _personality = intent.getIntExtra("personalitysale", 0);
        _personality2 = _personality;
        _size = intent.getIntExtra("_sizesale", 0);
        _size2 = _size;
//        Log.e("TAG", "" + _strength + "-" + _form + "-" + _friendly + "-" + _personality + "-" + _size);

        arr_horn = new ArrayList<String>();
        arr_horn2 = new ArrayList<String>();
        arr_neck = new ArrayList<String>();
        arr_body = new ArrayList<String>();
        arr_wing = new ArrayList<String>();
        arr_face = new ArrayList<String>();
        arr_head = new ArrayList<String>();
        arr_subkind = new ArrayList<Integer>();

        head_cpu = new ArrayList<Integer>();
        horn_cpu = new ArrayList<Integer>();
        horn2_cpu = new ArrayList<Integer>();
        wing_cpu = new ArrayList<Integer>();
        body_cpu = new ArrayList<Integer>();
        face_cpu = new ArrayList<Integer>();
        neck_cpu = new ArrayList<Integer>();

        temp_head_cpu = new ArrayList<Integer>();
        temp_horn_cpu = new ArrayList<Integer>();
        temp_horn2_cpu = new ArrayList<Integer>();
        temp_wing_cpu = new ArrayList<Integer>();
        temp_body_cpu = new ArrayList<Integer>();
        temp_face_cpu = new ArrayList<Integer>();
        temp_neck_cpu = new ArrayList<Integer>();
        arr_imagoDropPartsIndex = new ArrayList<Integer>();
        partsIndexes = new ArrayList<Integer>();
        id_Index = new ArrayList<Integer>();
        arrStamina = new ArrayList<Integer>();
        arrLevel = new ArrayList<Integer>();

        itemDes = new ArrayList<String>();
        itemId = new ArrayList<String>();
        itemName = new ArrayList<String>();
        rarity = new ArrayList<String>();
        coins = new ArrayList<String>();
        jewels = new ArrayList<String>();
        id_item = new ArrayList<Integer>();
        id_des = new ArrayList<String>();
        list_name = new ArrayList<String>();
        id_desbattle = new ArrayList<String>();
        star = new ArrayList<Integer>();

        arr_s_at = new ArrayList<Integer>();
        arr_s_hp = new ArrayList<Integer>();
        arr_s_criat = new ArrayList<Integer>();
        arr_s_de = new ArrayList<Integer>();
        arr_s_cri = new ArrayList<Integer>();
        arr_s_avoid = new ArrayList<Integer>();
        arr_s_luc = new ArrayList<Integer>();
        arr_s_spe = new ArrayList<Integer>();

        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileBattle csvFile = new CSVFileBattle(inputStream);
        List<String[]> scoreList = csvFile.read();
        for (int i = 1; i < itemId.size(); i++) {
            if (Integer.parseInt(itemId.get(i)) >= 100000) {
                id_item.add(Integer.parseInt(itemId.get(i)));
                id_des.add(itemDes.get(i));
            }
        }

        for (int i = 0; i < mypage.arr_species_supplement.size(); i++) {
            if (Integer.parseInt(mypage.arr_species_supplement.get(i)) == 7 && Integer.parseInt(mypage.arr_lv_supplement.get(i)) == 99) {
                param_Category1_supplement = 0;
                param_Category2_supplement = 0;
                param_Category3_supplement = 0;
                param_Lv_supplement = 0;
                param_hp_supplement = Integer.parseInt(mypage.arr_hp_supplement.get(i));
                param_attack_supplement = Integer.parseInt(mypage.arr_attack_supplement.get(i));
                param_CriticalAttack_supplement = Integer.parseInt(mypage.arr_criticalAttack_supplement.get(i));
                param_Defense_supplement = Integer.parseInt(mypage.arr_defense_supplement.get(i));
                param_Critical_supplement = Integer.parseInt(mypage.arr_critical_supplement.get(i));
                param_Avoid_supplement = Integer.parseInt(mypage.arr_avoid_supplement.get(i));
                param_Lucky_supplement = Integer.parseInt(mypage.arr_lucky_supplement.get(i));
                param_Speed_supplement = Integer.parseInt(mypage.arr_speed_supplement.get(i));
            }
        }
        runAnim();
        _Confetti();
//        for(int i=0;i<arr_species_parts.size();i++){
//            Log.e("TAF",""+arr_attack_parts.get(i));
//        }

    }


    String loaisale = "", namesell = "", hangsell = "";
    int wingNosale, faceNosale, neckNosale, bodyNosale, hornNosale, horn2Nosale, headNosale, matsale, idpetsell, _level,
            _hp, _attack, _criticalAttack, _defense, _critical, _avoid, _lucky, _speed, _exp, _size, _strength, _form,
            _friendly, _personality, _life, _size2, _strength2, _form2,
            _friendly2, _personality2, _life2, _fight;

    public void _setInfor() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        nickname.setText("" + pre.getString("nickname", ""));
        int sizelv = 11;
        if (mypage._Width <= 480)
            sizelv = 9;
        DrawLevel(layoutLevel, pre.getInt("lv", 1), sizelv);
        int lv = pre.getInt("lv", 1) - 1;
        if (lv >= mypage._title.length)
            lv = mypage._title.length - 1;
        txttitle.setText(mypage._title[mypage.rank]);
        txtlv.setText("" + pre.getInt("lv", 1));
        int sau = Integer.parseInt(txtlv.getText().toString()) * 10;
        txtphantram.setText("" + mypage.theluc + "/" + sau);
        progressBar3.setMax(pre.getInt("lv", 1) * 10);
        progressBar3.setProgress(pre.getInt("theluc", pre.getInt("lv", 1) * 10));
        DrawLevel(lnlvpet, _level, sizelv);
        txtnampet.setText(namesell);
        txtkind.setText(hangsell);
        prhp.setMax(mypage.pl_hp);
        prhp.setProgress(mypage._hp);
        if (mypage._hp < 1)
            mypage._hp = 1;
        txtHp.setText(mypage._hp + "/" + mypage.pl_hp);
        fighttext.setText("" + mypage._fightSum + "戦 " + mypage._fightWin + "勝");
        foresttext.setText("0戦 0勝");
        if (loaisale.equals("loai1")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            mphead.setImageResource(Chat.head[headNosale]);
            mphorn.setImageResource(Chat.horn[hornNosale]);
            bgmphead.setImageResource(Chat.bghead[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0000_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face[faceNosale]);
        } else if (loaisale.equals("loai2")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 2)
                neckNosale = 2;
            mphead.setImageResource(Chat.head2[headNosale]);
            mphorn.setImageResource(Chat.horn2[hornNosale]);
            bgmphead.setImageResource(Chat.bghead2[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn2[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0100_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face2[faceNosale]);
        } else if (loaisale.equals("loai3")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 4)
                neckNosale = 4;
            mphead.setImageResource(Chat.head3[headNosale]);
            mphorn.setImageResource(Chat.horn3[hornNosale]);
            mphorn2.setImageResource(Chat.horn33[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead3[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn3[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn33[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0001_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face3[faceNosale]);
        } else if (loaisale.equals("loai4")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 2)
                neckNosale = 2;
            mphead.setImageResource(Chat.head4[headNosale]);
            mphorn.setImageResource(Chat.horn4[hornNosale]);
            bgmphead.setImageResource(Chat.bghead4[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn4[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0101_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face4[faceNosale]);
        } else if (loaisale.equals("loai5")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            mphead.setImageResource(Chat.head5[headNosale]);
            mphorn.setImageResource(Chat.horn5[hornNosale]);
            mphorn2.setImageResource(Chat.horn55[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead5[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn5[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn55[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0002_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face5[faceNosale]);
        } else if (loaisale.equals("loai6")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 2)
                neckNosale = 2;
            mphead.setImageResource(Chat.head6[headNosale]);
            mphorn.setImageResource(Chat.horn6[hornNosale]);
            bgmphead.setImageResource(Chat.bghead6[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn6[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0102_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face6[faceNosale]);
        } else if (loaisale.equals("loai7")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            mphead.setImageResource(Chat.head7[headNosale]);
            mphorn.setImageResource(Chat.horn7[hornNosale]);
            bgmphead.setImageResource(Chat.bghead7[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn7[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0103_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face7[faceNosale]);
        } else if (loaisale.equals("loai8")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            mphead.setImageResource(Chat.head8[headNosale]);
            mphorn.setImageResource(Chat.horn8[hornNosale]);
            mphorn2.setImageResource(Chat.horn88[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead8[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn8[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn88[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0003_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face8[faceNosale]);
        }
    }

    public void DrawLevel(LinearLayout layoutLevel, int lv, int size) {
        if (layoutLevel != null)
            layoutLevel.removeAllViews();
        String str = "" + lv;
        String[] arr = str.split("");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, LinearLayout.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < arr.length; i++) {
            ImageView img = new ImageView(this);
            img.setLayoutParams(params);
            img.setAdjustViewBounds(true);
            if (arr[i].equals("0"))
                img.setImageResource(R.drawable.num0);
            else if (arr[i].equals("1"))
                img.setImageResource(R.drawable.num1);
            else if (arr[i].equals("2"))
                img.setImageResource(R.drawable.num2);
            else if (arr[i].equals("3"))
                img.setImageResource(R.drawable.num3);
            else if (arr[i].equals("4"))
                img.setImageResource(R.drawable.num4);
            else if (arr[i].equals("5"))
                img.setImageResource(R.drawable.num5);
            else if (arr[i].equals("6"))
                img.setImageResource(R.drawable.num6);
            else if (arr[i].equals("7"))
                img.setImageResource(R.drawable.num7);
            else if (arr[i].equals("8"))
                img.setImageResource(R.drawable.num8);
            else if (arr[i].equals("9"))
                img.setImageResource(R.drawable.num9);
            layoutLevel.addView(img);
        }
    }

    public void maxParamObj(int lv, int s) {
        int _level = lv + 1;
        int subKinds[] = {
                Chat.kBeetleSubKind_JapanBeetle, Chat.kBeetleSubKind_Caucasus,
                Chat.kBeetleSubKind_Satanas, Chat.kBeetleSubKind_Hercules,
                Chat.kBeetleSubKind_JapanDorcusRectus, Chat.kBeetleSubKind_JapanDorcusCurvidens,
                Chat.kBeetleSubKind_ProsopocoilusGiraffa, Chat.kBeetleSubKind_AllotopusRosenbergi,
        };
        int selectedKindBeetle = Chat.kTypeSpecies_Max;
//        int lv = 99;
        for (int idx = 0; idx < 8; idx++) {
            int subKind = subKinds[idx];
            int species = Chat.convertSpeciesValue(subKind);
//            Log.e("species",""+species);
            for (int i = 0; i < mypage.arr_species.size(); i++) {
                if (Integer.parseInt(mypage.arr_species.get(i)) == species && Integer.parseInt(mypage.arr_lv.get(i)) == 99) {
                    param_Category1 = 0;
                    param_Category2 = 0;
                    param_Category3 = 0;
                    param_Lv = 0;
                    param_hp = Integer.parseInt(mypage.arr_hp.get(i));
                    param_attack = Integer.parseInt(mypage.arr_attack.get(i));
                    param_CriticalAttack = Integer.parseInt(mypage.arr_criticalAttack.get(i));
                    param_Defense = Integer.parseInt(mypage.arr_defense.get(i));
                    param_Critical = Integer.parseInt(mypage.arr_critical.get(i));
                    param_Avoid = Integer.parseInt(mypage.arr_avoid.get(i));
                    param_Lucky = Integer.parseInt(mypage.arr_lucky.get(i));
                    param_Speed = Integer.parseInt(mypage.arr_speed.get(i));
                }
                if (Integer.parseInt(mypage.arr_species.get(i)) == s && Integer.parseInt(mypage.arr_lv.get(i)) == _level) {
                    setup_hp = Integer.parseInt(mypage.arr_hp.get(i));
                    setup_attack = Integer.parseInt(mypage.arr_attack.get(i));
                    setup_CriticalAttack = Integer.parseInt(mypage.arr_criticalAttack.get(i));
                    setup_Defense = Integer.parseInt(mypage.arr_defense.get(i));
                    setup_Critical = Integer.parseInt(mypage.arr_critical.get(i));
                    setup_Avoid = Integer.parseInt(mypage.arr_avoid.get(i));
                    setup_Lucky = Integer.parseInt(mypage.arr_lucky.get(i));
                    setup_Speed = Integer.parseInt(mypage.arr_speed.get(i));
                }
            }

            for (int i = 0; i < mypage.arr_species_supplement.size(); i++) {
                if (Integer.parseInt(mypage.arr_species_supplement.get(i)) == species && Integer.parseInt(mypage.arr_lv_supplement.get(i)) == 99) {
                    param_Category1_supplement = 0;
                    param_Category2_supplement = 0;
                    param_Category3_supplement = 0;
                    param_Lv_supplement = 0;
                    param_hp_supplement = Integer.parseInt(mypage.arr_hp_supplement.get(i));
                    param_attack_supplement = Integer.parseInt(mypage.arr_attack_supplement.get(i));
                    param_CriticalAttack_supplement = Integer.parseInt(mypage.arr_criticalAttack_supplement.get(i));
                    param_Defense_supplement = Integer.parseInt(mypage.arr_defense_supplement.get(i));
                    param_Critical_supplement = Integer.parseInt(mypage.arr_critical_supplement.get(i));
                    param_Avoid_supplement = Integer.parseInt(mypage.arr_avoid_supplement.get(i));
                    param_Lucky_supplement = Integer.parseInt(mypage.arr_lucky_supplement.get(i));
                    param_Speed_supplement = Integer.parseInt(mypage.arr_speed_supplement.get(i));
                }
                if (Integer.parseInt(mypage.arr_species_supplement.get(i)) == s && Integer.parseInt(mypage.arr_lv_supplement.get(i)) == _level) {
                    setup_hp_supplement = Integer.parseInt(mypage.arr_hp_supplement.get(i));
                    setup_attack_supplement = Integer.parseInt(mypage.arr_attack_supplement.get(i));
                    setup_CriticalAttack_supplement = Integer.parseInt(mypage.arr_criticalAttack_supplement.get(i));
                    setup_Defense_supplement = Integer.parseInt(mypage.arr_defense_supplement.get(i));
                    setup_Critical_supplement = Integer.parseInt(mypage.arr_critical_supplement.get(i));
                    setup_Avoid_supplement = Integer.parseInt(mypage.arr_avoid_supplement.get(i));
                    setup_Lucky_supplement = Integer.parseInt(mypage.arr_lucky_supplement.get(i));
                    setup_Speed_supplement = Integer.parseInt(mypage.arr_speed_supplement.get(i));
                }
            }
            getTotalPartsParameter(species);
            setup_getTotalPartsParameter(CPU_species);
        }
    }

    public int _returnHp(int param_hp, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement, int param_Defense_supplement,
                         int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement, int param_Speed_supplement, int parts_hp, int kind) {
        int hp = param_hp + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 1) + parts_hp;
        return hp;
    }

    public int _returnAttack(int param_attack, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                             int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                             int param_Speed_supplement, int parts_attack, int kind) {
        int a = param_attack + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 2) + parts_attack;
        return a;
    }

    public int _returnAttackCri(int param_CriticalAttack, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                int param_Speed_supplement, int parts_CriticalAttack, int kind) {
        int a = param_CriticalAttack + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 3) + parts_CriticalAttack;
        return a;
    }

    public int _returnDefence(int param_Defense, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                              int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                              int param_Speed_supplement, int parts_Defense, int kind) {
        int obj_defence = param_Defense + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 4) + parts_Defense;
        return obj_defence;
    }

    public int _returnCritical(int param_Critical, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                               int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                               int param_Speed_supplement, int parts_Critical, int kind) {
        int obj_critical = param_Critical + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 5) + parts_Critical;
        return obj_critical;
    }

    public int _returnAvoid(int param_Avoid, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                            int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                            int param_Speed_supplement, int parts_Avoid, int kind) {
        int obj_avoid = param_Avoid + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 6) + parts_Avoid;
        return obj_avoid;
    }

    public int _returnLucky(int param_Lucky, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                            int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                            int param_Speed_supplement, int parts_Lucky, int kind) {
        int obj_lucky = param_Lucky + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 7) + parts_Lucky;
        return obj_lucky;
    }

    public int _return(int param_Speed, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                       int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                       int param_Speed_supplement, int parts_Speed, int kind) {
        int obj_speed = param_Speed + calcExtraParamAtBeetle(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 8) + parts_Speed;
        return obj_speed;
    }


    public int _returnHp2(int param_hp, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement, int param_Defense_supplement,
                          int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement, int param_Speed_supplement, int parts_hp, int kind) {
        int hp = param_hp + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 1) + parts_hp;
        return hp;
    }

    public int _returnAttack2(int param_attack, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                              int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                              int param_Speed_supplement, int parts_attack, int kind) {
        int a = param_attack + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 2) + parts_attack;
        return a;
    }

    public int _returnAttackCri2(int param_CriticalAttack, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                 int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                 int param_Speed_supplement, int parts_CriticalAttack, int kind) {
        int a = param_CriticalAttack + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 3) + parts_CriticalAttack;
        return a;
    }

    public int _returnDefence2(int param_Defense, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                               int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                               int param_Speed_supplement, int parts_Defense, int kind) {
        int obj_defence = param_Defense + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 4) + parts_Defense;
        return obj_defence;
    }

    public int _returnCritical2(int param_Critical, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                int param_Speed_supplement, int parts_Critical, int kind) {
        int obj_critical = param_Critical + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 5) + parts_Critical;
        return obj_critical;
    }

    public int _returnAvoid2(int param_Avoid, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                             int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                             int param_Speed_supplement, int parts_Avoid, int kind) {
        int obj_avoid = param_Avoid + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 6) + parts_Avoid;
        return obj_avoid;
    }

    public int _returnLucky2(int param_Lucky, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                             int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                             int param_Speed_supplement, int parts_Lucky, int kind) {
        int obj_lucky = param_Lucky + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 7) + parts_Lucky;
        return obj_lucky;
    }

    public int _return2(int param_Speed, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                        int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                        int param_Speed_supplement, int parts_Speed, int kind) {
        int obj_speed = param_Speed + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 8) + parts_Speed;
        return obj_speed;
    }

    int obj_hp, obj_attack, obj_attackCritical, obj_defence, obj_critical, obj_avoid, obj_lucky, obj_speed;

    public void getTotalPartsParameter(int species) {
        for (int i = 0; i < Chat.KABUKUWA_PARTS; i++) {
            int partsRank = getEquipedPartsRank(i);
            if (partsRank == -1) {
                // 情報が不正のとき
                continue;
            }
            getPartsParameterSpeciesAndPartAndRank(species, i, partsRank);
        }
    }

    public void setup_getTotalPartsParameter(int species) {
        setZeroValue();
        for (int i = 0; i < Chat.KABUKUWA_PARTS; i++) {
            int partsRank = setup_getEquipedPartsRank(i, species);
            if (partsRank == -1) {
                // 情報が不正のとき
                continue;
            }
            setup_getPartsParameterSpeciesAndPartAndRank(species, i, partsRank);
            s_hp += setup_parts_hp;
            s_at += setup_parts_attack;
            s_criat += setup_parts_CriticalAttack;
            s_de += setup_parts_Defense;
            s_cri += setup_parts_Critical;
            s_avoid += setup_parts_Avoid;
            s_luc += setup_parts_Lucky;
            s_spe += setup_parts_Speed;
            if (s_spe < 0)
                s_spe = 0;
//            Log.e("END","END");
        }
    }

    int s_at = 0, s_hp = 0, s_criat = 0, s_de = 0, s_cri = 0, s_avoid = 0, s_luc = 0, s_spe = 0;
    ArrayList<Integer> arr_s_at, arr_s_hp, arr_s_criat, arr_s_de, arr_s_cri, arr_s_avoid, arr_s_luc, arr_s_spe;

    public void setup_getPartsParameterSpeciesAndPartAndRank(int species, int part, int rank) {
        if (part < 0)
            return;
        for (int i = 0; i < mypage.arr_species_parts.size(); i++) {
            if (Integer.parseInt(mypage.arr_species_parts.get(i)) == species &&
                    Integer.parseInt(mypage.arr_rank_parts.get(i)) == rank &&
                    Integer.parseInt(mypage.arr_part_parts.get(i)) == part) {
                setup_parts_hp = Integer.parseInt(mypage.arr_hp_parts.get(i));
                setup_parts_attack = Integer.parseInt(mypage.arr_attack_parts.get(i));
                setup_parts_CriticalAttack = Integer.parseInt(mypage.arr_criticalAttack_parts.get(i));
                setup_parts_Defense = Integer.parseInt(mypage.arr_defense_parts.get(i));
                setup_parts_Critical = Integer.parseInt(mypage.arr_critical_parts.get(i));
                setup_parts_Avoid = Integer.parseInt(mypage.arr_avoid_parts.get(i));
                setup_parts_Lucky = Integer.parseInt(mypage.arr_lucky_parts.get(i));
                setup_parts_Speed = Integer.parseInt(mypage.arr_speed_parts.get(i));
            }
        }
//        Log.e("CriticalAttack", "" + setup_parts_CriticalAttack);
        if ((species != 2 && part == 1) || (species != 4 && part == 1) || (species != 7 && part == 1))
            setup_parts_attack = 0;
//        Log.e("setup_parts_attack", "" + setup_parts_attack);
    }

    public void getPartsParameterSpeciesAndPartAndRank(int species, int part, int rank) {
        if (species < 0 || part < 0 || rank < 0)
            return;
        for (int i = 0; i < mypage.arr_species_parts.size(); i++) {
            if (Integer.parseInt(mypage.arr_species_parts.get(i)) == species &&
                    Integer.parseInt(mypage.arr_rank_parts.get(i)) == rank &&
                    Integer.parseInt(mypage.arr_part_parts.get(i)) == part) {
                parts_Category1 = Integer.parseInt(mypage.arr_species_parts.get(i));
                parts_Category2 = Integer.parseInt(mypage.arr_part_parts.get(i));
                parts_Category3 = Integer.parseInt(mypage.arr_rank_parts.get(i));
                parts_Lv = 0;
                parts_hp = Integer.parseInt(mypage.arr_hp_parts.get(i));
                parts_attack = Integer.parseInt(mypage.arr_attack_parts.get(i));
                parts_CriticalAttack = Integer.parseInt(mypage.arr_criticalAttack_parts.get(i));
                parts_Defense = Integer.parseInt(mypage.arr_defense_parts.get(i));
                parts_Critical = Integer.parseInt(mypage.arr_critical_parts.get(i));
                parts_Avoid = Integer.parseInt(mypage.arr_avoid_parts.get(i));
                parts_Lucky = Integer.parseInt(mypage.arr_lucky_parts.get(i));
                parts_Speed = Integer.parseInt(mypage.arr_speed_parts.get(i));
            }
        }
    }

    public int setup_getEquipedPartsRank(int part, int s) {
        int a = 0;
        if (part == 0)
            a = imagoHornRank;
//        if (part == 1)
//            a = imagoHorn2Rank;
        if (part == 1) {
            if (s == 2 || s == 4 || s == 7)
                a = imagoHorn2Rank;
            else
                a = -1;
        }
        if (part == 2)
            a = imagoBodyRank;
        if (part == 3)
            a = imagoFaceRank;
        if (part == 4)
            a = imagoHeadRank;
        if (part == 5)
            a = imagoNeckRank;
        if (part == 6)
            a = imagoWingRank;
        return a;
    }

    public int getEquipedPartsRank(int part) {
        int typeParts = part;
        switch (typeParts) {
            case 0:
                return 10;
            case 1:
                return 10;
            case 2:
                return 10;
            case 3:
                return 10;
            case 4:
                return 10;
            case 5:
                return 10;
            case 6:
                return 10;
            default:
                return -1;
        }
    }

    public int calcExtraParamAtBeetle(int inKind, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                      int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                      int param_Speed_supplement, int part) {
        int result = 0;
        double lifeMax = 0, strengthMax = 0, formMax = 0, friendlyMax = 0, personalityMax = 0;
        lifeMax = Chat.kBeetleLife_Max * Chat.parameterRatio(inKind);
        strengthMax = Chat.kBeetleStrength_Max * Chat.parameterRatio(inKind);
        formMax = Chat.kBeetleForm_Max * Chat.parameterRatio(inKind);
        friendlyMax = Chat.kBeetleFriendly_Max * Chat.parameterRatio(inKind);
        personalityMax = Chat.kBeetlePersonality_Max * Chat.parameterRatio(inKind);
        switch (part) {
            case 1: {
                double extraParamBaseRatio = (double) param_hp_supplement;
                // HP補正   (パラメータlife / 生命力Max) * パラメータ補正
                result = (int) Math.floor((double) _life / (double) lifeMax *
                        extraParamBaseRatio);
            }
            break;
            case 2: {
                double extraParamBaseRatio = (double) param_attack_supplement;
                // こうげき補正 (パラメータStrength / 強さMax) * パラメータ補正
                result = (int) Math.floor((double) _strength / (double) strengthMax *
                        extraParamBaseRatio);
            }
            break;
            case 3: {
                double extraParamBaseRatio = (double) param_CriticalAttack_supplement;
                // こうげき(クリティカル)補正 ((パラメータStrength / 強さMax) - (パラメータForm / かっこよさMax)) * パラメータ補正   値が大きくなりすぎると面白くないので
                double strength = ((double) _strength / (double) strengthMax);
                double form = ((double) _form / (double) formMax);
                result = (int) Math.floor((strength - form) * extraParamBaseRatio);
            }
            break;
            case 4: {
                double extraParamBaseRatio = (double) param_Defense_supplement;
                // ぼうぎょ補正 (パラメータSize - 0.6 * サイズmax) / (0.4 * サイズmax) * パラメータ補正  サイズはmax値の6割までは確実に成長するので伸びしろで計算をする
                double size = ((double) _size - 0.6 * (double) Chat.kBeetleSizeMax);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 5: {
                double extraParamBaseRatio = (double) param_Critical_supplement;
                // クリティカル発動補正 (パラメータForm / かっこよさMax - (パラメータFriendluw / なつき度Max)) * パラメータ補正  なつき度が高いと野生の感がなくなるイメージ
                double form = ((double) _form / (double) formMax);
                double friendly = ((double) _friendly / (double) friendlyMax);
                result = (int) Math.floor((form - friendly) * extraParamBaseRatio);
            }
            break;
            case 6: {
                double extraParamBaseRatio = (double) param_Avoid_supplement;
                //かいひ補正    (パラメータpersonality / パーソナリティMax -  (パラメータFriendluw / なつき度Max)) * パラメータ補正    なつき度が高いと野生の感がなくなるイメージ
                double personality = ((double) _personality / (double) personalityMax);
                double friendly = ((double) _friendly / (double) friendlyMax);
                result = (int) Math.floor((personality - friendly) * extraParamBaseRatio);
            }
            break;
            case 7: {
                double extraParamBaseRatio = (double) param_Lucky_supplement;
                // ラッキー補正 (1 - (パラメータStrength / 強さMax + パラメータForm / かっこよさMax + パラメータpersonality / パーソナリティMax) / 3 + (パラメータFriendluw / なつき度Max)) * パラメータ補正    あまり強すぎる個体を作らないために攻撃、クリティカル発動率、回避のパラメータとのバランスを取る。ただしある程度こまめに世話をした方が強くなるように生命力とは独立をさせて、friendlyが高いほど高くなるようにする。
                double strength = ((double) _strength / (double) strengthMax);
                double form = ((double) _form / (double) formMax);
                double personality = ((double) _personality / (double) personalityMax);
                double friendly = ((double) _friendly / (double) friendlyMax);
                result = (int) Math.floor((1 - (strength + form + personality) / 3.0 + friendly) * extraParamBaseRatio);
            }
            break;
            case 8: {
                double extraParamBaseRatio = (double) param_Speed_supplement;
                //すばやさ補正   (サイズmax - パラメータSize) / (0.4 * サイズmax) * パラメータ補正    ぼうぎょと同様に確実に成長する部分は無視をする
                double size = ((double) Chat.kBeetleSizeMax - (double) _size);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 0:
                break;
        }
        return (result);
    }

    ArrayList<String> content;
    ArrayList<String> coinmp;
    ArrayList<String> jewelmp;
    ArrayList<String> fooddong2;
    ArrayList<String> fooddong3;
    ArrayList<String> str_star;
    ArrayList<String> arrnumber;
    ArrayList<String> contentShow;
    ArrayList<String> coinShow;
    ArrayList<String> jewelShow;
    ArrayList<String> fooddong2Show;
    ArrayList<String> fooddong3Show;
    ArrayList<String> starShow;
    ArrayList<String> arrnumberShow;
    ArrayList<Integer> img;
    ArrayList<Integer> imgShow;
    ArrayList<String> contentItem;
    ArrayList<String> coinItem;
    ArrayList<String> jewelItem;
    ArrayList<String> fooddong2Item;
    ArrayList<String> fooddong3Item;
    ArrayList<String> starItem;
    ArrayList<String> arrnumberItem;
    ArrayList<String> contentItemShow;
    ArrayList<String> coinItemShow;
    ArrayList<String> jewelItemShow;
    ArrayList<String> fooddong2ItemShow;
    ArrayList<String> fooddong3ItemShow;
    ArrayList<String> starItemShow;
    ArrayList<String> arrnumberItemShow;
    ArrayList<Integer> imgItem;
    ArrayList<Integer> imgItemShow;

    ArrayList<String> contentDrink;
    ArrayList<String> coinDrink;
    ArrayList<String> jewelDrink;
    ArrayList<String> fooddong2Drink;
    ArrayList<String> fooddong3Drink;
    ArrayList<String> starDrink;
    ArrayList<String> arrnumberDrink;
    ArrayList<String> contentDrinkShow;
    ArrayList<String> coinDrinkShow;
    ArrayList<String> jewelDrinkShow;
    ArrayList<String> fooddong2DrinkShow;
    ArrayList<String> fooddong3DrinkShow;
    ArrayList<String> starDrinkShow;
    ArrayList<String> arrnumberDrinkShow;
    ArrayList<Integer> imgDrink;
    ArrayList<Integer> imgDrinkShow;
    LinearLayout lnstar;
    public static ArrayList<String> itemId;
    public static ArrayList<String> str_itemDes;
    public static ArrayList<String> itemName;
    public static ArrayList<String> rarity;
    public static ArrayList<String> coins;
    public static ArrayList<String> jewels;
    public static ArrayList<String> itemIdShop;
    public static ArrayList<String> itemNameShop;
    public static ArrayList<String> rarityShop;
    public static ArrayList<String> coinsShop;
    public static ArrayList<String> jewelsShop;
    public static ArrayList<String> itemDesShop;
    public static ArrayList<String> itemDesName;
    ArrayList<String> numitem;
    ArrayList<String> numitemDisplay;
    ArrayList<String> rarityDisplay;
    ArrayList<String> itemIdShopDisplay;
    ArrayList<String> DesnameDisplay;
    ArrayList<String> coinDisplay;
    ArrayList<String> jewelDisplay;

    ArrayList<Integer> _c;
    ArrayList<Integer> _c2;

    ArrayList<Integer> _idItem;
    ArrayList<Integer> _idItemShow;
    ArrayList<Integer> _idFood;
    ArrayList<Integer> _idFoodShow;
    ArrayList<Integer> _idDrink;
    ArrayList<Integer> _idDrinkShow;
    TextView txtdong1, txtdong2, txtdong3;
    ImageView shop_yes, shop_no, btnok;
    AdapterMono adapterMono, adapterMonoItem, adapterMonoDrink;
    private ItemArrayAdapter partitemAdapter;

    public void Dialog_Mochimono() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        dialogmochimono = new Dialog(Battle.this);
        dialogmochimono.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogmochimono.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogmochimono.setContentView(R.layout.mochimono_layout);
        dialogmochimono.setCanceledOnTouchOutside(false);
        layoutitem = (LinearLayout) dialogmochimono.findViewById(R.id.layoutitem);
        drinkitem = (ListView) dialogmochimono.findViewById(R.id.drinkitem);
        fooditem = (ListView) dialogmochimono.findViewById(R.id.fooditem);
        partitem = (ListView) dialogmochimono.findViewById(R.id.partitem);
        //
        itemIdShop = new ArrayList<String>();
        itemNameShop = new ArrayList<String>();
        rarityShop = new ArrayList<String>();
        coinsShop = new ArrayList<String>();
        jewelsShop = new ArrayList<String>();
        itemDesShop = new ArrayList<String>();
        itemDesName = new ArrayList<String>();
        numitem = new ArrayList<String>();
        numitemDisplay = new ArrayList<String>();
        rarityDisplay = new ArrayList<String>();
        itemIdShopDisplay = new ArrayList<String>();
        DesnameDisplay = new ArrayList<String>();
        coinDisplay = new ArrayList<String>();
        jewelDisplay = new ArrayList<String>();
//        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
//        CSVFileBattle csvFile = new CSVFileBattle(inputStream);
//        List<String[]> scoreList = csvFile.read();
        for (int i = 1; i < itemId.size(); i++) {
            if (Integer.parseInt(itemId.get(i)) >= 100000) {
                itemIdShop.add(itemId.get(i));
                rarityShop.add(rarity.get(i));
                jewelsShop.add(jewels.get(i));
                String str = coins.get(i);
                int a = Integer.parseInt(str) / 10;
                String b = "" + a;
                coinsShop.add(b);
                itemDesName.add(itemDes.get(i));
                String key = itemId.get(i);
                if (key.length() == 1)
                    key = "0000" + key;
                else if (key.length() == 2)
                    key = "000" + key;
                else if (key.length() == 3)
                    key = "00" + key;
                else if (key.length() == 4)
                    key = "0" + key;
                int _num = pre.getInt(key, 0);
                String value = "" + _num;
                numitem.add(value);
            }
        }
        for (int i = 0; i < numitem.size(); i++) {
            if (!numitem.get(i).equals("0")) {
                numitemDisplay.add(numitem.get(i));
                rarityDisplay.add(rarityShop.get(i));
                DesnameDisplay.add(itemDesName.get(i));
                coinDisplay.add(coinsShop.get(i));
                itemIdShopDisplay.add(itemIdShop.get(i));
                if (jewelsShop.get(i).equals(""))
                    jewelDisplay.add("0");
                else if (!jewelsShop.get(i).equals(""))
                    jewelDisplay.add(jewelsShop.get(i));
            }
        }

        for (int i = 0; i < itemIdShopDisplay.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (Integer.parseInt(itemIdShopDisplay.get(i)) <= Integer.parseInt(itemIdShopDisplay.get(j))) {
                    tempid = itemIdShopDisplay.get(i);
                    itemIdShopDisplay.set(i, itemIdShopDisplay.get(j));
                    itemIdShopDisplay.set(j, "" + tempid);
                    tempnumitem = numitemDisplay.get(i);
                    numitemDisplay.set(i, numitemDisplay.get(j));
                    numitemDisplay.set(j, tempnumitem);
                    temprarity = rarityDisplay.get(i);
                    rarityDisplay.set(i, rarityDisplay.get(j));
                    rarityDisplay.set(j, temprarity);
                    tempjewel = jewelDisplay.get(i);
                    jewelDisplay.set(i, jewelDisplay.get(j));
                    jewelDisplay.set(j, tempjewel);
                    tempcoin = coinDisplay.get(i);
                    coinDisplay.set(i, coinDisplay.get(j));
                    coinDisplay.set(j, tempcoin);
                    tempdis = DesnameDisplay.get(i);
                    DesnameDisplay.set(i, DesnameDisplay.get(j));
                    DesnameDisplay.set(j, tempdis);
                }
            }
        }

        partitemAdapter = new ItemArrayAdapter(this, DesnameDisplay, coinDisplay, jewelDisplay, rarityDisplay, itemIdShopDisplay, numitemDisplay);
        try {
            partitem.setAdapter(partitemAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        partitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mypagedialogitem();
                txtdong1.setText(DesnameDisplay.get(position));
                txtdong2.setText(DesnameDisplay.get(position));
                String kind = "";
                String str = itemIdShopDisplay.get(position);
                String name = "";
                String part = "";
                if (str.substring(0, 3).equals("100")) {
                    name = "kabutomushi";
                    kind = "カブトムシ";
                } else if (str.substring(0, 3).equals("101")) {
                    name = "caucasus";
                    kind = "コーカサスオオカブト";
                } else if (str.substring(0, 3).equals("102")) {
                    name = "satanas";
                    kind = "サタンオオカブト";
                } else if (str.substring(0, 3).equals("103")) {
                    name = "hercules";
                    kind = "ヘラクレスオオカブト";
                } else if (str.substring(0, 3).equals("110")) {
                    name = "kokuwagata";
                    kind = "コクワガタ";
                } else if (str.substring(0, 3).equals("111")) {
                    name = "oukuwagata";
                    kind = "オオクワガタ";
                } else if (str.substring(0, 3).equals("112")) {
                    name = "giraffa";
                    kind = "ギラファノコギリクワガタ";
                } else if (str.substring(0, 3).equals("113")) {
                    name = "golden";
                    kind = "オウゴンオニクワガタ";
                }
                if (str.substring(3, 4).equals("0"))
                    part = "horn";
                else if (str.substring(3, 4).equals("1"))
                    part = "horn2";
                else if (str.substring(3, 4).equals("2"))
                    part = "head";
                else if (str.substring(3, 4).equals("3"))
                    part = "face";
                else if (str.substring(3, 4).equals("4"))
                    part = "neck";
                else if (str.substring(3, 4).equals("5"))
                    part = "body";
                else if (str.substring(3, 4).equals("6"))
                    part = "wing";
                String pos = str.substring(4, 6);
                String pImg = "" + name + part + pos;
                int resID = context.getResources().getIdentifier("@drawable/" + pImg, "drawable", context.getPackageName());
                mpdialogitemicon.setImageResource(resID);
                txtdong3.setText("[" + kind + "]用パーツ\n" + "「そうび変更」画面でそうびできます。");
                int a = Integer.parseInt(str);
                for (int i = 0; i < Integer.parseInt(rarityDisplay.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(Battle.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
        arrnumber = new ArrayList<String>();
        content = new ArrayList<String>();
        coinmp = new ArrayList<String>();
        jewelmp = new ArrayList<String>();
        str_star = new ArrayList<String>();
        fooddong2 = new ArrayList<String>();
        fooddong3 = new ArrayList<String>();
        arrnumberShow = new ArrayList<String>();
        contentShow = new ArrayList<String>();
        coinShow = new ArrayList<String>();
        jewelShow = new ArrayList<String>();
        starShow = new ArrayList<String>();
        fooddong2Show = new ArrayList<String>();
        fooddong3Show = new ArrayList<String>();
        img = new ArrayList<Integer>();
        imgShow = new ArrayList<Integer>();
        //
        contentItem = new ArrayList<String>();
        coinItem = new ArrayList<String>();
        jewelItem = new ArrayList<String>();
        fooddong2Item = new ArrayList<String>();
        fooddong3Item = new ArrayList<String>();
        starItem = new ArrayList<String>();
        arrnumberItem = new ArrayList<String>();
        contentItemShow = new ArrayList<String>();
        coinItemShow = new ArrayList<String>();
        jewelItemShow = new ArrayList<String>();
        fooddong2ItemShow = new ArrayList<String>();
        fooddong3ItemShow = new ArrayList<String>();
        starItemShow = new ArrayList<String>();
        arrnumberItemShow = new ArrayList<String>();
        imgItem = new ArrayList<Integer>();
        imgItemShow = new ArrayList<Integer>();
        //
        contentDrink = new ArrayList<String>();
        coinDrink = new ArrayList<String>();
        jewelDrink = new ArrayList<String>();
        fooddong2Drink = new ArrayList<String>();
        fooddong3Drink = new ArrayList<String>();
        starDrink = new ArrayList<String>();
        arrnumberDrink = new ArrayList<String>();
        contentDrinkShow = new ArrayList<String>();
        coinDrinkShow = new ArrayList<String>();
        jewelDrinkShow = new ArrayList<String>();
        fooddong2DrinkShow = new ArrayList<String>();
        fooddong3DrinkShow = new ArrayList<String>();
        starDrinkShow = new ArrayList<String>();
        arrnumberDrinkShow = new ArrayList<String>();
        imgDrink = new ArrayList<Integer>();
        imgDrinkShow = new ArrayList<Integer>();

        _c = new ArrayList<Integer>();
        _c2 = new ArrayList<Integer>();

        _idItem = new ArrayList<Integer>();
        _idItemShow = new ArrayList<Integer>();
        _idFood = new ArrayList<Integer>();
        _idFoodShow = new ArrayList<Integer>();
        _idDrink = new ArrayList<Integer>();
        _idDrinkShow = new ArrayList<Integer>();

        _idDrink.add(1);
        _idDrink.add(3);
        _idFood.add(1001);
        _idFood.add(1003);
        _idFood.add(1011);
        _idFood.add(1012);
        _idFood.add(1013);
        _idFood.add(1014);
        _idFood.add(1015);
        _idFood.add(1016);
        _idItem.add(3001);
        _idItem.add(3002);
        _idItem.add(3003);
        _idItem.add(3004);
        _idItem.add(3005);
        _idItem.add(3006);
        _idItem.add(3007);
        _idItem.add(3008);

        contentDrink.add("ミネラルウォーター[成虫／幼虫兼用]");
        contentDrink.add("スペシャルジュース[成虫／幼虫兼用]");
        jewelDrink.add("0");
        jewelDrink.add("0");
        coinDrink.add("10");
        coinDrink.add("30");
        starDrink.add("1");
        starDrink.add("2");
        arrnumberDrink.add("" + _DRINK);
        arrnumberDrink.add("" + _DRINKBIG);
        imgDrink.add(R.drawable.drink_icon);
        imgDrink.add(R.drawable.new_shop_icon_drink2);

        fooddong2Drink.add("富士山の雪解け水が濾過されたミネラルたっぷりな水。");
        fooddong2Drink.add("昆虫に必要な栄養素も含んだスペシャルドリンク");
        fooddong3Drink.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3Drink.add("[" + mypage.namesell + "]" + "に使用しますか？");
        //
        imgItem.add(R.drawable.item_icon);
        imgItem.add(R.drawable.new_shop_icon_item2);
        imgItem.add(R.drawable.itm_liquor);
        imgItem.add(R.drawable.itm_runpa1);
        imgItem.add(R.drawable.itm_medicine1);
        imgItem.add(R.drawable.itm_medicine2);
        imgItem.add(R.drawable.itm_o2_capsule);
        imgItem.add(R.drawable.itm_gold_ticket);

        starItem.add("1");
        starItem.add("2");
        starItem.add("2");
        starItem.add("2");
        starItem.add("6");
        starItem.add("6");
        starItem.add("5");
        starItem.add("5");
        contentItem.add("成長促進剤2倍[幼虫用]");
        contentItem.add("成長促進剤10倍[幼虫用]");
        contentItem.add("鞆の浦の保命酒[ブリーダー用]");
        contentItem.add("お掃除ルンパ[幼虫用]");
        contentItem.add("若返りの薬[幼虫用]");
        contentItem.add("進化の薬[幼虫用]");
        contentItem.add("酸素カプセル[幼虫用]");
        contentItem.add("ゴールドガチャチケット");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        jewelItem.add("0");
        jewelItem.add("0");
        jewelItem.add("0");
        jewelItem.add("2");
        jewelItem.add("5");
        jewelItem.add("5");
        jewelItem.add("3");
        jewelItem.add("1");
        arrnumberItem.add("" + _ITEM);
        arrnumberItem.add("" + _ITEMBIG);
        arrnumberItem.add("" + _FOODBIG6);
        arrnumberItem.add("" + _ITEMBIG2);
        arrnumberItem.add("" + _ITEMBIG3);
        arrnumberItem.add("" + _ITEMBIG4);
        arrnumberItem.add("" + _ITEMBIG5);
        arrnumberItem.add("" + _ITEMGOLD);
        fooddong2Item.add("成長を促すためのホルモン剤。1段階のみ有効。");
        fooddong2Item.add("10倍のスピードで成長。ぐぐっと成長する。１段階のみ有効。");
        fooddong2Item.add("広島県福山市鞆町名産の薬味酒。ブリーダーのスタミナが100%回復します。");
        fooddong2Item.add("お掃除がきらいな人に最適。");
        fooddong2Item.add("１段階前の発達フェーズに戻る");
        fooddong2Item.add("発達フェーズを次に進めることが出来る");
        fooddong2Item.add("幼虫のストレス解消にオススメ。");
        fooddong2Item.add("ゴールドガチャを一度回せるレアチケット");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("[" + pre.getString("nickname", "") + "]" + "に使用しますか？");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        //
        img.add(R.drawable.food_icon);
        img.add(R.drawable.itm_rice4);
        img.add(R.drawable.itm_jelly1);
        img.add(R.drawable.itm_jelly2);
        img.add(R.drawable.itm_rice3);
        img.add(R.drawable.itm_rice2);
        img.add(R.drawable.itm_sap);
        img.add(R.drawable.itm_banana);

        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong2.add("カブトムシ／クワガタムシ幼虫のごはん。");
        fooddong2.add("マットごはんに改良を加えたスペシャルごはん。");
        fooddong2.add("一般的な昆虫ゼリー。成虫のHPが100回復します。");
        fooddong2.add("栄養満点の昆虫ゼリー。滋養強壮も良いため体づくりに最適。成虫のHPが300回復します。");
        fooddong2.add("広葉樹の発酵が進んだカブトムシ幼虫のごはん。");
        fooddong2.add("クワガタムシ幼虫のごはん。");
        fooddong2.add("成虫のえさ。カブトムシ、クワガタムシはこのにおいが大好き。成虫のHPが50%回復します。");
        fooddong2.add("成虫のえさ。野外でカブトムシ、クワガタムシを取るための必須アイテム。成虫のHPが100%回復します。");
        str_star.add("1");
        str_star.add("2");
        str_star.add("1");
        str_star.add("2");
        str_star.add("1");
        str_star.add("1");
        str_star.add("3");
        str_star.add("3");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("1");
        coinmp.add("10");
        coinmp.add("30");
        coinmp.add("10");
        coinmp.add("30");
        coinmp.add("30");
        coinmp.add("30");
        coinmp.add("0");
        coinmp.add("0");
        content.add("マットごはん[幼虫用]");
        content.add("マットごはんスペシャル[幼虫用]");
        content.add("昆虫ゼリー[成虫用]");
        content.add("スペシャルゼリー[成虫用]");
        content.add("腐葉土ごはん[幼虫用]");
        content.add("菌糸ごはん[幼虫用]");
        content.add("樹液[成虫用]");
        content.add("焼酎バナナ[成虫用]");
        _c.add(1);
        _c.add(1);
        _c.add(1);
        _c.add(1);
        _c.add(1);
        _c.add(1);
        _c.add(1);
        _c.add(1);
        String str1 = "" + _FOOD;
        String str2 = "" + _FOODBIG;
        String str3 = "" + _FOODBIG4;
        String str4 = "" + _FOODBIG5;
        String str5 = "" + _FOODBIG2;
        String str6 = "" + _FOODBIG3;
        String str7 = "" + _FOODBIG7;
        String str8 = "" + _FOODBIG8;
        arrnumber.add(str1);
        arrnumber.add(str2);
        arrnumber.add(str3);
        arrnumber.add(str4);
        arrnumber.add(str5);
        arrnumber.add(str6);
        arrnumber.add(str7);
        arrnumber.add(str8);
        for (int i = 0; i < arrnumber.size(); i++) {
            if (!arrnumber.get(i).equals("0")) {
                arrnumberShow.add(arrnumber.get(i));
                contentShow.add(content.get(i));
                coinShow.add(coinmp.get(i));
                jewelShow.add(jewelmp.get(i));
                fooddong2Show.add(fooddong2.get(i));
                fooddong3Show.add(fooddong3.get(i));
                starShow.add(str_star.get(i));
                imgShow.add(img.get(i));
                _idFoodShow.add(_idFood.get(i));
            }
        }
        adapterMono = new AdapterMono(this, contentShow, coinShow, jewelShow, starShow, arrnumberShow, imgShow, _idFoodShow);
        fooditem.setAdapter(adapterMono);
        fooditem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _item = 2;
                _pos = position;
                iddrink = _idFoodShow.get(position);
                mypagedialogitem();
                if (contentShow.get(position).equals("昆虫ゼリー[成虫用]") || contentShow.get(position).equals("スペシャルゼリー[成虫用]")
                        || contentShow.get(position).equals("樹液[成虫用]") || contentShow.get(position).equals("焼酎バナナ[成虫用]")) {
                    btnok.setVisibility(View.GONE);
                    shop_yes.setVisibility(View.VISIBLE);
                    shop_no.setVisibility(View.VISIBLE);
                }
                txtdong1.setText(contentShow.get(position));
                txtdong2.setText(fooddong2Show.get(position));
                txtdong3.setText(fooddong3Show.get(position));
                mpdialogitemicon.setImageResource(imgShow.get(position));
                for (int i = 0; i < Integer.parseInt(starShow.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(Battle.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        itemitem = (ListView) dialogmochimono.findViewById(R.id.itemitem);
        for (int i = 0; i < arrnumberItem.size(); i++) {
            if (!arrnumberItem.get(i).equals("0")) {
                arrnumberItemShow.add(arrnumberItem.get(i));
                contentItemShow.add(contentItem.get(i));
                coinItemShow.add(coinItem.get(i));
                jewelItemShow.add(jewelItem.get(i));
                fooddong2ItemShow.add(fooddong2Item.get(i));
                fooddong3ItemShow.add(fooddong3Item.get(i));
                starItemShow.add(starItem.get(i));
                imgItemShow.add(imgItem.get(i));
                _idItemShow.add(_idItem.get(i));
            }
        }
        adapterMonoItem = new AdapterMono(this, contentItemShow, coinItemShow, jewelItemShow, starItemShow, arrnumberItemShow, imgItemShow, _idItemShow);
        itemitem.setAdapter(adapterMonoItem);
        itemitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _clickmp = position;
                _item = 0;
                mypagedialogitem();
                if (contentItemShow.get(position).equals("鞆の浦の保命酒[ブリーダー用]")) {
                    shop_yes.setVisibility(View.VISIBLE);
                    shop_no.setVisibility(View.VISIBLE);
                    btnok.setVisibility(View.GONE);
                }
                txtdong1.setText(contentItemShow.get(position));
                txtdong2.setText(fooddong2ItemShow.get(position));
                txtdong3.setText(fooddong3ItemShow.get(position));
                mpdialogitemicon.setImageResource(imgItemShow.get(position));
                for (int i = 0; i < Integer.parseInt(starItemShow.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(Battle.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
        for (int i = 0; i < arrnumberDrink.size(); i++) {
            if (!arrnumberDrink.get(i).equals("0")) {
                arrnumberDrinkShow.add(arrnumberDrink.get(i));
                contentDrinkShow.add(contentDrink.get(i));
                coinDrinkShow.add(coinDrink.get(i));
                jewelDrinkShow.add(jewelDrink.get(i));
                fooddong2DrinkShow.add(fooddong2Drink.get(i));
                fooddong3DrinkShow.add(fooddong3Drink.get(i));
                starDrinkShow.add(starDrink.get(i));
                imgDrinkShow.add(imgDrink.get(i));
                _idDrinkShow.add(_idDrink.get(i));
            }
        }
        adapterMonoDrink = new AdapterMono(this, contentDrinkShow, coinDrinkShow, jewelDrinkShow, starDrinkShow, arrnumberDrinkShow, imgDrinkShow, _idDrinkShow);
        drinkitem.setAdapter(adapterMonoDrink);
        drinkitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _item = 1;
                _pos = position;
                iddrink = _idDrinkShow.get(position);
                mypagedialogitem();
                shop_yes.setVisibility(View.VISIBLE);
                shop_no.setVisibility(View.VISIBLE);
                btnok.setVisibility(View.GONE);
                txtdong1.setText(contentDrinkShow.get(position));
                txtdong2.setText(fooddong2DrinkShow.get(position));
                txtdong3.setText(fooddong3DrinkShow.get(position));
                mpdialogitemicon.setImageResource(imgDrinkShow.get(position));
                for (int i = 0; i < Integer.parseInt(starDrinkShow.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(Battle.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
        btncloselayoutitem = (Button) dialogmochimono.findViewById(R.id.btncloselayoutitem);
        ImageView dialogitemfood = (ImageView) dialogmochimono.findViewById(R.id.dialogitemfood);
        ImageView dialogitemdrink = (ImageView) dialogmochimono.findViewById(R.id.dialogitemdrink);
        ImageView dialogitemitem = (ImageView) dialogmochimono.findViewById(R.id.dialogitemitem);
        ImageView dialogitempart = (ImageView) dialogmochimono.findViewById(R.id.dialogitempart);
        dialogitempart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                HideLayoutItem();
                ShowPartItem();
            }
        });
        dialogitemfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                HideLayoutItem();
                ShowFoodItem();
            }
        });
        dialogitemdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                HideLayoutItem();
                ShowDrinkItem();
            }
        });
        dialogitemitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                HideLayoutItem();
                ShowItemItem();
            }
        });
        btncloselayoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (!flagBack) {
                    dialogmochimono.dismiss();
                } else if (flagBack) {
                    HideAllItem();
                    ShowLayoutItem();
                }
            }
        });
        dialogmochimono.show();
    }

    public void HideLayoutItem() {
        flagBack = true;
        layoutitem.setVisibility(View.GONE);
        btncloselayoutitem.setBackgroundResource(R.drawable.btn_back);
    }

    Dialog dialogmochimono, mpdialogitem;

    public void ShowFoodItem() {
        fooditem.setVisibility(View.VISIBLE);
    }

    public void ShowDrinkItem() {
        drinkitem.setVisibility(View.VISIBLE);
    }

    public void ShowItemItem() {
        itemitem.setVisibility(View.VISIBLE);
    }

    public void HideAllItem() {
        fooditem.setVisibility(View.GONE);
        drinkitem.setVisibility(View.GONE);
        itemitem.setVisibility(View.GONE);
        partitem.setVisibility(View.GONE);
    }

    Button btncloselayoutitem;
    ListView fooditem, itemitem, drinkitem, partitem;
    boolean flagBack = false;
    Animation animation;
    LinearLayout layoutitem;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowLayoutItem() {
        flagBack = false;
        btncloselayoutitem.setBackgroundResource(R.drawable.btn_close);
//        animation.setDuration(500);
        layoutitem.setVisibility(View.VISIBLE);
//        layoutitem.setAnimation(animation);
//        layoutitem.animate();
//        animation.start();
    }

    ImageView mpdialogitemicon;
    int _item, _pos, _clickmp, iddrink;

    public void mypagedialogitem() {
        mpdialogitem = new Dialog(Battle.this);
        mpdialogitem.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mpdialogitem.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mpdialogitem.setCanceledOnTouchOutside(false);
        mpdialogitem.setContentView(R.layout.mypagedialogitem);
        txtdong1 = (TextView) mpdialogitem.findViewById(R.id.txttitle);
        txtdong2 = (TextView) mpdialogitem.findViewById(R.id.txtcontent);
        txtdong3 = (TextView) mpdialogitem.findViewById(R.id.txtbottom);
        shop_yes = (ImageView) mpdialogitem.findViewById(R.id.shop_yes);
        shop_no = (ImageView) mpdialogitem.findViewById(R.id.shop_no);
        lnstar = (LinearLayout) mpdialogitem.findViewById(R.id.lnstar);
        btnok = (ImageView) mpdialogitem.findViewById(R.id.btnok);
        mpdialogitemicon = (ImageView) mpdialogitem.findViewById(R.id.mpdialogitemicon);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpdialogitem.dismiss();
            }
        });
        shop_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                if (pre.getBoolean("soundaction", true) && bsound == false)
                    mypage.kSECommand.start();
                int value = 0;
                String kkey = "";
                if (_item == 0) {
                    mypage.theluc = pre.getInt("lv", 1) * 10;
                    editor.putInt("theluc", mypage.theluc);
                    progressBar3.setProgress(mypage.theluc);
                    txtphantram.setText("" + mypage.theluc + "/" + mypage.theluc);
                    _FOODBIG6--;
                    String _a = "" + _FOODBIG6;
                    arrnumberItemShow.set(_clickmp, _a);
                    if (Integer.parseInt(_a) == 0) {
                        arrnumberItemShow.remove(_clickmp);
                        contentItemShow.remove(_clickmp);
                        coinItemShow.remove(_clickmp);
                        jewelItemShow.remove(_clickmp);
                        fooddong2ItemShow.remove(_clickmp);
                        fooddong3ItemShow.remove(_clickmp);
                        starItemShow.remove(_clickmp);
                        imgItemShow.remove(_clickmp);
                        _idItemShow.remove(_clickmp);
                    }
                    adapterMonoItem.notifyDataSetChanged();
                    String key = "" + _idItemShow.get(_clickmp);
                    if (key.length() == 1)
                        key = "0000" + key;
                    else if (key.length() == 2)
                        key = "000" + key;
                    else if (key.length() == 3)
                        key = "00" + key;
                    else if (key.length() == 4)
                        key = "0" + key;
                    editor.putInt(key, _FOODBIG6);
                    long k = Long.parseLong(key);
                    db.update_Sumpart(k, _FOODBIG6);
                } else if (_item == 1) {
                    kkey = "" + iddrink;
                    if (iddrink == 1) {
                        mypage._hp += 25;
                        _DRINK--;
                        value = _DRINK;
                    } else if (iddrink == 3) {
                        mypage._hp += 50;
                        _DRINKBIG--;
                        value = _DRINKBIG;
                    }
                    if (mypage._hp > mypage.pl_hp)
                        mypage._hp = mypage.pl_hp;
                    txtHp.setText(mypage._hp + "/" + mypage.pl_hp);
                    prhp.setProgress(mypage._hp);
                    db.update_Sumpart(iddrink, value);
                    double _curHp = mypage._hp * 100 / mypage.pl_hp;
                    db.update_hp(idpetsell, _curHp);
                    editor.putInt(kkey, value);
                    editor.commit();
                    String vv = "" + value;
                    arrnumberDrinkShow.set(_pos, vv);
                    if (Integer.parseInt(vv) == 0) {
                        arrnumberDrinkShow.remove(_pos);
                        contentDrinkShow.remove(_pos);
                        coinDrinkShow.remove(_pos);
                        jewelDrinkShow.remove(_pos);
                        fooddong2DrinkShow.remove(_pos);
                        fooddong3DrinkShow.remove(_pos);
                        starDrinkShow.remove(_pos);
                        imgDrinkShow.remove(_pos);
                        _idDrinkShow.remove(_pos);
                    }
                    adapterMonoDrink.notifyDataSetChanged();
                } else if (_item == 2) {
                    kkey = "" + iddrink;
                    if (iddrink == 1011) {
                        mypage._hp += 100;
                        _FOODBIG4--;
                        value = _FOODBIG4;
                    } else if (iddrink == 1012) {
                        mypage._hp += 300;
                        _FOODBIG5--;
                        value = _FOODBIG5;
                    } else if (iddrink == 1015) {
                        mypage._hp += mypage.pl_hp / 2;
                        _FOODBIG7--;
                        value = _FOODBIG7;
                    } else if (iddrink == 1016) {
                        mypage._hp = mypage.pl_hp;
                        _FOODBIG8--;
                        value = _FOODBIG8;
                    }
                    if (mypage._hp > mypage.pl_hp)
                        mypage._hp = mypage.pl_hp;
                    txtHp.setText(mypage._hp + "/" + mypage.pl_hp);
                    prhp.setProgress(mypage._hp);
                    db.update_Sumpart(iddrink, value);
                    double _curHp = mypage._hp * 100 / mypage.pl_hp;
                    db.update_hp(idpetsell, _curHp);
                    editor.putInt(kkey, value);
                    editor.commit();
                    String vv = "" + value;
                    arrnumberShow.set(_pos, vv);
                    if (Integer.parseInt(vv) == 0) {
                        arrnumberShow.remove(_pos);
                        contentShow.remove(_pos);
                        coinShow.remove(_pos);
                        jewelShow.remove(_pos);
                        fooddong2Show.remove(_pos);
                        fooddong3Show.remove(_pos);
                        starShow.remove(_pos);
                        imgShow.remove(_pos);
                        _idFoodShow.remove(_pos);
                    }
                    adapterMono.notifyDataSetChanged();
                }
                mpdialogitem.dismiss();
            }
        });
        shop_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpdialogitem.dismiss();
            }
        });
        mpdialogitem.show();
    }

    Context context = this;
    int _FOOD, _FOODBIG, _FOODBIG2, _FOODBIG3, _FOODBIG4, _FOODBIG5, _FOODBIG6, _FOODBIG7, _FOODBIG8,
            _DRINK, _DRINKBIG, _ITEM, _ITEMBIG, _ITEMBIG2, _ITEMBIG3, _ITEMBIG4, _ITEMBIG5, _ITEMGOLD;

    public void ShowPartItem() {
        partitem.setVisibility(View.VISIBLE);
    }

    public int calcExtraParamAtBeetle2(int inKind, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                       int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                       int param_Speed_supplement, int part) {
        int result = 0;
        double lifeMax = 0, strengthMax = 0, formMax = 0, friendlyMax = 0, personalityMax = 0;
        lifeMax = Chat.kBeetleLife_Max * Chat.parameterRatio(inKind);
        strengthMax = Chat.kBeetleStrength_Max * Chat.parameterRatio(inKind);
        formMax = Chat.kBeetleForm_Max * Chat.parameterRatio(inKind);
        friendlyMax = Chat.kBeetleFriendly_Max * Chat.parameterRatio(inKind);
        personalityMax = Chat.kBeetlePersonality_Max * Chat.parameterRatio(inKind);
        switch (part) {
            case 1: {
                double extraParamBaseRatio = (double) param_hp_supplement;
                // HP補正   (パラメータlife / 生命力Max) * パラメータ補正
                result = (int) Math.floor((double) _life2 / (double) lifeMax *
                        extraParamBaseRatio);
            }
            break;
            case 2: {
                double extraParamBaseRatio = (double) param_attack_supplement;
                // こうげき補正 (パラメータStrength / 強さMax) * パラメータ補正
                result = (int) Math.floor((double) _strength2 / (double) strengthMax *
                        extraParamBaseRatio);
            }
            break;
            case 3: {
                double extraParamBaseRatio = (double) param_CriticalAttack_supplement;
                // こうげき(クリティカル)補正 ((パラメータStrength / 強さMax) - (パラメータForm / かっこよさMax)) * パラメータ補正   値が大きくなりすぎると面白くないので
                double strength = ((double) _strength2 / (double) strengthMax);
                double form = ((double) _form2 / (double) formMax);
                result = (int) Math.floor((strength - form) * extraParamBaseRatio);
            }
            break;
            case 4: {
                double extraParamBaseRatio = (double) param_Defense_supplement;
                // ぼうぎょ補正 (パラメータSize - 0.6 * サイズmax) / (0.4 * サイズmax) * パラメータ補正  サイズはmax値の6割までは確実に成長するので伸びしろで計算をする
                double size = ((double) _size2 - 0.6 * (double) Chat.kBeetleSizeMax);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 5: {
                double extraParamBaseRatio = (double) param_Critical_supplement;
                // クリティカル発動補正 (パラメータForm / かっこよさMax - (パラメータFriendluw / なつき度Max)) * パラメータ補正  なつき度が高いと野生の感がなくなるイメージ
                double form = ((double) _form2 / (double) formMax);
                double friendly = ((double) _friendly2 / (double) friendlyMax);
                result = (int) Math.floor((form - friendly) * extraParamBaseRatio);
            }
            break;
            case 6: {
                double extraParamBaseRatio = (double) param_Avoid_supplement;
                //かいひ補正    (パラメータpersonality / パーソナリティMax -  (パラメータFriendluw / なつき度Max)) * パラメータ補正    なつき度が高いと野生の感がなくなるイメージ
                double personality = ((double) _personality2 / (double) personalityMax);
                double friendly = ((double) _friendly2 / (double) friendlyMax);
                result = (int) Math.floor((personality - friendly) * extraParamBaseRatio);
            }
            break;
            case 7: {
                double extraParamBaseRatio = (double) param_Lucky_supplement;
                // ラッキー補正 (1 - (パラメータStrength / 強さMax + パラメータForm / かっこよさMax + パラメータpersonality / パーソナリティMax) / 3 + (パラメータFriendluw / なつき度Max)) * パラメータ補正    あまり強すぎる個体を作らないために攻撃、クリティカル発動率、回避のパラメータとのバランスを取る。ただしある程度こまめに世話をした方が強くなるように生命力とは独立をさせて、friendlyが高いほど高くなるようにする。
                double strength = ((double) _strength2 / (double) strengthMax);
                double form = ((double) _form2 / (double) formMax);
                double personality = ((double) _personality2 / (double) personalityMax);
                double friendly = ((double) _friendly2 / (double) friendlyMax);
                result = (int) Math.floor((1 - (strength + form + personality) / 3.0 + friendly) * extraParamBaseRatio);
            }
            break;
            case 8: {
                double extraParamBaseRatio = (double) param_Speed_supplement;
                //すばやさ補正   (サイズmax - パラメータSize) / (0.4 * サイズmax) * パラメータ補正    ぼうぎょと同様に確実に成長する部分は無視をする
                double size = ((double) Chat.kBeetleSizeMax - (double) _size2);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 0:
                break;
        }
        return (result);
    }

    AtomicBoolean flaganim = new AtomicBoolean(false);

//    public void runAnim() {
//        flaganim.set(false);
//        Thread t = new Thread() {
//            int i;
//
//            @Override
//            public void run() {
//                while (1 < 2) {
//                    for (i = 0; i >= 0 && flaganim.get(); i++) {
////                        Log.e("TAG", "i:" + i);
//                        if (i > 5)
//                            i = 0;
//                        try {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    if (i == 1)
//                                        _anim_coin();
//                                    if (i == 3)
//                                        _anim_coin();
//                                    if (i == 5)
//                                        _anim_coin();
//                                }
//                            });
//                            Thread.sleep(5000);
//                        } catch (Exception e) {
//
//                        }
//                    }
//                }
//            }
//        };
//        flaganim.set(true);
//        t.start();
//    }

    static Timer timer;
    TimerTask timerTask;
    int imgCur = 0;

    public void runAnim() {
        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask, 0, 5000);
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        imgCur++;
                        if (imgCur > 5)
                            imgCur = 0;
                        if (imgCur == 1)
                            _anim_coin();
                        else if (imgCur == 3)
                            _anim_coin();
                        else if (imgCur == 5)
                            _anim_coin();
                    }
                });
            }
        };
    }

    public void _anim_coin() {
        if (anim_coin.isRunning())
            anim_coin.stop();
        if (anim_jewel.isRunning())
            anim_jewel.stop();
        if (anim_shin1.isRunning())
            anim_shin1.stop();
        if (anim_shin2.isRunning())
            anim_shin2.stop();
        anim_coin.start();
        anim_jewel.start();
        anim_shin1.start();
        anim_shin2.start();
    }

    public void _Confetti() {
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
//                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = 0; i < 4; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) _createConfetti();
                                if (i == 2) _createConfetti();
                                if (i == 3) _createConfetti();
                            }
                        });
                        Thread.sleep(1500);
                    } catch (Exception e) {

                    }
                }
            }
        };
        th.start();
    }

    public void _createConfetti() {
        int size = (int) Chat.convertDpToPixel(10);
        for (int i = 0; i < 9; i++) {
            int a = new Random().nextInt(4);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);
            int w = mypage._Width - 100;
            int mg = new Random().nextInt(w) + 50;
            int mt = new Random().nextInt(80);
            params.setMargins(mg, -mt, 0, 0);
            final ImageView img = new ImageView(this);
            if (a == 0)
                img.setImageResource(R.drawable.confetti_green);
            else if (a == 1)
                img.setImageResource(R.drawable.confetti_pink);
            else if (a == 2)
                img.setImageResource(R.drawable.confetti_white);
            else if (a == 3)
                img.setImageResource(R.drawable.confetti_yellow);
            img.setLayoutParams(params);
            confetti.addView(img);
            img.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            AnimationSet snowMov1 = new AnimationSet(true);
            RotateAnimation rotate1 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate1.setStartOffset(50);
            rotate1.setDuration(2000);
            rotate1.setRepeatCount(-1);
            snowMov1.addAnimation(rotate1);
            TranslateAnimation trans1 = new TranslateAnimation(0, new Random().nextInt(w) + 50, 0, 600);
            trans1.setDuration(3000);
            trans1.setRepeatCount(-1);
            snowMov1.addAnimation(trans1);
            snowMov1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    img.setLayerType(View.LAYER_TYPE_NONE, null);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            img.startAnimation(snowMov1);
        }
    }
}