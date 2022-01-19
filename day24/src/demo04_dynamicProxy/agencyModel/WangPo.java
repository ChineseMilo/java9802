package demo04_dynamicProxy.agencyModel;

public class WangPo implements Happy{
    JinLian jl;

    public WangPo(JinLian jl) {
        this.jl = jl;
    }

    @Override
    public void happy() {
        System.out.println("安排房间");
        jl.happy();
        System.out.println("已经结束了");
    }
}
