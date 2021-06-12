package com.example.game3072;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;

public class GameView extends View {

    public Paint paint = new Paint();
    public Paint p = new Paint();

    int height;
    int width;

    float width1;
    float width2;
    float width3;
    float width4;
    float width5;
    float height1;
    float height2;
    float height3;
    float height4;
    float height5;

    int a = 100;
    int b = a / 2;
    int h = a / 5;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(MatrixGame.a == 3) {
            p.setColor(Color.WHITE);
            p.setTextAlign(Paint.Align.CENTER);

            p.setTextSize(70);
            p.setTypeface(ResourcesCompat.getFont(getContext(), R.font.m_sb));

            paint.setColor(Color.RED);

            height = getHeight() / 2+200;
            width = getWidth() / 6+50;

            int l = 10; // промежуток между квадратиками

            width1 = (float) ((width - a) + (width * 2 - b)) / 2 - l;
            width2 = (float) ((width * 2 - b) + (width * 3)) / 2;
            width3 = (float) ((width * 3) + (width * 4 + b)) / 2 + l;
            height1 = (float) ((height - (width * 2) - a) + (height - width - b)) / 2 + h - l;
            height2 = (float) ((height - width - b) + (height)) / 2 + h;
            height3 = (float) ((height) + (height + width + b)) / 2 + h + l;

            int i = 0;
            int j = 0;

            int c = 12; // закругление квадратиков

            //
            //first row
            //
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height - (width * 2) - a - l, width * 2 - b - l, height - width - b - l, c, c, paint);
            //text
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height1, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b, height - (width * 2) - a - l, width * 3, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height1, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l, height - (width * 2) - a - l, width * 4 + b + l, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height1, p);
            //
            //second row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height - width - b, width * 2 - b - l, height, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height2, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b, height - width - b, width * 3, height, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height2, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l, height - width - b, width * 4 + b + l, height, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height2, p);
            //
            //third row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height + l, width * 2 - b - l, height + width + b + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height3, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b, height + l, width * 3, height + width + b + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height3, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l, height + l, width * 4 + b + l, height + width + b + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height3, p);

        }

        if (MatrixGame.a == 4) {
            p.setColor(Color.WHITE);
            p.setTextAlign(Paint.Align.CENTER);

            p.setTextSize(70);
            p.setTypeface(ResourcesCompat.getFont(getContext(), R.font.m_sb));

            paint.setColor(Color.RED);

            height = getHeight() / 2+50;
            width = getWidth() / 6;

            int l = 15; // промежуток между квадратиками

            width1 = (float) ((width - a) + (width * 2 - b)) / 2 - l;
            width2 = (float) ((width * 2 - b) + (width * 3)) / 2 - l/2;
            width3 = (float) ((width * 3) + (width * 4 + b)) / 2 + l/2;
            width4 = (float) ((width * 4 + b) + (width * 5 + a)) / 2 + l;
            height1 = (float) ((height - (width * 2) - a) + (height - width - b)) / 2 + h - l;
            height2 = (float) ((height - width - b) + (height)) / 2 + h - l/2;
            height3 = (float) ((height) + (height + width + b)) / 2 + h + l/2;
            height4 = (float) ((height + width + b) + (height + width * 2 + a)) / 2 + h + l;

            int i = 0;
            int j = 0;

            int c = 12; // закругление


            //
            //first row
            //
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height - (width * 2) - a - l, width * 2 - b - l, height - width - b - l, c, c, paint);
            //text
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height1, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/3, height - (width * 2) - a - l, width * 3 - l/3, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height1, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l/3, height - (width * 2) - a - l, width * 4 + b + l/3, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height1, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l, height - (width * 2) - a - l, width * 5 + a + l, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height1, p);
            //
            //second row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height - width - b - l/3, width * 2 - b - l, height - l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height2, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/3, height - width - b - l/3, width * 3 - l/3, height - l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height2, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l/3, height - width - b - l/3, width * 4 + b + l/3, height - l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3 - l/3, height2, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l, height - width - b - l/3, width * 5 + a + l, height - l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height2, p);
            //
            //third row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height + l/3, width * 2 - b - l, height + width + b + l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height3, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/3, height + l/3, width * 3 - l/3, height + width + b + l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height3, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l/3, height + l/3, width * 4 + b + l/3, height + width + b + l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height3, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l, height + l/3, width * 5 + a + l, height + width + b + l/3, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height3, p);
            //
            //fourth row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height + width + b + l, width * 2 - b - l, height + width * 2 + a + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height4, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/3, height + width + b + l, width * 3 - l/3, height + width * 2 + a + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height4, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3 + l/3, height + width + b + l, width * 4 + b + l/3, height + width * 2 + a + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height4, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l, height + width + b + l, width * 5 + a + l, height + width * 2 + a + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height4, p);
        }
        if (MatrixGame.a == 5) {
            p.setColor(Color.WHITE);
            p.setTextAlign(Paint.Align.CENTER);

            p.setTextSize(70);
            p.setTypeface(ResourcesCompat.getFont(getContext(), R.font.m_sb));

            paint.setColor(Color.RED);

            height = getHeight() / 2+10;
            width = getWidth() / 7 - 5;

            int l = 20; // промежуток

            width1 = (float) ((width - a) + (width * 2 - b)) / 2 - l;
            width2 = (float) ((width * 2 - b) + (width * 3)) / 2 - l/2;
            width3 = (float) ((width * 3) + (width * 4 + b)) / 2;
            width4 = (float) ((width * 4 + b) + (width * 5 + a)) / 2 + l/2;
            width5 = (float) ((width * 5 + a) + (width * 6 + a + b)) / 2 + l;
            height1 = (float) ((height - (width * 2) - a) + (height - width - b)) / 2 + h - l;
            height2 = (float) ((height - width - b) + (height)) / 2 + h - l/2;
            height3 = (float) ((height) + (height + width + b)) / 2 + h;
            height4 = (float) ((height + width + b) + (height + width * 2 + a)) / 2 + h + l/2;
            height5 = (float) ((height + width * 2 + a) + (height + width * 3 + a + b)) / 2 + h + l;

            int i = 0;
            int j = 0;

            int c = 12; // закругление

            //
            //first row
            //
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height - (width * 2) - a - l, width * 2 - b - l, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height1, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/2, height - (width * 2) - a - l, width * 3 - l/2, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height1, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3, height - (width * 2) - a - l, width * 4 + b, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height1, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l/2, height - (width * 2) - a - l, width * 5 + a + l/2, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height1, p);
            //fifth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 5 + a + l, height - (width * 2) - a - l, width * 6 + a + b + l, height - width - b - l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width5, height1, p);
            //
            //second row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height - width - b - l/2, width * 2 - b - l, height - l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height2, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/2, height - width - b - l/2, width * 3 - l/2, height - l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height2, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3, height - width - b - l/2, width * 4 + b, height - l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height2, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l/2, height - width - b - l/2, width * 5 + a + l/2, height - l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height2, p);
            //fifth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 5 + a + l, height - width - b - l/2, width * 6 + a + b + l, height - l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width5, height2, p);
            //
            //third row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height, width * 2 - b - l, height + width + b, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height3, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/2, height, width * 3 - l/2, height + width + b, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height3, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3, height, width * 4 + b, height + width + b, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height3, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l/2, height, width * 5 + a + l/2, height + width + b, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height3, p);
            //fifth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 5 + a + l, height, width * 6 + a + b + l, height + width + b, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width5, height3, p);
            //
            //fourth row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height + width + b + l/2, width * 2 - b - l, height + width * 2 + a + l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height4, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/2, height + width + b + l/2, width * 3 - l/2, height + width * 2 + a + l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height4, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3, height + width + b + l/2, width * 4 + b, height + width * 2 + a + l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height4, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l/2, height + width + b + l/2, width * 5 + a + l/2, height + width * 2 + a + l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height4, p);
            //fifth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 5 + a + l, height + width + b + l/2, width * 6 + a + b + l, height + width * 2 + a + l/2, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width5, height4, p);
            //
            //fifth row
            //
            i++;
            j = 0;
            //first
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width - a - l, height + width * 2 + a + l, width * 2 - b - l, height + width * 3 + b * 3 + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width1, height5, p);
            //second
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 2 - b - l/2, height + width * 2 + a + l, width * 3 - l/2, height + width * 3 + b * 3 + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width2, height5, p);
            //third
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 3, height + width * 2 + a + l, width * 4 + b, height + width * 3 + b * 3 + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width3, height5, p);
            //fourth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 4 + b + l/2, height + width * 2 + a + l, width * 5 + a + l/2, height + width * 3 + b * 3 + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width4, height5, p);
            //fifth
            j++;
            paint.setColor(get3Color(MatrixGame.matrix[i][j]));
            canvas.drawRoundRect(width * 5 + a + l, height + width * 2 + a + l, width * 6 + a + b + l, height + width * 3 + b * 3 + l, c, c, paint);
            canvas.drawText(String.valueOf(MatrixGame.matrix[i][j]), width5, height5, p);
        }
    }

    public int get3Color(int m) {
        switch (m) {
            case 0:
                return Color.parseColor("#383838");
            case 2:
            case 3:
                return Color.parseColor("#A1C900");
            case 4:
            case 6:
                return Color.parseColor("#DCD300");
            case 8:
            case 12:
                return Color.parseColor("#FFD231");
            case 16:
            case 24:
                return Color.parseColor("#FFB931");
            case 32:
            case 48:
                return Color.parseColor("#FFA031");
            case 64:
            case 96:
                return Color.parseColor("#FF8831");
            case 128:
            case 192:
                return Color.parseColor("#FF5631");
            case 256:
            case 384:
                return Color.parseColor("#FF3131");
            case 512:
            case 768:
                return Color.parseColor("#E01848");
            case 1024:
            case 1536:
                return Color.parseColor("#FF4E83");
            case 2048:
            case 3072:
                return Color.parseColor("#FF4EA3");
            case 4096:
            case 6144:
                return Color.parseColor("#F14EFF");
            case 8192:
            case 12288:
                return Color.parseColor("#C64EFF");
            case 16384:
            case 24576:
                return Color.parseColor("#914EFF");
            case 32768:
            case 49152:
                return Color.parseColor("#714EFF");
            default:
                return Color.parseColor("#4ED5FF");
        }
    }
}
