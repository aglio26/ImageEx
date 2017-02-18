package com.example.madlax.imageex;
import android.content.res.Resources;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;

//イメージの描画
public class ImageView extends View{
    private Bitmap image;
    //コンストラクタ
    public ImageView(Context context){
        super(context);
    setBackgroundColor(Color.WHITE);
    //画像の読込
    Resources r = context.getResources();
    image = BitmapFactory.decodeResource(r,R.drawable.alicetear);
    }

    //描画時に呼ばれる
    @Override
    protected void onDraw(Canvas canvas){
        //イメージの描画
        //canvas.drawBitmap(image,0,0,null);
        //イメージの拡大縮小描画
        int w = image.getWidth(); //画像の横幅読込
        int h = image.getHeight(); //画像の高さ読込
        Rect src = new Rect(0,0,w,h); //データの内描画する部分の指定
        Rect dst = new Rect(0,0,w/2,h/2);  //描画領域先の指定
        canvas.drawBitmap(image,src,dst,null); //画像の描画
    }

}

