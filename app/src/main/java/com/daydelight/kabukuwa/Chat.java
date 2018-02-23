package com.daydelight.kabukuwa;

import android.content.res.Resources;
import android.media.Image;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by goood on 8/6/15.
 */
public class Chat {
    public static int
            Kabutomusi = 0,    // カブトムシ
            Kokuwagata = 1,    // コクワガタ
            Caucasus = 2,    // コーカサス
            Dorcus = 3,    // オオクワガタ
            Satanas = 4,    // サターンオオカブト
            Giraffa = 5,    // ギラファノコギリクワガタ
            AllotopusRosenbergi = 6,    // オウゴンオニクワガタ
            Hercules = 7,    // ヘラクレスオオカブト
            kTypeSpecies_Max = 8,
            kBeetleSizeMax = 10000,
            kAttackResultType_Avoid = 0,    //回避
            kAttackResultType_Normal = 1,        //通常攻撃
            kAttackResultType_Critical = 2;        //クリティカル
//    public static int
//            nothing = -1,
//            horn1 = 0,
//            horn2 = 1,
//            body = 2,
//            face = 3,
//            head = 4,
//            neck = 5,
//            wing = 6;

    public static int KABUKUWA_SPECIES = 8,
            KABUKUWA_PARTS = 7;
    public static int
            kBattleParamKind_Unknown = 0,
            kBattleParamKind_HP = 1,                    //HP
            kBattleParamKind_Attack = 2,                //こうげき
            kBattleParamKind_AttackCritical = 3,        //こうげき(クリティカル)
            kBattleParamKind_Diffence = 4,                //ぼうぎょ
            kBattleParamKind_DoCritical = 5,            //クリティカル発動
            kBattleParamKind_Avoid = 6,                    //かいひ
            kBattleParamKind_Lucky = 7,                    //ラッキー
            kBattleParamKind_Speed = 8;
    public static int kCPULevelRegion_Easy = 0,
            kCPULevelRegion_Normal = 1,
            kCPULevelRegion_Hard = 2,
            kCPULevelRegion_King = 3,
            kCPULevelRegion_Max = 4;
    public static int dNumOfCPUForEasy = 8,    //EasyのCPUの数
            dNumOfCPUForNormal = 16,    //NormalのCPUの数
            dNumOfCPUForHard = 24,    //HardのCPUの数
            dNumOfCPUForKing = 32;    //KingのCPUの数
    public static int kShopItemNo_Parts_Imago_Start = 100000;            // 100000番台は各成虫パーツ
    public static int kBeetleSubKind_JapanBeetle = 0,    // 日本カブトムシ
            kBeetleSubKind_Caucasus = 1,                    // コーカサスカブトムシ
            kBeetleSubKind_Satanas = 2,                        // サタンオオカブト
            kBeetleSubKind_Hercules = 3,                    // ヘラクレスオオカブト
            kBeetleSubKind_JapanDorcusRectus = 1000,    // 日本コクワガタ
            kBeetleSubKind_JapanDorcusCurvidens = 1001,    // 日本オオクワガタ
            kBeetleSubKind_ProsopocoilusGiraffa = 1002,    // ギラファノコギリクワガタ
            kBeetleSubKind_AllotopusRosenbergi = 1003;    // オウゴンオニクワガタ
    public static String NoiTaolao[] = {"グズグズ", "ビクッ", "うわぁ～～い", "びえ～～～ん", "ぎゃぎゃぎゃ", "ニコッ", "バブー", "イヤイ", "ダメ", "ごろごろ",
            "キッ！", "だっこ、だっこ", "ガサゴソ", "なでなで", "イヤイヤ", "チラッ", "いないないばーして", "フン", "ニコニコ"};
    public static String Noi2Tuoi[] = {"ゲホゲホ", "ギギギッ", "も～", "そっとしておいて。", "ひとりがいい", "シレーッ", "プイッ", "遊んで、遊んで。",
            "にっこり", ")^o^(　)^o^(　)^o^(", "ニャンニャン", "もっともっと", "うれし～♪"};
    public static String NoiKhiAn[] = {"今日もコレ〜？", "そろそろ甘いものが食べたい。", "栄養補給、栄養補給", "ありがとうございました。", "ごはん♪ごはん♪"};
    public static String NoiKhiAn2tuoi[] = {" お腹がいっぱい", "食べ物、おいし～い。", "土ってどんな味？", "いただきましたぁ。", "食べても食べてもお腹がすくんだ。", "おいちー", "おくちあーん"};
    public static String NoiKhiAn1tuoi[] = {"ありがちゅ", "んまっ、んまっ", "ばっくん、ばっくん", "モグモグ", "ぺちゃぺちゃ", "大きくなった？", "カミカミ"};
    public static String NoiKhiUong[] = {"酔っぱらったぜ。", "栄養ドリンクにしてくれ！", "これ、お肌にいいの？", "おかわりください。", "甘いのお願い！"};
    public static String NoiKhiUong1tuoi[] = {"ゴックン、ゴックン", "ちっち、ちっち", "ちゅうちゅう", "コクコク", "プハー"};
    public static String NoiKhiUong2tuoi[] = {"のど、乾いたぁ", "お茶ください", "プハー", "お茶がよかった。"};
    public static String NoiKhiQuetNha[] = {"実は綺麗好きなんだ。", "ダニがいっぱいだと死んでしまうぞ！", "ピッカピカにしてね", "ベットの部屋も忘れずに"};
    public static String NoiKhiQuetNha1tuoi[] = {"きれいきれい", "ピッカピカ"};
    public static String NoiKhiQuetNha2tuoi[] = {"ピッカピカ", "掃除してくれてありがとう。", "綺麗にすると、気持ちいい！"};
    public static String NoiKhiMoodXau1tuoi[] = {"ぐちゅぐちゅ", "あちちちちち", "かゆーい", "ねんね、ねんね、ねんね", "ぶるぶる", "のど、かわいたあ", "プンプン",
            "つらい", "もうダメ"};
    public static String NoiKhiMoodXau2tuoi[] = {"暑い、暑い。", "水がほしいよオ。", "ダニ、ダニ、ダニ！", "かゆい、かゆい。", "寒い、寒い。",
            "眠い、眠い。", "外の音がうるさいよ。", "プン／プンプン"};
    public static String NoiKhiMoodXau3tuoi[] = {"目がかゆい、花粉症？", "暑いな。", "水、くれ。", "水、水、水。", "ダニをなんとかしてくれ！",
            "さむっ！！！", "眠いぞ！", "昼寝するぞ！", "外がうるさい！！！", "ほっといて！！"};
    public static String NoiKhiTam1tuoi[] = {"じゃあじゃあ", "ゴシゴシ", "すっきり", "ピッカピカ", "きれい、きれい"};
    public static String NoiKhiTam2tuoi[] = {"ちょっとあつっ", "めんめ〜タオル〜", "汚れ、おちた？", "雨？", "石鹸、ある？"};
    public static String NoiKhiTam3Tuoi[] = {"シャワーを浴びたら、泥パックでもするか。", "男前になっただろ。", "大事な髪にブラシをかけよっと。", "風呂上りの一杯、準備しといてね！"};
    public static String NoiTaoLao3Tuoi[] = {"不本意だが、驚いた。", "何すんだ！！！", "しない！！", "ぜったいいや！！", "触るな。", "だるいから、そっとしておいて。",
            "なんか用？", "やっぱりいや！！", "こっち見ないでよ！！", "ごろにゃあ～ん", "いっしょにあそぼー", "ぽっ♡", "ごろごろ)^o^(", "にこっ"};
    public static String NoiKhiThanhNhong[] = {"ん〜動けね．．.", "イチ、二、イチ、二  "};

