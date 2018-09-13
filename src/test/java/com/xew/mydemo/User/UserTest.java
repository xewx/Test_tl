package com.xew.mydemo.User;


import com.xew.mydemo.dao.UserMapper;
import com.xew.mydemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("s");
        list.add("d");
        list.add("a");
        list.add("s");
        list.add("a");
        list.add("d");
        list.add("f");
        Map<String,Integer> MSum=new HashMap<>();
        for (String temp : list) {
            Integer count = MSum.get(temp);
            MSum.put(temp, (count == null) ? 1 : count + 1);
        }
        for(String a:MSum.keySet()){
            System.out.println(a);
        }
        for(Integer a:MSum.values()){
            System.out.println(a);
        }
    }
}
