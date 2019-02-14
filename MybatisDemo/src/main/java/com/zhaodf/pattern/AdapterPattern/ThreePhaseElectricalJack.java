package com.zhaodf.pattern.AdapterPattern;

//这是我们的目标接口，因为用户只有三相电插头，我们只能提供三相电充电接口
public interface ThreePhaseElectricalJack {
    void charge();
}
