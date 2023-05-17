package com.example.learntodrive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifImageView;

public class RulesViewPagerAdapter extends PagerAdapter {
    private final Context ctx;

    public RulesViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.slide_rules, container, false);

        GifImageView logo = view.findViewById(R.id.dancer);
        TextView title = view.findViewById(R.id.textView31);
        TextView mail = view.findViewById(R.id.textView10);

        switch (position) {
            case 0:
                logo.setImageResource(R.drawable.checkmark);
                title.setText("Если количество правильных ответов в тесте превышает 70%, то следующий тест становится доступным. Каждый тест содержит десять вопросов.");
                title.setTextSize(20);
                break;
            case 1:
                logo.setImageResource(R.drawable.xmark);
                title.setText("Для сдачи тестов вам требуется интернет-соединение, однако книга по вождению доступна без подключения к сети.");
                title.setTextSize(22);
                break;
            case 2:
                logo.setImageResource(R.drawable.question);
                title.setText("Есть еще вопросы?");
                mail.setText("DriveSmart@mail.ru");
                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
