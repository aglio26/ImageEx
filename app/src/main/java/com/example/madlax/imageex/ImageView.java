package com.example.madlax.imageex;
import android.content.res.Resources;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.graphics.Point;
import android.app.Activity;
import android.graphics.Paint;

//イメージの描画
public class ImageView extends View{                                    //Viewクラスの継承クラス作成
    //フィールド変数
    private Bitmap image;
    public int ScreenWidth;
    public int ScreenHeight;

    //ユーザー定義メソッド
    public void getDisplaySize(Context context){
        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        ScreenWidth = p.x;
        ScreenHeight = p.y;
    }
    //コンストラクタ
    public ImageView(Context context) {                                  //コンストラクタ
        super(context);                                                 //継承元コンストラクタの実行
        setBackgroundColor(Color.WHITE);                                //背景を白にするメソッドの実行
        //画像の読込
        Resources r = context.getResources();                           //リソースのインスタンス生成
        image = BitmapFactory.decodeResource(r, R.drawable.koa);   //Bitmapクラスオブジェクトの生成
        //画面サイズ取得
        //get screen size and get origin,cell
        getDisplaySize(context);
    }



    //描画時に呼ばれる
    @Override                                                           //onDrawメソッドのオーバライド
    protected void onDraw(Canvas canvas){                               //オーバライド
        //イメージの描画
        canvas.drawBitmap(image,0,0,null);                              //画像をそのまま表示するメソッド
        //イメージの拡大縮小描画

        int w = image.getWidth();                                        //画像の横幅読込
        int h = image.getHeight();                                       //画像の高さ読込
        Rect src = new Rect(0,0,w,h);                                    //データの内描画する部分の指定
        Rect dst = new Rect(0,0,w/3,h/3);                              //描画領域先の指定
        //canvas.drawBitmap(image,src,dst,null);                           //指定場所に指定縮尺で画像を描画するメソッド
        //連続描画
        for(int count = 0; count < 2; count++){
            canvas.drawBitmap(image,src,dst,null);
            dst.left += ScreenWidth/3;
            dst.right += ScreenWidth/3;
        }
        //文字情報出力
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("横:"+ScreenWidth+",縦:"+ScreenHeight,0,ScreenHeight-400,paint);
    }

}

