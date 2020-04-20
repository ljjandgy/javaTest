package java8.stream.collectors;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ljj
 * @version sprint 19
 * @className Partitioning
 * @description
 * @date 2020-04-17 13:09:52
 */
public class Partitioning {
    @Test
    public void baseTest(){
        List<GroupBo> groupBoList = Arrays.asList(
                new GroupBo("laowang", "laowang1"),
                new GroupBo("laowang", "laowang2"),
                new GroupBo("laoyu", "laoyu1"),
                new GroupBo("laoyu", "laoyu2"));
        Map<Boolean,List<GroupBo>> baseMap =  groupBoList.stream().collect(Collectors.partitioningBy(group->"laoyu".equals(group.getName())));
        baseMap.get(true).forEach(bo->System.out.println(bo.getDescription()));
    }
    @Test
    public void increTest(){
        List<GroupBo> groupBoList = Arrays.asList(
                new GroupBo("laowang", "laowang1"),
                new GroupBo("laowang", "laowang2"),
                new GroupBo("laoyu", "laoyu1"),
                new GroupBo("laoyu", "laoyu2"));
        Map<Boolean,GroupBo> baseMap =  groupBoList.stream().collect(Collectors.partitioningBy(group->"laoyu".equals(group.getName()),Collectors.collectingAndThen(Collectors.toList(),list->list.get(0))));
        System.out.println(baseMap.get(true).getDescription());
    }
}
