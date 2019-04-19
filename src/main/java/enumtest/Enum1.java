package enumtest;

public enum Enum1 {
    TEST("1","2"),TEST1("2","3"),TEST2("3","4");

    private Enum1(String test1,String test2){
        this.test1 = test1;
        this.test2 = test2;
    }
    public String getTest1(){
        return test1;
    }
    public String getTest2(){
        return test2;
    }
    private String test1;
    private String test2;
}
