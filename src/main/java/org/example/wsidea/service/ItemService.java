package org.example.wsidea.service;

import org.example.wsidea.po.Bar;
import org.example.wsidea.po.Pie;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {
    private static final List<Bar> items = new ArrayList<>();
    private static final List<Pie> pie = new ArrayList<>();
    static {
        items.add(new Bar("周一",12));
        items.add(new Bar("周二",20));
        items.add(new Bar("周三",15));
        items.add(new Bar("周四",8));
        items.add(new Bar("周五",7));
        items.add(new Bar("周六",11));
        items.add(new Bar("周日",13));
        pie.add(new Pie("rose1",38));
        pie.add(new Pie("rose2",46));
        pie.add(new Pie("rose3",12));
        pie.add(new Pie("rose4",30));
        pie.add(new Pie("rose5",54));
        pie.add(new Pie("rose6",36));
    }
    //获取柱形图数据
    public Map<String,?> getData(){
        //模拟数据更新
        items.forEach(e -> e.setData(e.getData()+(int)(Math.random() * 5 + 1)));
        HashMap<String,Object> map = new HashMap<>();
        map.put("xAxisData", EntityUtils.toList(items,Bar::getName));
        map.put("yAxisData", EntityUtils.toList(items,Bar::getData));
        return map;
    }
    //获取饼图数据
    public Map<String,?> getPieData(){
        //模拟数据更新
        pie.forEach(e -> e.setValue(e.getValue()+(int)(Math.random() * 5 + 1)));
        HashMap<String,Object> map = new HashMap<>();
        map.put("pie",pie);
        return map;
    }
}