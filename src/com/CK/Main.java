package com.CK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1, 4, 4, 5};
        new Solution().oddEvenJumps(A);
    }
}

class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
            if (hi != null) higher[i] = lower[(int) hi.getValue()];
            if (lo != null) lower[i] = higher[(int) lo.getValue()];
            if (higher[i]) res++;
            map.put(A[i], i);
        }
        return res;
    }
}