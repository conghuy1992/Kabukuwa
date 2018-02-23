package com.daydelight.kabukuwa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.AdapterMenu2;
import com.daydelight.kabukuwa.adaptermenu_2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.daydelight.kabukuwa.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import java.util.List;

/**
 * Created by goood on 5/15/15.
 */
public class mypageMenu2 extends Activity {
    String Str[] = {"ゲーム中のタマゴの育て方", "りっぱな成虫になるまで", "タマゴ", "幼虫", "１齢幼虫", "２齢幼虫", "３齢幼虫", "蛹", "成虫"};
    String _detail[] = {"タマゴや体をなでると、おはなしするよ。友達指数をUPしよう。\n" + "\n" +
            "フードをおして、餌を選ぼう。満腹にしてあげよう！\n" + "\n" +
            "ドリンクを押して、ドリンクを選ぼう。元気に育てよう。\n" + "\n" +
            "食事や掃除、何かしているときは、邪魔をしないでね。まだこどもだから失敗しちゃうよ。\n" + "\n" +
            "シャワーを押そう。シャワーで性適な温 気をキープ！\n" + "\n" +
            "そうじを押そう。ダニやごみを掃除してくれるよ。\n" + "\n" +
            "うんちやおしつこの掃除もさせてね！\n" + "\n" +
            "温度にも気をつけてあげてね。暑すぎ寒すぎはキライだよ。\n" + "\n" +
            "寝ているときは、食べたり飲んだり、お掃除もシャワーもできないよ。\n" + "\n" +
            "マイペジに戻ってレベルアップしてないか確かめてみよう！\n" + "\n" +
            "フード・ドリンクがなくなったら、ショップで買えるよ！\n" + "\n" +
            "生長促進剤も上手につかうと、はやくおおきくなるよ。\n" + "\n" +
            "友達指数・フード・ドリンク・掃除であなただけの昆虫を育てよう。\n" + "\n" +
            "たまごから一齢幼虫になる\n" + "\n" +
            "一齢幼虫から二齢幼虫になるよ\n" + "\n" +
            "二齢幼虫から三齢幼虫になるよ\n" + "\n" +
            "三齢幼虫からさなぎになるよ\n" + "\n" +
            "さなぎから成虫になるよ。\n" + "\n" +
            "成虫は基本の８種類があるよ。\n" + "\n" +
            "タマゴにダニがいたら、マツトを取り替えてね。\n" + "\n" +
            "タマゴはふ化するまでなるべく動かさないでね。\n" + "\n" +
            "本物の生まれたてのタマゴは３ミリ位で白くて丸いよ。\n" + "\n" +
            "タマゴはつぶれやすいので、スプーンですくって動かすよ。\n" + "\n" +
            "ふ化する前にタマゴは５ミリ位に大きくなるよ。\n" + "\n" +
            "マツトはカラカラでも、しめり過ぎでもいけない。\n" + "\n" +
            "日かげで雨がふっても大丈夫な場所がいいよ。\n" + "\n" +
            "静かで、薄暗い場所がいいよ。\n" + "\n" +
            "成虫になるまで同じ場所で育ててね。\n" + "\n" +
            "アリや他の虫が来ない場所がいいよ。\n" + "\n" +
            "うまれてから２〜３週間で幼虫になるよ。",
            "タマゴや体をなでると、おはなしするよ。友達指数をUPしよう。\n" + "\n" +
                    "フードをおして、餌を選ぼう。満腹にしてあげよう！\n" + "\n" +
                    "ドリンクを押して、ドリンクを選ぼう。元気に育てよう。\n" + "\n" +
                    "食事や掃除、何かしているときは、邪魔をしないでね。まだこどもだから失敗しちゃうよ。\n" + "\n" +
                    "シャワーを押そう。シャワーで性適な温 気をキープ！\n" + "\n" +
                    "そうじを押そう。ダニやごみを掃除してくれるよ。\n" + "\n" +
                    "うんちやおしつこの掃除もさせてね！\n" + "\n" +
                    "温度にも気をつけてあげてね。暑すぎ寒すぎはキライだよ。\n" + "\n" +
                    "寝ているときは、食べたり飲んだり、お掃除もシャワーもできないよ。\n" + "\n" +
                    "マイペジに戻ってレベルアップしてないか確かめてみよう！\n" + "\n" +
                    "フード・ドリンクがなくなったら、ショップで買えるよ！\n" + "\n" +
                    "生長促進剤も上手につかうと、はやくおおきくなるよ。\n" + "\n" +
                    "友達指数・フード・ドリンク・掃除であなただけの昆虫を育てよう。\n" + "\n" +
                    "たまごから一齢幼虫になる\n" + "\n" +
                    "一齢幼虫から二齢幼虫になるよ\n" + "\n" +
                    "二齢幼虫から三齢幼虫になるよ\n" + "\n" +
                    "三齢幼虫からさなぎになるよ\n" + "\n" +
                    "さなぎから成虫になるよ。\n" + "\n" +
                    "成虫は基本の８種類があるよ。\n" + "\n" +
                    "タマゴにダニがいたら、マツトを取り替えてね。\n" + "\n" +
                    "タマゴはふ化するまでなるべく動かさないでね。\n" + "\n" +
                    "本物の生まれたてのタマゴは３ミリ位で白くて丸いよ。\n" + "\n" +
                    "タマゴはつぶれやすいので、スプーンですくって動かすよ。\n" + "\n" +
                    "ふ化する前にタマゴは５ミリ位に大きくなるよ。\n" + "\n" +
                    "マツトはカラカラでも、しめり過ぎでもいけない。\n" + "\n" +
                    "日かげで雨がふっても大丈夫な場所がいいよ。\n" + "\n" +
                    "静かで、薄暗い場所がいいよ。\n" + "\n" +
                    "成虫になるまで同じ場所で育ててね。\n" + "\n" +
                    "アリや他の虫が来ない場所がいいよ。\n" + "\n" +
                    "うまれてから２〜３週間で幼虫になるよ。",
            "タマゴや体をなでると、おはなしするよ。友達指数をUPしよう。\n" + "\n" +
                    "フードをおして、餌を選ぼう。満腹にしてあげよう！\n" + "\n" +
                    "ドリンクを押して、ドリンクを選ぼう。元気に育てよう。\n" + "\n" +
                    "食事や掃除、何かしているときは、邪魔をしないでね。まだこどもだから失敗しちゃうよ。\n" + "\n" +
                    "シャワーを押そう。シャワーで性適な温 気をキープ！\n" + "\n" +
                    "そうじを押そう。ダニやごみを掃除してくれるよ。\n" + "\n" +
                    "うんちやおしつこの掃除もさせてね！\n" + "\n" +
                    "温度にも気をつけてあげてね。暑すぎ寒すぎはキライだよ。\n" + "\n" +
                    "寝ているときは、食べたり飲んだり、お掃除もシャワーもできないよ。\n" + "\n" +
                    "マイペジに戻ってレベルアップしてないか確かめてみよう！\n" + "\n" +
                    "フード・ドリンクがなくなったら、ショップで買えるよ！\n" + "\n" +
                    "生長促進剤も上手につかうと、はやくおおきくなるよ。\n" + "\n" +
                    "友達指数・フード・ドリンク・掃除であなただけの昆虫を育てよう。\n" + "\n" +
                    "たまごから一齢幼虫になる\n" + "\n" +
                    "一齢幼虫から二齢幼虫になるよ\n" + "\n" +
                    "二齢幼虫から三齢幼虫になるよ\n" + "\n" +
                    "三齢幼虫からさなぎになるよ\n" + "\n" +
                    "さなぎから成虫になるよ。\n" + "\n" +
                    "成虫は基本の８種類があるよ。\n" + "\n" +
                    "タマゴにダニがいたら、マツトを取り替えてね。\n" + "\n" +
                    "タマゴはふ化するまでなるべく動かさないでね。\n" + "\n" +
                    "本物の生まれたてのタマゴは３ミリ位で白くて丸いよ。\n" + "\n" +
                    "タマゴはつぶれやすいので、スプーンですくって動かすよ。\n" + "\n" +
                    "ふ化する前にタマゴは５ミリ位に大きくなるよ。\n" + "\n" +
                    "マツトはカラカラでも、しめり過ぎでもいけない。\n" + "\n" +
                    "日かげで雨がふっても大丈夫な場所がいいよ。\n" + "\n" +
                    "静かで、薄暗い場所がいいよ。\n" + "\n" +
                    "成虫になるまで同じ場所で育ててね。\n" + "\n" +
                    "アリや他の虫が来ない場所がいいよ。\n" + "\n" +
                    "うまれてから２〜３週間で幼虫になるよ。", "\n" +
            "幼虫は死ぬと土に戻っちゃうよ。\n" + "\n" +
            "マツト交換は秋と翌年の春、２回交換するといいよ。\n" + "\n" +
            "マツトがウンチだらけになったら、交換してね。",
            "ふ化したらすぐにマツトを食べ始めるよ。\n" + "\n" +
                    "マツトが食べられないとすぐに死んじゃうよ。\n" + "\n" +
                    "マツト交換は秋と翌年の春、２回交換するといいよ。\n" + "\n" +
                    "マツトがウンチだらけになったら、交換してね。\n" + "\n" +
                    "最初は小さいけど、ゴハンでどんどん大きくなるよ。",
            "マット交換は秋と翌年の春、２回交換するといいよ。\n" + "\n" +
                    "マットがウンチだらけになったら、交換してね。\n" + "\n" +
                    "脱皮して直径３センチくらいになるよ。",
            "２回目の脱皮をして直径４−５センチくらいになるよ。\n" + "\n" +
                    "育ち成でおなかがすくよ。たくさんゴハンをあげてね！\n" + "\n" +
                    "冬みんする時は飲まず食わずでじ~っとしているよ。\n" + "\n" +
                    "大人になると体が金色くなるよ\n" + "\n" +
                    "いつでもベットのしめり気や温度が大事だよ。\n" + "\n" +
                    "一番いいペットは手でギユツとしたらダンゴになるくらいのしめり具合。\n" + "\n" +
                    "ペットがピチヨピチヨだと幼虫が死んじゃうよ\n" + "\n" +
                    "ふるいにかけたふ葉土なら１齢幼虫でも食べれるよ。\n" + "\n" +
                    "冬に温めると「春が来た？」と間違って起きちゃうよ！\n" + "\n" +
                    "冬に間違って起きると、寝不足で元気なくなるよ。\n" + "\n" +
                    "自然と同じように育てるのが大切だよ。寒さだって大切だよ。\n" + "\n" +
                    "小さい穴を５こ位あけたビニールをフタとケースにはさむと乾きにくいよ。\n" + "\n" +
                    "毎日のシュッシュは、やりすぎるとピチヨピチヨになるよ。",
            "黄色味が濃くなり、しわが増えてきたら、そろそろサナギになるよ。\n" + "\n" +
                    "さなぎになる直前は動きが単調になるよ。\n" + "\n" +
                    "さなぎになる直前にはエサはほとんど食べないんだよ。\n" + "\n" +
                    "同じ場所にずっといるようになると、さなぎ部屋（蛹室）を作るよ。\n" + "\n" +
                    "体をクネクネさせてまわりの土を固めて縦長の丸い部屋をつくるよ。\n" + "\n" +
                    "さなぎができたら羽化まで容器を動かさずじっと観察しよう。\n" + "\n" +
                    "オスは角の分だけ部屋をメスより長くつくるよ。\n" + "\n" +
                    "１週間ぐらいで皮を脱いで幼虫からさなぎになるよ。（蛹化）\n" + "\n" +
                    "さなぎになりたては、真っ白い色をしているよ。\n" + "\n" +
                    "さなぎは白からオレンジ色に。。。黒褐色へと色が変わってくよ。\n" + "\n" +
                    "約３週間でさなぎの皮を脱ぎ成虫になる。\n" + "\n" +
                    "マットの上で羽化すると、羽がクシャクシャになってしまうかもしれないよ。",
            "羽化しても１週間〜１０日ぐらいは体が固まるのをじっと土の中で待っているよ。\n" + "\n" +
                    "ちょうどいいしめり気を保とう。\n" + "\n" +
                    "マットは成虫が昼間に休む場所で、幼虫が食べるえさにもなるよ。\n" + "\n" +
                    "止まり木はプナやケヤキなど広葉樹の木が良いよ\n" + "\n" +
                    "エサは昆虫ゼリーかバナナが良いよ\n" + "\n" +
                    "スイカ、メロン、きゅうりはカブトムシがお腹をこわしちゃうよ。\n" + "\n" +
                    "野外ではクヌギなどの樹液が主食べだよ\n" + "\n" +
                    "カブトムシは夜に１番エサを食べるから毎日夕方に取り替えよう。\n" + "\n" +
                    "エサ台がないとカブトムシがエサをひっくり返しちゃうよ。\n" + "\n" +
                    "マットの上にエサを置くと、マットの中にえさが沈んでマットが汚れるよ。"};
    AdapterMenu2 adapter;
    ListView listView;
    Button button;
    private PublisherAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_menu2);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //
        button = (Button) findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.listmenu2);
        adapter = new AdapterMenu2(this, Str);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mypageMenu2.this, adaptermenu_2.class);
                intent.putExtra("TITLE", Str[position]);
                intent.putExtra("DETAIL", _detail[position]);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        try {
//            if (isApplicationSentToBackground(this)) {
                if (mypage.soundbg.isPlaying()) {
                    mypage.soundbg.pause();
                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("sound", true) == true) {
            mypage.soundbg.start();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}
