/*
 * Copyright (c) 2019. Parrot Faurecia Automotive S.A.S. All rights reserved.
 */

package com.parrot.car.aidl;

public interface Test {

    void envent();

    void envent2();

    public abstract static class Stub implements Test{

        public Stub() {
        }

        public void invork(){

            envent();
        }
    }

}
