package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String k = br.readLine();
        int arrInt[] = new int[k.length()];
        int arrTotalCount = 0;

        for (int i = 0; i < k.length(); i++) {
            arrInt[i] = k.charAt(i) - 48;
            arrTotalCount += arrInt[i];
        }

        Arrays.sort(arrInt);

        if ((arrTotalCount % 3 == 0) && (arrInt[0] == 0) ) {

            for (int i = k.length() - 1; i > -1; i--) {
                System.out.print(arrInt[i]);
            }
        } else {
            System.out.println(-1);
        }

    }
}
