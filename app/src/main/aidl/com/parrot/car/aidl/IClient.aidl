// IClient.aidl
package com.parrot.car.aidl;

// Declare any non-default types here with import statements
import com.parrot.car.aidl.Book;

interface IClient {


    void take(inout Book x);

}
