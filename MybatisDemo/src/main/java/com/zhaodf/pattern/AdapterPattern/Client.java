package com.zhaodf.pattern.AdapterPattern;

public class Client {
    public static void main(String[] args){
        ThreePhaseElectricalJack threePhaseElectricalJack = new Adapter();
        threePhaseElectricalJack.charge();
    }
}