    public static String NoiKhiChamConTrung[] = {"・・・", "カサカサ", "ムクムク。。", "あちちち", "早く外に出たいよオ", "なんの音？",
            "もこもこ", "トントン", "モゾモゾ", "くらい、くらい", "フラフラごっつんこ♪", "パリっ、パリパリッ"};
    public static String NoiKhiMoodTot1tuoi[] = {"超ゴキゲン", "ランランラン", "ニコニコ"};
    public static String NoiKhiMoodTot2tuoi[] = {"体調はいいみたい。", "早寝、早起き、早ごはん。", "テレビ、見よっと。", "外に出たら何しようかなあ？",
            "ちょっと散歩行かない？"};
    public static String NoiKhiMoodTot3tuoi[] = {"あともう少しで娑婆だ。", "土ランドは中々いいぞ！", "絶好調。", "今日の調子はどう？", "テレビでも見るか？",
            "ちょっと買い物いかない？", "何かお手伝いしようか？"};
    public static String NoiKhiDoi1tuoi[] = {"ぐうううう", "まんま、まんま", "うえ～～ん(>_<)", "はらペコリ", "おなかちゅいた"};
    public static String NoiKhiDoi2tuoi[] = {"お腹、すいたよオ。", "ごはん、まだ？", "おかわりください", "おなかがペッコペコ"};
    public static String NoiKhiDoi3tuoi[] = {"お腹、空いています。", "腹、へった！！！！", "ごはんまだ～？"};
    public static String NoiNham[] = {"よちよち", "るんるんるん", "ぴょん、ぴょん", "ぺたぺた"};
    public static String NoiNham2[] = {"ここは意外に狭いな。", "散歩に行きたいな。", "どこいくの？", "ジャーンプ", "買い物いこ～"};
    public static String NoiNham3[] = {"ぜえぜえ！！", "ランニングでもするか。", "そろそろここも飽きた。", "買い物いこ～"};
    public static String winnerMessageForPlayer[] = {"やったぜ！！", "やったー！！", "勝利！！", "勝ったぞー！！",
            "やっぴ〜", "らりほ〜", "あたるもユッケ、あたらぬもユッケ",
            "あの子シャイだから・・・", "うほほい！", "うほ♪", "げぴ♪", "分かる！"};
    public static String winnerMessageForCPU[] = {"出直してこい", "まだまだだな", "修行が足りん", "勝利！！",
            "カカカカカ(笑)", "ウケケケケ(笑)", "まるでこの世の縮図だな。",
            "愚の骨頂", "おとといきやがれ！", "いい心持ちだね〜", "ムダムダムダ！"};
    public static String startMessageForPlayer[] = {"頑張ります！！", "頑張るぞ！！", "いくぞー！！", "いきますよー！！", "勝負！！", "よろしく！！",
            "おげぺ〜", "やーやー我こそは！", "マジっすか!?",
            "ゲロゲロ〜", "みなぎる〜♪", "キライじゃ〜ない。", "朝飯前だぜ！", "ウケる〜♪", "やらいでか！"};
    public static String startMessageForCPU[] = {"負けないぞ！！", "かかってこい！！", "かかってきなさい！！", "いきますよー！！", "勝負！！", "こい！！",
            "おげぺ〜", "やーやー我こそは！", "マジっすか!?", "ゲロゲロ〜", "みなぎる〜♪",
            "キライじゃ〜ない。", "朝飯前だぜ！", "ウケる〜♪", "やらいでか！"};
    public static String massagesWin[] = {
            "おめでとう！", "CONGRATULATION！", "祝！", "頑張ったね！", "やるじゃん♪", "できたんこぶ！", "マンモスオゲペ〜",
    };
    public static String massagesLose[] = {"次こそ勝利だ！",
            "レベルを上げよう！", "再挑戦だ！", "パーツを変えてみよう！", "らしくないじゃん♪",
            "もはやこれまでの術！", "それナイわ〜", "ばふ！？", "おぼ・・・", "ブヒ〜",
    };
    public static int dWingMax = 4;
    public static int dBodyMax = 7;
    public static int dNeckMax = 4;
    public static int dHorn2Max = 7;
    public static int dHeadMax = 7;
    public static int dFaceMax = 7;
    public static int dHornMax = 7;

    public static int rankpet3(float age) {
        int a = 0;
        if (age < 1)
            a = 500;
        if (age >= 1 && age < 2)
            a = 800;
        if (age >= 2)
            a = 1000;
        return a;
    }

    public static int rankpet4(float age) {
        int a = 0;
        if (age < 1)
            a = 1000;
        if (age >= 1 && age < 2)
            a = 1600;
        if (age >= 2)
            a = 2000;
        return a;
    }

    public static int rankpet7(float age) {
        int a = 0;
        if (age < 1)
            a = 750;
        if (age >= 1 && age < 2)
            a = 1200;
        if (age >= 2)
            a = 1500;
        return a;
    }

    public static int rankpet8(float age) {
        int a = 0;
        if (age < 1)
            a = 1500;
        if (age >= 1 && age < 2)
            a = 2400;
        if (age >= 2)
            a = 3000;
        return a;
    }

    public static int bonusWithCondition(int friendly, int mood) {
        int bonus = (friendly / 10 + mood / 10) / 2;
        if (bonus > 100)
            bonus = 100;
        return bonus;
    }

    public static double ratio(int rank) {
        double ratio = 0;
        if (rank == 1)
            ratio = 1;
        if (rank == 2)
            ratio = 2;
        if (rank != 1 && rank != 2)
            ratio = 0.5;
        return ratio;
    }

    public static double ratio2(int rank) {
        double ratio = 0;
        if (rank == 1)
            ratio = 1;
        if (rank == 2)
            ratio = 2;
        if (rank != 1 && rank != 2)
            ratio = 0.8;
        return ratio;
    }

    public static int convertSpeciesValue(int kind) {
        // アプリのデータとCSV用のデータが異なるので変換する
        int result = -1;
        switch (kind) {
            case 0:
                // 日本カブトムシ
                result = Kabutomusi;
                break;
            case 1:
                // コーカサスカブトムシ
                result = Caucasus;
                break;
            case 2:
                // サタンオオカブト
                result = Satanas;
                break;
            case 3:
                // ヘラクレスオオカブト
                result = Hercules;
                break;
            case 1000:
                // 日本コクワガタ
                result = Kokuwagata;
                break;
            case 1001:
                // 日本オオクワガタ
                result = Dorcus;
                break;
            case 1002:
                // ギラファノコギリクワガタ
                result = Giraffa;
                break;
            case 1003:
                // オウゴンオニクワガタ
                result = AllotopusRosenbergi;
                break;
            default:
                break;
        }
        return result;
    }

    public static int needExpTilLevelUpAtImagoLevel(int inImagoLevel, int inSubKind) {
        if (inImagoLevel >= 99)
            return (2147483647);
        int maxExp = 0;
        switch (inSubKind) {
            case 0:
                maxExp = 300;
                break;
            case 1:
                maxExp = 500;
                break;
            case 2:
                maxExp = 600;
                break;
            case 3:
                maxExp = 1000;
                break;
            case 1000:
                maxExp = 300;
                break;
            case 1001:
                maxExp = 500;
                break;
            case 1002:
                maxExp = 600;
                break;
            case 1003:
                maxExp = 1000;
                break;
        }
        maxExp += maxExp * 0.1 * inImagoLevel;
        return (maxExp);
    }

    public static int battleExp(int subKind, int imagoLevel, int imagoHornRank, int imagoHorn2Rank, int imagoHeadRank,
                                int imagoFaceRank, int imagoNeckRank, int imagoBodyRank, int imagoWingRank, boolean inWon) {
        double kindValue = 0.0;
        switch (subKind) {
            case 0:
                kindValue = 300.0;
                break;
            case 1:
                kindValue = 500.0;
                break;
            case 2:
                kindValue = 600.0;
                break;
            case 3:
                kindValue = 1000.0;
                break;
            case 1000:
                kindValue = 300.0;
                break;
            case 1001:
                kindValue = 500.0;
                break;
            case 1002:
                kindValue = 600.0;
                break;
            case 1003:
                kindValue = 1000.0;
                break;
        }

        double minValue = kindValue / 5.0;
        double maxValue = kindValue;

        double baseExp = 0.0;
        if (imagoLevel == 0)
            baseExp = minValue;
        else
            baseExp = minValue + (maxValue - minValue) / 99.0 * ((double) imagoLevel + 1.0);

        double extValueRatio = 0.0;
        if (imagoHornRank >= 0)
            extValueRatio += 0.001 * Math.pow((double) imagoHornRank, 2.0);
        if (subKind == 1 || subKind == 2 || subKind == 3)
            extValueRatio += 0.001 * Math.pow((double) imagoHorn2Rank, 2.0);
        else
            extValueRatio += 0.001 * Math.pow((double) imagoHornRank / 2.0, 2.0);    //バトルシミュレータに合わせ、Horn2がない場合、Horn1の半分の値を考慮にいれる。
        if (imagoHeadRank >= 0)
            extValueRatio += 0.001 * Math.pow((double) imagoHeadRank, 2.0);
        if (imagoFaceRank >= 0)
            extValueRatio += 0.001 * Math.pow((double) imagoFaceRank, 2.0);
        if (imagoNeckRank >= 0)
            extValueRatio += 0.001 * Math.pow((double) imagoNeckRank, 2.0);
        if (imagoBodyRank >= 0)
            extValueRatio += 0.001 * Math.pow((double) imagoBodyRank, 2.0);
        if (imagoWingRank >= 0)
            extValueRatio += 0.001 * Math.pow((double) imagoWingRank, 2.0);
        double loseRatio = (inWon ? 1.0 : 0.1);    //負けた時は、1/10獲得としておく
        return (int) Math.round((baseExp + (baseExp * extValueRatio)) * loseRatio);
    }

    //    itemDroppingProbability:
//		パーツドロップ率。0~100のパーセントの値を返却
    public static double itemDroppingProbabilityAtImagoLevel(int inImagoLevel, int inPartsRank) {
        //基本の確率定義
        double baseProbabilityTbl[] =
                {
                        50.0,    //Rank0
                        45.0,
                        40.0,
                        35.0,
                        30.0,
                        25.0,
                        20.0,
                        15.0,
                        10.0,
                        5.0,
                        1.0,    //Rank10
                };
//        int numOfProbability = sizeof(baseProbabilityTbl) / sizeof(baseProbabilityTbl[0]);
        int numOfProbability = 11;
        if (inPartsRank < 0)
            inPartsRank = 0;
        if (numOfProbability <= inPartsRank)
            inPartsRank = (numOfProbability - 1);
        double resultProbability = baseProbabilityTbl[inPartsRank];
        //敵のLvによる補正も入れてみる。(Lv99の敵を倒したのにDrop率がゴールドパーツが1%のままなのは、さすがにひどいので)
        resultProbability += ((double) (inImagoLevel + 1) / 2.0) - (double) inPartsRank;
        return (resultProbability);
    }

