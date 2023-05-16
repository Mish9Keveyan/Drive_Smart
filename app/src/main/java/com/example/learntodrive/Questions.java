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
    private String Questions2[] = {
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак: ",
            "Этот дорожный знак: ",
            "Можно ли водителю автобуса обгонять в зоне действия этого знака? ",
            "Этот дорожный знак обозначает : ",
            "Можно ли останавливаться на полосе, обозначенной данным знаком, для посадки пассажиров?",
            "Этот дорожный знак обозначает : ",
            "Этот дорожный знак предупреждает, что впереди: ",
            "Какие транспортные средства имеют разрешение на движение по дороге, где установлен данный знак?",
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
    private String Choice2[][] = {
            {"Движение запрещено","Остановка запрещена","Стоянка запрещена"},
            {"Запрещает движение всех механических тс., за исключением двухколесных мототциклов без коляски.","Запрещает движение всех механических тс., за исключением колесных тракторов.","Запрещается движение тракторов и самоходных машин."},
            {"Разрешает движение только с указанной или большей скоростью. ","Запрещает движение с большей скоростью,чем указано на знаке.","Указывает скорость, с которой рекомендуется движение на данном участке дороги."},
            {"Можно при условии, если обгоняемое транспортное средство движется со скоростью менее 30 км/ч.","Нельзя.","Можно во всех случаях с соблюдением правил обгона."},
            {"Дорога с односторонним движением, на которой разрешено движение только грузовых автомобилей.","Рекомендуемое направление движения для грузовых автомобилей.","Полосу, предназначенную для движения только грузовых автомобилей."},
            {"Разрешается, если полоса расположена у правого края проезжей части, и если она не отделена от остальной проезжей части сплошной линией разметки.","Запрещается.","Разрешается."},
            {"Конец дополнительной полосы на подъеме или полосы разгона.","Дорога, не имеющую сквозного проезда.","Направление движения к объекту в населенном пункте."},
            {"Место, где дорога выходит на набережную или берег.","Участок дороги с водной преградой, на котором имеется разводной мост.","Участок дороги с водной преградой, не имеющий моста или паромной переправы."},
            {"Механическим транспортным средствам.","Всем транспортным средствам.","Автомобилям и мотоциклам."},
            {"Пересечение равнозначных дорог","Пересечение с круговым движением","Светофорное регулирование"}
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

    private String CoorectAnswers2[] = {
            "Остановка запрещена",
            "Запрещается движение тракторов и самоходных машин.",
            "Разрешает движение только с указанной или большей скоростью. ",
            "Можно во всех случаях с соблюдением правил обгона.",
            "Рекомендуемое направление движения для грузовых автомобилей.",
            "Разрешается, если полоса расположена у правого края проезжей части, и если она не отделена от остальной проезжей части сплошной линией разметки.",
            "Дорога, не имеющую сквозного проезда.",
            "Место, где дорога выходит на набережную или берег.",
            "Автомобилям и мотоциклам.",
            "Пересечение равнозначных дорог"
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
    private String Images2[] = {
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2Fno_parking.png?alt=media&token=46b4c6fb-6745-4290-8d65-b039148b0276",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Fdownload-removebg-preview.png?alt=media&token=7dcf984b-4d96-4fba-a582-2636ee5f8ece",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Fshop_items_catalog_image1711.png?alt=media&token=a3e528cb-3cc2-4859-87a0-95ed38de9dd4",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2F9a2e8f008a5df9fd9a507b0e43b552e1.png?alt=media&token=d14b6620-4a7d-4491-88d4-aa78e95f800e",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Fshop_items_catalog_image2517.png?alt=media&token=804ef6d0-4d38-4dbd-b195-c612dadd8379",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Fmek.png?alt=media&token=e5596cf8-b5e4-4d54-8605-fad2d30f49c4",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Ferku.png?alt=media&token=8aa7b1d9-de47-416e-8620-14d44d408f56",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Ffour.png?alt=media&token=8ced95bd-a25c-446c-a072-898007fc2ffa",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Fthree.png?alt=media&token=09d83f65-4df4-45a1-8ed0-7dc1de1d7f94",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Signs%2FLevel%202%2Fshop_items_catalog_image275.png?alt=media&token=77a01008-6393-4607-b4ed-0e51c3112434"
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
    private String QuestionsType2[] = {
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

    public String getQuestions1(int q) {
        String questions1 = Questions1[q];
        return questions1;
    }
    public String getQuestions2(int w){
        String questions2 = Questions2[w];
        return questions2;
    }

    public String[] getChoice1(int q) {
        String[] choice1 = Choice1[q];
        return choice1;
    }
    public String[] getChoice2(int w){
        String[] choice2 = Choice2[w];
        return choice2;
    }

    public String getImages1(int q) {
        String img1 = Images1[q];
        return img1;
    }

    public String getImages2(int w){
        String img2 = Images2[w];
        return img2;
    }

    public String getType1(int q) {
        String type1 = QuestionsType1[q];
        return type1;
    }

    public String getType2(int w){
        String type2 = QuestionsType2[w];
        return type2;
    }
    public int getLenght1(){
        return Questions1.length;
    }
    public int getLenght2(){
        return Questions2.length;
    }

    public String getCoorectAnswers1(int q) {

        String correct1 = CoorectAnswers1[q];

        return correct1;
    }
    public String getCoorectAnswers2(int w){

        String coorect2 = CoorectAnswers2[w];

        return coorect2;
    }
}
