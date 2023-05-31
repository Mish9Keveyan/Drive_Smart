package com.example.learntodrive.safeDrive;

public class Questions3 {

    private String Questions11[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    private String Questions12[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    private String Questions13[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    private String Questions14[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    private String Choice11[][] = {
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""}
    };
    private String Choice12[][] = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""}
    };
    private String Choice13[][] = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""}
    };
    private String Choice14[][] = {
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""}
    };


    private String CoorectAnswers11 [] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    private String CoorectAnswers12[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    private String CoorectAnswers13[] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    private String CoorectAnswers14 [] = {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
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
