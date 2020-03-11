package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 对堆的内存溢出进行复现
 */
public class HeapOomTest {
    static class OomObj{

    }
    public static void main(String[] args) {
        List<OomObj> oomObjList = new ArrayList<>();
        while (true){
            oomObjList.add(new OomObj());
        }
    }
}
