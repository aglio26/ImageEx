package com.example.madlax.imageex;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
/**
 * Created by madlax on 2017/02/15.
 */
///test
public class ImageEx extends Activity{                  //Activityクラスの継承クラス作成
    @Override                                           //OnCreateメソッドにオーバーライド
    public void onCreate(Bundle bundle){                //オーバーライド内容の記述開始
        super.onCreate(bundle);                         //継承元OnCreateの処理の実行
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //通知領域を消去するメソッドの実行
        setContentView(new ImageView(this));            //Viewクラスの呼び出しメソッドの実行 ImageViewのコンストラクタ実行
    }
}
