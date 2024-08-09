package com.demoblaze.api;

import com.intuit.karate.junit5.Karate;

public class KarateRunner {

    @Karate.Test
    Karate testAuth() {
        return Karate.run("AuthTests").relativeTo(getClass());
    }
}


