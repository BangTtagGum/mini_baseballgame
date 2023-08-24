package org.example;

class Referee {

    public boolean validationCheck(String choice) {
        if (choice.strip().length() != 3) {
//            System.out.println("유효하지 않은 입력입니다.");
            return false;
        }
        for (int i = 0; i < choice.length(); i++) {
            if (choice.charAt(i) < 48 && 57 < choice.charAt(i)) {
//                System.out.println("숫자만 입력해주세요");
                return false;

            }
        }
        if (choice.charAt(0) == choice.charAt(1) || choice.charAt(0) == choice.charAt(2)
                || choice.charAt(1) == choice.charAt(2)) {
//            System.out.println("\"중복없이\" 세개의 숫자를 입력해주세요 예) 805: ");
            return false;

        }
        return true;
    }

    public boolean answerCheck(String choice, String answer) {
        int s = 0;
        int b = 0;
        for (int i = 0; i < 3; i++) {
            if (choice.charAt(i) == answer.charAt(i)) {
                s++;
            } else if (answer.contains(String.valueOf(choice.charAt(i)))) {
                b++;
            }
        }

        System.out.println(s + " strike, " + b + " ball.");

        if (s == 3) {
            return true;
        } else {
            return false;
        }
    }
}
