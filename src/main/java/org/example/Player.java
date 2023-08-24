package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Player {

    String choice;

    public String guessNum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        System.out.print("0-9 까지 중복없이 세개의 숫자를 입력해주세요 : ");

        choice = br.readLine();

        return choice;
    }
}