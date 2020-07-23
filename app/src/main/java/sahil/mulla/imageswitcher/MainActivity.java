package sahil.mulla.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
ImageSwitcher imageSwitcher;
Button buttonSwitcher;
TextView textView;
int img_data[]={R.drawable.image1,R.drawable.images2,R.drawable.image3,R.drawable.images4,R.drawable.images5};
int count=img_data.length;
int image_index=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher=findViewById(R.id.imageSwitcher);
        buttonSwitcher=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(R.drawable.image1);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        Animation animation_in= AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        Animation animation_out= AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
        imageSwitcher.setInAnimation(animation_in);
        imageSwitcher.setOutAnimation(animation_out);

        buttonSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                image_index++;
                if(image_index==count) {
                    image_index=0;

                }
                if(image_index==0) {
                    textView.setText("Tiger");
                    imageSwitcher.setImageResource(img_data[image_index]);
                }else if(image_index==1)
                {
                    textView.setText("Cat");
                    imageSwitcher.setImageResource(img_data[image_index]);
                }else
                    if(image_index==2)
                {
                    textView.setText("Birds");
                    imageSwitcher.setImageResource(img_data[image_index]);
                }else if(image_index==3)
                {
                    textView.setText("Parrots");
                    imageSwitcher.setImageResource(img_data[image_index]);
                }else if(image_index==4)
                {
                    textView.setText("Dog");
                    imageSwitcher.setImageResource(img_data[image_index]);
                }
            }
        });
    }
}