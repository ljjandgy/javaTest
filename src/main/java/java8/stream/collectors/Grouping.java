package java8.stream.collectors;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ljj
 * @version sprint 19
 * @className Grouping
 * @description
 * @date 2020-04-14 13:17:41
 */
public class Grouping {
    List<GroupBo> groupBoList = Arrays.asList(
            new GroupBo("laowang","laowang1"),
            new GroupBo("laowang","laowang2"),
            new GroupBo("laoyu","laoyu1"),
            new GroupBo("laoyu","laoyu2"));
    @Test
    public void BaseGroupTest() {
        Map<String,List<GroupBo>> map = groupBoList.stream().collect(Collectors.groupingBy(GroupBo::getName));
        map.forEach((k,v)-> v.forEach(groupBo -> System.out.println(groupBo.getDescription())));
    }
    @Test
    public void  increGroupTest(){
        Map<String,Long> countMap = groupBoList.stream().collect(Collectors.groupingBy(GroupBo::getName,Collectors.counting()));
        countMap.forEach((k,v)->System.out.println(v));
        Map<String,GroupBo> groupMap = groupBoList.stream().collect(Collectors.groupingBy(GroupBo::getName,Collectors.collectingAndThen(Collectors.toList(),list->list.stream().filter(bo->bo.getDescription().contains("2")).collect(Collectors.toList()).get(0))));
        groupMap.forEach((k,v)->System.out.println(v.getDescription()));
    }
}