    public static boolean decideWhetherPartsDrop(int inImagoLevel, int inPartsRank) {
        double probability = itemDroppingProbabilityAtImagoLevel(inImagoLevel, inPartsRank);

        long nProbabilityMax = 10000;
        long nProbability = Math.round(probability * 100.0);
        int a = (int) (nProbabilityMax + 1);
        long randomValue = new Random().nextInt(a);
        if (randomValue <= nProbability)
            return true;
        return false;
    }

    public static int kBasePrice_JapanBeetle = 1000,
            kBasePrice_Cucasus = 5000,
            kBasePrice_Satans = 10000,
            kBasePrice_Hercules = 50000,
            kBasePrice_DorcusRectus = 2000,
            kBasePrice_DorcusCurvidens = 10000,
            kBasePrice_Giraffa = 20000,
            kBasePrice_Allotopus = 40000;

    public static int priceImageWithType(int beetleSubType, int wingNo, int bodyNo, int neckNo, int headNo, int faceNo, int hornNo, int horn2No) {
        int basePrice = 0;
        switch (beetleSubType) {
            case 0:            // 日本カブトムシ
                basePrice = kBasePrice_JapanBeetle;
                break;
            case 1:                // コーカサスカブトムシ
                basePrice = kBasePrice_Cucasus;
                break;
            case 2:                // サタンオオカブト
                basePrice = kBasePrice_Satans;
                break;
            case 3:                // ヘラクレスオオカブト
                basePrice = kBasePrice_Hercules;
                break;
            case 1000:        // 日本コクワガタ
                basePrice = kBasePrice_DorcusRectus;
                break;
            case 1001:    // 日本オオクワガタ
                basePrice = kBasePrice_DorcusCurvidens;
                break;
            case 1002:    // ギラファノコギリクワガタ
                basePrice = kBasePrice_Giraffa;
                break;
            case 1003:    // オウゴンオニクワガタ
            default:
                basePrice = kBasePrice_Allotopus;
                break;
        }
        if (wingNo >= 4) wingNo = 10;
        if (bodyNo >= 7) bodyNo = 10;
        if (hornNo >= 7) hornNo = 10;
        if (headNo >= 7) headNo = 10;
        if (horn2No >= 7) horn2No = 10;
        if (faceNo >= 5) faceNo = 10;
        if (beetleSubType == 0 || beetleSubType == 2 || beetleSubType == 1003 || beetleSubType == 3) {
            if (neckNo >= 3)
                neckNo = 10;
        }
        if (beetleSubType == 1000 || beetleSubType == 1001 || beetleSubType == 1002) {
            if (neckNo >= 2)
                neckNo = 10;
        }
        if (beetleSubType == 1) {
            if (neckNo >= 4)
                neckNo = 10;
        }

        int wingPrice = wingNo * basePrice / 10 * 3;
        int bodyPrice = bodyNo * basePrice / 10;
        int neckPrice = neckNo * basePrice / 10;
        int headPrice = headNo * basePrice / 10;
        int facePrice = faceNo * basePrice / 10;
        int fHornPrice = hornNo * basePrice / 10 * 2;
        int bHornPrice = 0;
        if (beetleSubType == 1 || beetleSubType == 2 || beetleSubType == 3)
            bHornPrice = horn2No * basePrice / 10 * 2;

        return (wingPrice + bodyPrice + neckPrice + headPrice + facePrice + fHornPrice + bHornPrice);
    }

    public static String _Strspecies(int kind) {
        String str = "";
        if (kind == 0)
            str = "100";
        if (kind == 1000)
            str = "110";
        if (kind == 1)
            str = "101";
        if (kind == 1001)
            str = "111";
        if (kind == 2)
            str = "102";
        if (kind == 1002)
            str = "112";
        if (kind == 1003)
            str = "113";
        if (kind == 3)
            str = "103";
        return str;
    }

    public static String _Strpart(int a) {
        String str = "";
        if (a >= 7)
            str = "10";
        if (a < 7)
            str = "0" + a;
        return str;
    }

    public static String _StrpartNeck(int a, int subkind) {
        String str = "";
        if (subkind == 0 || subkind == 2 || subkind == 1003 || subkind == 3) {
            if (a >= 3)
                str = "10";
            if (a < 3)
                str = "0" + a;
        }
        if (subkind == 1000 || subkind == 1001 || subkind == 1002) {
            if (a >= 2)
                str = "10";
            if (a < 2)
                str = "0" + a;
        }
        if (subkind == 1) {
            if (a >= 4)
                str = "10";
            if (a < 4)
                str = "0" + a;
        }
        return str;
    }

    public static int converkind(String loai) {
        int a = 0;
        if (loai.equals("loai1"))
            a = 0;
        if (loai.equals("loai2"))
            a = 1000;
        if (loai.equals("loai3"))
            a = 1;
        if (loai.equals("loai4"))
            a = 1001;
        if (loai.equals("loai5"))
            a = 2;
        if (loai.equals("loai6"))
            a = 1002;
        if (loai.equals("loai7"))
            a = 1003;
        if (loai.equals("loai8"))
            a = 3;
        return a;
    }

    public static String get_part(int subKind, int part, int position) {
        String part_kind = "";
        if ((part == 4 && subKind == 0) || (part == 4 && subKind == 2) || (part == 4 && subKind == 3) || (part == 4 && subKind == 1003)) {
            if (position > 2 && position != 10)
                position = 2;
        }
        if ((part == 4 && subKind == 1000) || (part == 4 && subKind == 1001) || (part == 4 && subKind == 1002)) {
            if (position > 1 && position != 10)
                position = 1;
        }
        if (subKind == 0) {
            if (position < 10)
                part_kind = "100" + part + "0" + position;
            if (position >= 10)
                part_kind = "100" + part + position;
        }
        if (subKind == 1) {
            if (position < 10)
                part_kind = "101" + part + "0" + position;
            if (position >= 10)
                part_kind = "101" + part + position;
        }
        if (subKind == 2) {
            if (position < 10)
                part_kind = "102" + part + "0" + position;
            if (position >= 10)
                part_kind = "102" + part + position;
        }
        if (subKind == 3) {
            if (position < 10)
                part_kind = "103" + part + "0" + position;
            if (position >= 10)
                part_kind = "103" + part + position;
        }
        if (subKind == 1000) {
            if (position < 10)
                part_kind = "110" + part + "0" + position;
            if (position >= 10)
                part_kind = "110" + part + position;
        }
        if (subKind == 1001) {
            if (position < 10)
                part_kind = "111" + part + "0" + position;
            if (position >= 10)
                part_kind = "111" + part + position;
        }
        if (subKind == 1002) {
            if (position < 10)
                part_kind = "112" + part + "0" + position;
            if (position >= 10)
                part_kind = "112" + part + position;
        }
        if (subKind == 1003) {
            if (position < 10)
                part_kind = "113" + part + "0" + position;
            if (position >= 10)
                part_kind = "113" + part + position;
        }
        return part_kind;
    }

    public static boolean beetleHasBackHornAtSubKind(int inSubKind) {
        switch (inSubKind) {
            case 1:
            case 2:
            case 3:
                return true;
        }
        return false;
    }

