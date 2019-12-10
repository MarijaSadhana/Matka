package mk.test.matka_v2.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public CustomTextView(Context context) {
        super(context);
        init();
    }
    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.DEFAULT;

            switch (getTypeface().getStyle()){
                case Typeface.BOLD:
                    tf = Typeface.createFromAsset(getContext().getAssets(), "font/roboto-bold.ttf");
                    break;
                default:
                    tf = Typeface.createFromAsset(getContext().getAssets(), "font/roboto.ttf");
                    break;
            }
            setTypeface(tf);
        }
    }
}
