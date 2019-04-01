package tw.com.flag.retrofit_restful;

import com.google.gson.annotations.SerializedName;

public class Datas {

    //  Gson
    @SerializedName("hello")
    private String hello;
    @SerializedName("sentence")
    private String sentence;
    @SerializedName("value")
    private int value;

    //
    void setHello(String hello) {
        this.hello = hello;
    }
    String getHello() {
        return hello;
    }
    void setSentence(String sentence) { this.sentence = sentence; }
    String getSentence() { return sentence; }
    void setValue1(int value) { this.value = value; }
    int getValue() { return value; }
}

