package com.zhaodf.pattern.AdapterPattern;

//我们的适配器
public class Adapter implements ThreePhaseElectricalJack{
    private TwoPhaseElectricalSocketAperture twoPhaseElectricalJack;

    public Adapter(){
        this.twoPhaseElectricalJack = new TwoPhaseElectricalSocketAperture();
    }
    public void charge() {
        System.out.println("通过转换器进行适配,将三相电插头转换为二相电插头");
        twoPhaseElectricalJack.twoPhaseElectricalSocketCharge();
    }
}
