package com.example.learntodrive;

import android.graphics.Color;

public class Questions {

    private String Questions1[] = {
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак обозначает : "
    };
    private String Choice1[][] = {
            {"Поворот налево запрещен","Движение направо","Опасный поворот направо"},
            {"Ограничение максимальной скорости","Ограничение минимальной скорости","Ограничение минимальной дистанции"},
            {"Движение без остановки запрещено","Движение запрещено","Разворот запрещен"},
            {"Конец главной дороги","Уступите дорогу","Главная дорога"},
            {"Пешеходный переход","Приближение к пешеходному переходу","Пешеходная зона"},
            {"Светофор","Пересечение равнозначных дорог","Светофорное регулирование"},
            {"Конец зоны всех ограничений","Уступите дорогу","Въезд запрещен"},
            {"Разворот запрещен","Поворот налево запрещен","Поворот направо запрещен"},
            {"Место стоянки","Тупик","Место стоянки легковых такси"},
            {"Строительные Работы","Дорожные работы","Прочие опасности"}
    };

    private String Images1[] = {
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fturn_right.png?alt=media&token=a62cf880-38b3-4347-be04-335310dd4584",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fspeed_limit.png?alt=media&token=696f42c7-d441-4718-a36b-1bcf5444eb5f",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fstop_sign.png?alt=media&token=c777f627-3b76-436c-9273-3e868efd576e",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fmain_road.png?alt=media&token=64ea0c80-d8c1-4b14-8810-d612414956f5",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fcrosswalk.png?alt=media&token=462d2e51-5f38-4be0-8412-c121d41e0837",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fsvetafor.png?alt=media&token=a28e793e-2193-40e1-8707-b76d135b6599",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2F%D0%A3%D1%81%D1%82%D1%83%D0%BF%D0%B8%D1%82%D0%B5%20%D0%B4%D0%BE%D1%80%D0%BE%D0%B3%D1%83.png?alt=media&token=aa1607ef-c5a3-4f5b-978c-ec954845041d",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2F3.18.2-%D0%9F%D0%BE%D0%B2%D0%BE%D1%80%D0%BE%D1%82-%D0%BD%D0%B0%D0%BB%D0%B5%D0%B2%D0%BE-%D0%B7%D0%B0%D0%BF%D1%80%D0%B5%D1%89%D0%B5%D0%BD-removebg-preview.png?alt=media&token=b044c4d7-e0b6-4f3c-a61d-e28ccc75238a",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fparkovka.png?alt=media&token=269ccc8f-cb80-4d66-9340-219e96a57017",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2F3f13402a7f2a9f17d57df3a06cbd1dc4.webp?alt=media&token=75c8c6c6-3729-4be4-bf28-79db1afbb786"
    };
    private String QuestionsType1[] = {
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton"
    };
    private String CoorectAnswers1 [] = {
            "Движение направо",
            "Ограничение максимальной скорости",
            "Движение без остановки запрещено",
            "Главная дорога",
            "Пешеходный переход",
            "Светофорное регулирование",
            "Уступите дорогу",
            "Поворот налево запрещен",
            "Место стоянки",
            "Дорожные работы"
    };

    public String getQuestions1(int q) {
        String questions1 = Questions1[q];
        return questions1;
    }

    public String[] getChoice1(int q) {
        String[] choice1 = Choice1[q];
        return choice1;
    }

    public String getImages1(int q) {
        String img1 = Images1[q];
        return img1;
    }

    public String getType1(int q) {
        String type1 = QuestionsType1[q];
        return type1;
    }
    public int getLenght1(){
        return Questions1.length;
    }

    public String getCoorectAnswers1(int q) {

        String correct1 = CoorectAnswers1[q];

        return correct1;
    }
}
