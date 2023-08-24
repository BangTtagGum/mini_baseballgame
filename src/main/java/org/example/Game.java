package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Game {

    private String secretNum;
    private final Player player;
    private final Referee referee;

    public Game(Player player, Referee referee) {
        this.player = player;
        this.referee = referee;
    }

    public void play() {
        System.out.println("[야구게임에 오신 것을 환영합니다.]");
        setSecretNum();
        String choice ="";
        while (true) {
            try {
                choice = player.guessNum();
                if (!referee.validationCheck(choice)) {
                    continue;
                }
            } catch (IOException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }
            if (referee.answerCheck(choice, secretNum)) {
                System.out.println("정답입니다!");
                break;
            }
        }
        System.out.println("야구게임을 종료합니다.");
    }

    private void setSecretNum() {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(nums.get(i));
        }
        this.secretNum = sb.toString();
    }

    public static void main(String[] args) {
        Player player = new Player();
        Referee referee = new Referee();
        Game game = new Game(player,referee);
        game.play();
    }
}







//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int l = Integer.parseInt(st.nextToken());
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 영향을 안 미쳐서 나중에 지우려고 보류한 것들
//        StringBuilder sb = new StringBuilder();
//        st = new StringTokenizer(br.readLine());
//        int arr[] = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 0; i < n; i++) {
//            pq.add(arr[i]);
//            if (i - l >= 0) {
//                if (pq.peek() >= arr[i-l]) {
//                    pq.poll();                  // 삭제 이후 이전에 보류 했던 것들과 비교
//                    while (pq2.size() != 0 && pq.peek() >= pq2.peek()) {
//                        pq.poll();
//                        pq2.poll();
//                    }
//                } else {
//                    pq2.add(arr[i - l]); // 새로운 pq에 저장 후 이후에 삭제 당장은 없는 수라고 생각
//                }
//            }
//            sb.append(pq.peek()).append(" ");
//        }
//        System.out.println(sb);
//    }