package com.ctci;

public class StringReverser {
    public String reverse(String forward) {
        if (forward == null) {
            return null;
        }

        String backward = "";

        for (int i = 0; i < forward.length(); i++) {
            backward = forward.charAt(i) + backward;
        }

        return backward;
    }
}
