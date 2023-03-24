package com.example.learntodrive;

public class Questions {

    private String Questions1[] = {
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
            {"Движение запрещено","Остановка запрещена","Стоянка запрещена"},
            {"Пешеходный переход","Приближение к пешеходному переходу","Пешеходная зона"},
            {"Пересечение с круговым движением","Объезд препятствия справа","Круговое движение"}
    };

    private String Images1[] = {
            "turn_right",
            "speed_limit",
            "stop_sign",
            "main_road",
            "no_parking",
            "crosswalk",
            "circulation"
    };
    private String QuestionsType1[] = {
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
            "Остановка запрещена",
            "Пешеходный переход",
            "Круговое движение"
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