    public static int itemIdOfSubKind(int inSubKind, int inPartsIndex, int inRank) {
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

    public static String gettextimage(ArrayList<String> arr_horn, int position) {
        String pImg = "";
        String str = arr_horn.get(position);
        String name = "";
        String part = "";
        if (str.substring(0, 3).equals("100"))
            name = "kabutomushi";
        if (str.substring(0, 3).equals("101"))
            name = "caucasus";
        if (str.substring(0, 3).equals("102"))
            name = "satanas";
        if (str.substring(0, 3).equals("103"))
            name = "hercules";
        if (str.substring(0, 3).equals("110"))
            name = "kokuwagata";
        if (str.substring(0, 3).equals("111"))
            name = "oukuwagata";
        if (str.substring(0, 3).equals("112"))
            name = "giraffa";
        if (str.substring(0, 3).equals("113"))
            name = "golden";
        if (str.substring(3, 4).equals("0"))
            part = "horn";
        if (str.substring(3, 4).equals("1"))
            part = "horn2";
        if (str.substring(3, 4).equals("2"))
            part = "head";
        if (str.substring(3, 4).equals("3"))
            part = "face";
        if (str.substring(3, 4).equals("4"))
            part = "neck";
        if (str.substring(3, 4).equals("5"))
            part = "body";
        if (str.substring(3, 4).equals("6"))
            part = "wing";
        String pos = str.substring(4, 6);
        pImg = "" + name + part + pos;
        return pImg;
    }

    public static void _setScale(float a, ImageView horn, ImageView horn2, ImageView head,
                                 ImageView face, ImageView neck, ImageView body, ImageView wing) {
        horn.setScaleX(a);
        horn.setScaleY(a);
        horn2.setScaleX(a);
        horn2.setScaleY(a);
        head.setScaleX(a);
        head.setScaleY(a);
        face.setScaleX(a);
        face.setScaleY(a);
        neck.setScaleX(a);
        neck.setScaleY(a);
        body.setScaleX(a);
        body.setScaleY(a);
        wing.setScaleX(a);
        wing.setScaleY(a);
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public static int kBeetleLife_Max = 10000;
    public static int kBeetleSatiety_Max = 1000;    // 満腹度MAX

    // 最大サイズ　パーセンテージでおのおののサイズは最大サイズにかける
// 例えばオオクワで最大90mmとするとサイズが8000だと90x8000/10000=72mmとなる
    public static int kBeetleMood_Max = 1000;    // 機嫌MAX
    public static int kBeetleHealth_Max = 1000;    // 健康度MAX
    public static int kBeetleColor_Max = 1000;    // 0が黒→1000があか抜けた色（カブトムシだと赤い）
    public static int kBeetleAlbinoEstablishment = 1000;    // アルビノが産まれる確立、実際には1/1000ということ
    public static int kBeetlePersonality_Max = 1000;    // 0→おとなしい、1000→攻撃的
    public static int kBeetleForm_Max = 1000;    // かっこよさMAX
    public static int kBeetleSleep_Max = 1000;    // 眠気MAX
    public static int kBeetleStrength_Max = 1000;    // 強さMAX
    public static int kBeetleMoisture_Max = 1000;    // 水分MAX
    public static int kBeetleExcreteB_Max = 1000;    // 排泄度（大）MAX
    public static int kBeetleExcreteS_Max = 1000;    // 排泄度（小）MAX
    public static int kBeetleFriendly_Max = 1000;    // なつき度MAX
    public static int kBeetleSleepingETimeMax = 150;

    public static double parameterRatio(int subKind) {
        switch (subKind) {
            case 0:                // 日本カブトムシ
                return (0.8);
            case 1:                    // コーカサスカブトムシ
                return (1.0);
            case 2:                        // サタンオオカブト
                return (2.0);
            case 3:                    // ヘラクレスオオカブト
                return (3.0);
            case 1000:    // 日本コクワガタ
                return (0.8);
            case 1001:    // 日本オオクワガタ
                return (2.0);
            case 1002:    // ギラファノコギリクワガタ
                return (2.0);
            case 1003:    // オウゴンオニクワガタ
                return (1.5);

            default:
                return (1.0);
        }
    }

    public static int nextGoalExpAtLevel(int inLevel) {
        int goalExp = 10;
        int nextGoalExp = 0;
        for (int level = 0; level < inLevel; ++level) {
            nextGoalExp += goalExp;
            goalExp += 10;
        }
        return (nextGoalExp);
    }

    public static int body1_1[] = {R.drawable.body_0000_00_w00_left, R.drawable.body_0000_00_w01_right, R.drawable.body_0000_00_w01_left, R.drawable.body_0000_00_w00_right};
    public static int body1_2[] = {R.drawable.body_0000_01_w00_left, R.drawable.body_0000_01_w01_right, R.drawable.body_0000_01_w01_left, R.drawable.body_0000_01_w00_right};
    public static int body1_3[] = {R.drawable.body_0000_02_w00_left, R.drawable.body_0000_02_w01_right, R.drawable.body_0000_02_w01_left, R.drawable.body_0000_02_w00_right};
    public static int body1_4[] = {R.drawable.body_0000_03_w00_left, R.drawable.body_0000_03_w01_right, R.drawable.body_0000_03_w01_left, R.drawable.body_0000_03_w00_right};
    public static int body1_5[] = {R.drawable.body_0000_04_w00_left, R.drawable.body_0000_04_w01_right, R.drawable.body_0000_04_w01_left, R.drawable.body_0000_04_w00_right};
    public static int body1_6[] = {R.drawable.body_0000_05_w00_left, R.drawable.body_0000_05_w01_right, R.drawable.body_0000_05_w01_left, R.drawable.body_0000_05_w00_right};
    public static int body1_7[] = {R.drawable.body_0000_06_w00_left, R.drawable.body_0000_06_w01_right, R.drawable.body_0000_06_w01_left, R.drawable.body_0000_06_w00_right};
    public static int body1_8[] = {R.drawable.body_0000_10_w00_left, R.drawable.body_0000_10_w01_right, R.drawable.body_0000_10_w01_left, R.drawable.body_0000_10_w00_right};

    public static int body2_1[] = {R.drawable.body_0100_00_w00_left, R.drawable.body_0100_00_w01_right, R.drawable.body_0100_00_w01_left, R.drawable.body_0100_00_w00_right};
    public static int body2_2[] = {R.drawable.body_0100_01_w00_left, R.drawable.body_0100_01_w01_right, R.drawable.body_0100_01_w01_left, R.drawable.body_0100_01_w00_right};
    public static int body2_3[] = {R.drawable.body_0100_02_w00_left, R.drawable.body_0100_02_w01_right, R.drawable.body_0100_02_w01_left, R.drawable.body_0100_02_w00_right};
    public static int body2_4[] = {R.drawable.body_0100_03_w00_left, R.drawable.body_0100_03_w01_right, R.drawable.body_0100_03_w01_left, R.drawable.body_0100_03_w00_right};
    public static int body2_5[] = {R.drawable.body_0100_04_w00_left, R.drawable.body_0100_04_w01_right, R.drawable.body_0100_04_w01_left, R.drawable.body_0100_04_w00_right};
    public static int body2_6[] = {R.drawable.body_0100_05_w00_left, R.drawable.body_0100_05_w01_right, R.drawable.body_0100_05_w01_left, R.drawable.body_0100_05_w00_right};
    public static int body2_7[] = {R.drawable.body_0100_06_w00_left, R.drawable.body_0100_06_w01_right, R.drawable.body_0100_06_w01_left, R.drawable.body_0100_06_w00_right};
    public static int body2_8[] = {R.drawable.body_0100_10_w00_left, R.drawable.body_0100_10_w01_right, R.drawable.body_0100_10_w01_left, R.drawable.body_0100_10_w00_right};

    public static int body3_1[] = {R.drawable.body_0001_00_w00_left, R.drawable.body_0001_00_w01_right, R.drawable.body_0001_00_w01_left, R.drawable.body_0001_00_w00_right};
    public static int body3_2[] = {R.drawable.body_0001_01_w00_left, R.drawable.body_0001_01_w01_right, R.drawable.body_0001_01_w01_left, R.drawable.body_0001_01_w00_right};
    public static int body3_3[] = {R.drawable.body_0001_02_w00_left, R.drawable.body_0001_02_w01_right, R.drawable.body_0001_02_w01_left, R.drawable.body_0001_02_w00_right};
    public static int body3_4[] = {R.drawable.body_0001_03_w00_left, R.drawable.body_0001_03_w01_right, R.drawable.body_0001_03_w01_left, R.drawable.body_0001_03_w00_right};
    public static int body3_5[] = {R.drawable.body_0001_04_w00_left, R.drawable.body_0001_04_w01_right, R.drawable.body_0001_04_w01_left, R.drawable.body_0001_04_w00_right};
    public static int body3_6[] = {R.drawable.body_0001_05_w00_left, R.drawable.body_0001_05_w01_right, R.drawable.body_0001_05_w01_left, R.drawable.body_0001_05_w00_right};
    public static int body3_7[] = {R.drawable.body_0001_06_w00_left, R.drawable.body_0001_06_w01_right, R.drawable.body_0001_06_w01_left, R.drawable.body_0001_06_w00_right};
    public static int body3_8[] = {R.drawable.body_0001_10_w00_left, R.drawable.body_0001_10_w01_right, R.drawable.body_0001_10_w01_left, R.drawable.body_0001_10_w00_right};

    public static int body4_1[] = {R.drawable.body_0101_00_w00_left, R.drawable.body_0101_00_w01_right, R.drawable.body_0101_00_w01_left, R.drawable.body_0101_00_w00_right};
    public static int body4_2[] = {R.drawable.body_0101_01_w00_left, R.drawable.body_0101_01_w01_right, R.drawable.body_0101_01_w01_left, R.drawable.body_0101_01_w00_right};
    public static int body4_3[] = {R.drawable.body_0101_02_w00_left, R.drawable.body_0101_02_w01_right, R.drawable.body_0101_02_w01_left, R.drawable.body_0101_02_w00_right};
    public static int body4_4[] = {R.drawable.body_0101_03_w00_left, R.drawable.body_0101_03_w01_right, R.drawable.body_0101_03_w01_left, R.drawable.body_0101_03_w00_right};
    public static int body4_5[] = {R.drawable.body_0101_04_w00_left, R.drawable.body_0101_04_w01_right, R.drawable.body_0101_04_w01_left, R.drawable.body_0101_04_w00_right};
    public static int body4_6[] = {R.drawable.body_0101_05_w00_left, R.drawable.body_0101_05_w01_right, R.drawable.body_0101_05_w01_left, R.drawable.body_0101_05_w00_right};
    public static int body4_7[] = {R.drawable.body_0101_06_w00_left, R.drawable.body_0101_06_w01_right, R.drawable.body_0101_06_w01_left, R.drawable.body_0101_06_w00_right};
    public static int body4_8[] = {R.drawable.body_0101_10_w00_left, R.drawable.body_0101_10_w01_right, R.drawable.body_0101_10_w01_left, R.drawable.body_0101_10_w00_right};

    public static int body5_1[] = {R.drawable.body_0002_00_w00_left, R.drawable.body_0002_00_w01_right, R.drawable.body_0002_00_w01_left, R.drawable.body_0002_00_w00_right};
    public static int body5_2[] = {R.drawable.body_0002_01_w00_left, R.drawable.body_0002_01_w01_right, R.drawable.body_0002_01_w01_left, R.drawable.body_0002_01_w00_right};
    public static int body5_3[] = {R.drawable.body_0002_02_w00_left, R.drawable.body_0002_02_w01_right, R.drawable.body_0002_02_w01_left, R.drawable.body_0002_02_w00_right};
    public static int body5_4[] = {R.drawable.body_0002_03_w00_left, R.drawable.body_0002_03_w01_right, R.drawable.body_0002_03_w01_left, R.drawable.body_0002_03_w00_right};
    public static int body5_5[] = {R.drawable.body_0002_04_w00_left, R.drawable.body_0002_04_w01_right, R.drawable.body_0002_04_w01_left, R.drawable.body_0002_04_w00_right};
    public static int body5_6[] = {R.drawable.body_0002_05_w00_left, R.drawable.body_0002_05_w01_right, R.drawable.body_0002_05_w01_left, R.drawable.body_0002_05_w00_right};
    public static int body5_7[] = {R.drawable.body_0002_06_w00_left, R.drawable.body_0002_06_w01_right, R.drawable.body_0002_06_w01_left, R.drawable.body_0002_06_w00_right};
    public static int body5_8[] = {R.drawable.body_0002_10_w00_left, R.drawable.body_0002_10_w01_right, R.drawable.body_0002_10_w01_left, R.drawable.body_0002_10_w00_right};

    public static int body6_1[] = {R.drawable.body_0102_00_w00_left, R.drawable.body_0102_00_w01_right, R.drawable.body_0102_00_w01_left, R.drawable.body_0102_00_w00_right};
    public static int body6_2[] = {R.drawable.body_0102_01_w00_left, R.drawable.body_0102_01_w01_right, R.drawable.body_0102_01_w01_left, R.drawable.body_0102_01_w00_right};
    public static int body6_3[] = {R.drawable.body_0102_02_w00_left, R.drawable.body_0102_02_w01_right, R.drawable.body_0102_02_w01_left, R.drawable.body_0102_02_w00_right};
    public static int body6_4[] = {R.drawable.body_0102_03_w00_left, R.drawable.body_0102_03_w01_right, R.drawable.body_0102_03_w01_left, R.drawable.body_0102_03_w00_right};
    public static int body6_5[] = {R.drawable.body_0102_04_w00_left, R.drawable.body_0102_04_w01_right, R.drawable.body_0102_04_w01_left, R.drawable.body_0102_04_w00_right};
    public static int body6_6[] = {R.drawable.body_0102_05_w00_left, R.drawable.body_0102_05_w01_right, R.drawable.body_0102_05_w01_left, R.drawable.body_0102_05_w00_right};
    public static int body6_7[] = {R.drawable.body_0102_06_w00_left, R.drawable.body_0102_06_w01_right, R.drawable.body_0102_06_w01_left, R.drawable.body_0102_06_w00_right};
    public static int body6_8[] = {R.drawable.body_0102_10_w00_left, R.drawable.body_0102_10_w01_right, R.drawable.body_0102_10_w01_left, R.drawable.body_0102_10_w00_right};

    public static int body7_1[] = {R.drawable.body_0103_00_w00_left, R.drawable.body_0103_00_w01_right, R.drawable.body_0103_00_w01_left, R.drawable.body_0103_00_w00_right};
    public static int body7_2[] = {R.drawable.body_0103_01_w00_left, R.drawable.body_0103_01_w01_right, R.drawable.body_0103_01_w01_left, R.drawable.body_0103_01_w00_right};
    public static int body7_3[] = {R.drawable.body_0103_02_w00_left, R.drawable.body_0103_02_w01_right, R.drawable.body_0103_02_w01_left, R.drawable.body_0103_02_w00_right};
    public static int body7_4[] = {R.drawable.body_0103_03_w00_left, R.drawable.body_0103_03_w01_right, R.drawable.body_0103_03_w01_left, R.drawable.body_0103_03_w00_right};
    public static int body7_5[] = {R.drawable.body_0103_04_w00_left, R.drawable.body_0103_04_w01_right, R.drawable.body_0103_04_w01_left, R.drawable.body_0103_04_w00_right};
    public static int body7_6[] = {R.drawable.body_0103_05_w00_left, R.drawable.body_0103_05_w01_right, R.drawable.body_0103_05_w01_left, R.drawable.body_0103_05_w00_right};
    public static int body7_7[] = {R.drawable.body_0103_06_w00_left, R.drawable.body_0103_06_w01_right, R.drawable.body_0103_06_w01_left, R.drawable.body_0103_06_w00_right};
    public static int body7_8[] = {R.drawable.body_0103_10_w00_left, R.drawable.body_0103_10_w01_right, R.drawable.body_0103_10_w01_left, R.drawable.body_0103_10_w00_right};

    public static int body8_1[] = {R.drawable.body_0003_00_w00_left, R.drawable.body_0003_00_w01_right, R.drawable.body_0003_00_w01_left, R.drawable.body_0003_00_w00_right};
    public static int body8_2[] = {R.drawable.body_0003_01_w00_left, R.drawable.body_0003_01_w01_right, R.drawable.body_0003_01_w01_left, R.drawable.body_0003_01_w00_right};
    public static int body8_3[] = {R.drawable.body_0003_02_w00_left, R.drawable.body_0003_02_w01_right, R.drawable.body_0003_02_w01_left, R.drawable.body_0003_02_w00_right};
    public static int body8_4[] = {R.drawable.body_0003_03_w00_left, R.drawable.body_0003_03_w01_right, R.drawable.body_0003_03_w01_left, R.drawable.body_0003_03_w00_right};
    public static int body8_5[] = {R.drawable.body_0003_04_w00_left, R.drawable.body_0003_04_w01_right, R.drawable.body_0003_04_w01_left, R.drawable.body_0003_04_w00_right};
    public static int body8_6[] = {R.drawable.body_0003_05_w00_left, R.drawable.body_0003_05_w01_right, R.drawable.body_0003_05_w01_left, R.drawable.body_0003_05_w00_right};
    public static int body8_7[] = {R.drawable.body_0003_06_w00_left, R.drawable.body_0003_06_w01_right, R.drawable.body_0003_06_w01_left, R.drawable.body_0003_06_w00_right};
    public static int body8_8[] = {R.drawable.body_0003_10_w00_left, R.drawable.body_0003_10_w01_right, R.drawable.body_0003_10_w01_left, R.drawable.body_0003_10_w00_right};

    public static int check_name(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        if (s1.equals(s2) || s1.equals(s3) || s1.equals(s4) || s1.equals(s5) ||
                s1.equals(s6) || s1.equals(s7) || s1.equals(s8)) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int check_name_create(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9) {
        if (s1.equals(s2) || s1.equals(s3) || s1.equals(s4) || s1.equals(s5) ||
                s1.equals(s6) || s1.equals(s7) || s1.equals(s8) || s1.equals(s9)) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void ShowImageZukan(ImageView imgzukan, ImageView imgzukan2, ImageView imgzukan3, ImageView imgzukan4,
                                      ImageView imgzukan5, ImageView imgzukan6, ImageView imgzukan7, ImageView imgzukan8) {
        imgzukan.setVisibility(View.VISIBLE);
        imgzukan2.setVisibility(View.GONE);
        imgzukan3.setVisibility(View.GONE);
        imgzukan4.setVisibility(View.GONE);
        imgzukan5.setVisibility(View.GONE);
        imgzukan6.setVisibility(View.GONE);
        imgzukan7.setVisibility(View.GONE);
        imgzukan8.setVisibility(View.GONE);
    }

    public static void ShowRunpa(boolean swipe, long runpaStartTime, FrameLayout fritm_runpa1, FrameLayout fritm_runpa2, FrameLayout fritm_runpa3,
                                 FrameLayout fritm_runpa4, FrameLayout fritm_runpa5, FrameLayout fritm_runpa6, FrameLayout fritm_runpa7, FrameLayout fritm_runpa8) {
        if (runpaStartTime != 0 && swipe == false)
            fritm_runpa1.setVisibility(View.VISIBLE);
        fritm_runpa2.setVisibility(View.GONE);
        fritm_runpa3.setVisibility(View.GONE);
        fritm_runpa4.setVisibility(View.GONE);
        fritm_runpa5.setVisibility(View.GONE);
        fritm_runpa6.setVisibility(View.GONE);
        fritm_runpa7.setVisibility(View.GONE);
        fritm_runpa8.setVisibility(View.GONE);
    }

    public static void ShowProgressbar(ProgressBar progressBar3, ProgressBar progressBar32, ProgressBar progressBar33, ProgressBar progressBar34,
                                       ProgressBar progressBar35, ProgressBar progressBar36, ProgressBar progressBar37, ProgressBar progressBar38) {
        progressBar3.setVisibility(View.VISIBLE);
        progressBar32.setVisibility(View.GONE);
        progressBar33.setVisibility(View.GONE);
        progressBar34.setVisibility(View.GONE);
        progressBar35.setVisibility(View.GONE);
        progressBar36.setVisibility(View.GONE);
        progressBar37.setVisibility(View.GONE);
        progressBar38.setVisibility(View.GONE);
    }

    public static void settextItem(int _i, TextView activeitem) {
        if (_i == 0)
            activeitem.setText("");
        else if (_i == 1)
            activeitem.setText("SPx2");
        else if (_i == 2)
            activeitem.setText("SPx10");
    }

    public static void HideRunpa(FrameLayout fritm_runpa1, FrameLayout fritm_runpa2, FrameLayout fritm_runpa3,
                                 FrameLayout fritm_runpa4, FrameLayout fritm_runpa5, FrameLayout fritm_runpa6, FrameLayout fritm_runpa7, FrameLayout fritm_runpa8) {
        fritm_runpa1.setVisibility(View.GONE);
        fritm_runpa2.setVisibility(View.GONE);
        fritm_runpa3.setVisibility(View.GONE);
        fritm_runpa4.setVisibility(View.GONE);
        fritm_runpa5.setVisibility(View.GONE);
        fritm_runpa6.setVisibility(View.GONE);
        fritm_runpa7.setVisibility(View.GONE);
        fritm_runpa8.setVisibility(View.GONE);
    }

    public static Integer[] body = new Integer[]{R.drawable.body_0000_00, R.drawable.body_0000_01, R.drawable.body_0000_02, R.drawable.body_0000_03,
            R.drawable.body_0000_04, R.drawable.body_0000_05, R.drawable.body_0000_06, R.drawable.body_0000_10_stand};
    public static Integer[] bgbody = new Integer[]{R.drawable.body_0000_00_s, R.drawable.body_0000_01_s, R.drawable.body_0000_02_s, R.drawable.body_0000_03_s,
            R.drawable.body_0000_04_s, R.drawable.body_0000_05_s, R.drawable.body_0000_06_s};
    public static Integer[] head = new Integer[]{R.drawable.head_0000_00, R.drawable.head_0000_01, R.drawable.head_0000_02,
            R.drawable.head_0000_03, R.drawable.head_0000_04, R.drawable.head_0000_05, R.drawable.head_0000_06, R.drawable.head_0000_10};
    public static Integer[] bghead = new Integer[]{R.drawable.head_0000_00_s, R.drawable.head_0000_01_s, R.drawable.head_0000_02_s, R.drawable.head_0000_03_s,
            R.drawable.head_0000_04_s, R.drawable.head_0000_05_s, R.drawable.head_0000_06_s, R.drawable.head_0000_06_s};
    public static Integer[] neck = new Integer[]{R.drawable.neck_0000_00, R.drawable.neck_0000_01, R.drawable.neck_0000_02, R.drawable.neck_0000_10};
    public static Integer[] bgneck = new Integer[]{R.drawable.neck_0000_00_s, R.drawable.neck_0000_01_s, R.drawable.neck_0000_02_s};
    public static Integer[] horn = new Integer[]{R.drawable.horn_0000_00, R.drawable.horn_0000_01, R.drawable.horn_0000_02, R.drawable.horn_0000_03, R.drawable.horn_0000_04,
            R.drawable.horn_0000_05, R.drawable.horn_0000_06, R.drawable.horn_0000_10};
    public static Integer[] bghorn = new Integer[]{R.drawable.horn_0000_00_s, R.drawable.horn_0000_01_s, R.drawable.horn_0000_02_s, R.drawable.horn_0000_03_s,
            R.drawable.horn_0000_04_s, R.drawable.horn_0000_05_s, R.drawable.horn_0000_06_s, R.drawable.horn_0000_06_s};
    public static Integer[] wing = new Integer[]{R.drawable.wing_0000_01, R.drawable.wing_0000_02, R.drawable.wing_0000_03, R.drawable.wing_0000_10};
    public static Integer[] bgwing = new Integer[]{R.drawable.wing_0000_00_s, R.drawable.wing_0000_01_s, R.drawable.wing_0000_02_s, R.drawable.wing_0000_03_s};
    public static Integer[] face = new Integer[]{R.drawable.face_0000_00, R.drawable.face_0000_01, R.drawable.face_0000_02, R.drawable.face_0000_03, R.drawable.face_0000_04, R.drawable.face_0000_10};

    public static Integer[] body2 = new Integer[]{R.drawable.body_0100_00, R.drawable.body_0100_01, R.drawable.body_0100_02, R.drawable.body_0100_03,
            R.drawable.body_0100_04, R.drawable.body_0100_05, R.drawable.body_0100_06, R.drawable.body_0100_10_stand};
    public static Integer[] head2 = new Integer[]{R.drawable.head_0100_00, R.drawable.head_0100_01, R.drawable.head_0100_02, R.drawable.head_0100_03,
            R.drawable.head_0100_04, R.drawable.head_0100_05, R.drawable.head_0100_06, R.drawable.head_0100_10};
    public static Integer[] neck2 = new Integer[]{R.drawable.neck_0100_00, R.drawable.neck_0100_01, R.drawable.neck_0100_10};
    public static Integer[] horn2 = new Integer[]{R.drawable.horn_0100_00, R.drawable.horn_0100_01, R.drawable.horn_0100_02, R.drawable.horn_0100_03,
            R.drawable.horn_0100_04, R.drawable.horn_0100_05, R.drawable.horn_0100_06, R.drawable.horn_0100_10};
    public static Integer[] wing2 = new Integer[]{R.drawable.wing_0100_01, R.drawable.wing_0100_02,
            R.drawable.wing_0100_03, R.drawable.wing_0100_10};
    public static Integer[] face2 = new Integer[]{R.drawable.face_0100_00, R.drawable.face_0100_01, R.drawable.face_0100_02, R.drawable.face_0100_03, R.drawable.face_0100_04, R.drawable.face_0100_10};
    public static Integer[] bgbody2 = new Integer[]{R.drawable.body_0100_00_s, R.drawable.body_0100_01_s, R.drawable.body_0100_02_s, R.drawable.body_0100_03_s, R.drawable.body_0100_04_s, R.drawable.body_0100_05_s, R.drawable.body_0100_06_s};
    public static Integer[] bghead2 = new Integer[]{R.drawable.head_0100_00_s, R.drawable.head_0100_01_s, R.drawable.head_0100_02_s, R.drawable.head_0100_03_s,
            R.drawable.head_0100_04_s, R.drawable.head_0100_05_s, R.drawable.head_0100_06_s, R.drawable.head_0100_06_s};
    public static Integer[] bgneck2 = new Integer[]{R.drawable.neck_0100_00_s, R.drawable.neck_0100_01_s};
    public static Integer[] bghorn2 = new Integer[]{R.drawable.horn_0100_00_s, R.drawable.horn_0100_01_s, R.drawable.horn_0100_02_s, R.drawable.horn_0100_03_s,
            R.drawable.horn_0100_04_s, R.drawable.horn_0100_05_s, R.drawable.horn_0100_06_s, R.drawable.horn_0100_06_s};
    public static Integer[] bgwing2 = new Integer[]{R.drawable.wing_0100_00_s, R.drawable.wing_0100_01_s, R.drawable.wing_0100_02_s, R.drawable.wing_0100_03_s};

    public static Integer[] body3 = new Integer[]{R.drawable.body_0001_00, R.drawable.body_0001_01, R.drawable.body_0001_02, R.drawable.body_0001_03,
            R.drawable.body_0001_04, R.drawable.body_0001_05, R.drawable.body_0001_06, R.drawable.body_0001_10_stand};
    public static Integer[] head3 = new Integer[]{R.drawable.head_0001_00, R.drawable.head_0001_01, R.drawable.head_0001_02, R.drawable.head_0001_03,
            R.drawable.head_0001_04, R.drawable.head_0001_05, R.drawable.head_0001_06, R.drawable.head_0001_10};
    public static Integer[] neck3 = new Integer[]{R.drawable.neck_0001_00, R.drawable.neck_0001_01, R.drawable.neck_0001_02,
            R.drawable.neck_0001_03, R.drawable.neck_0001_10};
    public static Integer[] horn33 = new Integer[]{R.drawable.horn2_0001_00, R.drawable.horn2_0001_01, R.drawable.horn2_0001_02,
            R.drawable.horn2_0001_03, R.drawable.horn2_0001_04, R.drawable.horn2_0001_05, R.drawable.horn2_0001_06, R.drawable.horn2_0001_10};
    public static Integer[] horn3 = new Integer[]{R.drawable.horn_0001_00, R.drawable.horn_0001_01, R.drawable.horn_0001_02, R.drawable.horn_0001_03,
            R.drawable.horn_0001_04, R.drawable.horn_0001_05, R.drawable.horn_0001_06, R.drawable.horn_0001_10};
    public static Integer[] wing3 = new Integer[]{R.drawable.wing_0001_01, R.drawable.wing_0001_02,
            R.drawable.wing_0001_03, R.drawable.wing_0001_10};
    public static Integer[] face3 = new Integer[]{R.drawable.face_0001_00, R.drawable.face_0001_01, R.drawable.face_0001_02, R.drawable.face_0001_03, R.drawable.face_0001_04, R.drawable.face_0001_10};
    public static Integer[] bgbody3 = new Integer[]{R.drawable.body_0001_00_s, R.drawable.body_0001_01_s, R.drawable.body_0001_02_s, R.drawable.body_0001_03_s, R.drawable.body_0001_04_s, R.drawable.body_0001_05_s, R.drawable.body_0001_06_s};
    public static Integer[] bghead3 = new Integer[]{R.drawable.head_0001_00_s, R.drawable.head_0001_01_s, R.drawable.head_0001_02_s, R.drawable.head_0001_03_s,
            R.drawable.head_0001_04_s, R.drawable.head_0001_05_s, R.drawable.head_0001_06_s, R.drawable.head_0001_06_s};
    public static Integer[] bgneck3 = new Integer[]{R.drawable.neck_0001_00_s, R.drawable.neck_0001_01_s, R.drawable.neck_0001_02_s, R.drawable.neck_0001_03_s};
    public static Integer[] bghorn33 = new Integer[]{R.drawable.horn2_0001_00_s, R.drawable.horn2_0001_01_s, R.drawable.horn2_0001_02_s, R.drawable.horn2_0001_03_s,
            R.drawable.horn2_0001_04_s, R.drawable.horn2_0001_05_s, R.drawable.horn2_0001_06_s, R.drawable.horn2_0001_06_s};
    public static Integer[] bghorn3 = new Integer[]{R.drawable.horn_0001_00_s, R.drawable.horn_0001_01_s, R.drawable.horn_0001_02_s, R.drawable.horn_0001_03_s,
            R.drawable.horn_0001_04_s, R.drawable.horn_0001_05_s, R.drawable.horn_0001_06_s, R.drawable.horn_0001_06_s};
    public static Integer[] bgwing3 = new Integer[]{R.drawable.wing_0001_00_s, R.drawable.wing_0001_01_s, R.drawable.wing_0001_02_s, R.drawable.wing_0001_03_s};

    public static Integer[] body5 = new Integer[]{R.drawable.body_0002_00, R.drawable.body_0002_01, R.drawable.body_0002_02, R.drawable.body_0002_03,
            R.drawable.body_0002_04, R.drawable.body_0002_05, R.drawable.body_0002_06, R.drawable.body_0002_10_stand};
    public static Integer[] head5 = new Integer[]{R.drawable.head_0002_00, R.drawable.head_0002_01, R.drawable.head_0002_02, R.drawable.head_0002_03,
            R.drawable.head_0002_04, R.drawable.head_0002_05, R.drawable.head_0002_06, R.drawable.head_0002_10};
    public static Integer[] neck5 = new Integer[]{R.drawable.neck_0002_00, R.drawable.neck_0002_01, R.drawable.neck_0002_02, R.drawable.neck_0002_10};
    public static Integer[] horn55 = new Integer[]{R.drawable.horn2_0002_00, R.drawable.horn2_0002_01, R.drawable.horn2_0002_02, R.drawable.horn2_0002_03,
            R.drawable.horn2_0002_04, R.drawable.horn2_0002_05, R.drawable.horn2_0002_06, R.drawable.horn2_0002_10};
    public static Integer[] horn5 = new Integer[]{R.drawable.horn_0002_00, R.drawable.horn_0002_01, R.drawable.horn_0002_02, R.drawable.horn_0002_03,
            R.drawable.horn_0002_04, R.drawable.horn_0002_05, R.drawable.horn_0002_06, R.drawable.horn_0002_10};
    public static Integer[] wing5 = new Integer[]{R.drawable.wing_0002_01, R.drawable.wing_0002_02, R.drawable.wing_0002_03, R.drawable.wing_0002_10};
    public static Integer[] face5 = new Integer[]{R.drawable.face_0002_00, R.drawable.face_0002_01, R.drawable.face_0002_02, R.drawable.face_0002_03, R.drawable.face_0002_04, R.drawable.face_0002_10};
    public static Integer[] bgbody5 = new Integer[]{R.drawable.body_0002_00_s, R.drawable.body_0002_01_s, R.drawable.body_0002_02_s, R.drawable.body_0002_03_s, R.drawable.body_0002_04_s, R.drawable.body_0002_05_s, R.drawable.body_0002_06_s};
    public static Integer[] bghead5 = new Integer[]{R.drawable.head_0002_00_s, R.drawable.head_0002_01_s, R.drawable.head_0002_02_s, R.drawable.head_0002_03_s, R.drawable.head_0002_04_s,
            R.drawable.head_0002_05_s, R.drawable.head_0002_06_s, R.drawable.head_0002_06_s};
    public static Integer[] bgneck5 = new Integer[]{R.drawable.neck_0002_00_s, R.drawable.neck_0002_01_s, R.drawable.neck_0002_02_s};
    public static Integer[] bghorn55 = new Integer[]{R.drawable.horn2_0002_00_s, R.drawable.horn2_0002_01_s, R.drawable.horn2_0002_02_s, R.drawable.horn2_0002_03_s,
            R.drawable.horn2_0002_04_s, R.drawable.horn2_0002_05_s, R.drawable.horn2_0002_06_s, R.drawable.horn2_0002_06_s};
    public static Integer[] bgwing5 = new Integer[]{R.drawable.wing_0002_00_s, R.drawable.wing_0002_01_s, R.drawable.wing_0002_02_s, R.drawable.wing_0002_03_s};
    public static Integer[] bghorn5 = new Integer[]{R.drawable.horn_0002_00_s, R.drawable.horn_0002_01_s, R.drawable.horn_0002_02_s, R.drawable.horn_0002_03_s,
            R.drawable.horn_0002_04_s, R.drawable.horn_0002_05_s, R.drawable.horn_0002_06_s, R.drawable.horn_0002_06_s};

    public static Integer[] body6 = new Integer[]{R.drawable.body_0102_00, R.drawable.body_0102_01, R.drawable.body_0102_02, R.drawable.body_0102_03,
            R.drawable.body_0102_04, R.drawable.body_0102_05, R.drawable.body_0102_06, R.drawable.body_0102_10_stand};
    public static Integer[] head6 = new Integer[]{R.drawable.head_0102_00, R.drawable.head_0102_01, R.drawable.head_0102_02, R.drawable.head_0102_03, R.drawable.head_0102_04,
            R.drawable.head_0102_05, R.drawable.head_0102_06, R.drawable.head_0102_10};
    public static Integer[] neck6 = new Integer[]{R.drawable.neck_0102_00, R.drawable.neck_0102_01, R.drawable.neck_0102_10};
    public static Integer[] horn6 = new Integer[]{R.drawable.horn_0102_00, R.drawable.horn_0102_01, R.drawable.horn_0102_02, R.drawable.horn_0102_03,
            R.drawable.horn_0102_04, R.drawable.horn_0102_05, R.drawable.horn_0102_06, R.drawable.horn_0102_10};
    public static Integer[] wing6 = new Integer[]{R.drawable.wing_0102_01, R.drawable.wing_0102_02, R.drawable.wing_0102_03, R.drawable.wing_0102_10};
    public static Integer[] face6 = new Integer[]{R.drawable.face_0102_00, R.drawable.face_0102_01, R.drawable.face_0102_02, R.drawable.face_0102_03, R.drawable.face_0102_04, R.drawable.face_0102_10};
    public static Integer[] bgbody6 = new Integer[]{R.drawable.body_0102_00_s, R.drawable.body_0102_01_s, R.drawable.body_0102_02_s, R.drawable.body_0102_03_s,
            R.drawable.body_0102_04_s, R.drawable.body_0102_05_s, R.drawable.body_0102_06_s, R.drawable.body_0102_06_s};
    public static Integer[] bghead6 = new Integer[]{R.drawable.head_0102_00_s, R.drawable.head_0102_01_s, R.drawable.head_0102_02_s, R.drawable.head_0102_03_s, R.drawable.head_0102_04_s,
            R.drawable.head_0102_05_s, R.drawable.head_0102_06_s, R.drawable.head_0102_06_s, R.drawable.head_0102_06_s};
    public static Integer[] bgneck6 = new Integer[]{R.drawable.neck_0102_00_s, R.drawable.neck_0102_01_s};
    public static Integer[] bghorn6 = new Integer[]{R.drawable.horn_0102_00_s, R.drawable.horn_0102_01_s, R.drawable.horn_0102_02_s, R.drawable.horn_0102_03_s,
            R.drawable.horn_0102_04_s, R.drawable.horn_0102_05_s, R.drawable.horn_0102_06_s, R.drawable.horn_0102_06_s};
    public static Integer[] bgwing6 = new Integer[]{R.drawable.wing_0102_00_s, R.drawable.wing_0102_01_s, R.drawable.wing_0102_02_s, R.drawable.wing_0102_03_s};

    public static Integer[] body4 = new Integer[]{R.drawable.body_0101_00, R.drawable.body_0101_01, R.drawable.body_0101_02, R.drawable.body_0101_03,
            R.drawable.body_0101_04, R.drawable.body_0101_05, R.drawable.body_0101_06, R.drawable.body_0101_10_stand};
    public static Integer[] head4 = new Integer[]{R.drawable.head_0101_00, R.drawable.head_0101_01, R.drawable.head_0101_02, R.drawable.head_0101_03,
            R.drawable.head_0101_04, R.drawable.head_0101_05, R.drawable.head_0101_06, R.drawable.head_0101_10};
    public static Integer[] neck4 = new Integer[]{R.drawable.neck_0101_00, R.drawable.neck_0101_01, R.drawable.neck_0101_10};
    public static Integer[] horn4 = new Integer[]{R.drawable.horn_0101_00, R.drawable.horn_0101_01, R.drawable.horn_0101_02, R.drawable.horn_0101_03,
            R.drawable.horn_0101_04, R.drawable.horn_0101_05, R.drawable.horn_0101_06, R.drawable.horn_0101_10};
    public static Integer[] wing4 = new Integer[]{R.drawable.wing_0101_01, R.drawable.wing_0101_02, R.drawable.wing_0101_03, R.drawable.wing_0101_10};
    public static Integer[] face4 = new Integer[]{R.drawable.face_0101_00, R.drawable.face_0101_01, R.drawable.face_0101_02, R.drawable.face_0101_03, R.drawable.face_0101_04, R.drawable.face_0101_10};
    public static Integer[] bgbody4 = new Integer[]{R.drawable.body_0101_00_s, R.drawable.body_0101_01_s, R.drawable.body_0101_02_s, R.drawable.body_0101_03_s, R.drawable.body_0101_04_s, R.drawable.body_0101_05_s, R.drawable.body_0101_06_s};
    public static Integer[] bghead4 = new Integer[]{R.drawable.head_0101_00_s, R.drawable.head_0101_01_s, R.drawable.head_0101_02_s, R.drawable.head_0101_03_s,
            R.drawable.head_0101_04_s, R.drawable.head_0101_05_s, R.drawable.head_0101_06_s, R.drawable.head_0101_06_s};
    public static Integer[] bgneck4 = new Integer[]{R.drawable.neck_0101_00_s, R.drawable.neck_0101_01_s};
    public static Integer[] bghorn4 = new Integer[]{R.drawable.horn_0101_00_s, R.drawable.horn_0101_01_s, R.drawable.horn_0101_02_s, R.drawable.horn_0101_03_s,
            R.drawable.horn_0101_04_s, R.drawable.horn_0101_05_s, R.drawable.horn_0101_06_s, R.drawable.horn_0101_06_s};
    public static Integer[] bgwing4 = new Integer[]{R.drawable.wing_0101_00_s, R.drawable.wing_0101_01_s, R.drawable.wing_0101_02_s, R.drawable.wing_0101_03_s};

    public static Integer[] body8 = new Integer[]{R.drawable.body_0003_00, R.drawable.body_0003_01, R.drawable.body_0003_02, R.drawable.body_0003_03,
            R.drawable.body_0003_04, R.drawable.body_0003_05, R.drawable.body_0003_06, R.drawable.body_0003_10_stand};
    public static Integer[] head8 = new Integer[]{R.drawable.head_0003_00, R.drawable.head_0003_01, R.drawable.head_0003_02, R.drawable.head_0003_03,
            R.drawable.head_0003_04, R.drawable.head_0003_05, R.drawable.head_0003_06, R.drawable.head_0003_10};
    public static Integer[] neck8 = new Integer[]{R.drawable.neck_0003_00, R.drawable.neck_0003_01, R.drawable.neck_0003_02, R.drawable.neck_0003_10};
    public static Integer[] horn88 = new Integer[]{R.drawable.horn2_0003_00, R.drawable.horn2_0003_01, R.drawable.horn2_0003_02, R.drawable.horn2_0003_03,
            R.drawable.horn2_0003_04, R.drawable.horn2_0003_05, R.drawable.horn2_0003_06, R.drawable.horn2_0003_10};
    public static Integer[] horn8 = new Integer[]{R.drawable.horn_0003_00, R.drawable.horn_0003_01, R.drawable.horn_0003_02, R.drawable.horn_0003_03,
            R.drawable.horn_0003_04, R.drawable.horn_0003_05, R.drawable.horn_0003_06, R.drawable.horn_0003_10};
    public static Integer[] wing8 = new Integer[]{R.drawable.wing_0003_01, R.drawable.wing_0003_02, R.drawable.wing_0003_03, R.drawable.wing_0003_10};
    public static Integer[] face8 = new Integer[]{R.drawable.face_0003_00, R.drawable.face_0003_01, R.drawable.face_0003_02, R.drawable.face_0003_03, R.drawable.face_0003_04, R.drawable.face_0003_10};
    public static Integer[] bgbody8 = new Integer[]{R.drawable.body_0003_00_s, R.drawable.body_0003_01_s, R.drawable.body_0003_02_s, R.drawable.body_0003_03_s, R.drawable.body_0003_04_s, R.drawable.body_0003_05_s, R.drawable.body_0003_06_s};
    public static Integer[] bghead8 = new Integer[]{R.drawable.head_0003_00_s, R.drawable.head_0003_01_s, R.drawable.head_0003_02_s, R.drawable.head_0003_03_s,
            R.drawable.head_0003_04_s, R.drawable.head_0003_05_s, R.drawable.head_0003_06_s, R.drawable.head_0003_06_s};
    public static Integer[] bgneck8 = new Integer[]{R.drawable.neck_0003_00_s, R.drawable.neck_0003_01_s, R.drawable.neck_0003_02_s};
    public static Integer[] bghorn88 = new Integer[]{R.drawable.horn2_0003_00_s, R.drawable.horn2_0003_01_s, R.drawable.horn2_0003_02_s, R.drawable.horn2_0003_03_s,
            R.drawable.horn2_0003_04_s, R.drawable.horn2_0003_05_s, R.drawable.horn2_0003_06_s, R.drawable.horn2_0003_06_s};
    public static Integer[] bgwing8 = new Integer[]{R.drawable.wing_0003_01_s, R.drawable.wing_0003_02_s, R.drawable.wing_0003_03_s};
    public static Integer[] bghorn8 = new Integer[]{R.drawable.horn_0003_00_s, R.drawable.horn_0003_01_s, R.drawable.horn_0003_02_s, R.drawable.horn_0003_03_s,
            R.drawable.horn_0003_04_s, R.drawable.horn_0003_05_s, R.drawable.horn_0003_06_s, R.drawable.horn_0003_06_s};

    public static Integer[] body7 = new Integer[]{R.drawable.body_0103_00, R.drawable.body_0103_01, R.drawable.body_0103_02, R.drawable.body_0103_03,
            R.drawable.body_0103_04, R.drawable.body_0103_05, R.drawable.body_0103_06, R.drawable.body_0103_10_stand};
    public static Integer[] head7 = new Integer[]{R.drawable.head_0103_00, R.drawable.head_0103_01, R.drawable.head_0103_02, R.drawable.head_0103_03,
            R.drawable.head_0103_04, R.drawable.head_0103_05, R.drawable.head_0103_06, R.drawable.head_0103_10};
    public static Integer[] neck7 = new Integer[]{R.drawable.neck_0103_00, R.drawable.neck_0103_01, R.drawable.neck_0103_02, R.drawable.neck_0103_10};
    public static Integer[] horn7 = new Integer[]{R.drawable.horn_0103_00, R.drawable.horn_0103_01, R.drawable.horn_0103_02, R.drawable.horn_0103_03,
            R.drawable.horn_0103_04, R.drawable.horn_0103_05, R.drawable.horn_0103_06, R.drawable.horn_0103_10};
    public static Integer[] wing7 = new Integer[]{R.drawable.wing_0103_01, R.drawable.wing_0103_02, R.drawable.wing_0103_03, R.drawable.wing_0103_10};
    public static Integer[] face7 = new Integer[]{R.drawable.face_0103_00, R.drawable.face_0103_01, R.drawable.face_0103_02, R.drawable.face_0103_03, R.drawable.face_0103_04, R.drawable.face_0103_10};
    public static Integer[] bgbody7 = new Integer[]{R.drawable.body_0103_00_s, R.drawable.body_0103_01_s, R.drawable.body_0103_02_s, R.drawable.body_0103_03_s, R.drawable.body_0103_04_s, R.drawable.body_0103_05_s, R.drawable.body_0103_06_s};
    public static Integer[] bghead7 = new Integer[]{R.drawable.head_0103_00_s, R.drawable.head_0103_01_s, R.drawable.head_0103_02_s, R.drawable.head_0103_03_s,
            R.drawable.head_0103_04_s, R.drawable.head_0103_05_s, R.drawable.head_0103_06_s, R.drawable.head_0103_06_s};
    public static Integer[] bgneck7 = new Integer[]{R.drawable.neck_0103_00_s, R.drawable.neck_0103_01_s, R.drawable.neck_0103_02_s};
    public static Integer[] bghorn7 = new Integer[]{R.drawable.horn_0103_00_s, R.drawable.horn_0103_01_s, R.drawable.horn_0103_02_s, R.drawable.horn_0103_03_s,
            R.drawable.horn_0103_04_s, R.drawable.horn_0103_05_s, R.drawable.horn_0103_06_s, R.drawable.horn_0103_06_s};
    public static Integer[] bgwing7 = new Integer[]{R.drawable.wing_0103_00_s, R.drawable.wing_0103_01_s, R.drawable.wing_0103_02_s, R.drawable.wing_0103_03_s};
}