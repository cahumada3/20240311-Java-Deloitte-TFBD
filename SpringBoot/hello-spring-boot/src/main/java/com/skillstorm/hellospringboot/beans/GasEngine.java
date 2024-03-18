package com.skillstorm.hellospringboot.beans;

public class GasEngine implements Engine {
    @Override
    public void run() {
        System.out.println("VROOOOOOOM");
    }
}
