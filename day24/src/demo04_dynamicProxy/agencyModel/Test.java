package demo04_dynamicProxy.agencyModel;

public class Test {
    public static void main(String[] args) {
        JinLian jl = new JinLian();
        WangPo wp = new WangPo(jl);

        wp.happy();
    }
}
