package demo01_Junit.assert1;

import org.junit.Assert;
import org.junit.Test;

public class Demo {

    @Test
    public void show(){
        Assert.assertEquals(30,sum(10,20));
        System.out.println(sum(10,20));
    }

    public int sum(int n1,int n2){
        return n1+n2;
    }
}
