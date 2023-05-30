package com.example.learntodrive.CrossRoads;

public class Questions2 {

    private String Questions11[] = {
            "Первым проедет перекресток: ",
            "Перекресток последним проедет: ",
            "Перекресток вторым проедет:",
            "Перекресток последним проедет:",
            "Транспортные средства проедут перекресток в следующей последовательности:",
            "Перекресток вторым проедет:",
            "Водитель какого транспортного средства должен уступить дорогу?",
            "В каком ответе правильно указана очередность проезда?",
            "Транспортные средства проедут перекресток в следующей последовательности:",
            "Транспортные средства проедут перекресток в следующей последовательности:"
    };
    private String Questions12[] = {
            "Синий автомобиль проедет перекресток:",
            "Водитель какого транспортного средства должен уступить дорогу?",
            "Водитель какого транспортного средства должен уступить дорогу?",
            "Красный автомобиль:",
            "Кто из водителей имеет преимущество на первоочередное движение?",
            "Водитель зеленого автомобиля:",
            "Транспортные средства проедут перекресток в следующей последовательности:",
            "Транспортные средства проедут перекресток в следующей последовательности:",
            "Транспортные средства проедут перекресток в следующей последовательности:",
            "Транспортные средства проедут перекресток в следующей последовательности:"
    };
    private String Questions13[] = {
            "Перекресток вторым проедет:",
            "Перекресток вторым проедет:",
            "Какой автомобиль последним проедет перекресток?",
            "Перекресток первым проедет:",
            "Укажите очередность проезда перекрестка:",
            "Перекресток последним проедет:",
            "Перекресток вторым проедет:",
            "Автомобили проедут перекресток в следующем порядке:",
            "В данной ситуации необходимо уступить:",
            "При движении прямо следует уступить:"
    };
    private String Questions14[] = {
            "Перекресток первым проедет:",
            "Перекресток последним проедет:",
            "Перекресток третьим проедет:",
            "Перекресток третьим проедет:",
            "Транспортные средства проедут перекресток в следующей последовательности:",
            "Желтый автомобиль проедет перекресток:",
            "В данной ситуации при проезде перекрестка:",
            "При повороте налево мы обязаны уступить дорогу:",
            "При проезде перекрестка мы обязаны уступить:",
            "В данной ситуации Вы должны уступить дорогу:"
    };

