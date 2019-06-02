package java8.stream.base;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对菜单里面的菜肴进行排序
 */
public class OrderByCalorie {
    /**
     * java7的实现版本,获取热烈从高到底的菜的名称
     */
    @Test
    public void java7Edition(){
        List<Dish> dishList = new ArrayList<>();
        assembleList(dishList);
        Collections.sort(dishList, new Comparator<Dish>() {
            @Override
            /**
             * o1是前一个对象,o2是后一个对象，方法返回值为1时两个对象才会交换位置
             */
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o2.calorie,o1.calorie);
            }
        });
        List<String> nameList = new ArrayList<>();
        for (Dish dish:dishList){
            nameList.add(dish.getName());
        }
        for (String name:nameList){
            System.out.println(name);
        }
    }
    @Test
    public void java8Edition(){
        List<Dish> dishList = new ArrayList<>();
        assembleList(dishList);
        //利用流处理机制直接完成所有操作(单线程版本)
        List<String> nameList = dishList
                .stream()
                .sorted(Comparator.comparing(Dish::getCalorie).reversed())
                .map(Dish::getName)
                .collect(Collectors.toList());
        //多线程版本
        List<String> nameListNew = dishList
                //流化
                .parallelStream()
                //排序
                .sorted(Comparator.comparing(Dish::getCalorie))
                //提取名称
                .map(Dish::getName)
                //转换为集合
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
        System.out.println();
        nameListNew.forEach(System.out::println);
    }

    private void assembleList(List<Dish> dishList){
        dishList.add(new Dish("水煮肉片",500));
        dishList.add(new Dish("红烧排骨",600));
        dishList.add(new Dish("番茄操蛋",250));
        dishList.add(new Dish("红烧肉",800));
    }

    class Dish{
        private String name;
        private int calorie;
        public Dish(String name,int calorie){
            this.name = name;
            this.calorie = calorie;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCalorie() {
            return calorie;
        }

        public void setCalorie(int calorie) {
            this.calorie = calorie;
        }
    }
}
