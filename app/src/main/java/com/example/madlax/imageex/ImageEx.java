package com.example.madlax.imageex;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
/**
 * Created by madlax on 2017/02/15.
 */
///test
public class ImageEx extends Activity{
        //アクティビティ起動時に呼ばれる
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new ImageView(this));
    }
}