    private String Choice11[][] = {
            {"Синий автомобиль","Красный автомобиль","Зеленый автомобиль"},
            {"Синий автомобиль.","Зеленый автомобиль.","Красный автомобиль."},
            {"Синий автомобиль.","Зеленый автомобиль.","Красный автомобиль."},
            {"Зеленый автомобиль.","Красный автомобиль.","Синий автомобиль."},
            {"Трамвай, желтый автомобиль, зеленый автомобиль.","Зеленый автомобиль, желтый автомобиль, трамвай.","Трамвай и зеленый автомобиль, желтый автомобиль."},
            {"Красный автомобиль.","Зеленый автомобиль.","Синий автомобиль."},
            {"Водители автомобилей.","Водитель трамвая.","Водитель грузового автомобиля."},
            {"Мотоцикл, автобус, грузовой автомобиль.","Автобус, мотоцикл, грузовой автомобиль.","Автобус, грузовой автомобиль, мотоцикл."},
            {"Легковой автомобиль, автобус, трамвай.","Трамвай, автобус, легковой автомобиль.","Трамвай, легковой автомобиль, автобус."},
            {"Тролейбус и автобус, легковой автомобиль.","Тролейбус, легковой автомобиль, автобус.","Легковому автомобиль, автобус, тролейбус."}
    };
    private String Choice12[][] = {
            {"Первым.","Вторым."},
            {"Водитель автомобиля.","Велосипедист."},
            {"Водитель мотоцикла.","Водитель автобуса."},
            {"Имеет преимущество в движении, так как приблизился к перекрестку с круговым движением с правой стороны синего автомобиля.","Должен уступить дорогу синему автомобилю, движущемуся по дороге с круговым движением."},
            {"Водитель автомобиля.","Водитель мотоцикла."},
            {"Должен уступить дорогу.","Имеет право на первоочередное движение."},
            {"Легковой автомобиль и грузовой автомобиль одновременно, автобус.","Автобус, легковой автомобиль и грузовой автомобиль одновременно."},
            {"Трамвай и автобус, мотоцикл и легковой автомобиль, грузовой автомобиль.","Грузовой автомобиль, трамвай и автобус, мотоцикл и легковой автомобиль."},
            {"Мотоцикл, автобус, трамвай и автомобиль \"Скорой помощи\", легковой автомобиль.","Автомобиль \"Скорой помощи\", трамвай, мотоцикл, автобус, легковой автомобиль."},
            {"Грузовой автомобиль и автобус, мотоцикл, троллейбус.","Грузовой автомобиль и мотоцикл, автобус, троллейбус."}
    };
    private String Choice13[][] = {
            {"Трамвай.","Красный автомобиль.","Синий автомобиль."},
            {"Белый автомобиль одновременно с желтым.","Красный автомобиль.","Зеленый автомобиль."},
            {"Синий.","Красный.","Зеленый."},
            {"Красный автомобиль.","Зеленый автомобиль.","Синий автомобиль."},
            {"Синий, красный одновременно с зеленым.","Красный, синий, зеленый.","Красный одновременно с зеленым, синий."},
            {"Зеленый автомобиль.","Синий автомобиль.","Красный автомобиль."},
            {"Зеленый автомобиль.","Красный автомобиль одновременно с синим.","Желтый автомобиль."},
            {"Синий, зеленый, красный.","Зеленый, красный, синий.","Красный, синий, зеленый."},
            {"Водителю грузового автомобиля.","Обоим водителям.","Водителю автобуса."},
            {"Водителю легкового автомобиля.","Всем.","Никому."}
    };
    private String Choice14[][] = {
            {"Красный автомобиль.","Синий автомобиль.","Зеленый автомобиль.","Желтый автомобиль."},
            {"Синий автомобиль.","Зеленый автомобиль.","Желтый автомобиль.","Красный автомобиль."},
            {"Желтый автомобиль.","Синий автомобиль.","Зеленый автомобиль.","Красный автомобиль."},
            {"Желтый автомобиль.","Kрасный автомобиль.","Синий автомобиль.","Зеленый автомобиль."},
            {"Легковой автомобиль, автобус, велосипед.","Автобус, велосипед, легковой автомобиль.","Автобус, легковой автомобиль, велосипед.","Велосипед, автобус, легковой автомобиль."},
            {"Первым.","Вторым.","Третьим.","Последним."},
            {"Имеем право проехать первыми.","Должны уступить водителю трамвая.","Должны уступить водителю грузового автомобиля.","Должны уступить всем водителям."},
            {"Водителю легкового автомобиля.","Водителю автобуса.","Водителю мотоцикла.","Никому."},
            {"Всем водителям.","Водителю мотоцикла.","Водителям мотоцикла и автобуса.","Водителям легкового автомобиля и автобуса."},
            {"Только водителю трамвая.","Водителю легкового автомобиля.","Водителям легкового автомобиля и трамвая.","Всем водителям."}
    };


