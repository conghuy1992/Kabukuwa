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
import android.widget.TextView;

import com.daydelight.kabukuwa.AdapterMenu2;
import com.daydelight.kabukuwa.adaptermenu_3;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.daydelight.kabukuwa.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import java.util.List;

/**
 * Created by goood on 5/15/15.
 */
public class mypageMenu3 extends Activity {
    String Str[] = {"スタートボタンを押しても、今まで...",
            "オスしか生まれないのですが、メス...",
            "遊んでいる途中にアプリケーション",
            "アプリケーションを削除した場合、...",
            "機種変更する場合は、どうすれば良...",
            "成長する方法がわかりません。",
            "何種類の性格がありますか？",
            "昆虫が出てきません。",
            "たまごから誕生する虫はゲーム開始",
            "最短どのくらいで成虫になりますか？",
            "日中は仕事や学校で世話ができませ...",
            "友達の成虫と交流をもったり戦わせ",
            "友達に成虫になった姿の画像を携帯...",
            "さなぎになったら放置しておけばそ...",
            "さなぎから成虫になるのは何日くら",
            "一度に何匹も育ててることはできま",
            "死ぬとどうなりますか？",
            "スタミナを回復するにはどうしたら",
            "セリフは変えることができますか？..",
            "家は牛乳瓶だけですか？",
            "成虫になったらどうなりますか？",
            "成虫は何パターンあるんですか？",
            "変態を見逃したくないのですが、見...",
            "ゲームをしている最中、着信やメー...",
            "直接電話で問合せしたい。可能です...",
            "情報交換をする場はありますか？",
            "どの世代をターゲットに作成したゲ...",
            "早くバトルがしたいですが、どうし...",
            "キャラクターを早く成虫にする方法...",
            "バトルで強いキャラを作りたい！",
            "バトルゲームを始めるにはどうした...",
            "誰と対戦したか忘れてしまいます。",
            "対戦の時、ピザみたいなのは何です...",
            "ルーレットは何のためにあるの？",
            "バトルをしたいのにスタミナがあり...",
            "バトルに勝ちやすくするための工夫...",
            "対戦キャラの横にあるアイテムは何？"
    };
    String _detail[] = {"質問\n" + "\n" +
            "スタートボタンを押しても、今までのデータは消えませんか？\n" + "\n" +
            "回答\n" + "\n" +
            "飼育中のデータがある場合には、つづきから始まります。",
            "質問\n" + "\n" +
                    "オスしか生まれないのですが、メスは生まれますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "現在はオスしか生まれません。次バージョン以降は、オスが生まれるか、メスが生まれるかはお楽しみですが、どちらも生まれます。",
            "質問\n" + "\n" +
                    "遊んでいる途中にアプリケーションが固まったり、終了してしまいます。\n" + "\n" +
                    "回答\n" + "\n" +
                    "メモリをオーバーしている可能性が考えられます。\n" + "\n" +
                    "ホームボタンをダブルクリックして同時に開いているアプリを閉じるか、電源を一旦オフにして下さい。",
            "質問\n" + "\n" +
                    "アプリケーションを削除した場合、アプリケーション内のデータはどうなりますか。\n" + "\n" +
                    "回答\n" + "\n" +
                    "データは、全て削除されます。再度ご利用の際には改めてダウンロードして下さい。",
            "質問\n" + "\n" +
                    "機種変更する場合は、どうすれば良いですか？中のデータを新しい機種に引き継ぎたいのですが。。。\n" + "\n" +
                    "回答\n" + "\n" +
                    "iTunesでの同期でバックアップをしておけば、新しい機種でデータの引き継ぎが可能です。",
            "質問\n" + "\n" +
                    "成長する方法がわかりません。\n" + "\n" +
                    "回答\n" + "\n" +
                    "成長は、ゲーム中で得る個性値によって変化します。いくつかのヒントは、アプリケーション内メニューのまめ知識をご参照下さい。",
            "質問\n" + "\n" +
                    "何種類の性格がありますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "公開していないので是非楽しみながら遊んでお客様ご自身で確かめてみてください。",
            "質問\n" + "\n" +
                    "昆虫が出てきません。\n" + "\n" +
                    "回答\n" + "\n" +
                    "下のペットの方へ行っていないか、ご確認ください。",
            "質問\n" + "\n" +
                    "たまごから誕生する虫はゲーム開始時に選択できるのですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "現在のところ、カブトムシ/クワガタムシのみになっています。今後他の昆虫も随時リリースしていきます。",
            "質問\n" + "\n" +
                    "最短どのくらいで成虫になりますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "実際の生育速度の約１０倍のスピードで成長します。温度や成長度などの条件によってもかわります。",
            "質問\n" + "\n" +
                    "日中は仕事や学校で世話ができません、何時間放置すると機嫌が悪くなったり病気になりますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "はい。病気にはなりませんがお腹がすくと機嫌が悪くなるので出来るだけかまってあげて下さい。",
            "質問\n" + "\n" +
                    "友達の成虫と交流をもったり戦わせることはできますか？\n" + "\n" +
                    "回答\n" +
                    "現在は交流できません。今後は友達の環境を見れるような交流を企画中です。",
            "質問\n" + "\n" +
                    "友達に成虫になった姿の画像を携帯で送りたい、画像として保存することできますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "現在準備中。つぎのアップデートで画像を保存したり、お友達に送ることが出来るようになります。",
            "質問\n" + "\n" +
                    "さなぎになったら放置しておけばそのうち成虫になるのでしょうか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "飼育まめ知識をご覧ください。",
            "質問\n" + "\n" +
                    "さなぎから成虫になるのは何日くらいかかりますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "実物では、７日から１０日ほどでさなぎから成虫になります。ただし幼虫の時にあまり世話をしてあげてないとなかなか成虫にならないかもしれません。",
            "質問\n" +
                    "一度に何匹も育ててることはできますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "現在はできません。今後は数匹購入できるようになります。",
            "質問\n" + "\n" +
                    "死ぬとどうなりますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "育てているキャラが死んでしまったら、またたまごからゲームが始まります。できるだけ死なないようにお世話をしてあげてください。",
            "質問\n" + "\n" +
                    "スタミナを回復するにはどうしたらいいですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "食事やドリンク等を与え、温度や清潔さを保つようにしてください。",
            "質問\n" + "\n" +
                    "セリフは変えることができますか？変え方について教えてください。\n" + "\n" +
                    "回答\n" + "\n" +
                    "セリフは変更できません。昆虫の状態によりコメントが出てきます。",
            "質問\n" + "\n" +
                    "家は牛乳瓶だけですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "現在は、牛乳瓶の家のみになります。",
            "質問\n" + "\n" +
                    "成虫になったらどうなりますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "頻繁にかまってあげればとってもいい成虫に成長します。成虫に成れば、また新しいくたまごからゲームが始まります。",
            "質問\n" + "\n" +
                    "成虫は何パターンあるんですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "現在は１パターンです。今後は増えていきますので、お楽しみにしてください。",
            "質問\n" + "\n" +
                    "変態を見逃したくないのですが、見れない時間帯があります。時間調整はできるのでしょうか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "出来るだけカブトムシ／クワガタムシと一緒にいてあげてください。そうすれば変態を見れるかも。。。",
            "質問\n" + "\n" +
                    "ゲームをしている最中、着信やメールが届くとどうなりますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "メールや着信を終えてゲームに戻るとそのまま続きからお楽しみ頂けます。",
            "質問\n" + "\n" +
                    "直接電話で問合せしたい。可能ですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "申し訳ありませんが、お問い合わせからメールしてください。電話には対応していません。",
            "質問\n" + "\n" +
                    "情報交換をする場はありますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "今後は情報交換の場も設けようと思います。",
            "質問\n" + "\n" +
                    "どの世代をターゲットに作成したゲームですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "幼稚園、小学生から成人までお楽しみいただけるようになっています。",
            "質問\n" + "\n" +
                    "早くバトルがしたいですが、どうしたらいいですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "飼育活動で成虫が育たないとバトルモードになりません。気長に育てましょう。",
            "質問\n" + "\n" +
                    "キャラクターを早く成虫にする方法はないですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "温度を上げるとゲージの減りが早くなります。\n" +
                    "成長速度が速くなる成長促進剤や、幼齢段階をスキップできる進化の薬を使うのもアリ。",
            "質問\n" + "\n" +
                    "バトルで強いキャラを作りたい！\n" + "\n" +
                    "回答\n" + "\n" +
                    "温度を低めに設定して、じっくり世話をすると大きく育ちやすいです。\n" +
                    "強い個体はパーツが赤色になります。\n" +
                    "蛹になる直前の栄養や水分状態に気をつけましょう！",
            "質問\n" + "\n" +
                    "バトルゲームを始めるにはどうしたらいいの？\n" + "\n" +
                    "回答\n" + "\n" +
                    "ビーチパラソルのある画面がバトルホーム画面です。\n" +
                    "自分のキャラクターを、切株のプロレスリングへ連れていくと、バトルがはじめられます。",
            "質問\n" + "\n" +
                    "誰と対戦したか忘れてしまいます。\n" + "\n" +
                    "回答\n" + "\n" +
                    "記憶力を高めたり、上から順番にしらみつぶしに戦っていくとわかり易いです。",
            "質問\n" + "\n" +
                    "対戦の時、ピザみたいなのは何ですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "ピザのようなルーレットです。1～８まで数字に応じて強い攻撃を繰り出せます。",
            "質問\n" + "\n" +
                    "ルーレットは何のためにあるの？\n" + "\n" +
                    "回答\n" + "\n" +
                    "タップのタイミングで攻撃威力を増強できます。\n" +
                    "（音楽をつけてプレイすると効果音が出てリズム遊びのようで、もっと楽しくなります。）\n" +
                    "また、攻撃の強さや回数で、経験値やコイン数が変わります★",
            "質問\n" + "\n" +
                    "バトルをしたいのにスタミナがありませんとありますが、どういうことですか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "プレイヤーであるブリーダーとしてのスタミナがないと、バトルに参戦できません。\n" +
                    "保命酒を使ったり、レベルアップをして、スタミナをつけましょう。",
            "質問\n" + "\n" +
                    "バトルに勝ちやすくするための工夫はありますか？\n" + "\n" +
                    "回答\n" + "\n" +
                    "ルーレットで攻撃威力を増すことと、バトル前にHPを回復しておくことです。\n" +
                    "装備品を見直して、ベストコーディネートで戦いに臨みましょう！",
            "質問\n" + "\n" +
                    "対戦キャラの横にあるアイテムは何？\n" + "\n" +
                    "回答\n" + "\n" +
                    "勝利した時にゲットできることのあるアイテムを表示しています。",
    };
    AdapterMenu2 adapter;
    ListView listView;
    Button button;
    private PublisherAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_menu3);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //
        TextView txt7 = (TextView) findViewById(R.id.textView7);
        txt7.setText("質問集");
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
                Intent intent = new Intent(mypageMenu3.this, adaptermenu_3.class);
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