    private String CoorectAnswers11 [] = {
            "Зеленый автомобиль",
            "Синий автомобиль.",
            "Синий автомобиль.",
            "Красный автомобиль.",
            "Трамвай и зеленый автомобиль, желтый автомобиль.",
            "Зеленый автомобиль.",
            "Водители автомобилей.",
            "Мотоцикл, автобус, грузовой автомобиль.",
            "Трамвай, легковой автомобиль, автобус.",
            "Тролейбус, легковой автомобиль, автобус."
    };
    private String CoorectAnswers12[] = {
            "Первым.",
            "Водитель автомобиля.",
            "Водитель автобуса.",
            "Должен уступить дорогу синему автомобилю, движущемуся по дороге с круговым движением.",
            "Водитель автомобиля.",
            "Имеет право на первоочередное движение.",
            "Автобус, легковой автомобиль и грузовой автомобиль одновременно.",
            "Грузовой автомобиль, трамвай и автобус, мотоцикл и легковой автомобиль.",
            "Мотоцикл, автобус, трамвай и автомобиль \"Скорой помощи\", легковой автомобиль.",
            "Грузовой автомобиль и мотоцикл, автобус, троллейбус."
    };
    private String CoorectAnswers13[] = {
            "Трамвай.",
            "Красный автомобиль.",
            "Красный.",
            "Синий автомобиль.",
            "Красный одновременно с зеленым, синий.",
            "Зеленый автомобиль.",
            "Красный автомобиль одновременно с синим.",
            "Красный, синий, зеленый.",
            "Обоим водителям.",
            "Водителю легкового автомобиля."
    };
    private String CoorectAnswers14 [] = {
            "Зеленый автомобиль.",
            "Зеленый автомобиль.",
            "Желтый автомобиль.",
            "Синий автомобиль.",
            "Велосипед, автобус, легковой автомобиль.",
            "Последним.",
            "Имеем право проехать первыми.",
            "Никому.",
            "Всем водителям.",
            "Водителям легкового автомобиля и трамвая."
    };


    private String Images11[] = {
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2Ffirst.jpg?alt=media&token=5d0e7876-5b67-4752-a053-731a2de408a6",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F2.png?alt=media&token=5a2a02a7-dcda-4635-8331-02f0a84dfcf8",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F3.png?alt=media&token=9ab9652a-e393-49c9-b5ed-3955125cfedb",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F4.png?alt=media&token=25caed75-e7b3-43c6-bc9e-1bea77b81891",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F5.png?alt=media&token=397a408f-947d-49bd-9593-850e325f56c3",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F6.png?alt=media&token=13c56361-190c-454f-8166-944eb36bdffd",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F7.png?alt=media&token=8e8638ce-cf8a-4c5f-9947-9a5e57d150c7",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F8.png?alt=media&token=7bbc13c7-2c14-45cd-8d5f-314dbdcc9e6a",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F9.png?alt=media&token=433011ba-1e31-438b-83a1-ad8be0fd5e25",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffirst%2F10.png?alt=media&token=75eae87f-b465-48d1-9ca5-4a8b5367f299"
    };
    private String Images12[] = {
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F1.png?alt=media&token=426dcff7-67d1-4b31-9eef-cf550f14fe3e",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F2.png?alt=media&token=aa167c01-c13d-4e62-a71e-905d85c58283",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F3.png?alt=media&token=cd078b30-0afa-49b1-b077-7e18f86ccc89",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F4.png?alt=media&token=1fed2c84-cff7-4a55-a546-9c659ee3f9ef",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F5.png?alt=media&token=051e183c-3bb2-4541-8c57-8220a825269a",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F6.png?alt=media&token=bc8be01e-ae36-4d37-a1f3-16033759a3da",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F7.png?alt=media&token=2fed8ebc-7818-4d6b-9930-7a6d1677e71f",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F8.png?alt=media&token=466d1a59-89fa-4d67-a2a2-2465ae08108b",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F9.png?alt=media&token=a0023e47-92ec-46d9-a57e-9e9dae109a25",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fsecond%2F10.png?alt=media&token=21cda1af-8f28-4ba5-a71d-9036f84dbfa0"
    };
    private String Images13[] = {
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F1.png?alt=media&token=e28c01f0-6846-42f4-9ce7-af7ba7ccbcf1",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F2.png?alt=media&token=ccc57645-bd61-494a-b18a-72646ceb1efa",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F3.png?alt=media&token=488dd9a8-e183-4ec8-a991-97a87f8d7f16",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F4.png?alt=media&token=02879c37-d7b3-47c9-8f40-abac3e35f727",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F5.png?alt=media&token=3fe8a3f2-2329-483c-a758-c24759d18ec4",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F6.png?alt=media&token=d668bf7a-56f5-4d38-947b-05b8635e21be",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F7.png?alt=media&token=65d24977-1160-4cd7-ae87-42b5985b0f26",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F8.png?alt=media&token=e26a3964-d04f-4f5c-b237-6271c1eb3dd5",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F9.png?alt=media&token=b348a98e-1e2b-4ca2-84ee-e6155be5d6e9",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Fthird%2F10.png?alt=media&token=961c37e3-bf3b-42bb-8184-d8106721e221"
    };
    private String Images14[] = {
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F1.png?alt=media&token=51aca26d-7698-4e8a-9f9a-c9676a0246eb",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F2.png?alt=media&token=0b661340-b4b3-4d92-a113-670f81971dd8",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F3.png?alt=media&token=95d6835c-59ab-474a-9dcf-b8f6c6591fa0",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F4.png?alt=media&token=148e3d87-b4cd-4ca0-9804-34e7e2afacb9",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F5.png?alt=media&token=388a955e-450b-4ef9-b55b-bf2ea49f8575",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F6.png?alt=media&token=1d1512b8-a5a6-4955-a7de-e3e08b78de4b",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F7.png?alt=media&token=0f5c660d-39d1-4eff-8a6a-8c30dd56b139",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F8.png?alt=media&token=22703593-8600-4ce3-b921-259682253c01",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F9.png?alt=media&token=d536b4f1-41c7-400f-a36e-b8b3dfab6f1f",
            "https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/Crossroads%2Ffourth%2F10.png?alt=media&token=20138538-06d8-4533-b0c5-c70386ce925f"
    };


    private String QuestionsType11[] = {
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
    private String QuestionsType12[] = {
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
    private String QuestionsType13[] = {
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
    private String QuestionsType14[] = {
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


    public String getQuestions11(int q) {
        String questions11 = Questions11[q];
        return questions11;
    }
    public String getQuestions12(int w){
        String questions12 = Questions12[w];
        return questions12;
    }
    public String getQuestions13(int a){
        String questions13 = Questions13[a];
        return questions13;
    }
    public String getQuestions14(int s){
        String questions14 = Questions14[s];
        return questions14;
    }


    public String[] getChoice11(int q) {
        String[] choice11 = Choice11[q];
        return choice11;
    }
    public String[] getChoice12(int w){
        String[] choice12 = Choice12[w];
        return choice12;
    }
    public String[] getChoice13(int a){
        String[] choice13 = Choice13[a];
        return choice13;
    }
    public String[] getChoice14(int s){
        String[] choice14 = Choice14[s];
        return choice14;
    }


    public String getImages11(int q) {
        String img11 = Images11[q];
        return img11;
    }
    public String getImages12(int w){
        String img12 = Images12[w];
        return img12;
    }
    public String getImages13(int a){
        String img13 = Images13[a];
        return img13;
    }
    public String getImages14(int s){
        String img14 = Images14[s];
        return img14;
    }


    public String getType11(int q) {
        String type11 = QuestionsType11[q];
        return type11;
    }
    public String getType12(int w){
        String type12 = QuestionsType12[w];
        return type12;
    }
    public String getType13(int a){
        String type13 = QuestionsType13[a];
        return type13;
    }
    public String getType14(int s) {
        String type14 = QuestionsType14[s];
        return type14;
    }


    public int getLenght11(){
        return Questions11.length;
    }
    public int getLenght12(){
        return Questions12.length;
    }
    public int getLenght13(){
        return Questions13.length;
    }
    public int getLenght14(){
        return Questions14.length;
    }


    public String getCoorectAnswers11(int q) {

        String correct11 = CoorectAnswers11[q];

        return correct11;
    }
    public String getCoorectAnswers12(int w){

        String coorect12 = CoorectAnswers12[w];

        return coorect12;
    }
    public String getCoorectAnswers13(int a){

        String coorect13 = CoorectAnswers13[a];

        return coorect13;
    }
    public String getCoorectAnswers14(int s){

        String coorect14 = CoorectAnswers14[s];

        return coorect14;
    }
}
